package Fabrica.restDTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class ProductoDTO implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private int idProducto;
	private String descripcion;
	private String familia;
	private BigDecimal precioUnitario;
	
	
	
	public ProductoDTO() {
		super();
	}



	public ProductoDTO(int idProducto, String descripcion, String familia, BigDecimal precioUnitario) {
		super();
		this.idProducto = idProducto;
		this.descripcion = descripcion;
		this.familia = familia;
		this.precioUnitario = precioUnitario;
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



	public String getFamilia() {
		return familia;
	}



	public void setFamilia(String familia) {
		this.familia = familia;
	}



	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}



	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}



	@Override
	public int hashCode() {
		return Objects.hash(idProducto);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ProductoDTO))
			return false;
		ProductoDTO other = (ProductoDTO) obj;
		return idProducto == other.idProducto;
	}



	@Override
	public String toString() {
		return "ProductoDTO [idProducto=" + idProducto + ", descripcion=" + descripcion + ", familia="
				+ familia + ", precioUnitario=" + precioUnitario + "]";
	}
	
	
	 
	
	
}
