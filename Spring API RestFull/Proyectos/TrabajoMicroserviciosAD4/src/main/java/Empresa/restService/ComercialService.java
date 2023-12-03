package Empresa.restService;

import java.util.List;
import Empresa.restDTO.ComercialDTO;
import Empresa.restDTO.PedidoDTO;
import Empresa.restEntity.Comerciale;






public interface ComercialService {

	Comerciale altaComercial(Comerciale comerciale);
	
	Comerciale modificarComercial(Comerciale comercial);

	Comerciale buscarUno(int idComercial);
	
	List<Comerciale> buscarTodos();

	boolean eliminarComercial(int idComercial);

	List<PedidoDTO> buscarPedidoPorComercial(int idComercial);

	List<ComercialDTO> buscarPorPedidosDeCliente(int idCliente);

	List<ComercialDTO> buscarComercialesConPedidos();


}
