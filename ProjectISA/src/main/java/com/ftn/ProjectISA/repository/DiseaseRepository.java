package com.ftn.ProjectISA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.ProjectISA.model.Disease;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease,Long>{

}
