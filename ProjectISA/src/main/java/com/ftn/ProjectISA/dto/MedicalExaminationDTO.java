package com.ftn.ProjectISA.dto;


import java.time.ZoneId;
import java.util.Date;

import com.ftn.ProjectISA.model.MedicalExamination;

public class MedicalExaminationDTO {
	
	private Long id;
	private Date startDateTime;
	private Long medicalRecordId;
	private Long doctorId;
	private Long typeDurationId;
	private int price;
	private Long medicalRoomId;
	
	
	public MedicalExaminationDTO() {}
	
	public MedicalExaminationDTO(MedicalExamination me) {
		this.id = me.getId();
		this.startDateTime = Date.from(me.getStartDateTime().atZone(ZoneId.systemDefault()).toInstant());
		if(me.getMedicalRecord()!= null) {
			this.medicalRecordId = me.getMedicalRecord().getId();	
		}
		this.doctorId = me.getDoctor().getId();
		this.typeDurationId = me.getTypeAndDuration().getId();
		this.price = me.getPrice();
		this.medicalRoomId = me.getMedicalRoom().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Date startDateTime) {
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

	public Long getTypeDurationId() {
		return typeDurationId;
	}

	public void setTypeDurationId(Long typeDurationId) {
		this.typeDurationId = typeDurationId;
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

	
	

}
