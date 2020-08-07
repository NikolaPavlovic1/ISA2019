package com.ftn.ProjectISA.dto;

import java.util.Date;

public class FilterClinicsDTO {
	
	private String type;
	private Date date;
	private Long clinicId;
	
	public FilterClinicsDTO() {}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getClinicId() {
		return clinicId;
	}

	public void setClinicId(Long clinicId) {
		this.clinicId = clinicId;
	}
	
	

}
