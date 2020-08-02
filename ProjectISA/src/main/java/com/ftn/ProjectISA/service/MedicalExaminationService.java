package com.ftn.ProjectISA.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.ProjectISA.dto.MedicalExaminationDTO;
import com.ftn.ProjectISA.model.MedicalExamination;
import com.ftn.ProjectISA.repository.MedicalExaminationRepository;
import com.ftn.ProjectISA.repository.MedicalRecordRepository;
import com.ftn.ProjectISA.repository.MedicalRoomRepository;
import com.ftn.ProjectISA.repository.UserRepository;

@Service
public class MedicalExaminationService {

	@Autowired
	MedicalExaminationRepository medicalExaminationRepository;
	
	@Autowired
	MedicalRoomRepository medicalRoomRepository;
	
	@Autowired
	MedicalRecordRepository medicalRecordRepository;
	
	@Autowired
	UserRepository userRepository;

	public List<MedicalExaminationDTO> findAllMedicalExaminations() {

		List<MedicalExaminationDTO> medicalExaminationDTOs = new ArrayList<MedicalExaminationDTO>();
		
		List<MedicalExamination> medicalExaminations = medicalExaminationRepository.findAll();
		
		for(MedicalExamination me : medicalExaminations)
			medicalExaminationDTOs.add(new MedicalExaminationDTO(me));
		
		return medicalExaminationDTOs;
	}
	
	public List<MedicalExaminationDTO> medicalExaminationsUserHistory(Long userId) {

		List<MedicalExaminationDTO> medicalExaminationDTOs = new ArrayList<MedicalExaminationDTO>();
		
		List<MedicalExamination> medicalExaminations = userRepository.getOne(userId).getMedicalRecord().getMedicalExaminations();
		
		for(MedicalExamination me : medicalExaminations)
			if(me.getStartDateTime().isBefore(LocalDateTime.now())) {
				medicalExaminationDTOs.add(new MedicalExaminationDTO(me));	
			}
			
		return medicalExaminationDTOs;
	}

	public MedicalExaminationDTO findMedicalExamination(Long id) {
		MedicalExaminationDTO retVal = new MedicalExaminationDTO(medicalExaminationRepository.getOne(id));
		return retVal;
	}
	
	public MedicalExaminationDTO addMedicalExamination(MedicalExaminationDTO examination) {
		MedicalExamination e = new MedicalExamination(examination);
		e.setDoctor(this.userRepository.getOne(examination.getDoctorId()));
		e.setMedicalRecord(this.medicalRecordRepository.getOne(examination.getMedicalRecordId()));
		e.setMedicalRoom(this.medicalRoomRepository.getOne(examination.getMedicalRoomId()));
		this.medicalExaminationRepository.save(e);
		return examination;
	}
	
	public void deleteMedicalExamination(Long id) {
		medicalExaminationRepository.deleteById(id);
	}
	
}
