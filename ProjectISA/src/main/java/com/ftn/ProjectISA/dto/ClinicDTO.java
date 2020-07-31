package com.ftn.ProjectISA.dto;

import java.util.ArrayList;
import java.util.List;

import com.ftn.ProjectISA.model.Address;
import com.ftn.ProjectISA.model.Clinic;
import com.ftn.ProjectISA.model.User;

public class ClinicDTO {
	
	private Long id;
	private List<UserDTO> doctors = new ArrayList<UserDTO>();
	private Address address;
	private String name;
	
	public ClinicDTO() {}
	
	public ClinicDTO(Clinic clinic) {
		this.id = clinic.getId();
		this.address = clinic.getAddress();
		this.name = clinic.getName();
		for(User u : clinic.getDoctors()) {
			this.doctors.add(new UserDTO(u));
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<UserDTO> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<UserDTO> doctors) {
		this.doctors = doctors;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
