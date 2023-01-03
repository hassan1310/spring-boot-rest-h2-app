package com.springboot.webservice.restful.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
@Entity(name = "USER_DETAILS")
//@JsonIgnoreProperties({"id","user_name"})
public class User {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	//@JsonIgnore
	private Long id;
	
	@Past(message = "the birth date should be less than the current date")
	@NotNull (message = "please enter your birth date")
	@Column(name = "BIRTH_DATE")
	@JsonProperty("birth_date")
	private LocalDate birthDate;
	
	@Size(min=2,message = "size can't be less than 2 characters")
	@NotBlank (message = "please enter your name")
	@Column(name = "NAME")
	@JsonProperty("user_name")
	private String name;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	List<Post> posts;
}
