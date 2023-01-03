package com.springboot.webservice.restful.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.webservice.restful.dto.PostDto;
import com.springboot.webservice.restful.entity.Post;
import com.springboot.webservice.restful.entity.User;
import com.springboot.webservice.restful.exception.UserNotFoundException;
import com.springboot.webservice.restful.repository.PostRepository;
import com.springboot.webservice.restful.repository.UserRepository;

@Component
public class PostService {
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public List<Post> getPosts(){
		Iterable<Post> postsIt = postRepository.findAll();
	    return StreamSupport.stream(postsIt.spliterator(), false).collect(Collectors.toList());	
	}
	
	public Post findPostByPostId(Long id) {
		if(id==null) {
			return null; 
		}
		Optional<Post> postOpt=postRepository.findById(id);
		if(!postOpt.isPresent()) {
			throw new UserNotFoundException("id:"+id+ " not found");
		}
		return postOpt.get();
	}
	
	public List<Post> getUserPosts(Long userId){
		if(userId==null) {
			throw new UserNotFoundException("id: "+userId+ " not found");
		}	
		return postRepository.findByUser_id(userId);
	}
	
	/*
	 * public Post getUserPost(Long userId,Long postId) {
	 * if(userId==null||postId==null) { throw new
	 * UserNotFoundException("id: "+userId+ " not found"); } Optional<Post>
	 * postOpt=postRepository.findFirstByIdAndUser_id(userId,postId);
	 * 
	 * if(!postOpt.isPresent()) { throw new
	 * UserNotFoundException("No data found related to the  entered Id"); }
	 * 
	 * return postOpt.get();
	 * 
	 * }
	 */
	
	
	public Post addPost(PostDto postDto,Long userId ) {
		if(postDto ==null||userId==null) {
			throw new UserNotFoundException("Please eneter a valid post data");
		}
		
		Optional<User> userOpt = userRepository.findById(userId);
		if(!userOpt.isPresent()) {  
			throw new UserNotFoundException("the user is not exists");
		}
		Post post=new Post();
		post.setDescription(postDto.getDescription());
		post.setPostingTime(LocalDateTime.now());
		post.setUser(userOpt.get());
		postRepository.save(post);
		return post;
	}
	
	public Post deletPost(Long id) {
		
		if(id==null) {
			throw new UserNotFoundException("Please inter a valid id");
		}
		Optional<Post> postOpt=postRepository.findById(id);
		if(!postOpt.isPresent()) {
			throw new UserNotFoundException("No Post found for the entred id");
		}
		postRepository.deleteById(id);
		
		return postOpt.get();
	}


}
