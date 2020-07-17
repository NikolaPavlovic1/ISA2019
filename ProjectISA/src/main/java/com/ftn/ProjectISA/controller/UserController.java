package com.ftn.ProjectISA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ftn.ProjectISA.dto.UserDTO;
import com.ftn.ProjectISA.service.UserService;

@Controller
@RequestMapping(value = "api/user")
public class UserController {
	
	@Autowired
	UserService userService;

	@GetMapping(value = "all")
	public ResponseEntity<List<UserDTO>> findAllUsers() {
		List<UserDTO> retVal = userService.findAllUsers();
		return new ResponseEntity<List<UserDTO>>(retVal, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}") 
	public ResponseEntity<UserDTO> findUser(@PathVariable Long id) { 
		UserDTO retVal = userService.findUser(id); 
		return new ResponseEntity<UserDTO>(retVal, HttpStatus.OK); }

	
	  @PostMapping(consumes = "application/json") 
	  public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO){
		  UserDTO retVal = userService.registerUser(userDTO); 
		  return new ResponseEntity<UserDTO>(retVal, HttpStatus.OK); 
	  }
	  
	
	  @PutMapping(consumes = "application/json") 
	  public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO){ 
		  UserDTO retVal = userService.updateUser(userDTO); 
		  return new ResponseEntity<UserDTO>(retVal, HttpStatus.OK); 
	  }
		 
	  @DeleteMapping(value = "/{id}") 
	  public ResponseEntity<?> deleteUser(@PathVariable Long id){ 
		  userService.deleteUser(id);
	  
		  return new ResponseEntity<>("User deleted successfully", HttpStatus.OK); 
	  }

}
