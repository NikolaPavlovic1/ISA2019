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
		
		if(user == null)
			throw new UsernameNotFoundException("User with username " + username + " does not exists");
		
		return new MyUserDetails(user.getUsername(),user.getPassword(),user.getRole(),user.isActive());
	}
	
	

}