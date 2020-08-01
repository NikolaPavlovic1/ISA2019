package com.ftn.ProjectISA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.ProjectISA.model.MedicalRoom;

@Repository
public interface MedicalRoomRepository extends JpaRepository<MedicalRoom,Long>{

}
