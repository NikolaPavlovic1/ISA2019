package com.ftn.ProjectISA.dto;

import com.ftn.ProjectISA.enums.Role;

public class AuthenticationResponse {

	private String token;
	private String username;
	private String role;
	
	public AuthenticationResponse() {}
	
	public AuthenticationResponse(String token, String username, Role role) {
		this.token = token;
		this.username = username;
		this.role = role.toString();
	}
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
