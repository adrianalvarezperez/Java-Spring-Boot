package Examen.entityBeans;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;


/**
 * The persistent class for the departamentos database table.
 * 
 */
@Entity
@Table(name="departamentos")
@NamedQuery(name="Departamento.findAll", query="SELECT d FROM Departamento d")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_depar")
	private int idDepar;

	private String direccion;

	private String nombre;

	//uni-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="jefe_depar")
	private Empleado empleado;

	public Departamento() {
	}
	


	public Departamento(int idDepar, String direccion, String nombre, Empleado empleado) {
		super();
		this.idDepar = idDepar;
		this.direccion = direccion;
		this.nombre = nombre;
		this.empleado = empleado;
	}


	public int getIdDepar() {
		return this.idDepar;
	}

	public void setIdDepar(int idDepar) {
		this.idDepar = idDepar;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(idDepar);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Departamento))
			return false;
		Departamento other = (Departamento) obj;
		return idDepar == other.idDepar;
	}



	@Override
	public String toString() {
		return "Departamento [idDepar=" + idDepar + ", direccion=" + direccion + ", nombre=" + nombre + ", empleado="
				+ empleado + "]";
	}
	

}