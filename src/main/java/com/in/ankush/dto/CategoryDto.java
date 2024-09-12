package com.in.ankush.dto;

import java.time.LocalDateTime;


public class CategoryDto {

	private String categoryId;
	private String name;
	private String description;
	private String categoryIcon;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private UserDto user;
	
	// private constructor
		 private CategoryDto(CategoryDtoBuilder builder) {
		        this.categoryId = builder.categoryId;
		        this.name = builder.name;
		        this.description = builder.description;
		        this.categoryIcon = builder.categoryIcon;
		        this.createdAt = builder.createdAt;
		        this.updatedAt = builder.updatedAt;
		        this.user = builder.user;
		    }
		 
		// Static method to get a builder instance
	    public static CategoryDtoBuilder builder() {
	        return new CategoryDtoBuilder();
	    }
		    
			 
			 
	 public static class CategoryDtoBuilder {
	        private String categoryId;
	        private String name;
	        private String description;
	        private String categoryIcon;
	        private LocalDateTime  createdAt;
	        private LocalDateTime  updatedAt;
	        private UserDto user;


	        public CategoryDtoBuilder categoryId(String categoryId) {
	            this.categoryId = categoryId;
	            return this;
	        }

	        public CategoryDtoBuilder name(String name) {
	            this.name = name;
	            return this;
	        }

	        public CategoryDtoBuilder description(String description) {
	            this.description = description;
	            return this;
	        }

	        public CategoryDtoBuilder categoryIcon(String categoryIcon) {
	            this.categoryIcon = categoryIcon;
	            return this;
	        }

	        public CategoryDtoBuilder createdAt(LocalDateTime  createdAt) {
	            this.createdAt = createdAt;
	            return this;
	        }

	        public CategoryDtoBuilder updatedAt(LocalDateTime  updatedAt) {
	            this.updatedAt = updatedAt;
	            return this;
	        }
	        public CategoryDtoBuilder user(UserDto user) {
	            this.user = user;
	            return this;
	        }

	        public CategoryDto build() {
	            return new CategoryDto(this);
	        }
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
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime  getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	} 
	
	
	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CategoryDto(String categoryId, String name, String description, String categoryIcon, LocalDateTime  createdAt,
			LocalDateTime updatedAt, UserDto user) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.description = description;
		this.categoryIcon = categoryIcon;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.user=user;
		
	}
	

	}
