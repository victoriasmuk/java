package com.victoriasmuk.ProjectManager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.victoriasmuk.ProjectManager.models.Project;
import com.victoriasmuk.ProjectManager.models.Task;
import com.victoriasmuk.ProjectManager.models.User;
import com.victoriasmuk.ProjectManager.services.ProjectService;
import com.victoriasmuk.ProjectManager.services.TaskService;
import com.victoriasmuk.ProjectManager.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ProjectController {
	@Autowired
	private UserService userService;
	@Autowired
	private ProjectService projectService;
	@Autowired 
	private TaskService taskService;
	
//	CREATE PROJECT
	@GetMapping("/projects/new")
	public String newProject(HttpSession session, @ModelAttribute("project") Project project) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		return "createProject.jsp";
	}
	
	@PostMapping("/projects/create")
	public String createProject(HttpSession session, @Valid @ModelAttribute("project") Project project, BindingResult result) {
		if(result.hasErrors()) {
			return "createProject.jsp";
		}
		User user = userService.findOneById((Long) session.getAttribute("userId"));
		project.setLead(user);
		projectService.create(project);
		return "redirect:/dashboard";
	}
	
//	UPDATE PROJECT 
	@GetMapping("/projects/edit/{projectId}")
	public String editProject(@PathVariable("projectId") Long id, HttpSession session, Model model) {
		Project currentProject = projectService.findOneById(id);
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		if((Long) session.getAttribute("userId") != currentProject.getLead().getId()) {
			return "redirect:/dashboard";
		}
		System.out.println(currentProject.getId());
		model.addAttribute("project", currentProject);
		return "editProject.jsp";
	}
	@PutMapping("/projects/update/{id}")
	public String updateProject(@PathVariable("id") Long id, @Valid @ModelAttribute("project") Project project, BindingResult result) {
		if(result.hasErrors()) {
			return "editProject.jsp";
		}
		System.out.println(project.getId());
		Project currentProject = projectService.findOneById(id);
		currentProject.setTitle(project.getTitle());
		currentProject.setDescription(project.getDescription());
		currentProject.setDueDate(project.getDueDate());
		projectService.update(currentProject);
		return "redirect:/dashboard";
	}
	
//	VIEW PROJECT DETAILS
	@GetMapping("/projects/view/{projectId}")
	public String viewProject(HttpSession session, @PathVariable("projectId") Long id, Model model) {
		Project project = projectService.findOneById(id);
		if(session.getAttribute("userId") == null || project == null) {
			return "redirect:/";
		}
		model.addAttribute("project", project);
		model.addAttribute("userId", (Long) session.getAttribute("userId"));
		return "viewProject.jsp";
	}
	
//	ADD PROJECT TASK
	@RequestMapping("/projects/tasks/{projectId}")
	public String projectTasks(HttpSession session, @ModelAttribute("task") Task task, @PathVariable("projectId") Long projectId, Model model) {
		Project project = projectService.findOneById(projectId);
		if(session.getAttribute("userId") == null || project == null) {
			return "redirect:/";
		}
		model.addAttribute("project", project);
		return "projectTasks.jsp";
	}
	@PostMapping("/tasks/create/{projectId}")
	public String createTask(@Valid @ModelAttribute("task") Task task, BindingResult result, @PathVariable("projectId") Long projectId, HttpSession session, Model model) {
		Project project = projectService.findOneById(projectId);
		if(result.hasErrors()) {
			model.addAttribute("project", project);
			return "projectTasks.jsp";
		}
		task.setCreatorName((String) session.getAttribute("userName"));
		task.setProject(project);
		taskService.create(task);
		return "redirect:/projects/tasks/" + projectId;
	}
	
//	ADD OR REMOVE TEAM MEMBERS
	@RequestMapping("/projects/addmember/{projectId}")
	public String addMember(@PathVariable("projectId") Long id, HttpSession session) {
		Project project = projectService.findOneById(id);
		User currentUser = userService.findOneById((Long) session.getAttribute("userId"));
		if(currentUser == null || project == null) {
			return "redirect:/";
		}
		if(currentUser.getProjects().contains(project)) {
			return "redirect:/dashboard";
		}
		currentUser.getProjects().add(project);
		userService.update(currentUser);
		return "redirect:/dashboard";
	}
	@RequestMapping("/projects/removemember/{projectId}")
	public String removeMember(@PathVariable("projectId") Long id, HttpSession session) {
		Project project = projectService.findOneById(id);
		User currentUser = userService.findOneById((Long) session.getAttribute("userId"));
		if(currentUser == null || project == null) {
			return "redirect:/";
		}
		if(!currentUser.getProjects().contains(project)) {
			return "redirect:/dashboard";
		}
		currentUser.getProjects().remove(project);
		userService.update(currentUser);
		return "redirect:/dashboard";	
	}
	
//	DELETE PROJECT
	@RequestMapping("/projects/delete/{projectId}")
	public String deleteProject(@PathVariable("projectId") Long id, HttpSession session) {
		Project project = projectService.findOneById(id);
		User currentUser = userService.findOneById((Long) session.getAttribute("userId"));
		if(currentUser == null || project == null) {
			return "redirect:/";
		}
		if(!project.getLead().equals(currentUser)) {
			return "redirect:/logout";
		}
		projectService.delete(id);
		return "redirect:/dashboard";
	}
}
