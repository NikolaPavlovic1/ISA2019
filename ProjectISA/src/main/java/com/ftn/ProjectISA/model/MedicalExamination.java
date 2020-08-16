package com.ftn.ProjectISA.model;

import java.time.LocalDateTime;
import java.time.ZoneId;
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
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ftn.ProjectISA.dto.MedicalExaminationDTO;

@Entity
public class MedicalExamination {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Version
	private Long version;
	
	private LocalDateTime startDateTime;
	private int price;

	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL) 
	private MedicalRoom medicalRoom;
	
	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL) 
	private MedicalRecord medicalRecord;
	
	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL) 
	private User doctor;
	
	@JsonManagedReference
	@ManyToMany(mappedBy = "medicalRecords")
	private List<Disease> diseaseHistory = new ArrayList<Disease>();

	@JsonManagedReference
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private TypeDuration typeAndDuration;
	
	public MedicalExamination() {}
	
	public MedicalExamination(MedicalExaminationDTO me) {
		this.startDateTime = me.getStartDateTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		this.price = me.getPrice();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}
	
	public User getDoctor() {
		return doctor;
	}

	public void setDoctor(User doctor) {
		this.doctor = doctor;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public MedicalRoom getMedicalRoom() {
		return medicalRoom;
	}

	public void setMedicalRoom(MedicalRoom medicalRoom) {
		this.medicalRoom = medicalRoom;
	}

	public List<Disease> getDiseaseHistory() {
		return diseaseHistory;
	}

	public void setDiseaseHistory(List<Disease> diseaseHistory) {
		this.diseaseHistory = diseaseHistory;
	}

	public TypeDuration getTypeAndDuration() {
		return typeAndDuration;
	}

	public void setTypeAndDuration(TypeDuration typeAndDuration) {
		this.typeAndDuration = typeAndDuration;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	

	
}
