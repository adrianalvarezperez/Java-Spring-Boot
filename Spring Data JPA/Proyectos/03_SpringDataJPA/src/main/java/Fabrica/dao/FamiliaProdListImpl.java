package Fabrica.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Fabrica.entityBeans.Familia;
import Fabrica.entityBeans.Producto;
import Fabrica.repository.IntFamilia;
import Fabrica.repository.IntProducto;





@Repository
public class FamiliaProdListImpl implements FamiliaProdDao {

	@Autowired
	private IntFamilia ifa;
	@Autowired
	private IntProducto iprod;
	
//------------------------------------------------------------------------------------->
	
	
	@Override
	public List<Familia> buscarTodos() {
		return ifa.findAll();
	}

	@Override
	public Familia buscarUno(int idFamilia) { 
		return ifa.findById(idFamilia).orElse(null);
	}

	
//------------------------------------------------------------------------------------->
	
	
	@Override
	public List<Producto> buscarTodoss() {
		return iprod.findAll();
	}

	@Override
	public Producto buscarUnoo(int idProducto) {
		return iprod.findById(idProducto).orElse(null);
	}

	@Override
	public int altaProducto(Producto producto) {
		try {
			iprod.save(producto);
			return 1;
		} catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	
//------------------------------------------------------------------------------------->
	
	
	@Override
	public List<Producto> buscarPorFamilia(int idFamilia) {
		return iprod.findByFamilia(idFamilia);
	}

	
}
