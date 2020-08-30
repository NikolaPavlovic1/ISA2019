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

import com.ftn.ProjectISA.model.MedicalRoom;
import com.ftn.ProjectISA.model.MedicalRoom;
import com.ftn.ProjectISA.repository.MedicalRoomRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class MedicalRoomServiceTest {
	
	@Autowired
	private MedicalRoomService medicalRoomService;

	@MockBean
	private MedicalRoomRepository medicalRoomRepositoryMocked;
	
	@Before
	public void setUp() {
		MedicalRoom room = new MedicalRoom();
		room.setId(1L);
		Mockito.when(medicalRoomRepositoryMocked.getOne(1L)).thenReturn(room);
	}
	
	@Test
	public void testGetOne() {
		Long id = 1L;
		MedicalRoom found = this.medicalRoomRepositoryMocked.getOne(id);
		

		assertEquals(id, found.getId());
	}
	
	@Test(expected=NullPointerException.class)
	public void testGetOneNotFound() {
		Long id = 2L;
		MedicalRoom room = this.medicalRoomRepositoryMocked.getOne(id);
		

		assertEquals(id, room.getId());
	}



}
