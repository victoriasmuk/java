package com.victoriasmuk.ProjectManager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victoriasmuk.ProjectManager.models.Task;
import com.victoriasmuk.ProjectManager.repositories.TaskRepository;

@Service
public class TaskService {
	@Autowired
	private TaskRepository taskRepo;
	
	public List<Task> findAll(){
		return taskRepo.findAll();
	}
	public Task findOneById(Long id) {
		Optional<Task> task = taskRepo.findById(id);
		if(task.isPresent()) {
			return task.get();
		}
		return null;
	}
	public Task create(Task task) {
		return taskRepo.save(task);
	}
}
