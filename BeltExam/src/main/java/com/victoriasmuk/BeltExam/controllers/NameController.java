package com.victoriasmuk.BeltExam.controllers;

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

import com.victoriasmuk.BeltExam.models.Name;
import com.victoriasmuk.BeltExam.models.User;
import com.victoriasmuk.BeltExam.services.NameService;
import com.victoriasmuk.BeltExam.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class NameController {
	@Autowired
	private UserService userService;
	@Autowired
	private NameService nameService;
	
//	CREATE BABY NAME
	@GetMapping("/names/new")
	public String newName(HttpSession session, @ModelAttribute("name") Name name) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		return "createName.jsp";
	}
	@PostMapping("/names/create")
	public String createName(HttpSession session, @Valid @ModelAttribute("name") Name name, BindingResult result, Model model) {
		nameService.validateCreate(name, result);
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			model.addAttribute("user", new User());
			return "createName.jsp";
		} 
		User user = userService.findOneById((Long) session.getAttribute("userId"));
		name.setOwn(user);
		nameService.create(name);
		return "redirect:/dashboard";			
	}
	
// UPDATE BABY NAME
	@GetMapping("/names/edit/{nameId}")
	public String editName(@PathVariable("nameId") Long id, HttpSession session, Model model) {
		Name currentName = nameService.findOneById(id);
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		if((Long) session.getAttribute("userId") != currentName.getOwn().getId()) {
			return "redirect:/dashboard";
		}
		model.addAttribute("name", currentName);
		return "editName.jsp";
	}
	@PutMapping("/names/update/{id}")
	public String processEditName(@PathVariable("id") Long id, @Valid @ModelAttribute("name") Name name, BindingResult result, HttpSession session, Model model) {
		nameService.validateUpdate(name, result);
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			model.addAttribute("user", new User());
			return "editName.jsp";
		}
		Name currentName = nameService.findOneById(id);
		currentName.setBabyName(name.getBabyName());
		currentName.setGender(name.getGender());
		currentName.setOrigin(name.getOrigin());
		currentName.setMeaning(name.getMeaning());
		nameService.update(currentName);
		return "redirect:/dashboard";
	}
	
//	VIEW BABY NAME DETAILS
	@GetMapping("/names/view/{nameId}")
	public String viewName(HttpSession session, @PathVariable("nameId") Long id, Model model) {
		Name name = nameService.findOneById(id);
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		if (name == null) {
			return "redirect:/dashboard";
		}
		User currentUser = userService.findOneById((Long) session.getAttribute("userId"));
		model.addAttribute("currentUser", currentUser);
		model.addAttribute("name", name);
		model.addAttribute("userId", (Long) session.getAttribute("userId"));
		return "viewName.jsp";
	}

// ADD VOTE
	@RequestMapping("/votes/create/{nameId}")
	public String addVote(@PathVariable("nameId") Long id, HttpSession session) {
		Name name = nameService.findOneById(id);
		User currentUser = userService.findOneById((Long) session.getAttribute("userId"));
		if(currentUser == null) {
			return "redirect:/";
		}
		if (name == null) {
			return "redirect:/dashboard";
		}
		if(currentUser.getNames().contains(name)) {
			return "redirect:/dashboard";
		}
		currentUser.getNames().add(name);
		userService.update(currentUser);
		return "redirect:/dashboard";
	}
	
//	DELETE BABYNAME
	@RequestMapping("/names/delete/{nameId}")
	public String deleteName(@PathVariable("nameId") Long id, HttpSession session) {
		Name name = nameService.findOneById(id);
		User currentUser = userService.findOneById((Long) session.getAttribute("userId"));
		if(currentUser == null) {
			return "redirect:/";
		}
		if (name == null) {
			return "redirect:/dashboard";
		}
		if(!name.getOwn().equals(currentUser)) {
			return "redirect:/logout";
		}
		name.setOwn(null);
		nameService.delete(id);
		return "redirect:/dashboard";
	}
}
