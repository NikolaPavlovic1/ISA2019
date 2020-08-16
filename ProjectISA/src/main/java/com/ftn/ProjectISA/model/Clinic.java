package com.ftn.ProjectISA.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ftn.ProjectISA.dto.ClinicDTO;

@Entity
public class Clinic {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Version
	private Long version;
	
	private String description;
	
	@JsonManagedReference
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="clinic")
	private List<User> doctors = new ArrayList<User>();
	
	@ElementCollection
	private List<LocalDateTime> appointments = new ArrayList<LocalDateTime>();
	
	@JsonManagedReference
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="clinic")
	private List<MedicalRoom> medicalRooms = new ArrayList<MedicalRoom>();
	
	@JsonManagedReference
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="clinic")
	private List<ClinicRate> clinicRates = new ArrayList<ClinicRate>();
	
	@JsonManagedReference
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Address address;
	
	@JsonManagedReference
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="clinic")
	private List<PricelistItem> pricelist = new ArrayList<PricelistItem>();
	
	private String name;
	
	public Clinic() {}
	
	public Clinic(ClinicDTO clinic) {
		this.address = clinic.getAddress();
		this.name = clinic.getName();
		this.description = clinic.getDescription();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<User> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<User> doctors) {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<LocalDateTime> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<LocalDateTime> appointments) {
		this.appointments = appointments;
	}

	public List<MedicalRoom> getMedicalRooms() {
		return medicalRooms;
	}

	public void setMedicalRooms(List<MedicalRoom> medicalRooms) {
		this.medicalRooms = medicalRooms;
	}

	public List<PricelistItem> getPricelist() {
		return pricelist;
	}

	public void setPricelist(List<PricelistItem> pricelist) {
		this.pricelist = pricelist;
	}

	public List<ClinicRate> getClinicRates() {
		return clinicRates;
	}

	public void setClinicRates(List<ClinicRate> clinicRates) {
		this.clinicRates = clinicRates;
	}
	
	public double getAvgClinicRate() {
		if(this.clinicRates.size() == 0) {
			return 0;
		}
		
		double result = 0;
		for(ClinicRate rate : this.clinicRates) {
			result+=rate.getRate();
		}
		
		return result/this.clinicRates.size();
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	
}
