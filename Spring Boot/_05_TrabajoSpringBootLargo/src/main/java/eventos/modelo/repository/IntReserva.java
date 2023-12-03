package eventos.modelo.repository;

import java.util.List;

import eventos.modelo.beans.Eventos;
import eventos.modelo.beans.Reservas;

public interface IntReserva {
	
	
	List<Reservas> findByEvento(int eventId);
	int nuevaReserva(Reservas reserva);
	int calcularAforoRestante(Eventos evento);
	
}
