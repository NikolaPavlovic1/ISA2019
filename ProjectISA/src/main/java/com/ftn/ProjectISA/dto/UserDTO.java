package com.ftn.ProjectISA.dto;

import com.ftn.ProjectISA.enums.Role;
import com.ftn.ProjectISA.model.Address;
import com.ftn.ProjectISA.model.User;

public class UserDTO {

	private Long id;
	private String name;
	private String lastName;
	private String email;
	private String userName;
	private String password;
	private String phoneNumber;
	private String insuranceNumber;
	private Address address;
	private MedicalRecordDTO medicalRecord;
	private Role role;
	
	public UserDTO() {}

	public UserDTO(Long id, String name, String lastName, String email, String userName, String password,
			String phoneNumber, String insuranceNumber, Address address, MedicalRecordDTO medicalRecord,
			Role role) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.insuranceNumber = insuranceNumber;
		this.address = address;
		this.medicalRecord = medicalRecord;
		this.role = role;
	}
	
	public UserDTO(User u) {
		this.id = u.getId();
		this.name = u.getName();
		this.lastName = u.getLastName();
		this.email = u.getEmail();
		this.userName = u.getUserName();
		this.password = u.getPassword();
		this.phoneNumber = u.getPhoneNumber();
		this.insuranceNumber = u.getInsuranceNumber();
		this.address = u.getAddress();
		this.medicalRecord = new MedicalRecordDTO(u.getMedicalRecord());
		this.role = u.getRole();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public MedicalRecordDTO getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(MedicalRecordDTO medicalRecord) {
		this.medicalRecord = medicalRecord;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
	
	
}
