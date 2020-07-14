package com.ftn.ProjectISA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.ProjectISA.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long>{

}
