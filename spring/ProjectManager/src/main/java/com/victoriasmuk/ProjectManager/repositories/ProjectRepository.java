package com.victoriasmuk.ProjectManager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.victoriasmuk.ProjectManager.models.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Long> {
	List<Project> findAll();
}