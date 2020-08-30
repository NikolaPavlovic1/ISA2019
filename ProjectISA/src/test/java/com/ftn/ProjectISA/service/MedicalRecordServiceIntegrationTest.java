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
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.ftn.ProjectISA.dto.MedicalRecordDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Transactional
public class MedicalRecordServiceIntegrationTest {
	
	@Autowired
	MedicalRecordService medicalRecordService;
	
	 @Test
	 public void testFind_All() {
	     List<MedicalRecordDTO> records = medicalRecordService.findAllMedicalRecords();
	     assertEquals(5, records.size());
	 }
	 
	 @SuppressWarnings("deprecation")
	 @Test
	 public void testGetByID_found() {
	     MedicalRecordDTO record = medicalRecordService.findMedicalRecord(101L);
	     assertThat(record).isNotNull();
	     assertEquals(new Long(101L), record.getId());
	}
	 
}
