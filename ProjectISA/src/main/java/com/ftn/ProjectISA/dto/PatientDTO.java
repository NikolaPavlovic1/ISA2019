package com.ftn.ProjectISA.dto;

import com.ftn.ProjectISA.model.Address;
import com.ftn.ProjectISA.model.Patient;

public class PatientDTO {

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
	
	public PatientDTO() {}

	public PatientDTO(Long id, String name, String lastName, String email, String userName, String password,
			String phoneNumber, String insuranceNumber, Address address, MedicalRecordDTO medicalRecord) {
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
	}
	
	public PatientDTO(Patient p) {
		this.id = p.getId();
		this.name = p.getName();
		this.lastName = p.getLastName();
		this.email = p.getEmail();
		this.userName = p.getUserName();
		this.password = p.getPassword();
		this.phoneNumber = p.getPhoneNumber();
		this.insuranceNumber = p.getInsuranceNumber();
		this.address = p.getAddress();
		this.medicalRecord = new MedicalRecordDTO(p.getMedicalRecord());
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
	
	
	
	
	
}
