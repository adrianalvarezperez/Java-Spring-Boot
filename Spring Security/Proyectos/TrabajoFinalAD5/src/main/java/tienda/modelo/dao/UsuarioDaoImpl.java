package tienda.modelo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tienda.modelo.beans.Usuario;
import tienda.modelo.repository.UsuarioRepository;




@Repository
public class UsuarioDaoImpl implements UsuarioDao {
	
	
	@Autowired
	private UsuarioRepository urepo;
	
	
//------------------------------------------------------------------------------------------------------------------------------------------------->
	
	
	@Override
	public Usuario findById(int id) {
		return urepo.findById(id).orElse(null);
	}
	
	
//------------------------------------------------------------------------------------------------------------------------------------------------->
	
	
	@Override
	public boolean registro(Usuario usuario) {
		if (findById(usuario.getIdUsuario()) == null) {
				try {
					urepo.save(usuario);
					return true;
				}catch (Exception e) {
					e.printStackTrace();
					return false;
				}
		}
		return false;
	}
	
	
//------------------------------------------------------------------------------------------------------------------------------------------------->
	
	
	@Override
	public Usuario findByUsername(String username) {
		return urepo.findByUsername(username);
	}
}
