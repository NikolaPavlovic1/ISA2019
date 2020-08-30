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

import com.ftn.ProjectISA.model.MedicalRecord;
import com.ftn.ProjectISA.repository.MedicalRecordRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class MedicalRecordServiceTest {
	
	@Autowired
	private MedicalRecordService medicalRecordService;

	@MockBean
	private MedicalRecordRepository medicalRecordRepository;

	@Before
	public void setUp() {
		MedicalRecord medicalRecord = new MedicalRecord();
		medicalRecord.setId(1L);
		Mockito.when(medicalRecordRepository.getOne(1L)).thenReturn(medicalRecord);
	}
	
	@Test
	public void testGetOne() {
		Long id = 1L;
		MedicalRecord found = this.medicalRecordRepository.getOne(id);
		

		assertEquals(id, found.getId());
	}
	
	@Test(expected=NullPointerException.class)
	public void testGetOneNotFound() {
		Long id = 2L;
		MedicalRecord record = this.medicalRecordRepository.getOne(id);
		

		assertEquals(id, record.getId());
	}


}
