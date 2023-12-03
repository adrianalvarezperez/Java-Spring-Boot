package com.ite.saludo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	
		@GetMapping("/saludo99")
		public String bienvenida() {
			return "Bienvenido al curso de Spring boot";
		}
	
	
	
	
	
}


