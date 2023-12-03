package tienda.modelo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tienda.modelo.beans.*;




public interface ClienteRepository extends JpaRepository<Usuario, Integer>{


		Usuario findByEmail(String email);

		
//------------------------------------------------------------------------------------------------------------------------------------------------->
		
		
		@Query("SELECT u FROM Usuario u JOIN u.compras c WHERE c IS NOT NULL GROUP BY u.idUsuario")
		List<Usuario> findWithCompras();
		
}
