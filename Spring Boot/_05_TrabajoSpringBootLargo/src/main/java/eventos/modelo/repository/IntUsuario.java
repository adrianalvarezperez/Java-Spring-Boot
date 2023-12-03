package eventos.modelo.repository;

import eventos.modelo.beans.Usuario;

public interface IntUsuario {
	Usuario findByUsernameAndPassword(String username, String password);	
}
