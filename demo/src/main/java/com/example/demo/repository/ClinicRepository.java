package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Clinic;


public interface ClinicRepository extends JpaRepository<Clinic, Long> {

	@Query("select clinic from Clinic clinic where clinic.id = ?1")
	public Clinic findOneById(long id);
	
	List<Clinic> findAll();
}
