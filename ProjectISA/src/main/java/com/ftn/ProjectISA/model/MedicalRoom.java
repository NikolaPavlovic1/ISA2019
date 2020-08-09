package com.ftn.ProjectISA.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class MedicalRoom {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String description;
	
	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL) 
	private Clinic clinic;
	
	@JsonManagedReference
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="medicalRoom")
	private List<MedicalExamination> medicalExaminations = new ArrayList<MedicalExamination>();
	
	public MedicalRoom() {}
	
	public MedicalRoom(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	public List<MedicalExamination> getMedicalExaminations() {
		return medicalExaminations;
	}

	public void setMedicalExaminations(List<MedicalExamination> medicalExaminations) {
		this.medicalExaminations = medicalExaminations;
	}
	
	
}
