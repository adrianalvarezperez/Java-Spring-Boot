package eventos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import eventos.modelo.beans.Eventos;
import eventos.modelo.repository.IntEvento;







@Controller
@RequestMapping("/eventos")
public class gestionEventos {


	@Autowired
	private IntEvento edao;
	
	
//------------------------------------------------------------------------------------------>	
	
	
	@GetMapping ("/altaForm")
	public String mostrarForm() {		//SOLO LLAMAMOS AL FORMULARIO
		return "formu";
	}
	
	
	@PostMapping("/alta")
	public String alta(Model model, Eventos eventos) {
		 
		if(edao.nuevoEvento(eventos) == 1) {	
			model.addAttribute("listaEventos", edao.buscarTodos());
			model.addAttribute("mensaje", "Evento insertado");
		} else {
			model.addAttribute("mensaje", "Evento no insertado");
		
		}
		
		return "index";
		
	}
	
	
//------------------------------------------------------------------------------------------>
	
	
	@GetMapping("/editar/{id}")
	public String editar(Model model, @PathVariable("id") int idEvento) {
		Eventos evento= edao.buscarUno(idEvento);
		model.addAttribute("eventuki", evento);
		
		return "editar";
	}
	
	
//------------------------------------------------------------------------------------------>
	
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(Model model, @PathVariable("id") int idEvento) {
	
		if(edao.eliminarEvento(edao.buscarUno(idEvento))) {
			model.addAttribute("listaEventos", edao.buscarTodos());
			model.addAttribute("mensaje", "Evento eliminado");
		} else {
			model.addAttribute("mensaje", "Evento no eliminado");
		}
		return "forward:/inicio";	// o return "index";    //VA A EL INICIO DE HOMECONTROLLER
	}
	
	
//------------------------------------------------------------------------------------------>
	
	
	@GetMapping("/cancelar/{id}")
	public String cancelar(Model model, @PathVariable("id") int idEvento) {
	
		if(edao.cancelarEvento(idEvento) == 1) {
			model.addAttribute("listaEventos", edao.buscarTodos());
			model.addAttribute("mensaje", "Evento cancelado");
		} else {
			model.addAttribute("mensaje", "Evento no se ha podido cancelar");
		}
		return "forward:/inicio";	// o return "index";    //VA A EL INICIO DE HOMECONTROLLER
	}
	
	
//------------------------------------------------------------------------------------------>
	
	
	@GetMapping("/activos")
	public String activos(Model model) {
			model.addAttribute("listaEventos", edao.buscarActivos());
		
		return "index";	// o return "index";    //VA A EL INICIO DE HOMECONTROLLER
	}
	
	
	
	@GetMapping("/cancelados")
	public String cancelados(Model model) {
			model.addAttribute("listaEventos", edao.buscarCancelados());
		
		return "index";	// o return "index";    //VA A EL INICIO DE HOMECONTROLLER
	}
	
	
	
	
	
}
