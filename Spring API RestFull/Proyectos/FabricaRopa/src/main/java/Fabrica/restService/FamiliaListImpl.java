package Fabrica.restService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Fabrica.restEntityBeans.Familia;
import Fabrica.restRepository.FamiliaRepository;






@Service
public class FamiliaListImpl implements FamiliaService{

	
	@Autowired
	private FamiliaRepository ifam;
	
	
	
	
	@Override
	public Familia altaFamilia(Familia familia) {
		
		if(buscarUno(familia.getIdFamilia()) == null){
			return ifam.save(familia);
		}
		return null;
	}
	
	
	@Override
	public Familia modificarFamilia(Familia familia) {
		
		if(buscarUno(familia.getIdFamilia()) != null){
			return ifam.save(familia);
		}
		return null;
	}

	
	@Override
	public boolean eliminarFamilia(int idFamilia) {
		try {
			if(buscarUno(idFamilia) != null){
				ifam.deleteById(idFamilia);
				return true;
			}
		}catch(Exception e) {
			return false;
		}
		return false;
	}

	
	@Override
	public Familia buscarUno(int idFamilia) {
		
		return ifam.findById(idFamilia).orElse(null);
	}
	

	@Override
	public List<Familia> buscarTodas() {
		
		return ifam.findAll();
	}

	
}
