package tienda.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import tienda.modelo.beans.LineasDeCompra;
import tienda.modelo.beans.Producto;

public class LineaCompraDTO implements Serializable{
	
	private static final long serialVersionUID= 1L;
	
	private ProductoDTO productoDTO;
	private int cantidad;
	private BigDecimal precioVenta;
	
	
	public LineaCompraDTO(ProductoDTO productoDTO, int cantidad, BigDecimal precioVenta) {
		super();
		this.productoDTO = productoDTO;
		this.cantidad = cantidad;
		this.precioVenta = precioVenta;
	}
	
	
	
	public ProductoDTO getProductoDTO() {
		return productoDTO;
	}
	public void setProductoDTO(ProductoDTO productoDTO) {
		this.productoDTO = productoDTO;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(BigDecimal precioVenta) {
		this.precioVenta = precioVenta;
	}
	public static LineaCompraDTO fromEntity(LineasDeCompra linea) {
		ProductoDTO producto = ProductoDTO.fromEntity(linea.getProducto());
		
		return new LineaCompraDTO(producto, linea.getCantidad(), linea.getPrecioUnitario());
	}
}
