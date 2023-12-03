package tienda.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tienda.modelo.beans.ILocalidadCount;
import tienda.modelo.beans.Usuario;




public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	
	Usuario findByUsername(String username);
	
	
//------------------------------------------------------------------------------------------------------------------------------------------------->
	
	
	@Query("SELECT d.localidad as localidad, COUNT(DISTINCT u.idUsuario) AS cantidad FROM Usuario u JOIN u.direcciones d GROUP BY d.localidad")
	List<ILocalidadCount> countUsersInLocalidad();
	
}
