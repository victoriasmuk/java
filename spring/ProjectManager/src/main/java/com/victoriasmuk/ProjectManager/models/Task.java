package com.victoriasmuk.ProjectManager.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="tasks")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String creatorName;
	
	@NotBlank(message="Task is required.")
	private String description;

	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="project_id")
	private Project project;
    
    public Task() {}
    	public Task(String creatorName, String description, Project project) {
    		super();
    		this.creatorName = creatorName;
    		this.description = description;
    		this.project = project;
    	}
    	public Task(Long id, String creatorName, String description, Project project) {
    		super();
    		this.id = id;
    		this.creatorName = creatorName;
    		this.description = description;
    		this.project = project;
    	}
    	public Long getId() {
    		return id;
    	}
    	public void setId(Long id) {
    		this.id = id;
    	}
    	public String getCreatorName() {
    		return creatorName;
    	}
    	public void setCreatorName(String creatorName) {
    		this.creatorName = creatorName;
    	}
    	public String getDescription() {
    		return description;
    	}
    	public void setDescription(String task) {
    		this.description = task;
    	}
    	public Project getProject() {
    		return project;
    	}
    	public void setProject(Project project) {
    		this.project = project;
    	}
    	public Date getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}
		public Date getUpdatedAt() {
			return updatedAt;
		}
		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	    }
	@PreUpdate
	protected void onUpdate(){
	    this.updatedAt = new Date();
	}	
}
