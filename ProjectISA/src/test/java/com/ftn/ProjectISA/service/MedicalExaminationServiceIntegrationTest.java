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

import com.ftn.ProjectISA.dto.MedicalExaminationDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Transactional
public class MedicalExaminationServiceIntegrationTest {
	
	@Autowired
	MedicalExaminationService medicalExaminationService;
	
	 @Test
	 public void testFind_All() {
	     List<MedicalExaminationDTO> examinations = medicalExaminationService.findAllMedicalExaminations();
	     assertEquals(5, examinations.size());
	 }
	 
	 @SuppressWarnings("deprecation")
	 @Test
	 public void testGetByID_found() {
	     MedicalExaminationDTO examination = medicalExaminationService.findMedicalExamination(101L);
	     assertThat(examination).isNotNull();
	     assertEquals(new Long(101L), examination.getId());
	}
	 
	 
}
