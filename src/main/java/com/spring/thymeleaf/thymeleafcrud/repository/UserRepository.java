package com.spring.thymeleaf.thymeleafcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.thymeleaf.thymeleafcrud.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
 
}
