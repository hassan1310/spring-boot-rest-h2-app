package com.springboot.webservice.restful.beans;

import lombok.Data;

@Data
public class HelloWorldBean{
	
	private String message;

	public HelloWorldBean(String message) {
		this.message=message;
	}

}
