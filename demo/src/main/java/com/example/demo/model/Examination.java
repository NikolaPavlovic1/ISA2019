package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Examination {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date appointment;
	
	@Temporal(TemporalType.TIME)
	@JsonFormat(pattern="HH:mm:ss", timezone="Europe/Belgrade")
	private Date time;
	
	private int hall;

	private int price;

	private int discount;

	private String type;

	private String duration;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private ExaminationStatus status;

	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;

	@ManyToOne
	@JoinColumn(name = "clinic_id")
	private Clinic clinic;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToOne
	private ExaminationType typeOfExamination;
	
	@OneToOne
	private Appointment tempTime;
	
	public Examination() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getAppointment() {
		return appointment;
	}

	public void setAppointment(Date appointment) {
		this.appointment = appointment;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getHall() {
		return hall;
	}

	public void setHall(int hall) {
		this.hall = hall;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public ExaminationStatus getStatus() {
		return status;
	}

	public void setStatus(ExaminationStatus status) {
		this.status = status;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ExaminationType getTypeOfExamination() {
		return typeOfExamination;
	}

	public void setTypeOfExamination(ExaminationType typeOfExamination) {
		this.typeOfExamination = typeOfExamination;
	}

	public Appointment getTempTime() {
		return tempTime;
	}

	public void setTempTime(Appointment tempTime) {
		this.tempTime = tempTime;
	}
	
	
}
