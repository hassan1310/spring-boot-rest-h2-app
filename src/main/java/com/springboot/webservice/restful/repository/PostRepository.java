package com.springboot.webservice.restful.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.springboot.webservice.restful.entity.Post;

@Component
public interface PostRepository extends JpaRepository<Post,Long>{

	List<Post> findByUser_id(Long userId);
	Optional<Post> findFirstByIdAndUser_id(Long userId,Long PostId);
}
