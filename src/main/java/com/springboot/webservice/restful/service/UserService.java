package com.springboot.webservice.restful.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.webservice.restful.entity.User;
import com.springboot.webservice.restful.exception.UserNotFoundException;
import com.springboot.webservice.restful.repository.UserRepository;

@Component
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> getUsers(){
		Iterable<User> usersIt = userRepository.findAll();
	    return StreamSupport.stream(usersIt.spliterator(), false).collect(Collectors.toList());	
	}
	
	public User findUserById(Long id) {
		if(id==null) {
			return null; 
		}
		Optional<User> userOpt=userRepository.findById(id);
		if(!userOpt.isPresent()) {
			throw new UserNotFoundException("id:"+id+ " not found");
		}
		return userOpt.get();
	}
	
	public User addUser(User user) {
		if(user ==null) {
			return null;
		}
		userRepository.save(user);
		return user;
	}
	
	public User deleteUser(Long id) {
		
		if(id==null) {
			throw new UserNotFoundException("Please inter a valid id");
		}
		Optional<User> userOpt=userRepository.findById(id);
		if(!userOpt.isPresent()) {
			throw new UserNotFoundException("No user found for the entred id");
		}
		userRepository.deleteById(id);
		
		return userOpt.get();
	}

}
