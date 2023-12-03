package Fabrica.restService;

import java.util.List;

import Fabrica.restDTO.ProductoDTO;







public interface ProductoService {

	
	ProductoDTO buscarUno(int idProducto);
	List<ProductoDTO> buscarTodos();
	List<ProductoDTO> buscarPorFamilia(int idFamilia);
	
}
