package eventos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import eventos.modelo.repository.IntEvento;










@Controller
public class HomeController {

	@Autowired
	private IntEvento edao;
	
	
	@GetMapping("/inicio")
	public String inicio(Model model) {
		model.addAttribute("listaEventos", edao.buscarTodos());
		return "index";
	}
	
}
