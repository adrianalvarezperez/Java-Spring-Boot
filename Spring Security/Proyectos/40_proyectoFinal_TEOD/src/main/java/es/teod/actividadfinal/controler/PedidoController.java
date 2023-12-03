package es.teod.actividadfinal.controler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.teod.actividadfinal.modelo.dtos.LineaPedidoDto;
import es.teod.actividadfinal.modelo.entity.Direccion;
import es.teod.actividadfinal.modelo.entity.Pedido;
import es.teod.actividadfinal.modelo.entity.ProductosEnPedido;

@Controller
@RequestMapping("/web/pedido")
public class PedidoController {
	
	@PostMapping("/altapedido")
	public String comprar(HttpSession sesion) {
		
		List<LineaPedidoDto> lista = (List<LineaPedidoDto>)sesion.getAttribute("cesta");
		Pedido p = new Pedido();
		p.setDireccione((Direccion)sesion.getAttribute("direccion"));
		p.setEstado("Terminado");
		p.setFechaRealizacion(new Date());
		p.setTarjeta(null);
		p.setTotalPedido(0);
		p.setUsuario(usuario);
		List<ProductosEnPedido> listaLP = new ArrayList<>();
		for (LineaPedidoDto ele: lista) {
			ProductosEnPedido pep = new ProductosEnPedido();
			pep.setCantidad(ele.getCantidad());
			pep.setPedido(p);
			pep.setProducto(productoRepo.findbyid(ele.getIdProducto()));
			pep.setPrecio(BigDecimal.valueOf(ele.getPrecioVenta()));
			
			listaLP.add(pep);
			
		}
		
		pedidoDao.altaPedido(p);
		
	}
	
	
	
	

}
