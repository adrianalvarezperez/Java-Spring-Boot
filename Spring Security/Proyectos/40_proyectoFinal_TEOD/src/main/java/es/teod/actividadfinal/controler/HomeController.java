package es.teod.actividadfinal.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import es.teod.actividadfinal.modelo.entity.Producto;
import es.teod.actividadfinal.modelo.repository.ProductoRepository;

@Controller
public class HomeController {
	
	@Autowired
	private ProductoRepository prodRepo;
	@GetMapping("/")
	public String inicio(Model model) {
		List<Producto> lista = prodRepo.findAll();
		model.addAttribute("listaProductos", lista);
		return "listaProductos";
	}
	@ResponseBody
	@GetMapping("/auth")
	public List<Producto> verTodos(Model model, Authentication aut) {
		
	 	System.out.println(aut.getName() + "  -  " + aut.getAuthorities());
		List<Producto> lista = prodRepo.findAll();
		model.addAttribute("listaTodos", lista);
		
		return lista;
		 
		
	}

}
