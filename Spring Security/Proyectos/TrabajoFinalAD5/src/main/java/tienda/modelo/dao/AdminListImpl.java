package tienda.modelo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tienda.modelo.beans.Usuario;
import tienda.modelo.repository.AdminRepository;




@Repository
public class AdminListImpl implements AdminDao {
	
	
	@Autowired
	private AdminRepository iadmin;

	
//------------------------------------------------------------------------------------------------------------------------------------------------->
	
	
	@Override
	public int altaAdmin(Usuario usuario) {
		try {
			iadmin.save(usuario);	//DA DE ALTA O MODIFICA 
			return 1;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
