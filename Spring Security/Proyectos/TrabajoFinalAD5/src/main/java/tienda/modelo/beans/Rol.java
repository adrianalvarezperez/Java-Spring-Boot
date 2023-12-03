package tienda.modelo.beans;

import java.io.Serializable;
import javax.persistence.*;




/**
 * The persistent class for the perfiles database table.
 * 
 */
@Entity
@Table(name="roles")
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final int ROL_ADMINISTRADOR = 1;
	public static final int ROL_CLIENTE = 2;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ROL")
	private int idRol;
	private String nombre;

	
	public Rol() {
	}

	
	public int getIdRol() {
		return this.idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}