package tienda.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tienda.modelo.beans.Compra;




public interface ComprasRepository extends JpaRepository<Compra, Integer>{
	
	
	@Query("SELECT c FROM Compra c WHERE c.estado='CARRITO' AND c.usuario.idUsuario = ?1")
	Compra findCarritoByUsuario(int idUsuario);

	
//------------------------------------------------------------------------------------------------------------------------------------------------->
	
	
	@Query("SELECT c FROM Compra c WHERE c.estado='COMPRADO' AND c.usuario.idUsuario = ?1")
	List<Compra> findComprasByUsuario(int idUsuario);

	
//------------------------------------------------------------------------------------------------------------------------------------------------->
	
	
	@Query("SELECT c FROM Compra c WHERE c.estado='COMPRADO' AND c.fechaDeRealizacion = CURRENT_DATE()")
	List<Compra> findComprasFromSameDay();
	
}
