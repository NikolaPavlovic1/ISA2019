package com.ftn.ProjectISA.dto;

import java.util.ArrayList;
import java.util.List;

import com.ftn.ProjectISA.model.MedicalExamination;
import com.ftn.ProjectISA.model.MedicalRoom;

public class MedicalRoomDTO {
	
	private Long id;
	private String description;
	private Long clinicId;
	private List<MedicalExaminationDTO> medicalExaminations = new ArrayList<MedicalExaminationDTO>();
	
	public MedicalRoomDTO() {
		
	}
	
	public MedicalRoomDTO(MedicalRoom medicalRoom) {
		this.clinicId = medicalRoom.getClinic().getId();
		this.description = medicalRoom.getDescription();
		this.id = medicalRoom.getId();
		for(MedicalExamination me : medicalRoom.getMedicalExaminations()) {
			this.medicalExaminations.add(new MedicalExaminationDTO(me));
		}
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

	public Long getClinicId() {
		return clinicId;
	}

	public void setClinicId(Long clinicId) {
		this.clinicId = clinicId;
	}

	public List<MedicalExaminationDTO> getMedicalExaminations() {
		return medicalExaminations;
	}

	public void setMedicalExaminations(List<MedicalExaminationDTO> medicalExaminations) {
		this.medicalExaminations = medicalExaminations;
	}
	
	

}
