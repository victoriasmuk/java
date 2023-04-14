package com.victoriasmuk.BurgerTracker.models;

import java.util.Date;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "burgers")
public class Burger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Burger name is required")
	private String burgerName;

	@NotBlank(message = "Restaurant name is required")
	private String restaurantName;

	@NotNull(message = "Rating is required")
	@Range(min = 1, max = 5, message = "Must be between 1 - 5")
	private Integer rating;

	@NotBlank(message = "Notes are required")
	private String notes;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	public Burger() {}
	
		public Burger(String burgerName, String restaurantName, Integer rating, String notes) {
			this.burgerName = burgerName;
			this.restaurantName = restaurantName;
			this.rating = rating;
			this.notes = notes;
		}

//	GETTERS
	public Long getId() {
		return id;
	}
	public String getBurgerName() {
		return burgerName;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public Integer getRating() {
		return rating;
	}
	public String getNotes() {
		return notes;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}

	
//	SETTERS
	public void setId(Long id) {
		this.id = id;
	}
	public void setBurgerName(String burgerName) {
		this.burgerName = burgerName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public void setNotes(String notes) {
		this.notes = notes;
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
