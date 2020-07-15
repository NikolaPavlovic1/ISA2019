package com.ftn.ProjectISA.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ftn.ProjectISA.model.Disease;
import com.ftn.ProjectISA.model.MedicalExamination;
import com.ftn.ProjectISA.model.MedicalRecord;

public class MedicalRecordDTO {

	private Long id;
	private Long patientId;
	private List<LocalDateTime> medicalExaminations = new ArrayList<LocalDateTime>();
	private List<Disease> diseaseHistory = new ArrayList<Disease>();
	
	public MedicalRecordDTO() {}
	
	public MedicalRecordDTO(MedicalRecord mr) {
		this.id = mr.getId();
		this.patientId = mr.getPatient().getId();
		
		for(MedicalExamination me : mr.getMedicalExaminations()) {
			this.medicalExaminations.add(me.getStartDateTime());
		}
		
		this.diseaseHistory = mr.getDiseaseHistory();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public List<LocalDateTime> getMedicalExaminations() {
		return medicalExaminations;
	}

	public void setMedicalExaminations(List<LocalDateTime> medicalExaminations) {
		this.medicalExaminations = medicalExaminations;
	}

	public List<Disease> getDiseaseHistory() {
		return diseaseHistory;
	}

	public void setDiseaseHistory(List<Disease> diseaseHistory) {
		this.diseaseHistory = diseaseHistory;
	}
	
	

}
