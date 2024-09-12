package com.in.ankush.io;

import java.time.LocalDateTime;

import lombok.Builder;


@Builder
public class CategoryResponse {
	
	private String categoryId;
	private String name;
	private String description;
	private String categoryIcon;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
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
	public String getIcon() {
		return categoryIcon;
	}
	public void setIcon(String icon) {
		this.categoryIcon = icon;
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
	
	
	public CategoryResponse(String categoryId, String name, String description, String icon, LocalDateTime  createdAt,
			LocalDateTime  updatedAt) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.description = description;
		this.categoryIcon = icon;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	public CategoryResponse() {
		super();
	}
	
	// Private constructor accepting a builder
    private CategoryResponse(CategoryResponseBuilder builder) {
        this.categoryId = builder.categoryId;
        this.name = builder.name;
        this.description = builder.description;
        this.categoryIcon = builder.categoryIcon;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
    }
	
	  // Static builder class
    public static class CategoryResponseBuilder {
        private String categoryId;
        private String name;
        private String description;
        private String categoryIcon;
        private LocalDateTime  createdAt;
        private LocalDateTime  updatedAt;

        public CategoryResponseBuilder categoryId(String categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public CategoryResponseBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CategoryResponseBuilder description(String description) {
            this.description = description;
            return this;
        }

        public CategoryResponseBuilder categoryIcon(String categoryIcon) {
            this.categoryIcon = categoryIcon;
            return this;
        }

        public CategoryResponseBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public CategoryResponseBuilder updatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public CategoryResponse build() {
            return new CategoryResponse(this);
        }
    }

}
