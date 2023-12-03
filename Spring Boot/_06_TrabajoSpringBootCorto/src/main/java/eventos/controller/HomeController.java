package eventos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import eventos.modelo.repository.IntReservaEventos;










@Controller
public class HomeController {

	@Autowired
	private IntReservaEventos rdao;
	
	
	@GetMapping("/inicio")
	public String inicio(Model model) {
		model.addAttribute("listaEventos", rdao.buscarTodos());
		return "index";
	}
	
}
