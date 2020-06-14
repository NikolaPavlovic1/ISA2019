package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Doctor;


public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	@Query("select doctor from Doctor doctor where doctor.id = ?1")
	public Doctor findOneById(long id);
}
