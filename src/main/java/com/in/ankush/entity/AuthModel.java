package com.in.ankush.entity;

public class AuthModel {

	private String email;
	private String password;
	
	
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AuthModel(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public AuthModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
