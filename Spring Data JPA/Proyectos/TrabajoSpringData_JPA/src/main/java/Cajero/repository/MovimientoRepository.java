package Cajero.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Cajero.entityBeans.Movimiento;





public interface MovimientoRepository extends JpaRepository<Movimiento, Integer>{
	
	
	//SACAME LOS MOVIMIENTOS DE UN ID_CUENTA QUE LE PASEMOS POR PARAMETROS. 
	@Query("select p from Movimiento p where p.cuenta.idCuenta = ?1")
	public List<Movimiento> findByCuenta(int idCuenta);


}
