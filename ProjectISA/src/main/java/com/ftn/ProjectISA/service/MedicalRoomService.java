package com.ftn.ProjectISA.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ftn.ProjectISA.dto.MedicalRoomDTO;
import com.ftn.ProjectISA.model.MedicalRoom;
import com.ftn.ProjectISA.repository.ClinicRepository;
import com.ftn.ProjectISA.repository.MedicalRoomRepository;

@Transactional(readOnly = true)
@Service
public class MedicalRoomService {
	
	@Autowired
	MedicalRoomRepository medicalRoomRepository;
	
	@Autowired
	ClinicRepository clinicRepository;
	
	@Transactional(readOnly = false)
	public MedicalRoomDTO addMedicalRoom(MedicalRoomDTO mr) {
		MedicalRoom room = new MedicalRoom(mr.getDescription());
		room.setClinic(clinicRepository.getOne(mr.getClinicId()));
		
		
		medicalRoomRepository.save(room);
		return mr;
	}

	public List<MedicalRoomDTO> findAllRooms() {

		List<MedicalRoomDTO> roomDtos = new ArrayList<MedicalRoomDTO>();
		
		List<MedicalRoom> rooms = medicalRoomRepository.findAll();
		
		for(MedicalRoom room : rooms)
			roomDtos.add(new MedicalRoomDTO(room));
		
		return roomDtos;
	}

	public MedicalRoomDTO findMedicalRoom(Long id) {
		MedicalRoomDTO retVal = new MedicalRoomDTO(medicalRoomRepository.getOne(id));
		return retVal;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_UNCOMMITTED)
	public void deleteMedicalRoom(Long id) {
		medicalRoomRepository.deleteById(id);
	}

}
