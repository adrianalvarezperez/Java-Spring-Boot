package productosFamilia.modelo.repository;

import java.util.List;

import productosFamilia.modelo.beans.Producto;






public interface IntProductos {
	
	List<Producto>  findAll();
	List<Producto>  novedades();
	int altaProducto(Producto producto);
	boolean borrarProducto(Producto producto);
	int modificarProducto(Producto producto);
	Producto findById(int idProducto);

}
