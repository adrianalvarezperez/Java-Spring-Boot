package Empleados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Empleados.modelo.beans.Empleado;
import Empleados.modelo.repository.IntEmpleado;







@Controller
@RequestMapping("/empleados")
public class GestionEmpleados {
	
	@Autowired
	private IntEmpleado edao;

	
	
	
	@GetMapping("/editar/{id}")
	public String editar(Model model, @PathVariable("id") int idEmpleado) {
		Empleado empleado= edao.buscarUno(idEmpleado);
		model.addAttribute("empleado99", empleado);
		
		return "editar";
	}
	
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(Model model, @PathVariable("id") int idEmpleado) {
	
		if(edao.eliminarEmpleado(edao.buscarUno(idEmpleado))) {
			model.addAttribute("listaEmpleados", edao.buscarTodos());
			model.addAttribute("mensaje", "Empleado eliminado");
		} else {
			model.addAttribute("mensaje", "Empleado no eliminado");
		}
		return "forward:/inicio";	// o return "index";    //VA A EL INICIO DE HOMECONTROLLER
	}
	
	
	@GetMapping("/cancelar/{id}")
	public String cancelar(Model model, @PathVariable("id") int idEmpleado) {
	
		if(edao.eliminarEmpleado(edao.buscarUno(idEmpleado))) {
			model.addAttribute("listaEmpleados", edao.buscarTodos());
			model.addAttribute("mensaje", "Empleado eliminado");
		} else {
			model.addAttribute("mensaje", "Empleado no eliminado");
		}
		return "forward:/inicio";	// o return "index";    //VA A EL INICIO DE HOMECONTROLLER
	}
	
	
	@GetMapping ("/altaForm")
	public String mostrarForm(Model model) {		//SOLO LLAMAMOS AL FORMULARIO
		return "altaEmpleado";
	}
	
	
	@PostMapping("/alta")
	public String alta(Model model, Empleado empleado) {
		 
		if(edao.altaEmpleado(empleado) == 1) {	
			model.addAttribute("listaEmpleados", edao.buscarTodos());
			model.addAttribute("mensaje", "Empleado insertado");
		} else {
			model.addAttribute("mensaje", "Empleado no insertado");
		
		}
		
		return "index";
		
	}
	
	
}
