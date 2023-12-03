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
import tienda.modelo.dao.TarjetaBancariaDao;
import tienda.modelo.beans.*;
import tienda.modelo.repository.ClienteRepository;




@Controller
@RequestMapping("/tarjeta")
public class TarjetaBancariaController {
	
	
	@Autowired
	private TarjetaBancariaDao iTarjeta;
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
	
	
	@GetMapping("/altaTarjeta")
	public String altaTarjeta() {
		return "altaTarjeta";
	}
	
	
	@PostMapping("/altaTarjeta")
	public String altaCliente(Model model, HttpSession sesion,
		@RequestParam(name="nombreTitular")String nombreTitular,
		@RequestParam(name="numeroTarjeta")BigDecimal numeroTarjeta,
		@RequestParam(name="fechaCaducidad")Date fechaCaducidad,
		@RequestParam(name="cvv")BigDecimal cvv) {
		
		
		TarjetasBancaria tarjeta= new TarjetasBancaria(0, cvv, fechaCaducidad, nombreTitular, numeroTarjeta);
		Usuario usuarioSesion = (Usuario) sesion.getAttribute("usuario");
		if(iTarjeta.altaTarjeta(tarjeta) == 0) {
			model.addAttribute("mensaje", "Error al guardar la Tarjeta introducida");
			return "altaTarjetas";
		}
		Usuario usuario = iclienteDao.buscarUno(usuarioSesion.getIdUsuario());
		List<TarjetasBancaria> tarjetas = usuario.getTarjetasBancarias();
		tarjetas.add(tarjeta);
		usuario.setTarjetasBancarias(tarjetas);
		
		iClienteRepository.save(usuario);
		model.addAttribute("mensaje", "Tarjeta guardada con exito");
		return "indexCliente";
	}
}
