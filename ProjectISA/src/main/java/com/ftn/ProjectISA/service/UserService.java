package com.ftn.ProjectISA.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ftn.ProjectISA.dto.RateDTO;
import com.ftn.ProjectISA.dto.UserDTO;
import com.ftn.ProjectISA.model.Clinic;
import com.ftn.ProjectISA.model.ClinicRate;
import com.ftn.ProjectISA.model.DoctorRate;
import com.ftn.ProjectISA.model.TypeDuration;
import com.ftn.ProjectISA.model.User;
import com.ftn.ProjectISA.repository.ClinicRepository;
import com.ftn.ProjectISA.repository.TypeDurationRepository;
import com.ftn.ProjectISA.repository.UserRepository;

@Transactional(readOnly = true)
@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TypeDurationRepository typeDurationRepository;
	
	@Autowired
	ClinicRepository clinicRepository;
	
	@Autowired
    PasswordEncoder passwordEncoder;
	
	@Autowired
	MyMailService mailService;

	@Transactional(readOnly = false)
	public UserDTO registerUser(UserDTO userDTO) {
		User user = new User(userDTO);
		
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		if(userDTO.getClinicId() != null) {
			user.setClinic(clinicRepository.getOne(userDTO.getClinicId()));
		}

		userRepository.save(user);
		return userDTO;
	}

	public List<UserDTO> findAllUsers() {

		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		
		List<User> users = userRepository.findAll();
		
		for(User u : users)
			userDTOs.add(new UserDTO(u));
		
		return userDTOs;
	}

	public UserDTO findUser(Long id) {
		UserDTO retVal = new UserDTO(userRepository.getOne(id));
		return retVal;
	}
	
	public UserDTO findUserByUsername(String username) {
		UserDTO retVal = new UserDTO(userRepository.findByUsername(username));
		return retVal;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public UserDTO updateUser(UserDTO user) {
		User u = userRepository.getOne(user.getId());
		u.setName(user.getName());
		u.setLastName(user.getLastName());
		u.setUsername(user.getUsername());
		u.setPhoneNumber(user.getPhoneNumber());
		
		return new UserDTO(userRepository.save(u));
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_UNCOMMITTED)
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public boolean approveUser(Long id) {	
		User u = userRepository.getOne(id);
		String confirmationKey = getRandomString();
		u.setConfirmationKey(confirmationKey);
		
		try {
			mailService.sendApprovedEmail(u);
			u.setApproved(true);
			userRepository.save(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public boolean declineUser(Long id) {	
		User u = userRepository.getOne(id);
		
		try {
			mailService.sendDeclinedEmail(u);
			u.setDeclined(true);
			userRepository.save(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public boolean activateAccount(String confirmationKey) {	
		User u = userRepository.findByConfirmationKey(confirmationKey);
		u.setActive(true);
		userRepository.save(u);
		
		return true;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	private String getRandomString() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        while (sb.length() < 18) { 
            int index = (int) (random.nextFloat() * characters.length());
            sb.append(characters.charAt(index));
        }
        String saltStr = sb.toString();
        return saltStr;

    }
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public boolean addTypeToDoctor(Long id, Long typeDuration) {	
		User u = userRepository.getOne(id);
		TypeDuration td = typeDurationRepository.getOne(typeDuration);
		td.getDoctors().add(u);
		
		typeDurationRepository.save(td);
		
		return true;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public boolean addDoctorToClinic(Long doctorId, Long clinicId) {	
		User u = userRepository.getOne(doctorId);
		Clinic clinic= this.clinicRepository.getOne(clinicId);
		u.setClinic(clinic);
		
		userRepository.save(u);
		
		return true;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
	public boolean rate(RateDTO rate) {	
		
		User patient = this.userRepository.getOne(rate.getPatientId());
		User doctor = this.userRepository.findByUsername(rate.getDoctorUsername());
		Clinic clinic = doctor.getClinic();
		
		boolean match = false;
		for(ClinicRate cr: patient.getPatientClinicRates()) {
			if(cr.getClinic().getId() == clinic.getId()) {
				if(cr.getRate() != rate.getClinicRate()) {
					cr.setRate(rate.getClinicRate());		
				}
				match = true;
			}
		}
		if(!match) {
			ClinicRate cr = new ClinicRate(rate.getClinicRate());
			cr.setClinic(clinic);
			cr.setUser(patient);
			patient.getPatientClinicRates().add(cr);
		}
		this.userRepository.save(patient);
		
		match = false;
		for(DoctorRate dr: patient.getPatientDoctorRates()) {
			if(dr.getDoctor().getId() == doctor.getId()) {
				if(dr.getRate() != rate.getDoctorRate()) {
					dr.setRate(rate.getDoctorRate());		
				}
				match = true;
			}
		}
		if(!match) {
			DoctorRate dr = new DoctorRate(rate.getDoctorRate());
			dr.setDoctor(doctor);
			dr.setPatient(patient);
			patient.getPatientDoctorRates().add(dr);
		}
		this.userRepository.save(patient);
		
		
		return true;
	}
}
