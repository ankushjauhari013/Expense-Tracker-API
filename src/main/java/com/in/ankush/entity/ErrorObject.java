package com.in.ankush.entity;

import java.util.Date;

public class ErrorObject {
	
	private Integer statusCode;
	private String message;
	private Date timeStamp;
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public ErrorObject(Integer statusCode, String message, Date timeStamp) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.timeStamp = timeStamp;
	}
	public ErrorObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	
	
}
