package tienda.modelo.dao;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tienda.dto.LineaCompraDTO;
import tienda.modelo.beans.Compra;
import tienda.modelo.beans.LineasDeCompra;
import tienda.modelo.beans.Usuario;
import tienda.modelo.repository.ComprasRepository;
import tienda.modelo.repository.LineasCompraRepository;




@Repository
public class CompraListImpl implements CompraDao {	
	
	
	@Autowired
	private ComprasRepository icompras;
	@Autowired
	private LineasCompraRepository iLineascompra;
	
	
//------------------------------------------------------------------------------------------------------------------------------------------------->
	
	
	@Override
	public int altaCompra(Compra compra) {
		try {
			icompras.save(compra);	//DA DE ALTA O MODIFICA 
			return 1;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	
//------------------------------------------------------------------------------------------------------------------------------------------------->
	
	
	@Override
	public int altaCarrito(Usuario usuario, List<LineaCompraDTO> elementosCarritoDTO) {
		Compra carritoAntiguo = icompras.findCarritoByUsuario(usuario.getIdUsuario());
		
		if (carritoAntiguo != null) {
			for (LineasDeCompra lineasAntiguas :carritoAntiguo.getLineasDeCompras()) {
				iLineascompra.delete(lineasAntiguas);
			}

			icompras.delete(carritoAntiguo);			
		}
		
		Compra carritoNuevo = new Compra(0, Compra.ESTADO_CARRITO, new Date(), usuario);
		Compra carrito = icompras.save(carritoNuevo);
		for (LineaCompraDTO elementoCarrito : elementosCarritoDTO) {
			LineasDeCompra lineaCompra = LineasDeCompra.fromDTO(elementoCarrito, carrito);
			iLineascompra.save(lineaCompra);
			carrito.addLineasDeCompra(lineaCompra);
		}

		try {
			icompras.save(carrito);
			return 1;
		} catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	
//------------------------------------------------------------------------------------------------------------------------------------------------->
	
	
	@Override
	public Compra buscarCarrito(Usuario usuario) {
		return icompras.findCarritoByUsuario(usuario.getIdUsuario());
	}

	
//------------------------------------------------------------------------------------------------------------------------------------------------->
	
	
	@Override
	public List<Compra> buscarComprasUsuario(Usuario usuario) {
		return icompras.findComprasByUsuario(usuario.getIdUsuario());
	}
	
	
//------------------------------------------------------------------------------------------------------------------------------------------------->
	
	
	@Override
	public List<Compra> buscarComprasDelDia() {
		return icompras.findComprasFromSameDay();
	}
}
