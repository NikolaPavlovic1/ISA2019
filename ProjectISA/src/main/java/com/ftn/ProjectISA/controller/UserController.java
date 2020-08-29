package com.ftn.ProjectISA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.ProjectISA.dto.AuthenticationRequest;
import com.ftn.ProjectISA.dto.AuthenticationResponse;
import com.ftn.ProjectISA.dto.RateDTO;
import com.ftn.ProjectISA.dto.UserDTO;
import com.ftn.ProjectISA.security.JwtUtil;
import com.ftn.ProjectISA.security.MyUserDetailsService;
import com.ftn.ProjectISA.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	MyUserDetailsService userDetailsService;
	
	@Autowired
	JwtUtil jwtUtil;

	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@GetMapping(value = "/all")
	public ResponseEntity<List<UserDTO>> findAllUsers() {
		List<UserDTO> retVal = userService.findAllUsers();
		return new ResponseEntity<List<UserDTO>>(retVal, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}") 
	public ResponseEntity<UserDTO> findUser(@PathVariable Long id) { 
		UserDTO retVal = userService.findUser(id); 
		return new ResponseEntity<UserDTO>(retVal, HttpStatus.OK); 
	}
	
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@GetMapping(value = "/approve/{id}") 
	public ResponseEntity<Boolean> approveUser(@PathVariable Long id) { 
		Boolean retVal = userService.approveUser(id);
		return new ResponseEntity<Boolean>(retVal,HttpStatus.OK); 
	}
	
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@GetMapping(value = "/decline/{id}") 
	public ResponseEntity<Boolean> declineUser(@PathVariable Long id) { 
		Boolean retVal = userService.declineUser(id);
		return new ResponseEntity<Boolean>(retVal,HttpStatus.OK); 
	}
	
	@PreAuthorize("hasAuthority('PATIENT')")
	@PostMapping(consumes = "application/json", value = "/rate") 
	public ResponseEntity<Boolean> rate(@RequestBody RateDTO rate) { 
		Boolean retVal = userService.rate(rate);
		return new ResponseEntity<Boolean>(retVal,HttpStatus.OK); 
	}
	
	@GetMapping(value = "/activate/{confirmationKey}") 
	public ResponseEntity<Boolean> activateUser(@PathVariable String confirmationKey) { 
		Boolean retVal = userService.activateAccount(confirmationKey);
		return new ResponseEntity<Boolean>(retVal,HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json", value="/register") 
	public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO){
		UserDTO retVal = userService.registerUser(userDTO); 
		return new ResponseEntity<UserDTO>(retVal, HttpStatus.OK); 
	}
	  
	@PostMapping(consumes = "application/json", value="/login") 
	public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest credentials){
		
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							credentials.getUsername(), credentials.getPassword()));
			
		} catch (BadCredentialsException bce) {
			System.out.println("Bad credentials!!!");
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(credentials.getUsername());
		final String jwt = jwtUtil.generateToken(userDetails);
		final UserDTO user = userService.findUserByUsername(credentials.getUsername());

		return new ResponseEntity<AuthenticationResponse>(
				new AuthenticationResponse(jwt,user.getUsername(),user.getRole(),user.getId()), HttpStatus.OK); 
	}
	
	@GetMapping(value="/logout") 
	public ResponseEntity<Boolean> logout(){
		
		if(SecurityContextHolder.getContext().getAuthentication()!= null) {
			SecurityContextHolder.getContext().setAuthentication(null);
			return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		}
		
		return new ResponseEntity<Boolean>(false,HttpStatus.BAD_REQUEST);
	}
	
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@GetMapping(value = "/{doctorId}/{typeId}") 
	public ResponseEntity<Boolean> addTypeToDoctor(@PathVariable Long doctorId, @PathVariable Long typeId) { 
		Boolean retVal = userService.addTypeToDoctor(doctorId, typeId);
		return new ResponseEntity<Boolean>(retVal,HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@GetMapping(value = "addDoctorToClinic/{doctorId}/{clinicId}") 
	public ResponseEntity<Boolean> addDoctorToClinic(@PathVariable Long doctorId, @PathVariable Long clinicId) { 
		Boolean retVal = userService.addDoctorToClinic(doctorId, clinicId);
		return new ResponseEntity<Boolean>(retVal,HttpStatus.OK);
	}
	
	
	@PutMapping(consumes = "application/json") 
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO){ 
		UserDTO retVal = userService.updateUser(userDTO); 
		return new ResponseEntity<UserDTO>(retVal, HttpStatus.OK); 
	}
	
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@DeleteMapping(value = "/{id}") 
	public ResponseEntity<?> deleteUser(@PathVariable Long id){ 
		userService.deleteUser(id);
		return new ResponseEntity<>("User deleted successfully", HttpStatus.OK); 
	}

}
