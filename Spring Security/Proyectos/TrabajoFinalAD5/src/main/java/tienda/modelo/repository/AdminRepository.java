package tienda.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tienda.modelo.beans.Usuario;




public interface AdminRepository extends JpaRepository<Usuario, String>{
	
	Usuario findByEmail(String email);

}
