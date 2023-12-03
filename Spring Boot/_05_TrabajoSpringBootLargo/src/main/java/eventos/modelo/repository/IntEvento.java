package eventos.modelo.repository;

import java.util.List;

import eventos.modelo.beans.Eventos;

public interface IntEvento {
	
	
	Eventos buscarUno(int idEvento);
	List<Eventos> buscarTodos();
	
	
	int nuevoEvento(Eventos evento);
	int editarEvento(Eventos evento);
	int cancelarEvento(int IdEventos);
	int cancelarEventoDestacado(int idEvento);
	boolean eliminarEvento(Eventos evento);
	
	
	List<Eventos> buscarActivos();
	List<Eventos> buscarCancelados();
	List<Eventos> buscarDestacados();
	List<Eventos> buscarNoDestacados();
}
