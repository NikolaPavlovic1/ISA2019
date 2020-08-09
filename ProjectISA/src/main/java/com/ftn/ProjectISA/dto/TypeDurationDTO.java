package com.ftn.ProjectISA.dto;

import com.ftn.ProjectISA.model.TypeDuration;

public class TypeDurationDTO {
	
	private String type;
	private int duration;
	private int price;
	private Long id;
	
	public TypeDurationDTO() {}
	
	public TypeDurationDTO(TypeDuration td) {
		this.type = td.getType();
		this.duration = td.getDuration();
		this.id = td.getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
