package com.ftn.ProjectISA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.ProjectISA.model.TypeDuration;

@Repository
public interface TypeDurationRepository  extends JpaRepository<TypeDuration,Long>{

}
