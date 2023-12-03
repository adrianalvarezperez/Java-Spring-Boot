package Empresa.restService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Empresa.restEntity.Comerciale;
import Empresa.restRepository.ComercialeRepository;







@Service
public class ComercialListImpl implements ComercialService{

	
	@Autowired 
	private ComercialeRepository iRepoComercial;
	
		
	
	public Comerciale altaComercial(Comerciale comercial) {
		if(buscarUno(comercial.getIdComercial()) == null) {
			return iRepoComercial.save(comercial);
		}
		return null;
	}
	
	
	public Comerciale modificarComercial(Comerciale comercial) {
		if(buscarUno(comercial.getIdComercial()) == null) {
			return iRepoComercial.save(comercial);
		}
		return null;
	}
	
	public Comerciale buscarUno(int idComercial) {
		return iRepoComercial.findById(idComercial).orElse(null);
	}
	
}
