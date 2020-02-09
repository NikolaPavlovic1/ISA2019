package isa.project.controller;

import isa.project.service.TerminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "termini")
public class TerminController {
	
	@SuppressWarnings("unused")
	@Autowired
	private TerminService terminService;

}
