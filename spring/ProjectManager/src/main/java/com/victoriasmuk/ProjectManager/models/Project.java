package com.victoriasmuk.ProjectManager.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="projects")
public class Project {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Title is required.")
	private String title;
	
	@NotBlank(message="Description is required")
	@Size(min=3, message="Description must be at least 3 characters.")
	private String description;
	
	@NotNull(message="Due date is required.")
	@Future(message="Due date must be in the future.")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dueDate;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
	@ManyToMany
	@JoinTable(
		name="users_projects",
		joinColumns = @JoinColumn(name="project_id"),
		inverseJoinColumns = @JoinColumn(name="user_id")
		)
	private List<User> users;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="lead_id")
	private User lead;
	
	@OneToMany(mappedBy="project", fetch = FetchType.LAZY)
	private List<Task> tasks;
	
	public Project() {}
		public Project(String title, String description, Date dueDate, List<User> users, User lead, List<Task> tasks) {
			super();
			this.title = title;
			this.description = description;
			this.dueDate = dueDate;
			this.users = users;
			this.lead = lead;
			this.tasks = tasks;
		}
		public Project(Long id, String title, String description, Date dueDate, List<User> users, User lead, List<Task> tasks) {
			super();
			this.id = id;
			this.title = title;
			this.description = description;
			this.dueDate = dueDate;
			this.users = users;
			this.lead = lead;
			this.tasks = tasks;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Date getDueDate() {
			return dueDate;
		}
		public void setDueDate(Date dueDate) {
			this.dueDate = dueDate;
		}
		public List<User> getUsers() {
			return users;
		}
		public void setUsers(List<User> users) {
			this.users = users;
		}
		public User getLead() {
			return lead;
		}
		public void setLead(User lead) {
			this.lead = lead;
		}
		public List<Task> getTasks() {
			return tasks;
		}
		public void setTasks(List<Task> tasks) {
			this.tasks = tasks;
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
