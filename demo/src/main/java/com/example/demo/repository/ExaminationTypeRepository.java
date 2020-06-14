package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ExaminationType;

public interface ExaminationTypeRepository extends JpaRepository<ExaminationType, Long> {

	Page<ExaminationType> findAll(Pageable pageable);
}