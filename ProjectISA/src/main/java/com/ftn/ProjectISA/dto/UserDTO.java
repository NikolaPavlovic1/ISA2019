package com.ftn.ProjectISA.dto;

import java.util.ArrayList;
import java.util.List;

import com.ftn.ProjectISA.enums.Role;
import com.ftn.ProjectISA.model.Address;
import com.ftn.ProjectISA.model.MedicalExamination;
import com.ftn.ProjectISA.model.PricelistItem;
import com.ftn.ProjectISA.model.TypeDuration;
import com.ftn.ProjectISA.model.User;

public class UserDTO {

	private Long id;
	private String name;
	private String lastName;
	private String email;
	private String username;
	private String password;
	private String phoneNumber;
	private String insuranceNumber;
	private Address address;
	private MedicalRecordDTO medicalRecord;
	private Role role;
	private boolean active;
	private boolean approved;
	private List<MedicalExaminationDTO> doctorsScheduledExaminations = new ArrayList<MedicalExaminationDTO>();
	private Long clinicId;
	private List<TypeDurationDTO> typesOfExamination = new ArrayList<TypeDurationDTO>();
	
	public UserDTO() {}

	public UserDTO(Long id, String name, String lastName, String email, String username, String password,
			String phoneNumber, String insuranceNumber, Address address, MedicalRecordDTO medicalRecord,
			Role role, boolean active, boolean approved) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.insuranceNumber = insuranceNumber;
		this.address = address;
		this.medicalRecord = medicalRecord;
		this.role = role;
		this.active = active;
		this.approved = approved;
	}
	
	public UserDTO(User u) {
		this.id = u.getId();
		this.name = u.getName();
		this.lastName = u.getLastName();
		this.email = u.getEmail();
		this.username = u.getUsername();
		this.password = u.getPassword();
		this.phoneNumber = u.getPhoneNumber();
		this.insuranceNumber = u.getInsuranceNumber();
		this.address = u.getAddress();
		this.medicalRecord = new MedicalRecordDTO(u.getMedicalRecord());
		this.role = u.getRole();
		this.active = u.isActive();
		this.approved = u.isApproved();
		for(MedicalExamination me: u.getDoctorsScheduledExaminations()) {
			this.doctorsScheduledExaminations.add(new MedicalExaminationDTO(me));
		}
		if(u.getClinic()!= null) {
			this.clinicId = u.getClinic().getId();	
		}
		for(TypeDuration td: u.getTypesOfExamination()) {
			TypeDurationDTO toAdd = new TypeDurationDTO(td);
			for(PricelistItem pli : u.getClinic().getPricelist()) {
				if(pli.getTypeOfExamination().equals(toAdd.getType())) {
					toAdd.setPrice(pli.getPrice());
					this.typesOfExamination.add(toAdd);
					break;
				}
			}
			
		}
		
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public List<MedicalExaminationDTO> getDoctorsScheduledExaminations() {
		return doctorsScheduledExaminations;
	}

	public void setDoctorsScheduledExaminations(List<MedicalExaminationDTO> doctorsScheduledExaminations) {
		this.doctorsScheduledExaminations = doctorsScheduledExaminations;
	}

	public Long getClinicId() {
		return clinicId;
	}

	public void setClinicId(Long clinicId) {
		this.clinicId = clinicId;
	}

	public List<TypeDurationDTO> getTypesOfExamination() {
		return typesOfExamination;
	}

	public void setTypesOfExamination(List<TypeDurationDTO> typesOfExamination) {
		this.typesOfExamination = typesOfExamination;
	}
	
	
	
	
	
}
