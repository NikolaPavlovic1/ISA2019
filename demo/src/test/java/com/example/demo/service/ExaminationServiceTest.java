package com.example.demo.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.example.demo.model.Examination;
import com.example.demo.repository.ExaminationRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExaminationServiceTest {

	@Mock
	private ExaminationRepository repositoryMock;
	
	@Mock
	private Examination examinationMock;
	
	@InjectMocks
	private ExaminationService service;
	
	@Test
	public void testFindAll() {
		
		Examination e = new Examination();
		e.setId((long) 100);
		e.setType("Type");
		
		when(repositoryMock.findAll()).thenReturn(Arrays.asList(e));
		List<Examination> list = service.findAll();
		
		assertEquals(list.get(0).getType(), e.getType());
	}
	
	@Test
	public void testGetExaminationsByType() {
		Examination e = new Examination();
		e.setId((long) 100);
		e.setType("Type");
		
		when(repositoryMock.getExaminationByType("Type")).thenReturn(Arrays.asList(e));
		
		List<Examination> list = service.getExaminationsByType("Type");
		
		assertEquals(list.get(0).getType(), e.getType());
		
	}
	
	@Test
	public void testGetExaminationHistory() {
		Examination e = new Examination();
		e.setId((long) 100);
		e.setType("Type");
		
		when(repositoryMock.getExaminationHistory()).thenReturn(Arrays.asList(e));
		
		List<Examination> list = service.getExaminationHistory();
		
		assertEquals(list.get(0).getType(), e.getType());
		
	}
	
	
}
