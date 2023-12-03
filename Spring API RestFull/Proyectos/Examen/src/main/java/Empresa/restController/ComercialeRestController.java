package Empresa.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Empresa.restEntity.Comerciale;
import Empresa.restService.ComercialListImpl;




@RestController
@RequestMapping("/comercial")
public class ComercialeRestController {

	
	@Autowired
	private ComercialListImpl iComercial;
	
	
	@PostMapping("/altaComercial")
	public Comerciale alta(@RequestBody Comerciale comercial) {
		return iComercial.altaComercial(comercial);
	}
	
	
		
		
}
