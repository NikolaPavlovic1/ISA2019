package com.ftn.ProjectISA.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.ftn.ProjectISA.dto.UserDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Transactional
public class UserServiceIntegrationTest {

	@Autowired
	UserService userService;
	
	 @Test
	 public void testFind_All() {
	     List<UserDTO> users = userService.findAllUsers();
	     assertEquals(5, users.size());
	 }
	 
	 @SuppressWarnings("deprecation")
	 @Test
	 public void testGetByID_found() {
	     UserDTO user = userService.findUser(102L);
	     assertThat(user).isNotNull();
	     assertEquals(new Long(102L), user.getId());
	}
	 
	 

}
