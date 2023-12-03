package API_REST.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import API_REST.entityBeans.Contacto;





@RestController
@RequestMapping("/inicio")
public class RestControllerSaludo {

	
	
	
	@GetMapping("/saludo")
	public String saludar() {
		return "Hola me llamo Cruceros";
	}
	
	
	
	
	
	@GetMapping("/contacto")
	public Contacto contacto() {
		return new Contacto("Cruceros", "634234123", "ppp@gmail.com");
	}
	
}
