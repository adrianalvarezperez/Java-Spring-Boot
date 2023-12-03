package eventos.modelo.beans;

import java.io.Serializable;
import java.util.Objects;

public class Reservas implements Serializable {

	
			//PROPIEDADES
			private static final long serialVersionUID= 1L;
			private int idReserva;
			private double precioVenta;
			private String observaciones;
			private int cantidad;
			private Usuario usuario;
			private Eventos evento;
			
			
			
			public Reservas(int idReserva, double precioVenta, String observaciones, int cantidad, Usuario usuario,
					Eventos evento) {
				super();
				this.idReserva = idReserva;
				this.precioVenta = precioVenta;
				this.observaciones = observaciones;
				this.cantidad = cantidad;
				this.usuario = usuario;
				this.evento = evento;
			}



			public Reservas() {
				super();
			}



			public int getIdReserva() {
				return idReserva;
			}



			public void setIdReserva(int idReserva) {
				this.idReserva = idReserva;
			}



			public double getPrecioVenta() {
				return precioVenta;
			}



			public void setPrecioVenta(double precioVenta) {
				this.precioVenta = precioVenta;
			}



			public String getObservaciones() {
				return observaciones;
			}



			public void setObservaciones(String observaciones) {
				this.observaciones = observaciones;
			}



			public int getCantidad() {
				return cantidad;
			}



			public void setCantidad(int cantidad) {
				this.cantidad = cantidad;
			}



			public Usuario getUsuario() {
				return usuario;
			}



			public void setUsuario(Usuario usuario) {
				this.usuario = usuario;
			}



			public Eventos getEvento() {
				return evento;
			}



			public void setEvento(Eventos evento) {
				this.evento = evento;
			}



			@Override
			public int hashCode() {
				return Objects.hash(idReserva);
			}



			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Reservas other = (Reservas) obj;
				return idReserva == other.idReserva;
			}



			@Override
			public String toString() {
				return "Reservas [idReserva=" + idReserva + ", precioVenta=" + precioVenta + ", observaciones="
						+ observaciones + ", cantidad=" + cantidad + ", usuario=" + usuario + ", eventos=" + evento
						+ "]";
			}
			
			
			
			
			
			
}
