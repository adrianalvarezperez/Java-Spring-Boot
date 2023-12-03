package es.teod.actividadfinal.modelo.dao;

import java.util.Date;
import java.util.List;

import es.teod.actividadfinal.modelo.entity.Direccion;
import es.teod.actividadfinal.modelo.entity.Pedido;
import es.teod.actividadfinal.modelo.entity.Tarjeta;

public interface PedidoDao {
	
	int altaPedido(Pedido pedido);
	Pedido buscarUno(int idPedido);
	List<Pedido> buscarPorDia(Date fecha);
	int salvarCarrito();
	
	
	
	

}
