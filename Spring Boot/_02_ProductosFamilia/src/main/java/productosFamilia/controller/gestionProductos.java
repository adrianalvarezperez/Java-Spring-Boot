package productosFamilia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import productosFamilia.modelo.beans.Producto;
import productosFamilia.modelo.repository.IntProductos;






@Controller
@RequestMapping("/productos")
public class gestionProductos {
	
	@Autowired
	private IntProductos iprod;
	
	
	
	
	@GetMapping("/editar")
	public String editar(Model model, @RequestParam("id") int idProducto) {
		Producto producto= iprod.findById(idProducto);
		model.addAttribute("producto", producto);
		return "editarproducto";
	}
	
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(Model model, @PathVariable("id") int idProducto) {
	
		if(iprod.borrarProducto(iprod.findById(idProducto))) {
			model.addAttribute("listaProductos", iprod.findAll());
			model.addAttribute("mensaje", "producto eliminado");
		} else {
			model.addAttribute("mensaje", "producto no eliminado");
		}
		return "forward:/inicio";	// o return "index";
	}
	
	
	@GetMapping ("/altaForm")
	public String mostrarForm() {		//SOLO LLAMAMOS AL FORMULARIO
		return "formu";
	}
	
	@PostMapping("/alta")
	public String alta(Model model, Producto producto) {
		 
		if(iprod.altaProducto(producto) == 1) {	
			model.addAttribute("listaProductos", iprod.findAll());
			model.addAttribute("mensaje", "Producto insertado");
		} else {
			model.addAttribute("mensaje", "Producto no insertado");
		
		}
		
		return "index";
		
	}
		
	
}
