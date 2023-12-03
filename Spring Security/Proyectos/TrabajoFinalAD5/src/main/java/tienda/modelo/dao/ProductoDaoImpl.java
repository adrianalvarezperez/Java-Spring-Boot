package tienda.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tienda.modelo.beans.Producto;
import tienda.modelo.repository.ProductoRepository;




@Service
public class ProductoDaoImpl implements IntProductoDao{

	
	@Autowired
	private ProductoRepository iproducto;

	
//------------------------------------------------------------------------------------------------------------------------------------------------->
	
	
	@Override
	public int altaProducto(Producto producto) {
		try {
			iproducto.save(producto);	//DA DE ALTA O MODIFICA 
			return 1;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	
//------------------------------------------------------------------------------------------------------------------------------------------------->
	
	
	@Override
	public int modificarProducto(Producto producto) {
		try {
			iproducto.save(producto);	//DA DE ALTA O MODIFICA 
			return 1;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	
//------------------------------------------------------------------------------------------------------------------------------------------------->
	
	
	//LO BORRA PRODUCTOS
	@Override
	public int eliminarProducto(int idProducto) {
		try {
			iproducto.deleteById(idProducto);			
			return 1;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	
//------------------------------------------------------------------------------------------------------------------------------------------------->
	
	
	//SACA TODOS LOS EMPLEADOS
	@Override
	public List<Producto> buscarProductos(){
		return iproducto.findAll();
	}
	
	
//------------------------------------------------------------------------------------------------------------------------------------------------->
	
	
	@Override
	public Producto buscarUno(int idProducto) {
		return iproducto.findById(idProducto).orElse(null);		//BUSCA POR ID_DEPARTAMENTO
	}


//------------------------------------------------------------------------------------------------------------------------------------------------->
	
	
	public List<Producto> buscarProductosPorNombre(String nombre) {
		return iproducto.findByTextInName(nombre);
	}
	
}
