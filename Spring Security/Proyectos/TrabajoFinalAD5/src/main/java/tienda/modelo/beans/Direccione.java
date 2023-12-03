package tienda.modelo.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;




/**
 * The persistent class for the DIRECCIONES database table.
 * 
 */
@Entity
@Table(name="DIRECCIONES")
@NamedQuery(name="Direccione.findAll", query="SELECT d FROM Direccione d")
public class Direccione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_DIRECCION")
	private int idDireccion;

	private String calle;

	@Column(name="CODIGO_POSTAL")
	private BigDecimal codigoPostal;

	private String letra;

	private String localidad;

	private int numero;

	private String piso;

	//bi-directional many-to-one association to Compra
	@OneToMany(mappedBy="direccione")
	private List<Compra> compras;

	//bi-directional many-to-many association to Usuario
	@ManyToMany(mappedBy="direcciones")
	private List<Usuario> usuarios;

	
	public Direccione() {
	}

	
	public Direccione(int idDireccion, String calle, BigDecimal codigoPostal, String letra, String localidad,
			int numero, String piso, List<Compra> compras, List<Usuario> usuarios) {
		super();
		this.idDireccion = idDireccion;
		this.calle = calle;
		this.codigoPostal = codigoPostal;
		this.letra = letra;
		this.localidad = localidad;
		this.numero = numero;
		this.piso = piso;
		this.compras = compras;
		this.usuarios = usuarios;
	}
	
	
	public Direccione(int idDireccion, String calle, BigDecimal codigoPostal, String letra, String localidad,
			int numero, String piso) {
		super();
		this.idDireccion = idDireccion;
		this.calle = calle;
		this.codigoPostal = codigoPostal;
		this.letra = letra;
		this.localidad = localidad;
		this.numero = numero;
		this.piso = piso;
	}

	public int getIdDireccion() {
		return this.idDireccion;
	}
	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}
	public String getCalle() {
		return this.calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public BigDecimal getCodigoPostal() {
		return this.codigoPostal;
	}
	public void setCodigoPostal(BigDecimal codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getLetra() {
		return this.letra;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
	public String getLocalidad() {
		return this.localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public int getNumero() {
		return this.numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getPiso() {
		return this.piso;
	}
	public void setPiso(String piso) {
		this.piso = piso;
	}
	public List<Compra> getCompras() {
		return this.compras;
	}
	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}
	public Compra addCompra(Compra compra) {
		getCompras().add(compra);
		compra.setDireccione(this);

		return compra;
	}
	public Compra removeCompra(Compra compra) {
		getCompras().remove(compra);
		compra.setDireccione(null);

		return compra;
	}
	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(idDireccion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Direccione))
			return false;
		Direccione other = (Direccione) obj;
		return idDireccion == other.idDireccion;
	}

	
	@Override
	public String toString() {
		return "Direccione [idDireccion=" + idDireccion + ", calle=" + calle + ", codigoPostal=" + codigoPostal
				+ ", letra=" + letra + ", localidad=" + localidad + ", numero=" + numero + ", piso=" + piso
				+ ", compras=" + compras + ", usuarios=" + usuarios + "]";
	}

}
