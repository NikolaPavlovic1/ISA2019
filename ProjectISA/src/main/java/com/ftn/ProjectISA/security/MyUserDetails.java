package com.ftn.ProjectISA.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ftn.ProjectISA.enums.Role;

public class MyUserDetails implements UserDetails{

	private String username;
	private String password;
	private boolean active;
	private List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	
	public MyUserDetails(String username, String password, Role role, boolean active) {
		this.username = username;
		this.password = password;
		this.active = active;
		this.authorities.add(new SimpleGrantedAuthority(role.toString()));
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return active;
	}

}
