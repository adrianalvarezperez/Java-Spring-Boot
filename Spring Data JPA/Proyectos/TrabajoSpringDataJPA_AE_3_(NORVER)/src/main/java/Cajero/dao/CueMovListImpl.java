package Cajero.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Cajero.entityBeans.Cuenta;
import Cajero.entityBeans.Movimiento;
import Cajero.repository.CuentaRepository;
import Cajero.repository.MovimientoRepository;









@Repository
public class CueMovListImpl implements CueMovDao{

	@Autowired
	private MovimientoRepository imov;
	@Autowired
	private CuentaRepository icue;
	
	
//------------------------------------------------------------------------------------->
	
	
			//MOVIMIENTOS
	
	
	//MÉTODO QUE VA A LA @QUERY
	@Override
	public List<Movimiento> buscarMoviPorCuenta(int idCuenta) {			//SACA LOS MOVIMIENTOS DE UN ID_CUENTA
		return imov.findByCuenta(idCuenta);
	}
	
	@Override
	public int altaIngre(Movimiento movimiento, Cuenta cuenta) {
		try {
			imov.save(movimiento);			//DA DE ALTA O MODIFICA 
			icue.save(cuenta);
			return 1;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	
//------------------------------------------------------------------------------------->
	
	
			//CUENTAS
	
	
	//SACA UNA CUENTA POR ID_CUENTA
	@Override
	public Cuenta buscarPorCuenta(int idCuenta) {
		return icue.findById(idCuenta).orElse(null);
										
	}
	
}
