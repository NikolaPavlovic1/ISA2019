package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.Doctor;


public class ClinicDTO {

	private String name;
	private String address;
	private String description;
	private String city;
	private int priceOfExamination;
	private double rating;
	private List<Doctor> doctors;
	
	public ClinicDTO() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPriceOfExamination() {
		return priceOfExamination;
	}

	public void setPriceOfExamination(int priceOfExamination) {
		this.priceOfExamination = priceOfExamination;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}
	
	
}
