package Empresa.restRepository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Empresa.restEntity.Comerciale;







public interface ComercialeRepository extends JpaRepository<Comerciale, Integer>{

	
	
	//SACA LOS COMERCIALES CON PEDIDOS DE UN ID_CLIENTE
	@Query("select distinct c from Comerciale c, Pedido p where p.comerciale.idComercial=c and p.cliente.idCliente= ?1")
	public List<Comerciale> buscarComercialConPedidosDeUnCliente(int idCliente);
	

	
	
	//SACA LOS COMERCIALES QUE TENGAS ALGUN PEDIDO
	@Query(value="select distinct c.* from comerciales c join pedidos p on c.id_comercial=p.id_comercial", nativeQuery=true)
	public List<Comerciale> buscarComercialesConPedidos();
	
	
	
	
}



