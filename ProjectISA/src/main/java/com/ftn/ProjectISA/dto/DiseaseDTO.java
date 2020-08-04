package com.ftn.ProjectISA.dto;

import com.ftn.ProjectISA.model.Disease;

public class DiseaseDTO {
	
	private Long id;
	private String name;
	private Long patientId;
	
	public DiseaseDTO() {}
	
	public DiseaseDTO(Disease disease) {
		this.id = disease.getId();
		this.name = disease.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	
	

}
