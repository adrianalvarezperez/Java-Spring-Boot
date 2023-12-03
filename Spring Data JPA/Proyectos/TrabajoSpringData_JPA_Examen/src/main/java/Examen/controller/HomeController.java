package Examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import Examen.dao.IntTodo;





@Controller
public class HomeController {

	
	@Autowired
	private IntTodo ito;
	
	
	
	
	@GetMapping("/inicio")
	public String inicio(Model model) {
		model.addAttribute("listaEmplDepart", ito.buscarEmpleadoPorDepart(10));
		model.addAttribute("listaEmpl", ito.buscarTodosEmple());
		return "index";
	}
}
