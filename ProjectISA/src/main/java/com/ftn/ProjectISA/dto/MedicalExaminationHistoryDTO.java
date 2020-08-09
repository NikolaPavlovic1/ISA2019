package com.ftn.ProjectISA.dto;

import java.time.ZoneId;
import java.util.Date;

import com.ftn.ProjectISA.model.MedicalExamination;

public class MedicalExaminationHistoryDTO {
	
	private Date date;
	private String doctorUsername;
	private String type;
	private int duration;
	private int price;
	private String clinic;
	private Long medicalRoom;
	private Long id;
	
	public MedicalExaminationHistoryDTO() {}
	
	public MedicalExaminationHistoryDTO(MedicalExamination me) {
		this.date = Date.from(me.getStartDateTime().atZone(ZoneId.systemDefault()).toInstant());
		this.doctorUsername = me.getDoctor().getUsername();
		this.type = me.getTypeAndDuration().getType();
		this.duration = me.getTypeAndDuration().getDuration();
		this.price = me.getPrice();
		this.clinic = me.getDoctor().getClinic().getName();
		this.medicalRoom = me.getMedicalRoom().getId();
		this.id = me.getId();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDoctorUsername() {
		return doctorUsername;
	}

	public void setDoctorUsername(String doctorUsername) {
		this.doctorUsername = doctorUsername;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getClinic() {
		return clinic;
	}

	public void setClinic(String clinic) {
		this.clinic = clinic;
	}

	public Long getMedicalRoom() {
		return medicalRoom;
	}

	public void setMedicalRoom(Long medicalRoom) {
		this.medicalRoom = medicalRoom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
