package com.springboot.webservice.restful.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.webservice.restful.entity.User;
import com.springboot.webservice.restful.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/users")
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@GetMapping("/users/{id}")
	public EntityModel<User>  getUserById(@PathVariable("id") Long id) {
		User user =userService.findUserById(id);
		EntityModel<User> entityModel=EntityModel.of(user);
		WebMvcLinkBuilder link=linkTo(methodOn(this.getClass()).getUsers());
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}

	@PostMapping("/users")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
		userService.addUser(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(user);
	}
	
	@DeleteMapping("/users/{id}")
	public User deleteUserById(@PathVariable("id") Long id) {
		User user = userService.deleteUser(id);
		return user;
	}
}
