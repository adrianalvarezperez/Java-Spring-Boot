package tienda.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import tienda.modelo.beans.LineasDeCompra;
import tienda.modelo.beans.Producto;

public class ProductoDTO implements Serializable{
	
	private static final long serialVersionUID= 1L;
	private int idProducto;
	private String descripcion;
	private String nombre;
	private BigDecimal precio;
	private int stock;

	
	public ProductoDTO(int idProducto, String descripcion, String nombre, BigDecimal precio, int stock) {
		super();
		this.idProducto = idProducto;
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}

	
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public static ProductoDTO fromEntity(Producto producto) {
		return new ProductoDTO(producto.getIdProducto(), producto.getDescripcion(), producto.getNombre(), producto.getPrecio(), producto.getStock());
	}
}
