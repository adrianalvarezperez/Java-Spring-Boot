package eventos.modelo.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import eventos.modelo.beans.Usuario;


@Repository
public class UsuarioListImpl implements IntUsuario {
	private List<Usuario> lista;
	
	public UsuarioListImpl() {
		lista = new ArrayList<Usuario>();
		cargarDatos();
	}

	private void cargarDatos() {
		lista.add(
				new Usuario(1, "user1", "password", "user1@mail.com", "Juan", "La calle", 1, new Date())
		);
		lista.add(
				new Usuario(1, "user2", "password", "user2@mail.com", "Maria", "La calle 2", 1, new Date())
		);
		lista.add(
				new Usuario(1, "user3", "password", "user3@mail.com", "Paca", "La calle 3", 0, new Date())
		);
	}

	@Override
	public Usuario findByUsernameAndPassword(String username, String password) {
		for (Usuario usu: lista) {
			if (usu.getUsername().equals(username) && usu.getPassword().equals(password)) {
				return usu;
			}
		}
				return null;
	}
}
