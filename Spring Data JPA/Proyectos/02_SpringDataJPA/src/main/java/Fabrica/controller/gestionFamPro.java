package Fabrica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Fabrica.dao.FamiliaProdDao;







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
		return "index";
	}
	
	@PostMapping("/porProducto")
	public String porProducto(Model model, @RequestParam(name="idProducto")int idProducto ) {
		model.addAttribute("fam4", ifaPro.buscarUnoo(idProducto));
		return "index";
	}
	

}
