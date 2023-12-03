package Cajero.dao;

import java.util.List;
import Cajero.entityBeans.Cuenta;
import Cajero.entityBeans.Movimiento;






public interface CuentaMovimientoDao {


		Cuenta buscarPorCuenta(int idCuenta);
		
		
		
		int alta(Movimiento movimiento, Cuenta cuenta);
		List<Movimiento> buscarMovimientoPorCuenta(int idCuenta);
	
}
