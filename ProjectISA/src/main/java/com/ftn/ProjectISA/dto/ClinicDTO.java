package com.ftn.ProjectISA.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ftn.ProjectISA.model.Address;
import com.ftn.ProjectISA.model.Clinic;
import com.ftn.ProjectISA.model.MedicalRoom;
import com.ftn.ProjectISA.model.PricelistItem;
import com.ftn.ProjectISA.model.User;

public class ClinicDTO {
	
	private Long id;
	private List<UserDTO> doctors = new ArrayList<UserDTO>();
	private Address address;
	private String name;
	private String description;
	private List<LocalDateTime> appointments = new ArrayList<LocalDateTime>();
	private List<MedicalRoomDTO> medicalRooms = new ArrayList<MedicalRoomDTO>();
	private List<PricelistItemDTO> pricelist = new ArrayList<PricelistItemDTO>();
	private double avgClinicRate;
	
	
	public ClinicDTO() {}
	
	public ClinicDTO(Clinic clinic) {
		this.id = clinic.getId();
		this.address = clinic.getAddress();
		this.name = clinic.getName();
		this.description = clinic.getDescription();
		this.appointments = clinic.getAppointments();
		this.avgClinicRate = clinic.getAvgClinicRate();
		
		for(User u : clinic.getDoctors()) {
			this.doctors.add(new UserDTO(u));
		}
		for(MedicalRoom mr : clinic.getMedicalRooms()) {
			this.medicalRooms.add(new MedicalRoomDTO(mr));
		}
		for(PricelistItem item : clinic.getPricelist()) {
			this.pricelist.add(new PricelistItemDTO(item));
		}
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<UserDTO> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<UserDTO> doctors) {
		this.doctors = doctors;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<LocalDateTime> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<LocalDateTime> appointments) {
		this.appointments = appointments;
	}

	public List<MedicalRoomDTO> getMedicalRooms() {
		return medicalRooms;
	}

	public void setMedicalRooms(List<MedicalRoomDTO> medicalRooms) {
		this.medicalRooms = medicalRooms;
	}

	public List<PricelistItemDTO> getPricelist() {
		return pricelist;
	}

	public void setPricelist(List<PricelistItemDTO> pricelist) {
		this.pricelist = pricelist;
	}

	public double getAvgClinicRate() {
		return avgClinicRate;
	}

	public void setAvgClinicRate(double avgClinicRate) {
		this.avgClinicRate = avgClinicRate;
	}
	
	

}
