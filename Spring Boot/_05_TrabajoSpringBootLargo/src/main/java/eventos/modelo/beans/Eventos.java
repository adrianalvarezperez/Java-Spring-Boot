package eventos.modelo.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Eventos implements Serializable{
	
	
				//PROPIEDADES
				private static final long serialVersionUID= 1L;
				private int idEvento;
				private String nombre;
				private String descripcion;
				private double precio;
				private String estado;
				private Tipo tipo;
				private char destacado;
				private Date fechaIngreso;
				private Date fechaInicio;
				private int duracion;
				private int aforoMaximo;
				private int minimoAsistencia;
				
				
//------------------------------------------------------------------------------------------>

				
				//CONSTRUCTOR CON PARAMETROS
				public Eventos(int idEvento, String nombre, String descripcion, double precio, String estado, Tipo tipo, char destacado, Date fechaInicio,int duracion, int aforoMaximo, int minimoAsistencia) {
					super();
					this.idEvento = idEvento;
					this.nombre = nombre;
					this.descripcion = descripcion;
					this.precio = precio;
					this.estado= estado;
					this.tipo= tipo;
					this.destacado= destacado;
					this.fechaInicio= fechaInicio;
					this.duracion = duracion;
					this.aforoMaximo = aforoMaximo;
					this.minimoAsistencia = minimoAsistencia;
				}

				


				//CONSTRUCTOR VACIO
				public Eventos() {
					super();
				}

				
//------------------------------------------------------------------------------------------>
				
				
				//SETTER --> CAMBIAN VALORES O IMPRIMEN DENTRO
				//GETTER --> RETORNAN VALORES O IMPRIMEN FUERA
				public int getIdEvento() {
					return idEvento;
				}


				public void setIdEvento(int idEvento) {
					this.idEvento = idEvento;
				}


				public String getNombre() {
					return nombre;
				}


				public void setNombre(String nombre) {
					this.nombre = nombre;
				}


				public String getDescripcion() {
					return descripcion;
				}


				public void setDescripcion(String descripcion) {
					this.descripcion = descripcion;
				}


				public double getPrecio() {
					return precio;
				}


				public void setPrecio(double precio) {
					this.precio = precio;
				}		
				
				
				public String getEstado() {
					return estado;
				}


				public void setEstado(String estado) {
					this.estado = estado;
				}

				public Tipo getTipo() {
					return tipo;
				}


				public void setTipo(Tipo tipo) {
					this.tipo = tipo;
				}	
				
				public char getDestacado() {
					return destacado;
				}


				public void setDestacado(char destacado) {
					this.destacado = destacado;
				}
				
				
				public Date getFechaInicio() {
					return fechaInicio;
				}
				
				
				public void setFechaInicio(Date fechaInicio) {
					this.fechaInicio= fechaInicio;
				}
				
				
				public Date getFechaIngreso() {
					return fechaIngreso;
				}


				public void setFechaIngreso(Date fechaIngreso) {
					this.fechaIngreso = fechaIngreso;
				}
				
				public int getDuracion() {
					return duracion;
				}

				public void setDuracion(int duracion) {
					this.duracion = duracion;
				}

				public int getAforoMaximo() {
					return aforoMaximo;
				}

				public void setAforoMaximo(int aforoMaximo) {
					this.aforoMaximo = aforoMaximo;
				}

				public int getMinimoAsistencia() {
					return minimoAsistencia;
				}

				public void setMinimoAsistencia(int minimoAsistencia) {
					this.minimoAsistencia = minimoAsistencia;
				}
				
				public String mostrarPrecioUnitario() {
					double precioUnitario = this.calcularPrecioUnitario();
					return String.format("%.2f", precioUnitario);
				}
				
				public double calcularPrecioUnitario() {
					return this.precio / this.aforoMaximo;
				}
				
				
//------------------------------------------------------------------------------------------>
		 

				//MÉTODO HASHCODE --> DEVUELVE UN NUMERO CON EL HASCODE
				@Override
				public int hashCode() {
					return Objects.hash(idEvento);
				}

				
				//MÉTODO EQUAL --> COMPARA SI SON IGUALES
				@Override
				public boolean equals(Object obj) {
					if (this == obj)
						return true;
					if (!(obj instanceof Eventos))
						return false;
					Eventos other = (Eventos) obj;
					return idEvento == other.idEvento;
				}

				
//------------------------------------------------------------------------------------------>
				
				
				//MÉTODO TO_STRING --> IMPRIME DATOS
				@Override
				public String toString() {
					return "Eventos [idEvento=" + idEvento + ", nombre=" + nombre + ", descripcion=" + descripcion
							+ ", precio=" + precio + ", estado=" + estado + ", tipo=" + tipo + ", destacado="
							+ destacado + ", fechaIngreso=" + fechaIngreso + ", fechaInicio=" + fechaInicio
							+ ", duracion=" + duracion + ", aforoMaximo=" + aforoMaximo + ", minimoAsistencia="
							+ minimoAsistencia + "]";
				}
							
				
		
	
				
}
