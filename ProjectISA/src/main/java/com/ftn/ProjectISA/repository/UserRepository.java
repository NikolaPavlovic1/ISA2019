package com.ftn.ProjectISA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.ProjectISA.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

	User findByUsername(String username);
	
	User findByEmail(String email);
	
	User findByConfirmationKey(String confirmationKey);
}
