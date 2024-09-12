package com.in.ankush.dto;

import lombok.Builder;

@Builder
public class UserDto {
	
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDto(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	private String name;
	private String email;

	
	// Private constructor
	private UserDto(UserDtoBuilder builder) {
        this.email = builder.email;
        this.name = builder.name;
    }
	
	// Static method to get a builder instance
    public static UserDtoBuilder builder() {
        return new UserDtoBuilder();
    }
    
    // Static inner class for building UserDto
    public static class UserDtoBuilder {
        private String email;
        private String name;

        public UserDtoBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserDto build() {
            return new UserDto(this);
        }
    }
}
