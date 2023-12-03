package tienda.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tienda.modelo.beans.ILocalidadCount;
import tienda.modelo.repository.UsuarioRepository;




@RestController
@RequestMapping("/rest")
public class UsuarioRestController {

	
	@Autowired
	private UsuarioRepository userRepository;
	
	
//------------------------------------------------------------------------------------------------------------------------------------------------->
	
	
	@GetMapping("/usuarios/localidades")  
	public List<ILocalidadCount> localidades() {
		return userRepository.countUsersInLocalidad();
	}
}
