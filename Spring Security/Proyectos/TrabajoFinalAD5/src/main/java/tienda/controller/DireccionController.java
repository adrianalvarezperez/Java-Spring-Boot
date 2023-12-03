package tienda.controller;

import java.math.BigDecimal;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tienda.modelo.dao.ClienteDao;
import tienda.modelo.dao.DireccionDao;
import tienda.modelo.beans.*;
import tienda.modelo.repository.ClienteRepository;




@Controller
@RequestMapping("/direccion")
public class DireccionController {

		
		@Autowired
		private DireccionDao iDireccion;
		@Autowired
		private ClienteDao iclienteDao;
		@Autowired
		private ClienteRepository iClienteRepository;

		
//------------------------------------------------------------------------------------------------------------------------------------------------->	
		
		
		@InitBinder
		public void initBinder(WebDataBinder binder) {
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
			sdf.setLenient(false);
			binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
		}
		
		
//------------------------------------------------------------------------------------------------------------------------------------------------->	
		
		
		@GetMapping("/altaDireccion")
		public String altaDireccion() {
			return "altaDireccion";
		}
		
		
		@PostMapping("/altaDireccion")
		public String altaCliente(Model model, HttpSession sesion,
				@RequestParam(name="calle")String calle, 
				@RequestParam(name="codigoPostal") BigDecimal codigoPostal,
				@RequestParam(name="letra")String letra, 
				@RequestParam(name="localidad")String localidad, 
				@RequestParam(name="numero")int numero,
 				@RequestParam(name="piso")String piso) {
			
			
			Usuario usuarioSesion = (Usuario) sesion.getAttribute("usuario");
			Direccione direccion= new Direccione(0, calle, codigoPostal, letra, localidad, numero, piso);
			
			if(iDireccion.altaDireccion(direccion) == 0){
				model.addAttribute("mensaje", "Ha habido un fallo guardando la direccion");
				return "altaDireccion";
			}
			
			Usuario usuario = iclienteDao.buscarUno(usuarioSesion.getIdUsuario());
			
			List<Direccione> direcciones = usuario.getDirecciones();
			direcciones.add(direccion);
			usuario.setDirecciones(direcciones);
			
			iClienteRepository.save(usuario);
			model.addAttribute("mensaje", "Direccion introducida");
			return "indexCliente";
		}
	}

