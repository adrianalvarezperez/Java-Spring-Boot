package es.teod.actividadfinal.controler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.teod.actividadfinal.modelo.dtos.LineaPedidoDto;
import es.teod.actividadfinal.modelo.entity.Producto;
import es.teod.actividadfinal.modelo.repository.ProductoRepository;

@Controller
@RequestMapping("/app/cesta")
public class CestaController {
	@Autowired
	private ProductoRepository prepo;
	
	@GetMapping("/ver")
	public String vercesta(Model model, HttpSession sesion) {
		List<LineaPedidoDto> lista = (List<LineaPedidoDto>)sesion.getAttribute("cesta");
		model.addAttribute("cesta", lista);
		
		return "verCesta";
	}
	
	@GetMapping("/addCesta/{idProductos}")
	public String addCesta(Model model, @PathVariable int idProductos) {
		Producto producto = prepo.findById(idProductos).orElse(null);
		model.addAttribute("producto", producto);
		return "formProducto";
	}
	
	@PostMapping("/addCesta/{idProductos}")
	public String procAddCesta(Model model, @PathVariable int idProductos, HttpSession sesion, LineaPedidoDto linea) {
		linea.setIdProducto(idProductos);
		List<LineaPedidoDto> cesta = (List<LineaPedidoDto>)sesion.getAttribute("cesta");
		if (cesta == null)
			cesta = new ArrayList<>();
		if (!cesta.contains(linea))
			cesta.add(linea);
		
		
		
		return "redirect:/";
	}
	
	@GetMapping("/comprar")
	public String comprar(Model model, HttpSession sesion) {
		List<LineaPedidoDto> lista = (List<LineaPedidoDto>)sesion.getAttribute("cesta");
		model.addAttribute("cesta", lista);
		
		return "verCesta";
	}

}
