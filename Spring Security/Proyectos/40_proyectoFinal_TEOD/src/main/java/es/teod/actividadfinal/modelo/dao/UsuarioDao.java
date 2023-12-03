package es.teod.actividadfinal.modelo.dao;

import es.teod.actividadfinal.modelo.entity.Direccion;
import es.teod.actividadfinal.modelo.entity.Tarjeta;
import es.teod.actividadfinal.modelo.entity.Usuario;

public interface UsuarioDao {
	
	void asignarTarjeta(Tarjeta tarjeta);
	void asignarDireccion(Direccion direccion);
	void eliminarTarjeta(int idTarjeta);
	void eliminarDireccion(int idDireccion);
	int altaUsuario(Usuario usuario);
	Usuario buscarByEmailAndPassword(String email, String password);
	Usuario buscarUsuario(int idUsuario);

}
