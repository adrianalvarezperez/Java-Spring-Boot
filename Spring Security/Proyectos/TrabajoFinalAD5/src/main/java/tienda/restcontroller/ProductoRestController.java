package tienda.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tienda.modelo.beans.Producto;
import tienda.modelo.repository.ProductoRepository;




@RestController
@RequestMapping("/rest")

public class ProductoRestController {
	
	
	@Autowired
	private ProductoRepository productRepository;
	
	
//------------------------------------------------------------------------------------------------------------------------------------------------->
	
	
	@GetMapping("/producto/precio/{id}")
	public ResponseEntity precioProducto(@PathVariable("id")int idProducto) {
		Producto producto= productRepository.findById(idProducto).orElse(null);
		if(producto==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El producto no se ha encontrado");
		}
		return ResponseEntity.status(HttpStatus.OK).body(producto.getPrecio());
	}
}
