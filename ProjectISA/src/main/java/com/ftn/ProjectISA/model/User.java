package com.ftn.ProjectISA.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.ftn.ProjectISA.dto.UserDTO;
import com.ftn.ProjectISA.enums.Role;


@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String lastName;
	private String email;
	private String username;
	private String password;
	private String phoneNumber;
	private String insuranceNumber;
	private boolean active;
	private Role role; 
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Address address;
	
	@OneToOne(mappedBy="user")
    private MedicalRecord medicalRecord;
	
	public User() {}
	
	public User(UserDTO u) {
		this.name = u.getName();
		this.lastName = u.getLastName();
		this.email = u.getEmail();
		this.username = u.getUsername();
		this.password = u.getPassword();
		this.phoneNumber = u.getPhoneNumber();
		this.insuranceNumber = u.getInsuranceNumber();
		this.address = u.getAddress();
		this.medicalRecord = new MedicalRecord();
		this.role = u.getRole();
		this.active = false;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getInsuranceNumber() {
		return insuranceNumber;
	}

	public void setInsuranceNumber(String insuranceNumber) {
		this.insuranceNumber = insuranceNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	

}
