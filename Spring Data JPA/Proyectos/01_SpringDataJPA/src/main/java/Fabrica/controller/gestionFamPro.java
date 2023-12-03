package Fabrica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Fabrica.repository.IntFamilia;






@Controller
public class gestionFamPro {
	
	
	@Autowired
	private IntFamilia ifa;
	
	
	@GetMapping("/inicio")
	public String familia(Model model) {
		model.addAttribute("fam", ifa.findAll());
		model.addAttribute("fam2", ifa.findById(1).orElse(null));
		return "index";
	}

}
