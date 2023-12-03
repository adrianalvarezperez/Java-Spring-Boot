package Empresa.restDTO;

import java.util.Objects;

public class ComercialDTO {

	private int idComercial;
	private String apellido1;
	private String apellido2;
	private double comision;
	private String nombre;

	
	public ComercialDTO(int idComercial, String apellido1, String apellido2, double comision, String nombre) {
		super();
		this.idComercial = idComercial;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.comision = comision;
		this.nombre = nombre;
	}

	public ComercialDTO() {
		super();
	}

	public int getIdComercial() {
		return idComercial;
	}

	public void setIdComercial(int idComercial) {
		this.idComercial = idComercial;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public double getComision() {
		return comision;
	}

	public void setComision(double comision) {
		this.comision = comision;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idComercial);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ComercialDTO))
			return false;
		ComercialDTO other = (ComercialDTO) obj;
		return idComercial == other.idComercial;
	}

	@Override
	public String toString() {
		return "ComercialesDTO [idComercial=" + idComercial + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", comision=" + comision + ", nombre=" + nombre + "]";
	}
	
	
	
}
