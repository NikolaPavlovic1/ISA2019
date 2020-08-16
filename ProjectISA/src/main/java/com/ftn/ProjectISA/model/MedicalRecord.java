package com.ftn.ProjectISA.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class MedicalRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Version
	private Long version;
	
	@JsonBackReference
	@OneToOne
    @JoinColumn (name="user")
	private User user;
	
	@JsonManagedReference
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="medicalRecord")
	private List<MedicalExamination> medicalExaminations = new ArrayList<MedicalExamination>();
	
	@JsonManagedReference
	@ManyToMany(mappedBy = "medicalRecords")
	private List<Disease> diseaseHistory = new ArrayList<Disease>();
	
	public MedicalRecord() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<MedicalExamination> getMedicalExaminations() {
		return medicalExaminations;
	}

	public void setMedicalExaminations(List<MedicalExamination> medicalExaminations) {
		this.medicalExaminations = medicalExaminations;
	}

	public List<Disease> getDiseaseHistory() {
		return diseaseHistory;
	}

	public void setDiseaseHistory(List<Disease> diseaseHistory) {
		this.diseaseHistory = diseaseHistory;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	
	
	
	
}
