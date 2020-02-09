package isa.project.controller;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import isa.project.dto.StudentDTO;

import isa.project.model.Student;
import isa.project.service.StudentService;

@RestController
@RequestMapping(value = "students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping(value = "/all")
	public ResponseEntity<List<Student>> getAllStudents() {

		List<Student> students = studentService.findAll();

		// convert students to DTOs
		List<StudentDTO> studentsDTO = new ArrayList<>();
		for (Student s : students) {
			studentsDTO.add(new StudentDTO(s));
		}

		return new ResponseEntity<>(students, HttpStatus.OK);
	}

}
