package tienda.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import tienda.dto.LineaCompraDTO;
import tienda.modelo.dao.CompraDao;
import tienda.modelo.beans.Usuario;





@Controller
@RequestMapping("/cliente")
public class ClienteController {

	
	@Autowired
	private CompraDao iCompra;

	
//------------------------------------------------------------------------------------------------------------------------------------------------->
	
	
	//PARA PARSEAR LAS FECHAS
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}
	
	
//------------------------------------------------------------------------------------------------------------------------------------------------->
	
	
	@GetMapping("/compras")
	public String verCompras(HttpSession sesion, Model model) {
		Usuario usuarioSesion = (Usuario) sesion.getAttribute("usuario");
		
		model.addAttribute("compras", iCompra.buscarComprasUsuario(usuarioSesion));
		
		return "clienteCompras";
	}
	
	
//------------------------------------------------------------------------------------------------------------------------------------------------->
	
	
	@GetMapping("/altaCliente")
	public String alta() {
		return "altaCliente";
	}
	
	
//------------------------------------------------------------------------------------------------------------------------------------------------->
	

	@GetMapping("/sesionActivaCliente")
	public String sesionActiva() {
		return "indexCliente";
	}
	
	
	@GetMapping("/inicioSesionCliente")
	public String identificate() {
		return "inicioSesionCliente";
	}
	
	
	@GetMapping("/cerrarSesion")
	public String cerrarSesion(HttpSession sesion) {
		List<LineaCompraDTO> carrito = (List<LineaCompraDTO>) sesion.getAttribute("carrito");
		Usuario usuario = (Usuario) sesion.getAttribute("usuario");
		if (carrito != null) {
			iCompra.altaCarrito(usuario, carrito);
		}
		
		if(sesion.getAttribute("usuario") != null) {
			sesion.removeAttribute("usuario");
		}
		
		if(sesion.getAttribute("carrito") != null) {
			sesion.removeAttribute("carrito");
		}
		
		return "redirect:/logout";
	}
	
}
