package Empleados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import Empleados.modelo.repository.IntEmpleado;








@Controller
public class HomeController {

	@Autowired
	private IntEmpleado edao;

	
	
	
	
	@GetMapping("/inicio")
	public String inicio(Model model) {
		model.addAttribute("listaEmpleados", edao.buscarTodos());
		return "index";
	}
	
	
}
