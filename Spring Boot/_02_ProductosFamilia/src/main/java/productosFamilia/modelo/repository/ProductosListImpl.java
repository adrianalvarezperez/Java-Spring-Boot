package productosFamilia.modelo.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import productosFamilia.modelo.beans.Producto;








@Repository
public class ProductosListImpl implements IntProductos{

		private List<Producto> lista;
		public static int nuevoCod;
		
		FamiliaListImpl f; 
		
		public ProductosListImpl() {
			lista = new ArrayList<Producto>();
		    f = new FamiliaListImpl();
			cargarDatos();
		}
		
		
		
		
	private void cargarDatos() {
			
			IntFamilia ifamilias = new FamiliaListImpl();
			
			
				lista.add(new Producto(1,"Camisa blanca XL Hombre",30,new Date(),ifamilias.finById(1)));
				lista.add(new Producto(2,"Camisa verde XS Mujer",60,new Date(),ifamilias.finById(1)));
				lista.add(new Producto(3,"Pantalon blanca L Hombre",15,new Date(),ifamilias.finById(2)));
				lista.add(new Producto(4,"Pantalon verde S Mujer",45,new Date(),ifamilias.finById(2)));
				lista.add(new Producto(5,"Jersey blanca XL Hombre",78,new Date(),ifamilias.finById(3)));
				lista.add(new Producto(6,"Jersey verde XS Mujer",87,new Date(),ifamilias.finById(3)));
				lista.add(new Producto(7,"Chaleco blanca XL Hombre",56,new Date(),ifamilias.finById(4)));
				lista.add(new Producto(8,"Chaleco verde S Mujer",36,new Date(),ifamilias.finById(4)));
				lista.add(new Producto(9,"Camiseta blanca M Hombre",34,new Date(),ifamilias.finById(5)));
				lista.add(new Producto(10,"Camiseta verde M Mujer",120,new Date(),ifamilias.finById(5)));
				
				nuevoCod= 10;
		}
		

		@Override
		public List<Producto> findAll() {
			return lista;
		}

		
		@Override
		public Producto findById(int idProducto) {
			
			Producto aux = new Producto();
			aux.setIdProducto(idProducto);
			
			int i = lista.indexOf(aux);
			if (i== -1)
				return null;
			else
				return lista.get(i);
		}
		
		
		@Override
		public List<Producto> novedades() {
			return lista;
		}
		

		@Override
		public int altaProducto(Producto producto) {
			if(lista.contains(producto)) {
				return 0;
			} else {
				f.insertarFamilia(producto.getFamilia());
				producto.setIdProducto(++nuevoCod);			//GENERA CODIGOS NUEVOS DESDE EL ULTIMO
				return lista.add(producto)?1:0;
			}
		}
		
		
		@Override
		public boolean borrarProducto(Producto producto) {
			 return lista.remove(producto);
		}
		

		@Override
		public int modificarProducto(Producto producto) {
			int i = lista.indexOf(producto);
			if (i == -1)
				return 0;
			else
				return (lista.set(i, producto) != null)?1:0;
		}
		
		
		
}
