package com.in.ankush.io;

import lombok.Builder;

@Builder
public class CategoryRequest {
	
	private String name;
	private String description;
	private String icon;
	
	  // Private constructor
    private CategoryRequest(CategoryRequestBuilder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.icon = builder.icon;
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
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public CategoryRequest(String name, String description, String icon) {
		super();
		this.name = name;
		this.description = description;
		this.icon = icon;
	}
	public CategoryRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	

    // Static nested builder class
    public static class CategoryRequestBuilder {
        private String name;
        private String description;
        private String icon;

        public CategoryRequestBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CategoryRequestBuilder description(String description) {
            this.description = description;
            return this;
        }

        public CategoryRequestBuilder icon(String icon) {
            this.icon = icon;
            return this;
        }

        public CategoryRequest build() {
            return new CategoryRequest(this);
        }
    }

    // Static method to get a builder instance
    public static CategoryRequestBuilder builder() {
        return new CategoryRequestBuilder();
    }
}
