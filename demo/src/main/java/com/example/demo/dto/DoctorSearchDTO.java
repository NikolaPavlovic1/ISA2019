package com.example.demo.dto;

import java.util.ArrayList;

import com.example.demo.model.Doctor;


public class DoctorSearchDTO {

	private String name;
	private String surname;
	private double rating;
	private ArrayList<Doctor> doctors;
	
	public DoctorSearchDTO() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public ArrayList<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(ArrayList<Doctor> doctors) {
		this.doctors = doctors;
	}
	
	
}
