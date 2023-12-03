package Fabrica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Fabrica.beans.Producto;
import Fabrica.dao.IntFabricaDao;






@RestController
@RequestMapping("rest/producto")
public class ProductoRestController {
	
	
	@Autowired
	private IntFabricaDao idao;
	@GetMapping("/todos")
	public List<Producto> todos(){
		
		
		return idao.buscarTodos();
	}

}
