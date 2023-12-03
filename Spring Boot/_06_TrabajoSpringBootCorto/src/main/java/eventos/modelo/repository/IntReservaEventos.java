package eventos.modelo.repository;

import java.util.List;

import eventos.modelo.beans.Eventos;
import eventos.modelo.beans.Reservas;
import eventos.modelo.beans.Usuario;


public interface IntReservaEventos {
	
	
	
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
	
	Usuario findByUsernameAndPassword(String username, String password);
	List<Reservas> findByEvento(int eventId);
	int nuevaReserva(Reservas reserva);
	int calcularAforoRestante(Eventos evento);
}
