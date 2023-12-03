package Fabrica.restRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Fabrica.restEntityBeans.Producto;

public interface ProductosRepository extends JpaRepository<Producto, Integer>{

	
	
	//SACAME TODOS LO PRODUCTOS DE UNA FAMILIA
	@Query("select p from Producto p where p.familia.idFamilia= ?1")
	public List<Producto> buscarProductoPorFamilia(int idFamilia);
	
}
