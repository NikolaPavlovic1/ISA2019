package com.ftn.ProjectISA.dto;

import com.ftn.ProjectISA.model.DoctorRate;

public class DoctorRateDTO {
	
	private Long id;
	private int rate;
	private Long patientId;
	private Long doctorId;
	
	public DoctorRateDTO() {
		
	}
	
	public DoctorRateDTO(DoctorRate doctorRate) {
		this.doctorId = doctorRate.getDoctor().getId();
		this.id = doctorRate.getId();
		this.patientId = doctorRate.getPatient().getId();
		this.rate = doctorRate.getRate();
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

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	
	

}
