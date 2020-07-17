package com.ftn.ProjectISA.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.ProjectISA.dto.UserDTO;
import com.ftn.ProjectISA.model.User;
import com.ftn.ProjectISA.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public UserDTO registerUser(UserDTO userDTO) {
		User u = new User(userDTO);

		userRepository.save(u);
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
}
