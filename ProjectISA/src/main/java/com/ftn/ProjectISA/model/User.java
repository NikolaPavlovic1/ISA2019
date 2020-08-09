package com.ftn.ProjectISA.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
	private boolean approved;
	private boolean declined;
	private String confirmationKey;
	private Role role; 
	
	@JsonManagedReference
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Address address;
	
	@JsonManagedReference
	@OneToOne(mappedBy="user",cascade=CascadeType.ALL)
    private MedicalRecord medicalRecord;
	
	@JsonManagedReference
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="user")
	private List<ClinicRate> patientClinicRates = new ArrayList<ClinicRate>();
	
	@JsonManagedReference
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="patient")
	private List<DoctorRate> patientDoctorRates = new ArrayList<DoctorRate>();
	
	
	
	//doctors
	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL) 
	private Clinic clinic;
	
	@JsonManagedReference
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="doctor")
	private List<MedicalExamination> doctorsScheduledExaminations = new ArrayList<MedicalExamination>();
	
	@JsonManagedReference
	@ManyToMany(mappedBy = "doctors")
	private List<TypeDuration> typesOfExamination = new ArrayList<TypeDuration>();
	
	@JsonManagedReference
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="doctor")
	private List<DoctorRate> doctorRates = new ArrayList<DoctorRate>();
	
	
	
	public User() {}
	
	public User(UserDTO u) {
		this.name = u.getName();
		this.lastName = u.getLastName();
		this.email = u.getEmail();
		this.username = u.getUsername();
		this.phoneNumber = u.getPhoneNumber();
		this.insuranceNumber = u.getInsuranceNumber();
		this.address = u.getAddress();
		this.medicalRecord = new MedicalRecord();
		this.medicalRecord.setUser(this);
		this.role = u.getRole();
		this.active = false;
		this.approved = false;
		this.declined = false;
		this.setConfirmationKey(null);
		
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

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved= approved;
	}

	public String getConfirmationKey() {
		return confirmationKey;
	}

	public void setConfirmationKey(String confirmationKey) {
		this.confirmationKey = confirmationKey;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	public List<MedicalExamination> getDoctorsScheduledExaminations() {
		return doctorsScheduledExaminations;
	}

	public void setDoctorsScheduledExaminations(List<MedicalExamination> doctorsScheduledExaminations) {
		this.doctorsScheduledExaminations = doctorsScheduledExaminations;
	}

	public List<TypeDuration> getTypesOfExamination() {
		return typesOfExamination;
	}

	public void setTypesOfExamination(List<TypeDuration> typesOfExamination) {
		this.typesOfExamination = typesOfExamination;
	}

	public List<ClinicRate> getPatientClinicRates() {
		return patientClinicRates;
	}

	public void setPatientClinicRates(List<ClinicRate> patientClinicRates) {
		this.patientClinicRates = patientClinicRates;
	}

	public List<DoctorRate> getPatientDoctorRates() {
		return patientDoctorRates;
	}

	public void setPatientDoctorRates(List<DoctorRate> patientDoctorRates) {
		this.patientDoctorRates = patientDoctorRates;
	}

	public List<DoctorRate> getDoctorRates() {
		return doctorRates;
	}

	public void setDoctorRates(List<DoctorRate> doctorRates) {
		this.doctorRates = doctorRates;
	}
	
	public double getAvgDoctorRate() {
		if(this.doctorRates.size() == 0) {
			return 0;
		}
		
		double result = 0;
		for(DoctorRate rate : this.doctorRates) {
			result+=rate.getRate();
		}
		
		return result/this.doctorRates.size();
	}

	public boolean isDeclined() {
		return declined;
	}

	public void setDeclined(boolean declined) {
		this.declined = declined;
	}

}
