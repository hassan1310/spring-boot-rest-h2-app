package com.springboot.webservice.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.springboot.webservice.restful.entity.User;

@Component
public interface UserRepository extends JpaRepository<User, Long> {

}
