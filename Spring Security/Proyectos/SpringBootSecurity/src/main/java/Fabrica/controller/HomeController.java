package Fabrica.controller;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Fabrica.beans.Producto;
import Fabrica.beans.Usuario;
import Fabrica.dao.IntFabricaDao;





@Controller
public class HomeController {
	
	@Autowired
	private IntFabricaDao idao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	
	
	@GetMapping("/")
	public String verTodos(Model model, Authentication aut) {
		
	//	System.out.println(aut.getName() + "  -  " + aut.getAuthorities());
		List<Producto> lista = idao.buscarTodos();
		model.addAttribute("listaTodos", lista);
		
		return "listaProductos";
	}
	
	
	
	@GetMapping("/registro")
	public String registrar(Model model) {
		
		
	//	model.addAttribute("mensaje", "registrando");
		
		return "registro";
	}
	
	
	
	@PostMapping("/registro")
	public String proregistrar(Model model, Usuario usuario, RedirectAttributes ratt) {
		
		usuario.setEnabled(1);
		usuario.setFechaRegistro(new Date());
	 	usuario.addPerfil(idao.findById(3));
	 	usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
	 	
	 	if (idao.registro(usuario)) {
	 		ratt.addFlashAttribute("mensaje", "alta realizada");
	 		return "redirect:/login";
	 	}
	 	else {
	 		model.addAttribute("mensaje", "ya existe como usuario");
	 		return "/registro";
	 	}
	}
	
	
	
	@GetMapping("/error")
	public String procesarError() {
		
		 
		System.out.println("procesar error");
		
		return "pruebas";
	}
	
	
	
	@GetMapping("/index")
	public String procesarLogin(Authentication aut, Model model, HttpSession misesion) {
		
		System.out.println("usuario : " + aut.getName());
		Usuario usuario = idao.findById(aut.getName());
		
		if (misesion.getAttribute("usuario") == null)
			misesion.setAttribute("usuario", usuario);
		
		System.out.println();
		
		for (GrantedAuthority ele: aut.getAuthorities())
			System.out.println("ROL : " + ele.getAuthority());
		
		model.addAttribute("mensaje", aut.getAuthorities());
		
		
		return "redirect:/";
	}
	
	

}
