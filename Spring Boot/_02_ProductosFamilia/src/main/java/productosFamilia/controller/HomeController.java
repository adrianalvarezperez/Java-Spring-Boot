package productosFamilia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import productosFamilia.modelo.repository.IntProductos;






@Controller
public class HomeController {

	@Autowired
	private IntProductos iprod;
	
	
	@GetMapping("/inicio")
	public String inicio(Model model) {
		
		model.addAttribute("listaProductos", iprod.findAll());
		return "index";
	}
	
	
}
