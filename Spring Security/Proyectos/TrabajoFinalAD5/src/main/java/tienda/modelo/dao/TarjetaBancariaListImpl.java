package tienda.modelo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tienda.modelo.beans.TarjetasBancaria;
import tienda.modelo.repository.TarjetasBancariasRepository;




@Repository
public class TarjetaBancariaListImpl implements TarjetaBancariaDao{

	
	@Autowired
	private TarjetasBancariasRepository iTarjeta;
	
	
//------------------------------------------------------------------------------------------------------------------------------------------------->
	
	
	@Override
	public int altaTarjeta(TarjetasBancaria Tarjeta) {
		try {
			iTarjeta.save(Tarjeta);	//DA DE ALTA O MODIFICA 
			return 1;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}