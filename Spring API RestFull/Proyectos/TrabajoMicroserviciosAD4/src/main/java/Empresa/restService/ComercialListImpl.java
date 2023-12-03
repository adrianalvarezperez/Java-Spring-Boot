package Empresa.restService;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Empresa.restDTO.ComercialDTO;
import Empresa.restDTO.PedidoDTO;
import Empresa.restEntity.Comerciale;
import Empresa.restEntity.Pedido;
import Empresa.restRepository.ComercialeRepository;
import Empresa.restRepository.PedidoRepository;







@Service
public class ComercialListImpl implements ComercialService{

	
	
		@Autowired
		private ComercialeRepository iComercial;							//LLAMAMOS A LOS REPOSITORIOS
		@Autowired
		private PedidoRepository ipedido;
	
		
		
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------->	
		
		
		
		//DAMOS DE ALTA UN COMERCIAL
		@Override
		public Comerciale altaComercial(Comerciale comercial) {
			if(buscarUno(comercial.getIdComercial()) == null){				//SI EL ID_COMERCIAL ES IGUAL A VACIO LO DAMOS DE ALTA
				return iComercial.save(comercial);
			}
			return null;
		}
		
		
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------->	
		
		//MODIFICAMOS UN COMERCIAL
		@Override
		public Comerciale modificarComercial(Comerciale comercial) {
			
			if(buscarUno(comercial.getIdComercial()) != null){				//SI EL ID_COMERCIAL NO ESTA VACIO LO MODIFICAMOS
				return iComercial.save(comercial);
			}
			return null;
		}
		
		
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------->	
		
		
		
		//ELIMINAMOS UN COMERCIAL
		@Override
		public boolean eliminarComercial(int idComercial) {
			try {
				if(buscarUno(idComercial) != null){							//SI EL ID_COMERCIAL NO ESTA VACIO LO ELIMINAMOS
					iComercial.deleteById(idComercial);
					return true;
				}
			}catch(Exception e) {
				return false;
			}
			return false;
		}
		
		
		
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------->	
		
		
		
		//SACAMOS LOS DATOS DE UN COMERCIAL
		@Override
		public Comerciale buscarUno(int idComercial) {			
			return iComercial.findById(idComercial).orElse(null);			//BUSCAMOS UN COMERCIAL POR EL ID
		}
		
		
		
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------->	
		
		
		//SACAMOS TODOS LOS COMECIALES
		@Override
		public List<Comerciale> buscarTodos() {
			return iComercial.findAll();
		}
		
		
		
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------->	
		
		
			
		//CONVERTIR COMERCIAL A DTO
		private ComercialDTO convertirComercialADTO(Comerciale comercial) {
			ComercialDTO comercialDTO= new ComercialDTO();
			comercialDTO.setIdComercial(comercial.getIdComercial());
			comercialDTO.setApellido1(comercial.getApellido1());
			comercialDTO.setApellido2(comercial.getApellido2());
			comercialDTO.setComision(comercial.getComision());
			comercialDTO.setNombre(comercial.getNombre());
			return comercialDTO;
		}
		
		
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
		
		
		
		//SACAR UNA LISTA CON LOS COMERCIALES CON PEDIDOS POR ID_CLIENTE
		@Override
		public List<ComercialDTO> buscarPorPedidosDeCliente(int idCliente){
			 List<Comerciale> comerciales= iComercial.buscarComercialConPedidosDeUnCliente(idCliente); 		//LISTA QUE VA AL METODO DEL REPOSITORIO DONDE ESTA LA @QUERY
			 List<ComercialDTO> comercialesDTO = new ArrayList<ComercialDTO>();
			 for(Comerciale comercial:comerciales) {
				ComercialDTO comercialDTO= convertirComercialADTO(comercial);
				comercialesDTO.add(comercialDTO);
			 }
			 return comercialesDTO;
		}
		

		
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
		
		
		
		//SACAR UNA LISTA DE LOS COMERCIALES CON PEDIDOS
		@Override
		public List<ComercialDTO> buscarComercialesConPedidos(){
			List<Comerciale> comerciales= iComercial.buscarComercialesConPedidos(); 	 				//LISTA QUE VA AL METODO DEL REPOSITORIO DONDE ESTA LA @QUERY
			List<ComercialDTO> comercialesDTO = new ArrayList<ComercialDTO>();
			 for(Comerciale comercial:comerciales) {
				ComercialDTO comercialDTO= convertirComercialADTO(comercial);
				comercialesDTO.add(comercialDTO);
			 }
			 return comercialesDTO;
		}
		
		
		
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------->		
		
		
		
		//SACAR UNA LISTA DE PEDIDOS POR ID_COMERCIAL
		@Override
		public List<PedidoDTO> buscarPedidoPorComercial(int idComercial) {		
			List<Pedido> pedidos = ipedido.buscarPedidoPorComercial(idComercial);						//LISTA QUE VA AL METODO DEL REPOSITORIO DONDE ESTA LA @QUERY
			List<PedidoDTO> pedidosDTO = new ArrayList<PedidoDTO>();
			for(Pedido pedido:pedidos) {
				PedidoDTO pedidoDTO = new PedidoDTO();
				pedidoDTO.setCliente(pedido.getCliente().getIdCliente());
				ComercialDTO comercialDTO = convertirComercialADTO(pedido.getComerciale());
				pedidoDTO.setComerciale(comercialDTO);
				pedidoDTO.setIdPedido(pedido.getIdPedido());
				pedidosDTO.add(pedidoDTO);
			}
			 
			return pedidosDTO;
		}
	
}
