package com.springboot.webservice.restful.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data    //error response structure
public class ErrorDetails {
	
	private LocalDateTime timeStamp;
	private String message;
	private String description;
	public ErrorDetails(LocalDateTime timeStamp, String message, String description) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.description = description;
	}
	
	

	

}
