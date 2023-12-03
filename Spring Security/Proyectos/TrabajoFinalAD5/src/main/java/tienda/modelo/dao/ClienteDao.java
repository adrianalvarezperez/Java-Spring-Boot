package tienda.modelo.dao;

import java.util.List;

import tienda.modelo.beans.*;




public interface ClienteDao {

	
	int altaCliente(Usuario usuario);
	Usuario buscarUno(int idUsuario);
	List<Usuario> buscarUsuariosConCompras();
}
