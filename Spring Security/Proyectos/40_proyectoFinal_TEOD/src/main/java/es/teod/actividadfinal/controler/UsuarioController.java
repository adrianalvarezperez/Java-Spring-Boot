package es.teod.actividadfinal.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.teod.actividadfinal.modelo.repository.UsuarioRepository;

@RestController
@RequestMapping("/rest/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository urepo;
	
	 

}
