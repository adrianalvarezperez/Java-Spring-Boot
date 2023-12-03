package eventos.modelo.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Usuario implements Serializable{

		//PROPIEDADES
		private static final long serialVersionUID= 1L;
		private int idUsuario;
		private String username;
		private String password;
		private String email;
		private String nombre;
		private String direccion;
		private int disponible;
		private Date fechaRegistro;
		
		
		
		public Usuario(int idUsuario, String username, String password, String email, String nombre, String direccion,
				int disponible, Date fechaRegistro) {
			super();
			this.idUsuario = idUsuario;
			this.username = username;
			this.password = password;
			this.email = email;
			this.nombre = nombre;
			this.direccion = direccion;
			this.disponible = disponible;
			this.fechaRegistro = fechaRegistro;
		}



		public Usuario() {
			super();
		}



		public int getIdUsuario() {
			return idUsuario;
		}



		public void setIdUsuario(int idUsuario) {
			this.idUsuario = idUsuario;
		}



		public String getUsername() {
			return username;
		}



		public void setUsername(String username) {
			this.username = username;
		}



		public String getPassword() {
			return password;
		}



		public void setPassword(String password) {
			this.password = password;
		}



		public String getEmail() {
			return email;
		}



		public void setEmail(String email) {
			this.email = email;
		}



		public String getNombre() {
			return nombre;
		}



		public void setNombre(String nombre) {
			this.nombre = nombre;
		}



		public String getDireccion() {
			return direccion;
		}



		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}



		public int getDisponible() {
			return disponible;
		}



		public void setDisponible(int disponible) {
			this.disponible = disponible;
		}



		public Date getFechaRegistro() {
			return fechaRegistro;
		}



		public void setFechaRegistro(Date fechaRegistro) {
			this.fechaRegistro = fechaRegistro;
		}



		@Override
		public int hashCode() {
			return Objects.hash(idUsuario);
		}



		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Usuario other = (Usuario) obj;
			return idUsuario == other.idUsuario;
		}



		@Override
		public String toString() {
			return "Clientes [idUsuario=" + idUsuario + ", username=" + username + ", password=" + password + ", email="
					+ email + ", nombre=" + nombre + ", direccion=" + direccion + ", disponible=" + disponible
					+ ", fechaRegistro=" + fechaRegistro + "]";
		}
		
	
//------------------------------------------------------------------------------------------>
	
	
}
