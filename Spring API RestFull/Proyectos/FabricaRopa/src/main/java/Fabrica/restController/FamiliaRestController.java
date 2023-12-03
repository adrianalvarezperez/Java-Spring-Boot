package Fabrica.restController;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Fabrica.restEntityBeans.Familia;
import Fabrica.restService.FamiliaService;






@RestController
@RequestMapping("/familias")
public class FamiliaRestController {

	
	@Autowired
	private FamiliaService iFamServ;
	
	
//-------------------------------------------------------------------------------------------------->
	
	
	@GetMapping("/todas")
	public List<Familia> todas(){
		return iFamServ.buscarTodas();
	}
	
	
//-------------------------------------------------------------------------------------------------->
	
	
	@GetMapping("/una")				//SE LO METEMOS MANUAL AQUI EL NUMERO DE FAMILIA
	public Familia una(){
		return iFamServ.buscarUno(1);
	}
	
	
	@GetMapping("/unaa")			//LO TRAEMOS DE UN FORMULARIO
	public Familia unaa(@RequestParam("idFamilia") int idFamilia){
		return iFamServ.buscarUno(idFamilia);
	}
	
	
	@GetMapping("/unaaa/{id}")		//LO PASAMOS POR LA URL
	public Familia unaaa(@PathVariable("id") int idFamilia){
		return iFamServ.buscarUno(idFamilia);
	}
	
	
//-------------------------------------------------------------------------------------------------->
	
	
	@PostMapping("/alta")
	public Familia alta(@RequestBody Familia familia) {					//LLEGA UN JSON FORMATEAMELO A UN OBJETO DE LA CLASE FAMILIA QUE SE LLAMA FAMILIA
		return iFamServ.altaFamilia(familia);
	}
	
	
//-------------------------------------------------------------------------------------------------->
	
	
	@PutMapping("/modificar")
	public Familia modificar(@RequestBody Familia familia) {			//LLEGA UN JSON FORMATEAMELO A UN OBJETO DE LA CLASE FAMILIA QUE SE LLAMA FAMILIA
		return iFamServ.modificarFamilia(familia);
	}
	
	
	//-------------------------------------------------------------------------------------------------->
	
	
	@DeleteMapping("/eliminar/{id}")
	public boolean eliminar(@PathVariable("id") int idFamilia) {			
		return iFamServ.eliminarFamilia(idFamilia);
	}
	 
	
	@DeleteMapping("/eliminar2/{id}")
	public String eliminar2(@PathVariable("id") int idFamilia) {			
		 if(iFamServ.eliminarFamilia(idFamilia)) {
			 return "Familia eliminada";
		 }
		 return "Familia NOOO existe O NO SE PUEDE BORRAR ";
	}
	
}
