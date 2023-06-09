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
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@NotBlank(message="First name is required!")
    @Size(min=3, max=30, message="First name must be between 3 and 30 characters.")
    private String firstName;
	
	@NotBlank(message="Last name is required!")
    @Size(min=3, max=30, message="Last name must be between 3 and 30 characters.")
    private String lastName;
    
	@NotBlank(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;
    
	@NotBlank(message="Password is required!")
    @Size(min=8, max=128, message="Password must be between 8 and 128 characters.")
    private String password;
    
    @Transient
    @NotBlank(message="Please confirm your password!")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{8,}$", message = "Must include: a minimum of 8 characters, at least one uppercase letter, one lowercase letter, one number and one special character.")
    @Size(min=8, max=128, message="Password must be between 8 and 128 characters.")
    private String confirmPassword;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @ManyToMany
	@JoinTable(
		name="users_projects",
		joinColumns = @JoinColumn(name="user_id"),
		inverseJoinColumns = @JoinColumn(name="project_id")
		)
	private List<Project> projects;
	
	@OneToMany(mappedBy="lead", fetch = FetchType.LAZY)
	private List<Project> ownedProjects;
    
    
    public User() {}
    
	    public User(String firstName, String lastName, String email, String password, String confirmPassword, List<Project> projects, List<Project> ownedProjects) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.password = password;
			this.confirmPassword = confirmPassword;
			this.projects = projects;
			this.ownedProjects = ownedProjects;
		}
	    
	    public User(Long id, String firstName, String lastName, String email, String password, String confirmPassword, List<Project> projects, List<Project> ownedProjects) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.password = password;
			this.confirmPassword = confirmPassword;
			this.projects = projects;
			this.ownedProjects = ownedProjects;
		}
    
	    public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getConfirmPassword() {
			return confirmPassword;
		}
		public void setConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
		}
		public List<Project> getProjects() {
			return projects;
		}
		public void setProjects(List<Project> projects) {
			this.projects = projects;
		}
		public List<Project> getOwnedProjects() {
			return ownedProjects;
		}
		public void setOwnedProjects(List<Project> ownedProjects) {
			this.ownedProjects = ownedProjects;
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