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
import eventos.modelo.repository.IntEvento;
import eventos.modelo.repository.IntReserva;
import eventos.modelo.repository.IntUsuario;
import eventos.modelo.repository.ReservaListImpl;



@Controller
@RequestMapping("/clientes")
public class gestionUsuario {
	

	
	@Autowired
	private IntEvento edao;
	@Autowired
	private IntReserva rdao;
	@Autowired
	private IntUsuario udao;
	
//------------------------------------------------------------------------------------->	
	
	@GetMapping ("/loginForm")
	public String mostrarFormLogin(Model model) {
		return "altaUsuario";
	}
	
	@PostMapping ("/login")
	public String inicioSesion(HttpSession sesi, @RequestParam("username") String username, @RequestParam("password") String password, RedirectAttributes redi, Model model) {
		Usuario usu = udao.findByUsernameAndPassword(username, password);
		if (usu != null) {
			sesi.setAttribute("clienteSesion", usu);
			return "redirect:/inicio";
		}
		
		redi.addFlashAttribute("mensaje", "Credenciales incorrectas");
		
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
			model.addAttribute("listaEventos", edao.buscarActivos());
		
		return "index";	
	}
	
	@GetMapping("/cancelados")
	public String cancelados(Model model) {
			model.addAttribute("listaEventos", edao.buscarCancelados());
		
		return "index";	
	}
	
	@GetMapping("/destacados")
	public String destacados(Model model) {
		model.addAttribute("listaEventos", edao.buscarDestacados());
	
		return "index";	
	}
	
	@GetMapping("/noDestacados")
	public String noDestacados(Model model) {
		model.addAttribute("listaEventos", edao.buscarNoDestacados());
	
		return "index";	 
	}
	
//------------------------------------------------------------------------------------->	
	
	@GetMapping ("/detalle/{id}")
	public String detalle(Model model, @PathVariable("id") int idEvento) {
		Eventos evento= edao.buscarUno(idEvento);
		model.addAttribute("evento", evento);
		int aforo = rdao.calcularAforoRestante(evento);
		model.addAttribute("aforo_restante", aforo);
		return "detalleEvento";
	}
	
//------------------------------------------------------------------------------------->	
	
	@PostMapping ("/reservar/{id}")
	public String reservar(HttpSession sesi, Model model, @PathVariable("id") int idEvento, @RequestParam(name="cantidad", defaultValue = "0") int cantidadReserva, RedirectAttributes redi) {
		Usuario usu= (Usuario) sesi.getAttribute("clienteSesion");
		if (usu == null) {
			redi.addFlashAttribute("mensaje", "Solo puedes reservar si eres cliente");
			return "redirect:/clientes/detalle/"+idEvento;
		}
		
		Eventos evento = edao.buscarUno(idEvento);
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
		
		Reservas reserva = new Reservas(ReservaListImpl.ultimoId, evento.calcularPrecioUnitario(), "Ninguna observacion", cantidadReserva, usu, evento);
		rdao.nuevaReserva(reserva);
		redi.addFlashAttribute("mensaje", "Todo correcto, reserva realizada");
		return "redirect:/clientes/detalle/"+idEvento;
	}
	
}
