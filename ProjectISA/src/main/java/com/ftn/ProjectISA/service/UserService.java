package com.ftn.ProjectISA.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ftn.ProjectISA.dto.UserDTO;
import com.ftn.ProjectISA.model.Clinic;
import com.ftn.ProjectISA.model.TypeDuration;
import com.ftn.ProjectISA.model.User;
import com.ftn.ProjectISA.repository.ClinicRepository;
import com.ftn.ProjectISA.repository.TypeDurationRepository;
import com.ftn.ProjectISA.repository.UserRepository;

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

	public UserDTO updateUser(UserDTO user) {
		User u = userRepository.getOne(user.getId());
		u.setName(user.getName());
		u.setLastName(user.getLastName());
		u.setUsername(user.getUsername());
		u.setPhoneNumber(user.getPhoneNumber());
		
		return new UserDTO(userRepository.save(u));
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
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
	
	
	
	public boolean activateAccount(String confirmationKey) {	
		User u = userRepository.findByConfirmationKey(confirmationKey);
		u.setActive(true);
		userRepository.save(u);
		
		return true;
	}
	
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
	
	public boolean addTypeToDoctor(Long id, Long typeDuration) {	
		User u = userRepository.getOne(id);
		TypeDuration td = typeDurationRepository.getOne(typeDuration);
		td.getDoctors().add(u);
		
		typeDurationRepository.save(td);
		
		return true;
	}
	
	public boolean addDoctorToClinic(Long doctorId, Long clinicId) {	
		User u = userRepository.getOne(doctorId);
		Clinic clinic= this.clinicRepository.getOne(clinicId);
		u.setClinic(clinic);
		
		userRepository.save(u);
		
		return true;
	}
}
