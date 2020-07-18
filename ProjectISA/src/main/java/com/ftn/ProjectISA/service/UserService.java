package com.ftn.ProjectISA.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ftn.ProjectISA.dto.UserDTO;
import com.ftn.ProjectISA.model.User;
import com.ftn.ProjectISA.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
    PasswordEncoder passwordEncoder;
	
	@Autowired
	MyMailService mailService;

	public UserDTO registerUser(UserDTO userDTO) {
		User user = new User(userDTO);
		user.setPassword(passwordEncoder.encode(user.getPassword()));

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
		u.setEmail(user.getEmail());
		u.setPhoneNumber(user.getPhoneNumber());
		u.setInsuranceNumber(user.getInsuranceNumber());
		
		return new UserDTO(userRepository.save(u));
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
	public boolean approveUser(Long id) {	
		User u = userRepository.getOne(id);
		u.setApproved(true);
		String confirmationKey = getRandomString();
		u.setConfirmationKey(confirmationKey);
		
		/*try {
			mailService.sendEmail(u);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		return true;
	}
	
	public boolean activateAccount(String confirmationKey) {	
		User u = userRepository.findByConfirmationKey(confirmationKey);
		u.setActive(true);
		
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
}
