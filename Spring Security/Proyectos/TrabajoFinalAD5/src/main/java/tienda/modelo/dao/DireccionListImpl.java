package tienda.modelo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tienda.modelo.beans.Direccione;
import tienda.modelo.repository.DireccionesRepository;




@Repository
public class DireccionListImpl implements DireccionDao{


	@Autowired
	private DireccionesRepository iDireccion;
	
	
//------------------------------------------------------------------------------------------------------------------------------------------------->	
	
	
	@Override
	public int altaDireccion(Direccione Direcciones) {
		try {
			iDireccion.save(Direcciones);	//DA DE ALTA O MODIFICA 
			return 1;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
}