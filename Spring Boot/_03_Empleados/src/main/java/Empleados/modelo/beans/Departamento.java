package Empleados.modelo.beans;

import java.io.Serializable;
import java.util.Objects;

public class Departamento implements Serializable{

	private static final long serialVersionUID = 1L;
	private int idDepart;
	private String nombre;
	
	
	
	
	
	public Departamento(int idDepart, String nombre) {
		super();
		this.idDepart = idDepart;
		this.nombre = nombre;
	}


	public Departamento() {
		super();
	}

	
	
	

	public int getIdDepart() {
		return idDepart;
	}


	public void setIdDepart(int idDepart) {
		this.idDepart = idDepart;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	
	
	@Override
	public int hashCode() {
		return Objects.hash(idDepart);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Departamento))
			return false;
		Departamento other = (Departamento) obj;
		return idDepart == other.idDepart;
	}


	
	
	@Override
	public String toString() {
		return "Departamento [idDepart=" + idDepart + ", nombre=" + nombre + "]";
	}
	
	
	



	
	
	
	
	
	
}
