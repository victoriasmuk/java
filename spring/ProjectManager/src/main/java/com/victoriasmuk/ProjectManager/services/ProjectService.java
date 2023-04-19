package com.victoriasmuk.ProjectManager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victoriasmuk.ProjectManager.models.Project;
import com.victoriasmuk.ProjectManager.repositories.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository projectRepo;
	
	public List<Project> findAll(){
		return projectRepo.findAll();
	}
	public Project findOneById(Long id) {
		Optional<Project> project = projectRepo.findById(id);
		if(project.isPresent()) {
			return project.get();
		}
		return null;
	}
	public Project create(Project project) {
		return projectRepo.save(project);
	}
	public Project update(Project project) {
		return projectRepo.save(project);
	}
	public void delete(Long id) {
		projectRepo.deleteById(id);
	}
}
