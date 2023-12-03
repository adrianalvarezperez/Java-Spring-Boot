package eventos.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String alta(Model model, HttpSession sesi, Eventos eventos) {
		 
		eventos.setFechaIngreso(new Date());
		if(edao.nuevoEvento(eventos) == 1) {	
			model.addAttribute("listaEventos", edao.buscarTodos());
			model.addAttribute("mensaje", "Evento insertado");
			sesi.setAttribute("eventoSesion", eventos);				//CONSERVA LA SESION EN TODOS LOS EDITAR EL NOMBRE QUE METAS
		} else {
			model.addAttribute("mensaje", "Evento no insertado");
		
		}
		
		return "index";
		
	}
	
	/*@PostMapping("/alta")
	public String alta(RedirectAttributes redi, Eventos eventos) {
		 
		if(rdao.nuevoEvento(eventos) == 1) {	
			//redi.addFlashAttribute("listaEventos", edao.buscarTodos());	//*NO HACE FALTA ESTA LÍNEA
			redi.addFlashAttribute("mensaje", "Evento insertado");
		} else {
			redi.addFlashAttribute("mensaje", "Evento no insertado");
		
		}
		
		return "redirect:/inicio";
		
	} */
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}
	
	
//------------------------------------------------------------------------------------------>
	
	
	@GetMapping("/editar/{id}")
	public String editar(Model model, @PathVariable("id") int idEvento) {
		Eventos evento= edao.buscarUno(idEvento);
		model.addAttribute("evento", evento);
		
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
		return "forward:/inicio";	
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
		return "forward:/inicio";	
	}
	
	
//------------------------------------------------------------------------------------------>	
	
	
	@GetMapping("/cancelarDestacado/{id}")
	public String cancelarDestacado(Model model, @PathVariable("id") int idEvento) {
	
		if(edao.cancelarEventoDestacado(idEvento) == 1) {
			model.addAttribute("listaEventos", edao.buscarTodos());
			model.addAttribute("mensaje", "Evento destacado cancelado");
		} else {
			model.addAttribute("mensaje", "Evento destacado no se ha podido cancelar");
		}
		return "forward:/inicio";	
	}
	
	
	
}
