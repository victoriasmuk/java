package com.victoriasmuk.Books.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=2, message="Title must be at least 2 characters long.")
	private String title;
	
	@NotNull
	@Size(min=2, message="Description must be at least 2 characters long.")
	private String description;
	
	@NotNull
	@Size(min=2, message="Language must be at least 2 characters long.")
	private String language;
	
	@NotNull
	@Min(value=1, message="Must be at least one page.")
	private Integer pages;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	public Book() {}
		public Book(String title, String description, String language, Integer pages) {
			this.title = title;
			this.description = description;
			this.language = language;
			this.pages = pages;
		}
		
		public Long getId() {
			return id;
		}
		public String getTitle() {
			return title;
		}
		public String getDescription() {
			return description;
		}
		public String getLanguage() {
			return language;
		}
		public Integer getPages() {
			return pages;
		}
		public Date getCreatedAt() {
			return createdAt;
		}
		public Date getUpdatedAt() {
			return updatedAt;
		}
		
		public void setId(Long id) {
			this.id = id;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public void setLanguage(String language) {
			this.language = language;
		}
		public void setPages(Integer pages) {
			this.pages = pages;
		}
		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}
		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}
		
		@PrePersist
		protected void onCreate() {
			this.createdAt = new Date();
		}
		
		@PreUpdate
		protected void onUpdate() {
			this.updatedAt = new Date();
		}
}
