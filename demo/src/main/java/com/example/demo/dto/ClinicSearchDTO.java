package com.example.demo.dto;

import java.util.Date;
import java.util.List;

import com.example.demo.model.Clinic;
import com.example.demo.model.Doctor;
import com.example.demo.model.Examination;



public class ClinicSearchDTO {

	private String examinationType;
	
	private Date examinationDate;
	
	private String clinicLocation;
	
	private double clinicRating;
	
	private List<Clinic> clinics;
	
	private List<ClinicDTO> clinicsDTO;
	
	private Examination examination;
	
	private List<Doctor> doctors;
	
	private double examinationPrice;
	
	public ClinicSearchDTO() {
		
	}


	public String getExaminationType() {
		return examinationType;
	}


	public void setExaminationType(String examinationType) {
		this.examinationType = examinationType;
	}



	public Date getExaminationDate() {
		return examinationDate;
	}

	public void setExaminationDate(Date examinationDate) {
		this.examinationDate = examinationDate;
	}

	public String getClinicLocation() {
		return clinicLocation;
	}

	public void setClinicLocation(String clinicLocation) {
		this.clinicLocation = clinicLocation;
	}

	public double getClinicRating() {
		return clinicRating;
	}

	public void setClinicRating(double clinicRating) {
		this.clinicRating = clinicRating;
	}

	public List<Clinic> getClinics() {
		return clinics;
	}

	public void setClinics(List<Clinic> clinics) {
		this.clinics = clinics;
	}

	public List<ClinicDTO> getClinicsDTO() {
		return clinicsDTO;
	}

	public void setClinicsDTO(List<ClinicDTO> clinicsDTO) {
		this.clinicsDTO = clinicsDTO;
	}

	public Examination getExamination() {
		return examination;
	}

	public void setExamination(Examination examination) {
		this.examination = examination;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public double getExaminationPrice() {
		return examinationPrice;
	}

	public void setExaminationPrice(double examinationPrice) {
		this.examinationPrice = examinationPrice;
	}
	
	
}
