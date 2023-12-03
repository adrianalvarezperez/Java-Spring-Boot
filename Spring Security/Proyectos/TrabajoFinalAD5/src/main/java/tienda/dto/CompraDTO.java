package tienda.dto;

import java.io.Serializable;
import java.math.BigDecimal;




public class CompraDTO implements Serializable{
	
	private static final long serialVersionUID= 1L;
	private int idUsuario;
	private Integer cantidadPedidos;
	private BigDecimal totalCompra;

	
	
	public CompraDTO(int idUsuario, Integer cantidadPedidos, BigDecimal totalCompra) {
		super();
		this.idUsuario = idUsuario;
		this.cantidadPedidos = cantidadPedidos;
		this.totalCompra = totalCompra;
	}

	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Integer getCantidadPedidos() {
		return cantidadPedidos;
	}
	public void setCantidadPedidos(Integer cantidadPedidos) {
		this.cantidadPedidos = cantidadPedidos;
	}
	public BigDecimal getTotalCompra() {
		return totalCompra;
	}
	public void setTotalCompra(BigDecimal totalCompra) {
		this.totalCompra = totalCompra;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
