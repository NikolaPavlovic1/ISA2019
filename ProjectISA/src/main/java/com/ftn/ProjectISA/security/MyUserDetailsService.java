package com.ftn.ProjectISA.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ftn.ProjectISA.model.User;
import com.ftn.ProjectISA.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userRepository.findByUsername(username);
		
		if(user == null) {
			System.out.println("NNNNNNNNNNNNNNNNNNNNNNNNNNN");
		}
		
		
		
		if(user == null)
			throw new UsernameNotFoundException("User with username " + username + " does not exists");
		
		
		System.out.println(user.getUsername());
		System.out.println(user.getRole());
		System.out.println(user.getPassword());
		System.out.println(user.isActive());
		
		
		return new MyUserDetails(user.getUsername(),user.getPassword(),user.getRole(),user.isActive());
	}
	
	

}
