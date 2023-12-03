package Cajero.dao;

import java.util.List;

import Cajero.entityBeans.Cuenta;
import Cajero.entityBeans.Movimiento;











public interface CueMovDao {

	
	Cuenta buscarPorCuenta(int idCuenta);
	
	
	
	int altaIngre(Movimiento movimiento, Cuenta cuenta);
	List<Movimiento> buscarMoviPorCuenta(int idCuenta);
	
	
}
