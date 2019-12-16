package com.myservs.demo.Dto;

import java.util.Date;

public class ExceptionDTO {

	private Date timeStmp;
	private String message;
	private String details;
	
	public ExceptionDTO(Date timeStmp, String message, String details) {
		super();
		this.timeStmp = timeStmp;
		this.message = message;
		this.details = details;
	}
	public Date getTimeStmp() {
		return timeStmp;
	}
	public void setTimeStmp(Date timeStmp) {
		this.timeStmp = timeStmp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
	
}
