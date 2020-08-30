package com.ftn.ProjectISA.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.ftn.ProjectISA.dto.MedicalRoomDTO;

public class MedicalRoomServiceIntegrationTest {
	
	@Autowired
	MedicalRoomService medicalRoomService;
	
	 @Test
	 public void testFind_All() {
	     List<MedicalRoomDTO> rooms = medicalRoomService.findAllRooms();
	     assertEquals(4, rooms.size());
	 }
	 
	 @SuppressWarnings("deprecation")
	 @Test
	 public void testGetByID_found() {
	     MedicalRoomDTO room = medicalRoomService.findMedicalRoom(101L);
	     assertThat(room).isNotNull();
	     assertEquals(new Long(101L), room.getId());
	}
	 
	 @Test
	 @Transactional
	 @Rollback(true) 
	 public void testAdd() {
	     MedicalRoomDTO room = new MedicalRoomDTO();
	     room.setDescription("Test room");
	     room.setClinicId(101L);
	     
	     int sizeBefore = medicalRoomService.findAllRooms().size();
	     MedicalRoomDTO savedRoom = medicalRoomService.addMedicalRoom(room);
	       
	     assertThat(savedRoom).isNotNull();
	        List<MedicalRoomDTO> rooms = medicalRoomService.findAllRooms();
	        assertThat(rooms).hasSize(sizeBefore + 1);
	        assertEquals(savedRoom.getDescription(),"Test room");
	        assertEquals(room.getClinicId(),savedRoom.getClinicId());
	        
	    }

}
