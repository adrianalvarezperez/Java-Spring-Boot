package tienda.modelo.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;


/**
 * The persistent class for the TARJETAS_BANCARIAS database table.
 * 
 */
@Entity
@Table(name="TARJETAS_BANCARIAS")
@NamedQuery(name="TarjetasBancaria.findAll", query="SELECT t FROM TarjetasBancaria t")
public class TarjetasBancaria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_TARJETA")
	private int idTarjeta;

	private BigDecimal cvv;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_CADUCIDAD")
	private Date fechaCaducidad;

	@Column(name="NOMBRE_TITULAR")
	private String nombreTitular;

	@Column(name="NUMERO_TARJETA")
	private BigDecimal numeroTarjeta;

	//bi-directional many-to-one association to Compra
	@OneToMany(mappedBy="tarjetasBancaria")
	private List<Compra> compras;

	//bi-directional many-to-many association to Usuario
	@ManyToMany(mappedBy="tarjetasBancarias")
	private List<Usuario> usuarios;

	
	public TarjetasBancaria() {
	}

	
	public TarjetasBancaria(int idTarjeta, BigDecimal cvv, Date fechaCaducidad, String nombreTitular,
			BigDecimal numeroTarjeta, List<Compra> compras, List<Usuario> usuarios) {
		super();
		this.idTarjeta = idTarjeta;
		this.cvv = cvv;
		this.fechaCaducidad = fechaCaducidad;
		this.nombreTitular = nombreTitular;
		this.numeroTarjeta = numeroTarjeta;
		this.compras = compras;
		this.usuarios = usuarios;
	}
	
	
	public TarjetasBancaria(int idTarjeta, BigDecimal cvv, Date fechaCaducidad, String nombreTitular,
			BigDecimal numeroTarjeta) {
		super();
		this.idTarjeta = idTarjeta;
		this.cvv = cvv;
		this.fechaCaducidad = fechaCaducidad;
		this.nombreTitular = nombreTitular;
		this.numeroTarjeta = numeroTarjeta;
	}

	
	public int getIdTarjeta() {
		return this.idTarjeta;
	}
	public void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}
	public BigDecimal getCvv() {
		return this.cvv;
	}
	public void setCvv(BigDecimal cvv) {
		this.cvv = cvv;
	}
	public Date getFechaCaducidad() {
		return this.fechaCaducidad;
	}
	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	public String getNombreTitular() {
		return this.nombreTitular;
	}
	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}
	public BigDecimal getNumeroTarjeta() {
		return this.numeroTarjeta;
	}
	public void setNumeroTarjeta(BigDecimal numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	public List<Compra> getCompras() {
		return this.compras;
	}
	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}
	public Compra addCompra(Compra compra) {
		getCompras().add(compra);
		compra.setTarjetasBancaria(this);

		return compra;
	}
	public Compra removeCompra(Compra compra) {
		getCompras().remove(compra);
		compra.setTarjetasBancaria(null);

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
		return Objects.hash(idTarjeta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof TarjetasBancaria))
			return false;
		TarjetasBancaria other = (TarjetasBancaria) obj;
		return idTarjeta == other.idTarjeta;
	}

	
	@Override
	public String toString() {
		return "TarjetasBancaria [idTarjeta=" + idTarjeta + ", cvv=" + cvv + ", fechaCaducidad=" + fechaCaducidad
				+ ", nombreTitular=" + nombreTitular + ", numeroTarjeta=" + numeroTarjeta + ", compras=" + compras
				+ ", usuarios=" + usuarios + "]";
	}

}