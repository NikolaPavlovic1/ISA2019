package com.ftn.ProjectISA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.ProjectISA.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long>{

}
