 package com.in.ankush.entity;

import java.time.LocalDateTime;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "tbl_categories")
@Data
@Builder
public class CategoryEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	private String categoryId;
	
	@Column(unique=true)
	private String name;
	
	private String description;
	private String categoryIcon;
	
	@CreationTimestamp
	private LocalDateTime  createdAt;
	
	@UpdateTimestamp
	private LocalDateTime  updatedAt;
	
	@JoinColumn(name="user_id",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategoryIcon() {
		return categoryIcon;
	}

	public void setCategoryIcon(String categoryIcon) {
		this.categoryIcon = categoryIcon;
	}

	public LocalDateTime  getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime  createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime  getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime  updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public CategoryEntity(Long id, String categoryId, String name, String description, String categoryIcon,
			LocalDateTime  createdAt, LocalDateTime  updatedAt, User user) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
		this.description = description;
		this.categoryIcon = categoryIcon;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.user = user;
	}

	public CategoryEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	private CategoryEntity(CategoryEntityBuilder builder) {
        this.categoryId = builder.categoryId;
        this.name = builder.name;
        this.description = builder.description;
        this.categoryIcon = builder.categoryIcon;
        this.user = builder.user;
    }
	
    // Static builder method
	 public static CategoryEntityBuilder builder() {
	        return new CategoryEntityBuilder();
	    }
	 
	// Inner static builder class
	    public static class CategoryEntityBuilder {
	        private String categoryId;
	        private String name;
	        private String description;
	        private String categoryIcon;
	        private User user;

	        // Builder methods
	        public CategoryEntityBuilder categoryId(String categoryId) {
	            this.categoryId = categoryId;
	            return this;
	       }
	        
	        public CategoryEntityBuilder name(String name) {
	            this.name = name;
	            return this;
	        }

	        public CategoryEntityBuilder description(String description) {
	            this.description = description;
	            return this;
	        }

	        public CategoryEntityBuilder categoryIcon(String categoryIcon) {
	            this.categoryIcon = categoryIcon;
	            return this;
	        }

	        public CategoryEntityBuilder user(User user) {
	            this.user = user;
	            return this;
	        }

	        // Build method to return the final object
	        public CategoryEntity build() {
	            return new CategoryEntity(this);
	        }
	    }
}
