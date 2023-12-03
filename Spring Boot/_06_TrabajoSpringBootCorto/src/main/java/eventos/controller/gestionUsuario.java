package eventos.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import eventos.modelo.beans.Eventos;
import eventos.modelo.beans.Reservas;
import eventos.modelo.beans.Usuario;
import eventos.modelo.repository.IntReservaEventos;
import eventos.modelo.repository.ReservaEventosListImpl;



@Controller
@RequestMapping("/clientes")
public class gestionUsuario {
	

	
	@Autowired
	private IntReservaEventos rdao;
	
//------------------------------------------------------------------------------------->	
	
	@GetMapping ("/loginForm")
	public String mostrarFormLogin(Model model) {
		return "altaUsuario";
	}
	
	@PostMapping ("/login")
	public String inicioSesion(HttpSession sesi, @RequestParam("username") String username, @RequestParam("password") String password, RedirectAttributes redi, Model model) {
		Usuario usu = rdao.findByUsernameAndPassword(username, password);
		if (usu != null) {
			redi.addFlashAttribute("mensaje", "Usuario logeado");
			sesi.setAttribute("clienteSesion", usu);
			return "redirect:/inicio";
		}
		
		redi.addFlashAttribute("mensaje", "Usuario o contraseña incorrectos");
		
		return "redirect:/clientes/loginForm";
		
	}
	
	@GetMapping ("/cerrarSesion")
	public String cerrar(HttpSession sesi) {
		if (sesi.getAttribute("clienteSesion") != null) {
			sesi.removeAttribute("clienteSesion");
		}

		return "redirect:/clientes/loginForm";
	}
		
		
//------------------------------------------------------------------------------------->		
	
	@GetMapping("/activos")
	public String activos(Model model) {
			model.addAttribute("listaEventos", rdao.buscarActivos());
		
		return "index";	
	}
	
	@GetMapping("/cancelados")
	public String cancelados(Model model) {
			model.addAttribute("listaEventos", rdao.buscarCancelados());
		
		return "index";	
	}
	
	@GetMapping("/destacados")
	public String destacados(Model model) {
		model.addAttribute("listaEventos", rdao.buscarDestacados());
	
		return "index";	
	}
	
	@GetMapping("/noDestacados")
	public String noDestacados(Model model) {
		model.addAttribute("listaEventos", rdao.buscarNoDestacados());
	
		return "index";	 
	}
	
//------------------------------------------------------------------------------------->	
	
	@GetMapping ("/detalle/{id}")
	public String detalle(Model model, @PathVariable("id") int idEvento) {
		Eventos evento= rdao.buscarUno(idEvento);
		model.addAttribute("evento", evento);
		int aforo = rdao.calcularAforoRestante(evento);
		model.addAttribute("aforo_restante", aforo);
		return "detalleEvento";
	}
	
	
	@PostMapping ("/reservar/{id}")
	public String reservar(HttpSession sesi, Model model, @PathVariable("id") int idEvento, @RequestParam(name="cantidad", defaultValue = "0") int cantidadReserva, RedirectAttributes redi) {
		Usuario usu= (Usuario) sesi.getAttribute("clienteSesion");
		if (usu == null) {
			redi.addFlashAttribute("mensaje", "Solo puedes reservar si eres cliente");
			return "redirect:/clientes/detalle/"+idEvento;
		}
		
		Eventos evento = rdao.buscarUno(idEvento);
		if (evento == null) {
			redi.addFlashAttribute("mensaje", "Evento invalido");
			return "redirect:/clientes/detalle/"+idEvento;
		}
		
		if (cantidadReserva > 10 || cantidadReserva < 1) {
			redi.addFlashAttribute("mensaje", "Solo puedes reservar un maximo de 10 y un minimo de 1");
			return "redirect:/clientes/detalle/"+idEvento;
		}

		if (rdao.calcularAforoRestante(evento) < evento.getAforoMaximo()) {
			redi.addFlashAttribute("mensaje", "No puedes pedir tantas entradas");
			return "redirect:/clientes/detalle/"+idEvento;
		}
		
		Reservas reserva = new Reservas(ReservaEventosListImpl.ultimoId, evento.calcularPrecioUnitario(), "Ninguna observacion", cantidadReserva, usu, evento);
		rdao.nuevaReserva(reserva);
		redi.addFlashAttribute("mensaje", "RESERVA REALIZADA CORRECTAMENTE!!!");
		return "redirect:/clientes/detalle/"+idEvento;
	}
	
}
