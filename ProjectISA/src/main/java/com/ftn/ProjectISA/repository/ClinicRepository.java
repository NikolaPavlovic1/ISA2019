package com.ftn.ProjectISA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.ProjectISA.model.Clinic;

@Repository
public interface ClinicRepository extends JpaRepository<Clinic,Long>{

}
