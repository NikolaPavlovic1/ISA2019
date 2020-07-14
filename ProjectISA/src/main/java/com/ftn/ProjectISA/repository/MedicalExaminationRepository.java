package com.ftn.ProjectISA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.ProjectISA.model.MedicalExamination;

@Repository
public interface MedicalExaminationRepository extends JpaRepository<MedicalExamination,Long>{

}
