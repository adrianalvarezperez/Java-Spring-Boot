package tienda.modelo.beans;

import java.io.Serializable;
import javax.persistence.*;

import tienda.dto.LineaCompraDTO;

import java.math.BigDecimal;
import java.util.Objects;




/**
 * The persistent class for the LINEAS_DE_COMPRA database table.
 * 
 */
@Entity
@Table(name="LINEAS_DE_COMPRA")
@NamedQuery(name="LineasDeCompra.findAll", query="SELECT l FROM LineasDeCompra l")
public class LineasDeCompra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_LINEAS_DE_COMPRA")
	private int idLineasDeCompra;

	private int cantidad;

	@Column(name="PRECIO_UNITARIO")
	private BigDecimal precioUnitario;

	//bi-directional many-to-one association to Compra
	@ManyToOne
	@JoinColumn(name="ID_COMPRA")
	private Compra compra;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="ID_PRODUCTO")
	private Producto producto;

	
	public LineasDeCompra() {
	}

	
	public LineasDeCompra(int idLineasDeCompra, int cantidad, BigDecimal precioUnitario, Compra compra,
			Producto producto) {
		super();
		this.idLineasDeCompra = idLineasDeCompra;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.compra = compra;
		this.producto = producto;
	}

	
	public int getIdLineasDeCompra() {
		return this.idLineasDeCompra;
	}
	public void setIdLineasDeCompra(int idLineasDeCompra) {
		this.idLineasDeCompra = idLineasDeCompra;
	}
	public int getCantidad() {
		return this.cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getPrecioUnitario() {
		return this.precioUnitario;
	}
	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public Compra getCompra() {
		return this.compra;
	}
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	public Producto getProducto() {
		return this.producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(idLineasDeCompra);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof LineasDeCompra))
			return false;
		LineasDeCompra other = (LineasDeCompra) obj;
		return idLineasDeCompra == other.idLineasDeCompra;
	}

	
	@Override
	public String toString() {
		return "LineasDeCompra [idLineasDeCompra=" + idLineasDeCompra + ", cantidad=" + cantidad + ", precioUnitario="
				+ precioUnitario + ", compra=" + compra + ", producto=" + producto + "]";
	}
	

	public static LineasDeCompra fromDTO(LineaCompraDTO dto, Compra compra) {
		Producto producto = Producto.fromDTO(dto.getProductoDTO());
		return new LineasDeCompra(0, dto.getCantidad(), dto.getPrecioVenta(), compra, producto);
	}
}
