package Empresa.restRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Empresa.restEntity.Pedido;






public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

	
	
	//SACAME TODOS LOS PEDIDOS DE UN ID_COMERCIAL
	@Query("select p from Pedido p where p.comerciale.idComercial= ?1")
	public List<Pedido> buscarPedidoPorComercial(int idComercial);
	
	
	
}
