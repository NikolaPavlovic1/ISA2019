package com.example.demo.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Clinic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String address;

	private String description;

	private String city;

	private double rating;
	
	@OneToMany(mappedBy = "clinic", cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = { "clinic" }, allowSetters = true)
	private List<Doctor> doctors = new ArrayList<>();
	
	@OneToMany(mappedBy = "clinic", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Examination> examinations = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name = "clinic_examination_type", joinColumns = @JoinColumn(name = "clinic_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "examination_type_id", referencedColumnName = "id"))
	private Set<ExaminationType> types = new HashSet<ExaminationType>();
	
	private double numberOfRatings;
	
	private double sumOfRatings;
	
	public Clinic() {
		
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

	public List<Examination> getExaminations() {
		return examinations;
	}

	public void setExaminations(List<Examination> examinations) {
		this.examinations = examinations;
	}

	public Set<ExaminationType> getTypesOfExamination() {
		return types;
	}

	public void setTypesOfExamination(Set<ExaminationType> typesOfExamination) {
		this.types = typesOfExamination;
	}

	public double getNumberOfRatings() {
		return numberOfRatings;
	}

	public void setNumberOfRatings(double numberOfRatings) {
		this.numberOfRatings = numberOfRatings;
	}

	public double getSumOfRatings() {
		return sumOfRatings;
	}

	public void setSumOfRatings(double sumOfRatings) {
		this.sumOfRatings = sumOfRatings;
	}
	
	public void addRating(double rating) {
		this.sumOfRatings += rating;
	}
	
	public void increaseNumberOfRating() {
		this.numberOfRatings++;
	}
}
