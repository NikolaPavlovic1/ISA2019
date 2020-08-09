package com.ftn.ProjectISA.dto;

import com.ftn.ProjectISA.model.ClinicRate;

public class ClinicRateDTO {

	private Long id;
	private int rate;
	private Long clinicId;
	private Long userId;
	
	public ClinicRateDTO() {
		
	}
	
	public ClinicRateDTO(ClinicRate clinicRate) {
		this.clinicId = clinicRate.getClinic().getId();
		this.userId = clinicRate.getUser().getId();
		this.id = clinicRate.getId();
		this.rate = clinicRate.getRate();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public Long getClinicId() {
		return clinicId;
	}

	public void setClinicId(Long clinicId) {
		this.clinicId = clinicId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
}
