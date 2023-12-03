package es.teod.actividadfinal.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.teod.actividadfinal.modelo.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	public Usuario findByEmailAndContraseña(String emial, String password);

}
