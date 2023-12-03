package Examen.controller;



import java.math.BigDecimal;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Examen.dao.IntTodo;
import Examen.entityBeans.Departamento;
import Examen.entityBeans.Empleado;
import Examen.entityBeans.Perfile;







@Controller
@RequestMapping("/proyectos")
public class gestionTodo {

	
		@Autowired
		private IntTodo ito;
		
	
//------------------------------------------------------------------------------------->	
	
	
		//PARA PARSEAR LAS FECHAS
		@InitBinder
		public void initBinder(WebDataBinder binder) {
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
			sdf.setLenient(false);
			binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
		}
	

	
//------------------------------------------------------------------------------------->
	
		
		//VA AL JSP LOGIN
		@GetMapping("/identificate")
		public String identificate() {
			return "login";
		}
	
	
	
		//NOS LOGUEAMOS Y NOS LLEGAN LOS PARAMETROS POR REQUESPARAM INTRODUCIDOS EN EL JSP LOGIN
		@PostMapping("/login")
		public String login(HttpSession sesi, @RequestParam("idEmpl") int idEmpl, @RequestParam("password") String password, RedirectAttributes redi) {
			
			Empleado emp= ito.buscarUnooo(idEmpl);
			
	        if (emp != null && emp.getPassword().equals(password) && emp.getPerfile().getIdPerfil() == 4) {
	            redi.addFlashAttribute("mensaje", "Usuario logeado");
				sesi.setAttribute("sesion", emp);
				return "redirect:/inicio";
	        } else {
	        	redi.addFlashAttribute("mensaje", "Usuario incorrecto");
	    		return "redirect:/proyectos/identificate";
	        }
	          
		}	
	
	
	
		//SALE DE LA SESION
		@GetMapping ("/cerrarSesion")
		public String cerrar(HttpSession sesi) {
			
			if (sesi.getAttribute("sesion") != null) {
				sesi.removeAttribute("sesion");
			}
			return "redirect:/proyectos/identificate";
		}
		
		
//------------------------------------------------------------------------------------->	
		
		
		//VAMOS AL JSP ALTA
		@GetMapping("/formAlta")
		public String alta(RedirectAttributes redi, HttpSession sesi) {
			Empleado emp = (Empleado) sesi.getAttribute("sesion");
			if (emp == null) {
				redi.addFlashAttribute("mensaje", "Empleado no introducido");
				return "redirect:/proyectos/login";
			} else {
				return "alta";
			}
		}
		
		
		
		//DAMOS DE ALTA UN EMPLEADO 
		@PostMapping("/alta")
		public String alta(Model model, HttpSession sesi, RedirectAttributes redi, @RequestParam(name="apellidos")String apellidos, 
				@RequestParam(name="correo")String correo, @RequestParam(name="fechaNacimiento")Date fechaNacimiento, 
				@RequestParam(name="nombre")String nombre, @RequestParam(name="password")String password, 
				@RequestParam(name="salario")BigDecimal salario, @RequestParam(name="idDepar")int idDepar, 
				@RequestParam(name="idPerfil")int idPerfil) {
			
			
			Departamento dep= ito.buscarUno(idDepar);
			Perfile per= ito.buscarUnoo(idPerfil);
			
			//PINTAMOS EL FORMULARIO EN LA BASE DE DATOS COGIENDO UN ID
			Empleado emp= new Empleado(0, apellidos, correo, new Date(), fechaNacimiento, nombre, password, salario, dep, per);
			
			if(ito.altaIngre(emp) == 1) {
				model.addAttribute("mensaje","Alta realizada");
				return "redirect:/inicio";
			} else {
				model.addAttribute("mensaje", "Alta NOOO realizada!!!");
				return "/proyectos/formAlta";
			}
			
		}
		
		
//------------------------------------------------------------------------------------->	
		
		
		//BORRAMOS UN EMPLEADO
		@PostMapping("/borrar")
		public String borrar(@RequestParam(name="idEmpl")int idEmpl, Model model){
			ito.eliminar(idEmpl);
				model.addAttribute("mensaje","Empleado borrado");
				return "redirect:/inicio";
			
		}
		
		
//------------------------------------------------------------------------------------->		
		
		
		//MODIFICAMOS UN EMPLEADO
		@PostMapping("/modificar")
        public String modificar(HttpSession sesion, RedirectAttributes redi, @RequestParam("idEmpl") int idEmpl, @RequestParam("apellidos") String apellidos, Model model) {
            Empleado emp = ito.buscarUnooo(idEmpl);
            emp.setApellidos(apellidos);
            
            if(ito.altaIngre(emp) == 1) {
                model.addAttribute("mensaje", "Apellido del Empleado modificado");
                return "index";
            } else {
                model.addAttribute("mensaje", "Apellido del Empleado NOOO modificado!!!");
                return "index";
            }
		}
		

//------------------------------------------------------------------------------------->
		
		
		//SACAMOS DATOS DE UN EMPLEADO AL PULSAR EL ENLACE VER
		@GetMapping("/empleadoDetalle/{id}")
		public String detalleEmpleado(Model model, @PathVariable("id") int idEmpl) {
			Empleado emp= ito.buscarUnooo(idEmpl);
			if(emp == null) {
				model.addAttribute("mensaje", "Empleado no existe");
				return "index";
			}
			if(emp != null)
			model.addAttribute("empleado", emp);
			return "DetalleEmpleado";
		}
	
}
