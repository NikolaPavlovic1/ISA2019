package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUsername(String username);
	
	@Query("select user from User user where user.email = :email")
	public User findOneByEmail(@Param("email") String email);
}
