package tienda.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import tienda.modelo.dao.ProductoDaoImpl;
import tienda.modelo.beans.*;




@Controller
@RequestMapping("/producto")
public class ProductoController {

	
	@Autowired
	private ProductoDaoImpl iproducto;

	
//---------------------------------------------------------------------------------------------------------------------------------------------------->

	
	@GetMapping("/catalogoProductos")
	public String catalogoProductos(Model model, @RequestParam(name="busqueda", defaultValue="", required=false)String nombreProducto) {
		List<Producto> listaProductos; 
		if (nombreProducto.isEmpty()) {
			listaProductos = iproducto.buscarProductos();
		} else {
			listaProductos = iproducto.buscarProductosPorNombre(nombreProducto);
		}
		model.addAttribute("listaProducto", listaProductos);
		return "catalogoProductos";
	}
	
	
//---------------------------------------------------------------------------------------------------------------------------------------------------->
	
	
	@GetMapping("/producto")
	public String producto(Model model) {
		model.addAttribute("listaProducto", iproducto.buscarProductos()); 		//SACA TODOS LOS PRODUCTOS
		return "indexProducto";
	}
	
	
//------------------------------------------------------------------------------------------------------------------------------------------------->
	
	
	@GetMapping("/{id}")
	public String verProductoCliente(Model model,@PathVariable("id")int idProducto) {
		model.addAttribute("producto", iproducto.buscarUno(idProducto));
		return "fichaProducto";
	}
	
	
//---------------------------------------------------------------------------------------------------------------------------------------------------->
	
	
	@GetMapping("/altaProducto")
	public String altaProducto() {
		return "altaProducto";
	}
	
	
	
	@PostMapping("/altaProducto")
	public String altaProducto(Model model, @RequestParam(name="nombreProducto")String nombreProducto, @RequestParam(name="descripcion")String descripcion,
			@RequestParam(name="precio")BigDecimal precio, @RequestParam(name="stock")int stock) {
		
			Producto producto= new Producto(0, descripcion, nombreProducto, precio, stock);
			
			if(iproducto.altaProducto(producto) == 1){
				model.addAttribute("mensaje", "Producto dado de alta con exito");
				model.addAttribute("listaProducto", iproducto.buscarProductos()); 		//SACA TODOS LOS PRODUCTOS
				return "indexProducto";
			}
			model.addAttribute("mensaje", "Producto no dado de alta");
			return "altaProducto";
	}
	
	
	
//---------------------------------------------------------------------------------------------------------------------------------------------------->
	
	
	@GetMapping("/modificarProducto/{id}")
	public String modificarProducto(@PathVariable("id")int idProducto, HttpSession sesion) {
			Producto producto= iproducto.buscarUno(idProducto);
			sesion.setAttribute("sesionIdProducto", producto);
			return "modificarProducto";
	}
	
	
	@PostMapping("/modificarProducto")
	public String modificarProducto(Model model, @RequestParam(name="idProducto")int idProducto, @RequestParam(name="nombreProducto")String nombreProducto, 
			@RequestParam(name="descripcion")String descripcion, @RequestParam(name="precio")BigDecimal precio, @RequestParam(name="stock")int stock) {
		
			Producto producto= iproducto.buscarUno(idProducto);
			producto.setNombre(nombreProducto);
			producto.setDescripcion(descripcion);
			producto.setPrecio(precio);
			producto.setStock(stock);
			
			if(iproducto.modificarProducto(producto) == 1) {
				model.addAttribute("mensaje", "Producto modificado correctamente");
				model.addAttribute("listaProducto", iproducto.buscarProductos()); 		//SACA TODOS LOS PRODUCTOS
				return "indexProducto";
			}
			model.addAttribute("mensaje", "Producto NOOOO modicado");
			return "indexProducto";
	}
	
	
//---------------------------------------------------------------------------------------------------------------------------------------------------->
	
	
	@GetMapping("/eliminarProducto/{id}")
	public String eliminarProducto(Model model, @PathVariable("id")int idProducto) {
		if(iproducto.eliminarProducto(idProducto) == 1) {
			model.addAttribute("mensaje", "Producto eliminado correctamente");
			return "redirect:/producto/producto";
		}
		model.addAttribute("mensaje", "Producto NOOO eliminado");
		return "indexProducto";
	}
}
