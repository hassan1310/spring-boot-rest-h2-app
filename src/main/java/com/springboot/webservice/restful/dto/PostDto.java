package com.springboot.webservice.restful.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class PostDto {
	
	@NotEmpty(message ="please enter Post description")
	private String  description;

}
