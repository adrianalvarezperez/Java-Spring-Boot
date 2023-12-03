package eventos.modelo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import eventos.modelo.beans.Eventos;
import eventos.modelo.beans.Reservas;




@Repository
public class ReservaListImpl implements IntReserva {

	
	private List<Reservas> lista;
	public static int ultimoId;


	public ReservaListImpl() {
		lista=  new ArrayList<>();
	}
	
//------------------------------------------------------------------------------------------>
	
	@Override
	public int nuevaReserva(Reservas reserva) {
		ultimoId = ultimoId + 1;
		reserva.setIdReserva(ultimoId);
		lista.add(reserva);
		return 1;
	}

	public static void setUltimoId(int ultimoId) {
		ReservaListImpl.ultimoId = ultimoId;
	}

	@Override
	public List<Reservas> findByEvento(int eventId) {
		List<Reservas> reservasDelEvento = new ArrayList<>();
		for (Reservas reserva: lista) {
			if (reserva.getEvento().getIdEvento() == eventId) {
				reservasDelEvento.add(reserva);
			}
		}
		return reservasDelEvento;
	}
	
	@Override
	public int calcularAforoRestante(Eventos evento) {
		List<Reservas> reservas = this.findByEvento(evento.getIdEvento());
		int reservasTotales = 0;
		for (Reservas reserva: reservas) {
			reservasTotales += reserva.getCantidad();
		}

		return evento.getAforoMaximo() - reservasTotales;
	}
	
}
