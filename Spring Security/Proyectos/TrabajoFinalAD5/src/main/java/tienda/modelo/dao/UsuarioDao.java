package tienda.modelo.dao;

import tienda.modelo.beans.Usuario;




public interface UsuarioDao {
	
	Usuario findById(int id);
	Usuario findByUsername(String username);
	boolean registro(Usuario usuario);
	
}
