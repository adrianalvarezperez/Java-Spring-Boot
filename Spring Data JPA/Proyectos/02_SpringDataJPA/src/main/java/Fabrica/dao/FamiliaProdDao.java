package Fabrica.dao;

import java.util.List;

import Fabrica.entityBeans.Familia;
import Fabrica.entityBeans.Producto;







public interface FamiliaProdDao {
	
	
	List<Familia> buscarTodos();
	Familia buscarUno(int idFamilia);
	
//------------------------------------------------------------------------------------->
	
	List<Producto> buscarTodoss();
	Producto buscarUnoo(int idProducto);
	
//------------------------------------------------------------------------------------->
	
	List<Producto> buscarPorFamilia(int idFamilia);
	
	
}
