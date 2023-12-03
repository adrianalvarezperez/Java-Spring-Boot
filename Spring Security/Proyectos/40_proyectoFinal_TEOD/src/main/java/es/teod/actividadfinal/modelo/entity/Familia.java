package es.teod.actividadfinal.modelo.entity;

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
	@Column(name="id_familias")
	private int idFamilias;

	private String nombre;

	public Familia() {
	}

	public int getIdFamilias() {
		return this.idFamilias;
	}

	public void setIdFamilias(int idFamilias) {
		this.idFamilias = idFamilias;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}