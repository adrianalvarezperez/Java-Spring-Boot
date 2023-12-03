package tienda.modelo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tienda.modelo.beans.Rol;
import tienda.modelo.repository.RolRepository;




@Repository
public class RolDaoImpl implements RolDao{
	
	
	@Autowired
	private RolRepository prepo;

	
//------------------------------------------------------------------------------------------------------------------------------------------------->
	
	
	@Override
	public Rol findById(int idPerfil) {
		return prepo.findById(idPerfil).orElse(null);
	}
}
