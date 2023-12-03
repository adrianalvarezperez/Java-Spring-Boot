package Cajero.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Cajero.entityBeans.Cuenta;
import Cajero.entityBeans.Movimiento;
import Cajero.repository.CuentaRepository;
import Cajero.repository.MovimientoRepository;





@Repository
public class CuentaMovimientoListImpl implements CuentaMovimientoDao{

	
	@Autowired 
	private CuentaRepository icue;
	@Autowired
	private MovimientoRepository imov;
	
	
	
	
	
	//METODO QUE VA A LA @QUERY
	@Override
	public List<Movimiento> buscarMovimientoPorCuenta(int idCuenta){
		return imov.findByCuenta(idCuenta);	//SACA LOS MOVIMIENTOS DE UN ID_CUENTA
	}


	
	//METODO PARA DAR DE ALTA O MODIFICAR
	@Override
	public int alta(Movimiento movimiento, Cuenta cuenta) {
		try {
			imov.save(movimiento);
			icue.save(cuenta);
			return 1;
		} catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}


	
	//SACA UNA CUENTA POR ID_CUENTA
	@Override
	public Cuenta buscarPorCuenta(int idCuenta) {
		return icue.findById(idCuenta).orElse(null);
	}





	
	
}
