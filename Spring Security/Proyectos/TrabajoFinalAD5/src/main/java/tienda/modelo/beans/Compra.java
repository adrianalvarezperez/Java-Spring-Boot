package tienda.modelo.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.lang.Nullable;
import tienda.modelo.beans.Compra;





@Entity
@Table(name="COMPRAS")
@NamedQuery(name="Compra.findAll", query="SELECT c FROM Compra c")
public class Compra implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static String ESTADO_CARRITO = "CARRITO";
	public static String ESTADO_COMPRA = "COMPRADO";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_COMPRA")
	private int idCompra;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_DE_REALIZACION")
	private Date fechaDeRealizacion;

	//bi-directional many-to-one association to Direccione
	@ManyToOne(optional=true)
	@JoinColumn(name="ID_DIRECCION")
	@Nullable
	private Direccione direccione;

	//bi-directional many-to-one association to TarjetasBancaria
	@ManyToOne(optional=true)
	@JoinColumn(name="ID_TARJETA")
	private TarjetasBancaria tarjetasBancaria;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	//bi-directional many-to-one association to LineasDeCompra
	@OneToMany(mappedBy="compra")
	private List<LineasDeCompra> lineasDeCompras;

	
	public Compra() {
	}

	public Compra(int idCompra, String estado, Date fechaDeRealizacion, Direccione direccione,
			TarjetasBancaria tarjetasBancaria, Usuario usuario, List<LineasDeCompra> lineasDeCompras) {
		super();
		this.idCompra = idCompra;
		this.estado = estado;
		this.fechaDeRealizacion = fechaDeRealizacion;
		this.direccione = direccione;
		this.tarjetasBancaria = tarjetasBancaria;
		this.usuario = usuario;
		this.lineasDeCompras = lineasDeCompras;
	}
	

	public Compra(int idCompra, String estado, Date fechaDeRealizacion, Usuario usuario) {
		super();
		this.idCompra = idCompra;
		this.estado = estado;
		this.fechaDeRealizacion = fechaDeRealizacion;
		this.usuario = usuario;
		this.lineasDeCompras = new ArrayList();
	}

	
	public int getIdCompra() {
		return this.idCompra;
	}
	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}
	public String getEstado() {
		return this.estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFechaDeRealizacion() {
		return this.fechaDeRealizacion;
	}
	public void setFechaDeRealizacion(Date fechaDeRealizacion) {
		this.fechaDeRealizacion = fechaDeRealizacion;
	}
	public Direccione getDireccione() {
		return this.direccione;
	}
	public void setDireccione(Direccione direccione) {
		this.direccione = direccione;
	}
	public TarjetasBancaria getTarjetasBancaria() {
		return this.tarjetasBancaria;
	}
	public void setTarjetasBancaria(TarjetasBancaria tarjetasBancaria) {
		this.tarjetasBancaria = tarjetasBancaria;
	}
	public Usuario getUsuario() {
		return this.usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<LineasDeCompra> getLineasDeCompras() {
		return this.lineasDeCompras;
	}
	public void setLineasDeCompras(List<LineasDeCompra> lineasDeCompras) {
		this.lineasDeCompras = lineasDeCompras;
	}
	public LineasDeCompra addLineasDeCompra(LineasDeCompra lineasDeCompra) {
		getLineasDeCompras().add(lineasDeCompra);
		lineasDeCompra.setCompra(this);

		return lineasDeCompra;
	}
	public LineasDeCompra removeLineasDeCompra(LineasDeCompra lineasDeCompra) {
		getLineasDeCompras().remove(lineasDeCompra);
		lineasDeCompra.setCompra(null);

		return lineasDeCompra;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(idCompra);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Compra))
			return false;
		Compra other = (Compra) obj;
		return idCompra == other.idCompra;
	}

	
	@Override
	public String toString() {
		return "Compra [idCompra=" + idCompra + ", estado=" + estado + ", fechaDeRealizacion=" + fechaDeRealizacion
				+ ", direccione=" + direccione + ", tarjetasBancaria=" + tarjetasBancaria + ", usuario=" + usuario
				+ ", lineasDeCompras=" + lineasDeCompras + "]";
	}
}
