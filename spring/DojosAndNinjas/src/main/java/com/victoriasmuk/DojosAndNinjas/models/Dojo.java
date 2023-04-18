package com.victoriasmuk.DojosAndNinjas.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="dojos")
public class Dojo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Dojo name is required")
	private String dojoName;
	
	@OneToMany(mappedBy="dojo", fetch=FetchType.LAZY)
	private List<Ninja> ninjas;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	public Dojo () {}
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getDojoName() {
			return dojoName;
		}
		public void setDojoName(String dojoName) {
			this.dojoName = dojoName;
		}
		public List<Ninja> getNinjas() {
			return ninjas;
		}
		public void setNinjas(List<Ninja> ninjas) {
			this.ninjas = ninjas;
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
