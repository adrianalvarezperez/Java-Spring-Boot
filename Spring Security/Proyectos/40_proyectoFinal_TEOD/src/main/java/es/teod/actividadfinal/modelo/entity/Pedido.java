package es.teod.actividadfinal.modelo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pedidos database table.
 * 
 */
@Entity
@Table(name="pedidos")
@NamedQuery(name="Pedido.findAll", query="SELECT p FROM Pedido p")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pedido")
	private int idPedido;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_realizacion")
	private Date fechaRealizacion;

	@Column(name="total_pedido")
	private BigDecimal totalPedido;

	//uni-directional many-to-one association to Direccion
	@ManyToOne
	@JoinColumn(name="id_direccion")
	private Direccion direccione;

	//uni-directional many-to-one association to Tarjeta
	@ManyToOne
	@JoinColumn(name="id_tarjeta")
	private Tarjeta tarjeta;

	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	//bi-directional many-to-one association to ProductosEnPedido
	@OneToMany(mappedBy="pedido", cascade={CascadeType.PERSIST})
	private List<ProductosEnPedido> productosEnPedidos;

	public Pedido() {
	}

	public int getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaRealizacion() {
		return this.fechaRealizacion;
	}

	public void setFechaRealizacion(Date fechaRealizacion) {
		this.fechaRealizacion = fechaRealizacion;
	}

	public BigDecimal getTotalPedido() {
		return this.totalPedido;
	}

	public void setTotalPedido(BigDecimal totalPedido) {
		this.totalPedido = totalPedido;
	}

	public Direccion getDireccione() {
		return this.direccione;
	}

	public void setDireccione(Direccion direccione) {
		this.direccione = direccione;
	}

	public Tarjeta getTarjeta() {
		return this.tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<ProductosEnPedido> getProductosEnPedidos() {
		return this.productosEnPedidos;
	}

	public void setProductosEnPedidos(List<ProductosEnPedido> productosEnPedidos) {
		this.productosEnPedidos = productosEnPedidos;
	}

	public void addProductosEnPedido(ProductosEnPedido productosEnPedido) {
		if (productosEnPedidos == null)
			productosEnPedidos = new ArrayList<>();
		productosEnPedidos.add(productosEnPedido);
		productosEnPedido.setPedido(this);

		
	}

	public void removeProductosEnPedido(ProductosEnPedido productosEnPedido) {
		if (productosEnPedidos == null)
			productosEnPedidos = new ArrayList<>();
		productosEnPedidos.remove(productosEnPedido);
		productosEnPedido.setPedido(null);

	
	}

}