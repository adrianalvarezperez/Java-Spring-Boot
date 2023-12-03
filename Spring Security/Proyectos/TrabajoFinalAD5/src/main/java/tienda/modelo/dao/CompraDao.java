package tienda.modelo.dao;

import java.util.List;

import tienda.dto.LineaCompraDTO;
import tienda.modelo.beans.Compra;
import tienda.modelo.beans.Usuario;




public interface CompraDao {
	
	
	int altaCompra(Compra compra);
	int altaCarrito(Usuario usuario, List<LineaCompraDTO> elementosCarrito);
	Compra buscarCarrito(Usuario usuario);
	List<Compra> buscarComprasUsuario(Usuario usuario);
	List<Compra> buscarComprasDelDia();
}
