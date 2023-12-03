package Fabrica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Fabrica.beans.Usuario;






public interface UsuarioRepository extends JpaRepository<Usuario, String>{

}
