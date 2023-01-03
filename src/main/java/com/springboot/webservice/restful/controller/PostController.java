package com.springboot.webservice.restful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.webservice.restful.dto.PostDto;
import com.springboot.webservice.restful.entity.Post;
import com.springboot.webservice.restful.service.PostService;

import jakarta.validation.Valid;

@RestController
public class PostController {
	
	@Autowired
	PostService postService;
	
	/*
	 * @GetMapping("/user/posts") public List<Post> getPosts(){ return
	 * postService.getPosts(); }
	 */
	
	@GetMapping("/user/{userId}/posts")
	public List<Post> getUserPosts(@PathVariable("userId") Long userId){
		return postService.getUserPosts(userId);
	}
	
	@GetMapping("/user/posts/{postId}")
	public Post getPostByid(@PathVariable("postId") Long postId){
		return postService.findPostByPostId(postId);
	}
	
	
	/*
	 * @GetMapping("/{userId}/posts/{postId}") public Post
	 * getUserPost(@PathVariable("userId") Long userId,@PathVariable("postId") Long
	 * postId){ return postService.getUserPost(userId,postId); }
	 */
	
	@PostMapping("/user/{userId}/posts")
	public Post createPost(@Valid  @RequestBody PostDto postDto ,@PathVariable("userId") Long userId) {	
		return postService.addPost(postDto,userId);
	}
	
	@DeleteMapping("/user/posts/{postId}")
	public Post deletePost(@PathVariable("postId") Long postId) {	
		return postService.deletPost(postId);
	}
	
	
	
	

}
