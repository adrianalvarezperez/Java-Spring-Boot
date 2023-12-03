package Empresa.restController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Empresa.restDTO.ComercialDTO;
import Empresa.restDTO.PedidoDTO;
import Empresa.restEntity.Comerciale;
import Empresa.restEntity.Pedido;
import Empresa.restRepository.ComercialeRepository;
import Empresa.restRepository.PedidoRepository;
import Empresa.restService.ComercialService;





@RestController
@RequestMapping("/comercial")
public class ComercialeRestController {

	
	
		@Autowired
		private ComercialService iComercial;
		@Autowired
		private ComercialeRepository irepoComercial;
		@Autowired
		private PedidoRepository irepoPedido;
		
		
		
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------->	
		
		
		
		//LLEGA UN JSON FORMATEAMELO A UN OBJETO DE LA CLASE COMERCIALE QUE SE LLAMA COMERCIALE
		@PostMapping("/altaComercial")
		public Comerciale alta(@RequestBody Comerciale comercial) {					
			return iComercial.altaComercial(comercial);
		}
		
		
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------->	
		
		
		//LLEGA UN JSON FORMATEAMELO A UN OBJETO DE LA CLASE COMERCIALE QUE SE LLAMA COMERCIALE
		@PutMapping("/modificarComercial")
		public Comerciale modificar(@RequestBody Comerciale comercial) {			
			return iComercial.modificarComercial(comercial);
		}
		
		
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------->	

		
		//ELIMINA UN COMERCIAL QUE LE PASAMOS EL ID POR LA URL
		@DeleteMapping("/eliminarComercial/{id}")
		public String eliminar(@PathVariable("id") int idComercial) {				
			 if(iComercial.eliminarComercial(idComercial)) {
				 return "Comercial eliminada";
			 }
			 return "Comercial NOOO existe O NO SE PUEDE BORRAR ";
		}
		
		
		//ELIMINA UN COMERCIAL QUE LE PASAMOS EL ID POR LA URL
		@DeleteMapping("/eliminarComercialOtra/{id}")
		public boolean eliminarComercialOtra(@PathVariable("id") int idComercial) {			
			return iComercial.eliminarComercial(idComercial);
		}
		
		
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------->	


		
		//DATOS DEL COMERCIAL CUYO ID SE LO PASAMOS POR URL
		@GetMapping("/buscarComercial/{id}")	
		public Comerciale buscarComercial(@PathVariable("id") int idComercial){					
			return iComercial.buscarUno(idComercial);
		}
		
		
		
		//LISTA DE TODOS LOS COMERCIALES
		@GetMapping("/buscaTodosComerciales")
		public List<Comerciale> todas(){
			return iComercial.buscarTodos();
		}
		
		
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------->	

		
		
		//LISTA DE LOS COMERCIALES QUE HAN ATENDIDO PEDIDOS ID_CLIENTE
		@GetMapping("/bycliente/{id}")
		public ResponseEntity<?> byCiente(@PathVariable("id") int idCliente){
			List<ComercialDTO> comercialesDTO= iComercial.buscarPorPedidosDeCliente(idCliente);
			if(comercialesDTO.isEmpty() ) {
				return new ResponseEntity<String>("Cliente no exite", HttpStatus.NOT_FOUND);
			}
			return ResponseEntity.status(HttpStatus.OK).body(comercialesDTO);
			
		}
		
		
		//LISTA DE LOS COMERCIALES QUE HAN ATENDIDO PEDIDOS ID_CLIENTE
		@GetMapping("/byclienteOtra/{id}")
		public List<Comerciale> byClienteOtra(@PathVariable("id") int idCliente) {			
				return irepoComercial.buscarComercialConPedidosDeUnCliente(idCliente);
		}
				
		
	
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------->	

		
		
		//LISTA DE COMERCIALES QUE HAN ATENDIDO ALGUN PEDIDO
		@GetMapping("/conpedidos")
		public ResponseEntity<?> conpedidos() {
			List<ComercialDTO> comercialesDTO= iComercial.buscarComercialesConPedidos();
			if(comercialesDTO.isEmpty() ) {
				return new ResponseEntity<String>("Cliente no exite", HttpStatus.NOT_FOUND);
			}
			return ResponseEntity.status(HttpStatus.OK).body(comercialesDTO);
		}
		
		
		
		//LISTA DE COMERCIALES QUE HAN ATENDIDO ALGUN PEDIDO
		@GetMapping("/conpedidosOtra")
		public List<Comerciale> byClienteOtra() {			
				return irepoComercial.buscarComercialesConPedidos();
		}
		
		
		
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------->	

		
		
		//LISTA DE LOS PEDIDOS POR ID_COMERCIAL
		@GetMapping("/pedidos/{id}")
		public ResponseEntity<?> pedidos(@PathVariable("id") int idComercial) {				
			List<PedidoDTO> pedidosDTO= iComercial.buscarPedidoPorComercial(idComercial);
			if(pedidosDTO.isEmpty()) {
				return new ResponseEntity<String>("No hay pedidos", HttpStatus.NOT_FOUND);
			}
			return ResponseEntity.status(HttpStatus.OK).body(pedidosDTO);
		}
		
	
		
		//LISTA DE LOS PEDIDOS POR ID_COMERCIAL
		@GetMapping("/pedidosOtra/{id}")
		public List<Pedido> pedidosOtra(@PathVariable("id") int idComercial) {			
			return irepoPedido.buscarPedidoPorComercial(idComercial);
		}
		
}
