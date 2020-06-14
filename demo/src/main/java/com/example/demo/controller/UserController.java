package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.EmailService;
import com.example.demo.service.UserService;


@RestController
@RequestMapping(value = "users")
public class UserController {

	
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private EmailService emailService;

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@RequestMapping(value = "/registration", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<User> registerUser(
			@RequestBody User newUser) {

		newUser.setTempPassword(newUser.getPassword());
		String hashPass = "";
		hashPass = encoder.encode(newUser.getPassword());
		newUser.setPassword(hashPass);
		newUser.setVerified(false);
		

		try {
			emailService.sendingMailForVerification(newUser);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
		}

		userService.saveUser(newUser);

		return new ResponseEntity<>(newUser, HttpStatus.OK);
	}

	@RequestMapping(value = "/getCurrentUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User getCurrentUser(@Context HttpServletRequest request) {
		User user = userService.getCurrentUser();
		return user;
	}

	@RequestMapping(value = "/change", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<User> changeUser(@RequestBody User newUser) {
		
		String hashPass = "";
		hashPass = encoder.encode(newUser.getPassword());
		newUser.setPassword(hashPass);
		userService.saveUser(newUser);

		return new ResponseEntity<>(newUser, HttpStatus.OK);
	}

	@RequestMapping(value = "/verify/{email}", method = RequestMethod.GET)
	public String verifikuj(@PathVariable String email) {
		User user = userService.findByEmail(email);
		user.setVerified(true);
		user.setRole(Role.REGISTERED);
		userService.saveUser(user);
		return "You have successfully verified the account!";
	}
	
	@RequestMapping(value = "/currentUser", method = RequestMethod.GET)
	public User currentUser(@Context HttpServletRequest request) {
		return userService.getCurrentUser();
	}
}
