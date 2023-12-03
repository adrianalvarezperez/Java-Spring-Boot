package tienda.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tienda.modelo.beans.Producto;




public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	
	
	@Query("select p from Producto p where p.nombre LIKE %?1%")
	List<Producto> findByTextInName(String text);
	
}
