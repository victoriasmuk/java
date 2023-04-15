package com.victoriasmuk.SafeTravels.models;

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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="expenses")
public class Expense {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank(message = "Expense name is required")
	private String expenseName;
	
	@NotBlank(message = "Vendor is required")
	private String vendor;
	
	@NotNull(message = "Amount is required")
	@Min(value = 1, message = "Must be greater than 0")
	private Integer amount;
	
	@NotBlank(message = "Description is required")
	private String description;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public Expense() {}
    
    	public Expense(String expenseName, String vendor, Integer amount, String description) {
    		this.expenseName = expenseName;
    		this.vendor = vendor;
    		this.amount = amount;
    		this.description = description;
    	}
    	
    	public Long getId() {
    		return id;
    	}
    	public void setId(Long id) {
    		this.id = id;
    	}
    	public String getExpenseName() {
    		return expenseName;
    	}
    	public void setExpenseName(String expenseName) {
    		this.expenseName = expenseName;
    	}
    	public String getVendor() {
    		return vendor;
    	}
    	public void setVendor(String vendor) {
    		this.vendor = vendor;
    	}
    	public Integer getAmount() {
    		return amount;
    	}
    	public void setAmount(Integer amount) {
    		this.amount = amount;
    	}
    	public String getDescription() {
    		return description;
    	}
    	public void setDescription(String description) {
    		this.description = description;
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
