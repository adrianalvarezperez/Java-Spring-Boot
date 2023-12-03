package Fabrica.beans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the familias database table.
 * 
 */
@Entity
@Table(name="familias")
@NamedQuery(name="Familia.findAll", query="SELECT f FROM Familia f")
public class Familia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigo;

	private String descripcion;

	public Familia() {
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}