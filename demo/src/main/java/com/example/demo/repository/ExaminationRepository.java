package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Examination;


public interface ExaminationRepository extends JpaRepository<Examination, Long> {

	List<Examination> findAll();
	
	@Query("select examination from Examination examination where examination.type = ?1")
	List<Examination> getExaminationByType(String type);

	@Query("select examination from Examination examination where examination.status = com.example.demo.model.ExaminationStatus.SCHEDULED or examination.status = com.example.demo.model.ExaminationStatus.CANCELED")
	List<Examination> getExaminationHistory();

	@Query("select examination from Examination examination where examination.status = com.example.demo.model.ExaminationStatus.FREE")
	List<Examination> getFreeExaminations();
	
	@Query("select examination from Examination examination where examination.status = com.example.demo.model.ExaminationStatus.SCHEDULED ")
	List<Examination> getScheduledExaminations();
}
