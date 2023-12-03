package Empresa.restEntity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;


/**
 * The persistent class for the clientes database table.
 * 
 */
@Entity
@Table(name="clientes")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cliente")
	private int idCliente;

	private String apellido1;

	private String apellido2;

	private int categoria;

	private String ciudad;

	private String nombre;

	public Cliente() {
	}

	public Cliente(int idCliente, String apellido1, String apellido2, int categoria, String ciudad, String nombre) {
		super();
		this.idCliente = idCliente;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.categoria = categoria;
		this.ciudad = ciudad;
		this.nombre = nombre;
	}

	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public int getCategoria() {
		return this.categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Cliente))
			return false;
		Cliente other = (Cliente) obj;
		return idCliente == other.idCliente;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", categoria=" + categoria + ", ciudad=" + ciudad + ", nombre=" + nombre + "]";
	}

}