package Empresa.restDTO;

import java.io.Serializable;
import java.util.Objects;

public class PedidoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int idPedido;
	private int cliente;
	private ComercialDTO comercial;
	
	
	public PedidoDTO() {
		super();
	}


	public PedidoDTO(int idPedido, ComercialDTO comercial, int cliente) {
		super();
		this.idPedido = idPedido;
		this.comercial = comercial;
		this.cliente = cliente;
	}


	public int getIdPedido() {
		return idPedido;
	}


	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}


	public ComercialDTO getComerciale() {
		return comercial;
	}


	public void setComerciale(ComercialDTO comercial) {
		this.comercial = comercial;
	}


	public int getCliente() {
		return cliente;
	}


	public void setCliente(int cliente) {
		this.cliente = cliente;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cliente);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof PedidoDTO))
			return false;
		PedidoDTO other = (PedidoDTO) obj;
		return Objects.equals(cliente, other.cliente);
	}


	@Override
	public String toString() {
		return "ComercialesDTO [idPedido=" + idPedido + ", comerciale=" + comercial + ", cliente=" + cliente + "]";
	}


	
}
