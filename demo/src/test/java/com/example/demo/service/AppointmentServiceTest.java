package com.example.demo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Appointment;
import com.example.demo.repository.AppointmentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppointmentServiceTest {

	@Mock
	private AppointmentRepository repositoryMock;
	
	@Mock
	private Appointment appointment;
	
	@InjectMocks
	private AppointmentService service;
	
	@Test
	public void testGetAppointment() {
		
		Appointment a = new Appointment();
		a.setId((long) 100);
		a.setAppointment(new Date(10-06-2020));
		
		when(repositoryMock.getAppointmentByDate(new Date(10-06-2020))).thenReturn(a);
		
		Appointment app = service.getAppointment(new Date(10-06-2020));
		
		assertEquals(app.getAppointment(), a.getAppointment());
	}
}
