package com.ftn.ProjectISA.dto;

import java.util.ArrayList;
import java.util.List;

import com.ftn.ProjectISA.model.Disease;
import com.ftn.ProjectISA.model.MedicalExamination;
import com.ftn.ProjectISA.model.MedicalRecord;

public class MedicalRecordDTO {

	private Long id;
	private Long userId;
	private List<MedicalExaminationDTO> medicalExaminations = new ArrayList<MedicalExaminationDTO>();
	private List<DiseaseDTO> diseaseHistory = new ArrayList<DiseaseDTO>();
	
	public MedicalRecordDTO() {}
	
	public MedicalRecordDTO(MedicalRecord mr) {
		this.id = mr.getId();
		this.userId = mr.getUser().getId();
		
		for(MedicalExamination me : mr.getMedicalExaminations()) {
			this.medicalExaminations.add(new MedicalExaminationDTO(me));
		}
		
		for(Disease d : mr.getDiseaseHistory()) {
			this.diseaseHistory.add(new DiseaseDTO(d));
		}

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<MedicalExaminationDTO> getMedicalExaminations() {
		return medicalExaminations;
	}

	public void setMedicalExaminations(List<MedicalExaminationDTO> medicalExaminations) {
		this.medicalExaminations = medicalExaminations;
	}

	public List<DiseaseDTO> getDiseaseHistory() {
		return diseaseHistory;
	}

	public void setDiseaseHistory(List<DiseaseDTO> diseaseHistory) {
		this.diseaseHistory = diseaseHistory;
	}
	
	

}
