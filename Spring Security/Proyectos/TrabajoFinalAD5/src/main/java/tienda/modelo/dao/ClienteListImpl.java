package tienda.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tienda.modelo.beans.*;
import tienda.modelo.repository.ClienteRepository;




@Repository
public class ClienteListImpl implements ClienteDao {
	
	
	@Autowired
	private ClienteRepository iuser;
	
	
//------------------------------------------------------------------------------------------------------------------------------------------------->
	
	
	@Override
	public int altaCliente(Usuario usuario) {
		try {
			iuser.save(usuario);	//DA DE ALTA O MODIFICA 
			return 1;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}


//------------------------------------------------------------------------------------------------------------------------------------------------->
	
	
	@Override
	public Usuario buscarUno(int idUsuario) {
		return iuser.findById(idUsuario).orElse(null);
	}

	
//------------------------------------------------------------------------------------------------------------------------------------------------->
	
	
	@Override
	public List<Usuario> buscarUsuariosConCompras() {
		return iuser.findWithCompras();
	}
}
