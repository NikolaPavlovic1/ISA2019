package com.ftn.ProjectISA.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ftn.ProjectISA.model.User;
import com.ftn.ProjectISA.model.User;
import com.ftn.ProjectISA.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class UserServiceTest {
	
	@Autowired
	private UserService userService;

	@MockBean
	private UserRepository userRepositoryMocked;
	
	@Before
	public void setUp() {
		User user = new User();
		user.setId(1L);
		Mockito.when(userRepositoryMocked.getOne(1L)).thenReturn(user);
		Mockito.when(userRepositoryMocked.getOne(2L)).thenThrow(NullPointerException.class);
		
	}
	
	
	@Test
	public void testGetOne() {
		Long id = 1L;
		User found = this.userRepositoryMocked.getOne(id);
		

		assertEquals(id, found.getId());
	}
	
	@Test(expected=NullPointerException.class)
	public void testGetOneNotFound() {
		Long id = 2L;
		User user = this.userRepositoryMocked.getOne(id);
		

		assertEquals(id, user.getId());
	}



}
