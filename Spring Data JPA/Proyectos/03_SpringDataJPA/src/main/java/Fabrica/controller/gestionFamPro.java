package Fabrica.controller;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Fabrica.dao.FamiliaProdDao;
import Fabrica.entityBeans.Familia;
import Fabrica.entityBeans.Producto;







@Controller
public class gestionFamPro {
	
	
	@Autowired
	private FamiliaProdDao ifaPro;
	
	
	@GetMapping("/inicio")
	public String familia(Model model) {
		model.addAttribute("fam", ifaPro.buscarTodos());
		model.addAttribute("fam2", ifaPro.buscarUno(1));
		return "index";
	}
	
	
	
	
	@PostMapping("/porFamilia")
	public String porFamilia(Model model, @RequestParam(name="idFamilia")int idFamilia ) {
		model.addAttribute("fam3", ifaPro.buscarPorFamilia(idFamilia));
		model.addAttribute("fam4", ifaPro.buscarUnoo(idFamilia));
		return "index";
	}
	
	
	@GetMapping("/alta")
	public String alta(Model model) {
		Producto prod= new Producto(0,"Camisita", new Date(), BigDecimal.valueOf(120), new Familia(1, "Chaqueta"));
		if(ifaPro.altaProducto(prod) == 1) {
			model.addAttribute("mensaje", "Producto creado correctamente");
		}else {
			model.addAttribute("mensaje", "Producto NO creado!!!");
		}
		return "index";
	}
	
}
