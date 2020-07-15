package com.ftn.ProjectISA.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.ProjectISA.dto.MedicalExaminationDTO;
import com.ftn.ProjectISA.model.MedicalExamination;
import com.ftn.ProjectISA.model.MedicalRecord;
import com.ftn.ProjectISA.repository.MedicalExaminationRepository;
import com.ftn.ProjectISA.repository.MedicalRecordRepository;

@Service
public class MedicalExaminationService {

	@Autowired
	MedicalExaminationRepository medicalExaminationRepository;
	
	@Autowired
	MedicalRecordRepository medicalRecordRepository;

	public List<MedicalExaminationDTO> findAllMedicalExaminations() {

		List<MedicalExaminationDTO> medicalExaminationDTOs = new ArrayList<MedicalExaminationDTO>();
		
		List<MedicalExamination> medicalExaminations = medicalExaminationRepository.findAll();
		
		for(MedicalExamination me : medicalExaminations)
			medicalExaminationDTOs.add(new MedicalExaminationDTO(me));
		
		return medicalExaminationDTOs;
	}

	public MedicalExaminationDTO findMedicalExamination(Long id) {
		MedicalExaminationDTO retVal = new MedicalExaminationDTO(medicalExaminationRepository.getOne(id));
		return retVal;
	}
	
	public MedicalExaminationDTO addMedicalExamination(MedicalExaminationDTO me) {
		MedicalRecord medicalRecord = medicalRecordRepository.getOne(me.getMedicalRecord().getId());
		MedicalExamination newMedicalExamination = new MedicalExamination(me);
		newMedicalExamination.setMedicalRecord(medicalRecord);
		medicalRecordRepository.save(medicalRecord);
		return new MedicalExaminationDTO(newMedicalExamination);
	}
	
	public void deleteMedicalExamination(Long id) {
		medicalExaminationRepository.deleteById(id);
	}
	
}
