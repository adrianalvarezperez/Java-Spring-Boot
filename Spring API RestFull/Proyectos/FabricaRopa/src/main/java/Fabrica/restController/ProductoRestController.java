package Fabrica.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Fabrica.restDTO.ProductoDTO;
import Fabrica.restEntityBeans.Producto;
import Fabrica.restRepository.ProductosRepository;
import Fabrica.restService.ProductoService;





@RestController
@RequestMapping("/productos")
public class ProductoRestController {

	
	
	@Autowired
	private ProductosRepository iprod;
	@Autowired
	private ProductoService iProdServ;
	
	
	
	@GetMapping("/porFamilia/{id}")
	public List<Producto> porFamilia(@PathVariable("id") int idFamilia){
		return iprod.buscarProductoPorFamilia(idFamilia);
	}
	
	
	
	@GetMapping("/ver/{id}")
	public ResponseEntity<?> verProducto(@PathVariable("id") int idProducto){
		ProductoDTO pdto= iProdServ.buscarUno(idProducto);
		if(pdto == null) {
			return new ResponseEntity<String>("Producto no exite", HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.status(HttpStatus.OK).body(pdto);
	}
}
