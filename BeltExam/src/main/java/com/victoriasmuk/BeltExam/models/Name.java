package com.victoriasmuk.BeltExam.models;

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
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="names")
public class Name {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Name is required")
	@Size(min=2, message="Name must be at least 2 characters.")
	private String babyName;
	
	@NotBlank(message="Gender is required.")
	@Size(min=3, message="Please select a gender.")
	private String gender;
	
	@NotBlank(message="Origin is required.")
	private String origin;
	
	@NotBlank(message="Meaning is required.")
	private String meaning;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
	@ManyToMany
	@JoinTable(
		name="users_names",
		joinColumns = @JoinColumn(name="name_id"),
		inverseJoinColumns = @JoinColumn(name="user_id")
		)
	private List<User> users;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="own_id")
	private User own;
	
	
	public Name() {}
		public Name(String babyName, String gender, String origin, String meaning, List<User> users, User own) {
			super();
			this.babyName = babyName;
			this.gender = gender;
			this.origin = origin;
			this.meaning = meaning;
			this.users = users;
			this.own = own;
		}
		public Name(Long id, String babyName, String gender, String origin, String meaning, List<User> users, User own) {
			super();
			this.id = id;
			this.babyName = babyName;
			this.gender = gender;
			this.origin = origin;
			this.meaning = meaning;
			this.users = users;
			this.own = own;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getBabyName() {
			return babyName;
		}
		public void setBabyName(String babyName) {
			this.babyName = babyName;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getOrigin() {
			return origin;
		}
		public void setOrigin(String origin) {
			this.origin = origin;
		}
		public String getMeaning() {
			return meaning;
		}
		public void setMeaning(String meaning) {
			this.meaning = meaning;
		}
		public List<User> getUsers() {
			return users;
		}
		public void setUsers(List<User> users) {
			this.users = users;
		}
		public User getOwn() {
			return own;
		}
		public void setOwn(User own) {
			this.own = own;
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
