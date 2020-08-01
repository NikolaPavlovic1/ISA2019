package com.ftn.ProjectISA.dto;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.ftn.ProjectISA.model.Clinic;
import com.ftn.ProjectISA.model.PricelistItem;

public class PricelistItemDTO {
	
	private Long id;
	private String typeOfExamination;
	private int price;
	private Long clinicId;
	
	public PricelistItemDTO() {}
	
	public PricelistItemDTO(PricelistItem item) {
		this.clinicId = item.getClinic().getId();
		this.id = item.getId();
		this.typeOfExamination = item.getTypeOfExamination();
		this.price = item.getPrice();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypeOfExamination() {
		return typeOfExamination;
	}

	public void setTypeOfExamination(String typeOfExamination) {
		this.typeOfExamination = typeOfExamination;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Long getClinicId() {
		return clinicId;
	}

	public void setClinicId(Long clinicId) {
		this.clinicId = clinicId;
	}
	
	
	

}
