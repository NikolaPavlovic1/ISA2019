package com.ftn.ProjectISA.dto;

import java.time.LocalDateTime;

import com.ftn.ProjectISA.model.MedicalExamination;

public class MedicalExaminationDTO {
	
	private Long id;
	private LocalDateTime startDateTime;
	private Long medicalRecordId;
	private Long doctorId;
	private String type;
	private int duration;
	private int price;
	private Long medicalRoomId;
	
	public MedicalExaminationDTO() {}
	
	public MedicalExaminationDTO(MedicalExamination me) {
		this.id = me.getId();
		this.startDateTime = me.getStartDateTime();
		this.medicalRecordId = me.getMedicalRecord().getId();
		this.doctorId = me.getDoctor().getId();
		this.type = me.getType();
		this.duration = me.getDuration();
		this.price = me.getPrice();
		this.medicalRecordId = me.getMedicalRoom().getId();
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

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public Long getMedicalRecordId() {
		return medicalRecordId;
	}

	public void setMedicalRecordId(Long medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}

	public String getType() {
		return type;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Long getMedicalRoomId() {
		return medicalRoomId;
	}

	public void setMedicalRoomId(Long medicalRoomId) {
		this.medicalRoomId = medicalRoomId;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
