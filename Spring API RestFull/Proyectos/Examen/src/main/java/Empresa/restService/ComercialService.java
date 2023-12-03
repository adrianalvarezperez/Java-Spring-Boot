package Empresa.restService;

import Empresa.restEntity.Comerciale;





public interface ComercialService {

	Comerciale altaComercial(Comerciale comercial);
	Comerciale modificarComercial(Comerciale comercial);
	Comerciale buscarUno(int idComercial);
	
}
