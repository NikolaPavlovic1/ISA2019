package com.ftn.ProjectISA.dto;

public class RateDTO {
	
	private int clinicRate;
	private int doctorRate;
	private Long patientId;
	private String doctorUsername;
	
	public RateDTO() {}

	public int getClinicRate() {
		return clinicRate;
	}

	public void setClinicRate(int clinicRate) {
		this.clinicRate = clinicRate;
	}

	public int getDoctorRate() {
		return doctorRate;
	}

	public void setDoctorRate(int doctorRate) {
		this.doctorRate = doctorRate;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getDoctorUsername() {
		return doctorUsername;
	}

	public void setDoctorUsername(String doctorUsername) {
		this.doctorUsername = doctorUsername;
	}


	
	

}
