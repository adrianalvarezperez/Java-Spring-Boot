package Fabrica.restService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Fabrica.restDTO.ProductoDTO;
import Fabrica.restEntityBeans.Producto;
import Fabrica.restRepository.ProductosRepository;





 @Service
public class ProductoListImpl implements ProductoService{

	
	@Autowired
	private ProductosRepository iprod;
	
	
	@Override
	public ProductoDTO buscarUno(int idProducto) {
		Producto producto= iprod.findById(idProducto).orElse(null);
		if(producto == null) {
			return null;
		}
		
		ProductoDTO pdto= new ProductoDTO();
		pdto.setIdProducto(producto.getIdProducto());
		pdto.setDescripcion(producto.getDescripcion());
		pdto.setFamilia(producto.getFamilia().getDescripcion());
		pdto.setPrecioUnitario(producto.getPrecioUnitario());
		return pdto;
	}

	
	@Override
	public List<ProductoDTO> buscarTodos() {
		return null;
	}

	
	@Override
	public List<ProductoDTO> buscarPorFamilia(int idFamilia) {
		
		return null;
	}

}
