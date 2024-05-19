package com.instituto.galton.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfesorController {
	
	@GetMapping("/profesores")
	public String getProfesores() {
		return "profesores";
	}
}
