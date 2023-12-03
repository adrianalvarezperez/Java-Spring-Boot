package Fabrica.restService;

import java.util.List;

import Fabrica.restEntityBeans.Familia;

public interface FamiliaService {

	
		Familia altaFamilia(Familia familia);
		
		boolean eliminarFamilia(int idFamilia);
		
		Familia buscarUno(int idFamilia);
		
		List<Familia> buscarTodas();
		
		Familia modificarFamilia(Familia familia);
	
}
