package com.ftn.ProjectISA.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.ProjectISA.dto.MedicalExaminationDTO;
import com.ftn.ProjectISA.dto.MedicalExaminationHistoryDTO;
import com.ftn.ProjectISA.model.Clinic;
import com.ftn.ProjectISA.model.MedicalExamination;
import com.ftn.ProjectISA.model.MedicalRoom;
import com.ftn.ProjectISA.model.TypeDuration;
import com.ftn.ProjectISA.model.User;
import com.ftn.ProjectISA.repository.MedicalExaminationRepository;
import com.ftn.ProjectISA.repository.MedicalRecordRepository;
import com.ftn.ProjectISA.repository.MedicalRoomRepository;
import com.ftn.ProjectISA.repository.TypeDurationRepository;
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
	TypeDurationRepository typeDurationRepository;
	
	@Autowired
	UserRepository userRepository;

	public List<MedicalExaminationDTO> findAllMedicalExaminations() {

		List<MedicalExaminationDTO> medicalExaminationDTOs = new ArrayList<MedicalExaminationDTO>();
		
		List<MedicalExamination> medicalExaminations = medicalExaminationRepository.findAll();
		
		for(MedicalExamination me : medicalExaminations)
			medicalExaminationDTOs.add(new MedicalExaminationDTO(me));
		
		return medicalExaminationDTOs;
	}
	
	public List<MedicalExaminationHistoryDTO> medicalExaminationsUserHistory(Long userId) {

		List<MedicalExaminationHistoryDTO> medicalExaminationDTOs = new ArrayList<MedicalExaminationHistoryDTO>();
		
		List<MedicalExamination> medicalExaminations = userRepository.getOne(userId).getMedicalRecord().getMedicalExaminations();
		
		for(MedicalExamination me : medicalExaminations)
			if(me.getStartDateTime().isBefore(LocalDateTime.now())) {
				medicalExaminationDTOs.add(new MedicalExaminationHistoryDTO(me));	
			}
			
		return medicalExaminationDTOs;
	}
	
	public List<MedicalExaminationHistoryDTO> medicalExaminationsUserReservations(Long userId) {

		List<MedicalExaminationHistoryDTO> medicalExaminationDTOs = new ArrayList<MedicalExaminationHistoryDTO>();
		
		List<MedicalExamination> medicalExaminations = userRepository.getOne(userId).getMedicalRecord().getMedicalExaminations();
		
		for(MedicalExamination me : medicalExaminations)
			if(me.getStartDateTime().isAfter(LocalDateTime.now())) {
				medicalExaminationDTOs.add(new MedicalExaminationHistoryDTO(me));	
			}
			
		return medicalExaminationDTOs;
	}
	
	public List<MedicalExaminationHistoryDTO> getPredefinedMedicalExaminations(Long clinicId) {

		List<MedicalExaminationHistoryDTO> medicalExaminationDTOs = new ArrayList<MedicalExaminationHistoryDTO>();
		
		List<MedicalExamination> medicalExaminations = this.medicalExaminationRepository.findAll();
		
		for(MedicalExamination me : medicalExaminations)
			if(me.getStartDateTime().isAfter(LocalDateTime.now()) && me.getMedicalRecord()==null && me.getDoctor().getClinic().getId()==clinicId) {
				medicalExaminationDTOs.add(new MedicalExaminationHistoryDTO(me));	
			}
			
		return medicalExaminationDTOs;
	}

	public MedicalExaminationDTO findMedicalExamination(Long id) {
		MedicalExaminationDTO retVal = new MedicalExaminationDTO(medicalExaminationRepository.getOne(id));
		return retVal;
	}
	
	public MedicalExaminationDTO addMedicalExamination(MedicalExaminationDTO examination) {
		MedicalExamination e = new MedicalExamination(examination);
		
		User doctor = this.userRepository.getOne(examination.getDoctorId());	
		e.setDoctor(doctor);
		
		e.setMedicalRecord(this.medicalRecordRepository.getOne(examination.getMedicalRecordId()));
		
		TypeDuration td = this.typeDurationRepository.getOne(examination.getTypeDurationId());
		e.setTypeAndDuration(td);
		
		Clinic clinic = doctor.getClinic();
		for(MedicalRoom room : clinic.getMedicalRooms()) {
			boolean free = true;
			for(MedicalExamination ex : room.getMedicalExaminations()) {
				if(ex.getStartDateTime() == examination.getStartDateTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()) {
					free = false;
				}
			}
			
			if(free) {
				e.setMedicalRoom(room);
				this.medicalExaminationRepository.save(e);
				return examination;
			}
		}
		
		
		
		
		return null;
	}
	
	public MedicalExaminationHistoryDTO addPredefinedMedicalExamination(MedicalExaminationDTO examination) {
		MedicalExamination e = new MedicalExamination(examination);
		
		User doctor = this.userRepository.getOne(examination.getDoctorId());	
		e.setDoctor(doctor);
		
		e.setMedicalRecord(null);
		
		TypeDuration td = this.typeDurationRepository.getOne(examination.getTypeDurationId());
		e.setTypeAndDuration(td);
		
		Clinic clinic = doctor.getClinic();
		for(MedicalRoom room : clinic.getMedicalRooms()) {
			boolean free = true;
			for(MedicalExamination ex : room.getMedicalExaminations()) {
				if(ex.getStartDateTime() == examination.getStartDateTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()) {
					free = false;
				}
			}
			
			if(free) {
				e.setMedicalRoom(room);
				this.medicalExaminationRepository.save(e);
				return new MedicalExaminationHistoryDTO(e);
			}
		}
		
		
		
		
		return null;
	}
	
	public Boolean reservePredefinedMedicalExamination(Long patientId,Long examinationId){
		MedicalExamination e = this.medicalExaminationRepository.getOne(examinationId);
		User u = this.userRepository.getOne(patientId);
		e.setMedicalRecord(u.getMedicalRecord());
	
		this.medicalExaminationRepository.save(e);
		
		
		
		
		return true;
	}
	
	public void deleteMedicalExamination(Long id) {
		medicalExaminationRepository.deleteById(id);
	}
	
	public void addTypeDuration(String type, int duration) {
		TypeDuration typeDuration = new TypeDuration();
		typeDuration.setType(type);
		typeDuration.setDuration(duration);
		this.typeDurationRepository.save(typeDuration);
		
	}
	
}
