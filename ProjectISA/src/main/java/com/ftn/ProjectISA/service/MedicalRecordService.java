package com.ftn.ProjectISA.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.ProjectISA.dto.MedicalRecordDTO;
import com.ftn.ProjectISA.model.MedicalRecord;
import com.ftn.ProjectISA.repository.MedicalRecordRepository;
import com.ftn.ProjectISA.repository.UserRepository;

@Service
public class MedicalRecordService {

	@Autowired
	MedicalRecordRepository medicalRecordRepository;
	
	@Autowired
	UserRepository userRepository;
	

	public List<MedicalRecordDTO> findAllMedicalRecords() {

		List<MedicalRecordDTO> medicalRecordDTOs = new ArrayList<MedicalRecordDTO>();
		
		List<MedicalRecord> medicalRecords = medicalRecordRepository.findAll();
		
		for(MedicalRecord mr : medicalRecords)
			medicalRecordDTOs.add(new MedicalRecordDTO(mr));
		
		return medicalRecordDTOs;
	}

	public MedicalRecordDTO findMedicalRecord(Long userId) {
		MedicalRecordDTO retVal = new MedicalRecordDTO(this.userRepository.getOne(userId).getMedicalRecord());
		return retVal;
	}

}
