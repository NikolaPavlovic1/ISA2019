package com.ftn.ProjectISA.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class DoctorRate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private int rate;
	
	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL) 
	private User patient;
	
	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL) 
	private User doctor;
	
	public DoctorRate() {}
	
	public DoctorRate(int rate) {
		this.rate = rate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public User getPatient() {
		return patient;
	}

	public void setPatient(User patient) {
		this.patient = patient;
	}

	public User getDoctor() {
		return doctor;
	}

	public void setDoctor(User doctor) {
		this.doctor = doctor;
	}
	
	
}
