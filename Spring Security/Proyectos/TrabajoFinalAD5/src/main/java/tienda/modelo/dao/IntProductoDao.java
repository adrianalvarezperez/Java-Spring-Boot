package tienda.modelo.dao;

import java.util.List;

import tienda.modelo.beans.Producto;




public interface IntProductoDao {
	
	int altaProducto(Producto producto);
	int eliminarProducto(int idProducto);
	int modificarProducto(Producto producto);
	List<Producto> buscarProductos();
	Producto buscarUno(int idProducto);
	List<Producto> buscarProductosPorNombre(String nombre);
}
