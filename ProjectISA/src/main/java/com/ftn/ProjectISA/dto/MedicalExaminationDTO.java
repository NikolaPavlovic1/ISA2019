package com.ftn.ProjectISA.dto;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.ftn.ProjectISA.model.MedicalExamination;
import com.ftn.ProjectISA.model.MedicalRecord;

public class MedicalExaminationDTO {
	
	private Long id;
	private LocalDateTime startDateTime;
	private MedicalRecordDTO medicalRecord;
	
	public MedicalExaminationDTO() {}
	
	public MedicalExaminationDTO(MedicalExamination me) {
		this.id = me.getId();
		this.startDateTime = me.getStartDateTime();
		this.medicalRecord = new MedicalRecordDTO(me.getMedicalRecord());
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

	public MedicalRecordDTO getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(MedicalRecordDTO medicalRecord) {
		this.medicalRecord = medicalRecord;
	}
	
	

}
