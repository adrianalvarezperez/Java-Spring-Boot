package Fabrica.dao;

import java.util.List;
import Fabrica.beans.Perfile;
import Fabrica.beans.Producto;
import Fabrica.beans.Usuario;







public interface IntFabricaDao {

	
	int insertarProducto(Producto producto);
	Producto buscarUno(int codigo);
	List<Producto> buscarTodos();
	List<Producto> buscarporFamilia(int codigoFamilia);
	List<Producto> buscarPormarcayColor(String marca, String color);
	int borrarProducto(int codigo);
	int modificarProducto(Producto producto);
	
	
	
//------------------------------------------------------------------------------------>	
	
	
	Perfile findById(int idPerfil); 
	
	
//------------------------------------------------------------------------------------>		
	
	
	Usuario findById(String username);
	boolean registro(Usuario usuario);
	
}
