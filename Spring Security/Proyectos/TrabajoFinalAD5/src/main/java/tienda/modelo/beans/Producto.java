package tienda.modelo.beans;

import java.io.Serializable;
import javax.persistence.*;

import tienda.dto.ProductoDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;




/**
 * The persistent class for the PRODUCTOS database table.
 * 
 */
@Entity
@Table(name="PRODUCTOS")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PRODUCTO")
	private int idProducto;

	private String descripcion;

	private String nombre;

	private BigDecimal precio;

	private int stock;

	//bi-directional many-to-one association to LineasDeCompra
	@OneToMany(mappedBy="producto")
	private List<LineasDeCompra> lineasDeCompras;

	
	public Producto() {
	}

	
	public Producto(int idProducto, String descripcion, String nombre, BigDecimal precio, int stock,
			List<LineasDeCompra> lineasDeCompras) {
		super();
		this.idProducto = idProducto;
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.lineasDeCompras = lineasDeCompras;
	}

	
	public Producto(int idProducto, String descripcion, String nombre, BigDecimal precio, int stock) {
		super();
		this.idProducto = idProducto;
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}
	

	public int getIdProducto() {
		return this.idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getDescripcion() {
		return this.descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public BigDecimal getPrecio() {
		return this.precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public int getStock() {
		return this.stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public List<LineasDeCompra> getLineasDeCompras() {
		return this.lineasDeCompras;
	}
	public void setLineasDeCompras(List<LineasDeCompra> lineasDeCompras) {
		this.lineasDeCompras = lineasDeCompras;
	}
	public LineasDeCompra addLineasDeCompra(LineasDeCompra lineasDeCompra) {
		getLineasDeCompras().add(lineasDeCompra);
		lineasDeCompra.setProducto(this);

		return lineasDeCompra;
	}
	public LineasDeCompra removeLineasDeCompra(LineasDeCompra lineasDeCompra) {
		getLineasDeCompras().remove(lineasDeCompra);
		lineasDeCompra.setProducto(null);

		return lineasDeCompra;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(idProducto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Producto))
			return false;
		Producto other = (Producto) obj;
		return idProducto == other.idProducto;
	}

	
	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", descripcion=" + descripcion + ", nombre=" + nombre
				+ ", precio=" + precio + ", stock=" + stock + ", lineasDeCompras=" + lineasDeCompras + "]";
	}

	public static Producto fromDTO(ProductoDTO dto) {
		return new Producto(dto.getIdProducto(), dto.getDescripcion(), dto.getNombre(), dto.getPrecio(), dto.getStock());
	}
}