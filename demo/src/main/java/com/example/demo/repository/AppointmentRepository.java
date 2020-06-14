package com.example.demo.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Appointment;


public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

	@Query("select appointment from Appointment appointment where appointment.appointment = ?1")
	Appointment getAppointmentByDate(Date date);
}
