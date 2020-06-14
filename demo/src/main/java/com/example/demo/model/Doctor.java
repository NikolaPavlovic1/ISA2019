package com.example.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String surname;

	private double rating;

	@Temporal(TemporalType.DATE)
	private Date vacationFrom;

	@Temporal(TemporalType.DATE)
	private Date vacationTo;
	
	@Temporal(TemporalType.TIME)
	@JsonFormat(pattern="HH:mm:ss", timezone="Europe/Belgrade")
	private Date workingTimeFrom;
	
	@Temporal(TemporalType.TIME)
	@JsonFormat(pattern="HH:mm:ss", timezone="Europe/Belgrade")
	private Date workingTimeTo;
	
	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Examination> examinations = new ArrayList<>();
	
	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
	private List<Appointment> appointments = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "clinic_id")
	private Clinic clinic;
	
	@ManyToMany
	@JoinTable(name = "doctor_type_examination", joinColumns = @JoinColumn(name = "doctor_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "type_examination_id", referencedColumnName = "id"))
	private Set<ExaminationType> types = new HashSet<ExaminationType>();
	
	private double numberOfRatings;
	
	private double sumOfRatings;
	
	public Doctor() {
		
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

	public Date getVacationFrom() {
		return vacationFrom;
	}

	public void setVacationFrom(Date vacationFrom) {
		this.vacationFrom = vacationFrom;
	}

	public Date getVacationTo() {
		return vacationTo;
	}

	public void setVacationTo(Date vacationTo) {
		this.vacationTo = vacationTo;
	}

	public Date getWorkingTimeFrom() {
		return workingTimeFrom;
	}

	public void setWorkingTimeFrom(Date workingTimeFrom) {
		this.workingTimeFrom = workingTimeFrom;
	}

	public Date getWorkingTimeTo() {
		return workingTimeTo;
	}

	public void setWorkingTimeTo(Date workingTimeTo) {
		this.workingTimeTo = workingTimeTo;
	}

	public List<Examination> getExaminations() {
		return examinations;
	}

	public void setExaminations(List<Examination> examinations) {
		this.examinations = examinations;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	public Set<ExaminationType> getTypesOfExamination() {
		return types;
	}

	public void setTypesOfExamination(Set<ExaminationType> typesOfExamination) {
		this.types= typesOfExamination;
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
