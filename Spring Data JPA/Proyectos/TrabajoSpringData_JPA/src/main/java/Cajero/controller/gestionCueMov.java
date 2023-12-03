package Cajero.controller;


import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Cajero.dao.CueMovDao;
import Cajero.entityBeans.Cuenta;
import Cajero.entityBeans.Movimiento;








@Controller
@RequestMapping("/cuenta")
public class gestionCueMov {
	
	
	@Autowired
	private CueMovDao icu;
	
	
//------------------------------------------------------------------------------------->	
					
	
					//ACCEDEMOS A LOS JSP

	@GetMapping("/numeroCuenta")
	public String altaCuenta() {
		return "numCuenta";
	}
	
	@GetMapping("/ingresarCantidad")
	public String ingresarCantidad() {
		return "ingresar";
	}
	
	@GetMapping("/extraerCantidad")
	public String extraerCantidad() {
		return "extraer";
	}
	
	@GetMapping("/transferenciaDestino")
	public String transferenciadestino() {
		return "transferencia";
	}
	
	
	@GetMapping("/movimientos")
	public String movimientos(Model model, HttpSession sesi) {
		Cuenta cue = (Cuenta) sesi.getAttribute("cuentaSesion");						//GUARDAMOS LA SESION EN LA VARIABLE
		model.addAttribute("saldoTotal", icu.buscarPorCuenta(cue.getIdCuenta()));		//SACAMOS EL SALDO DEL ID CUENTA DE LA SESION
		model.addAttribute("mov", icu.buscarMoviPorCuenta(cue.getIdCuenta()));			//SACAMOS LOS MOVIMIENTOS DEL IDCUENTA DE LA SESION
		return "verMovimientos";
	}	
	
	
//------------------------------------------------------------------------------------->
	
							//USUARIO LOGUEADO METIENDO IDCUENTA
	
	
	//NOS LOGUEAMOS Y NOS LLEGAN LOS PARAMETROS POR REQUESPARAM INTRODUCIDOS EN EL JSP NUMCUENTA
	@PostMapping("/cuent")
	public String cuent(HttpSession sesi, @RequestParam("idCuenta") int idCuenta, RedirectAttributes redi, Model model) {
		Cuenta cue = icu.buscarPorCuenta(idCuenta); //GUARDA EN LA VARIABLE LA BUSQUEDA QUE HACE A LA BASE DE DATOS CON ID_CUENTA PASADO POR PARAMETROS
		if (cue != null) {
			redi.addFlashAttribute("mensaje", "Usuario logeado");
			sesi.setAttribute("cuentaSesion", cue);
			return "redirect:/inicio";
		}
		redi.addFlashAttribute("mensaje", "Numero de cuenta incorrecto");
		return "redirect:/cuenta/numeroCuenta";
	}
	
	
	
	//SALE DE LA SESION
	@GetMapping ("/cerrarSesion")
	public String cerrar(HttpSession sesi) {
		if (sesi.getAttribute("cuentaSesion") != null) {
			sesi.removeAttribute("cuentaSesion");
		}
			return "redirect:/cuenta/numeroCuenta";
	}
	
	
//------------------------------------------------------------------------------------->
	
	
	//INGRESAMOS DINERO
	@PostMapping("/ingreso")
	public String ingreso(Model model, HttpSession sesi, @RequestParam(name="cantidad", defaultValue = "0") int cantidadIngreso, RedirectAttributes redi) {
		
		Cuenta cue = (Cuenta) sesi.getAttribute("cuentaSesion");
		if (cue == null) {
			redi.addFlashAttribute("mensaje", "Cuenta no introducida");
		return "redirect:/cuenta/numeroCuenta";
		}
		
		
		
		Cuenta cue1= icu.buscarPorCuenta(cue.getIdCuenta());		//GUARDAMOS EN LA VARIABLE LA CUENTA DE LA SESION
		
		double suma= cue1.getSaldo() + cantidadIngreso;				//GUARDAMOS EN LA VARIABLE EL ACTUAL CANTIDAD A INGRESAR
		
		
		//PINTAMOS DATOS EN BASE DE DATOS
		Movimiento movi= new Movimiento(0, cantidadIngreso, new Date(), "Ingreso", cue1);
		cue1.setSaldo(suma);
		
		if(icu.altaIngre(movi, cue1) == 1) {		//ESTABLECE UNA CONDICION AL METODO Y SI ES 1 HACE EL INGRESO Y SI ES 0 NO LO HACE
			model.addAttribute("mensaje","Ingreso realizado");
			return "index";
		} else {
			model.addAttribute("mensaje", "Ingreso no realizado");
			return "/cuenta/ingresarCantidad";
		}
	}
	
	
//------------------------------------------------------------------------------------->
	
	
	@PostMapping("/extraccion")
	public String extraccion(Model model, HttpSession sesi, @RequestParam(name="cantidad", defaultValue = "0") int cantidadSacar, RedirectAttributes redi) {
		
		Cuenta cue = (Cuenta) sesi.getAttribute("cuentaSesion");
		if (cue == null) {
			redi.addFlashAttribute("mensaje", "Cuenta no introducida");
		return "redirect:/cuenta/numeroCuenta";
		}
		
		
		Cuenta cue1= icu.buscarPorCuenta(cue.getIdCuenta());		//GUARDAMOS EN LA VARIABLE LA CUENTA DE LA SESION
		
		double resta= cue1.getSaldo() - cantidadSacar;				//GUARDAMOS EN LA VARIABLE EL ACTUAL CANTIDAD A RETIRAR
		
		if(resta < 0) {
			redi.addFlashAttribute("mensaje", "No se puede realizar la operacion. SALDO INSUFICIENTE!!!");		//SI LA CANTIDAD A RETIRAR ES MENOR DE CERO, NO DEJA RETIRAR DINERO
			return "redirect:/cuenta/extraerCantidad";
		} else {
		
			
			
		//PINTAMOS DATOS EN LASE DE DATOS
		Movimiento movi= new Movimiento(0, cantidadSacar, new Date(), "Extraccion", cue1);
		cue1.setSaldo(resta);
		
		if(icu.altaIngre(movi, cue1) == 1) {							//ESTABLECE UNA CONDICION AL METODO Y SI ES 1 HACE EL INGRESO Y SI ES 0 NO LO HACE
			model.addAttribute("mensaje","Extraccion realizado");
			return "index";
		} else {
			model.addAttribute("mensaje", "Extraccion no realizado");
			return "/cuenta/extraerCantidad";
		}
		}
	}
	

//------------------------------------------------------------------------------------->
	
	
	//TRANSFERENCIA
	@PostMapping("/cantidadDestino")
	public String cantidadDestino(Model model, HttpSession sesi, @RequestParam(name="cantidad", defaultValue = "0") double cantidadSacar, @RequestParam(name="idCuenta") int cuentaDestino, RedirectAttributes redi) {
		
		//GUARDAMOS LA SESION
		Cuenta cue = (Cuenta) sesi.getAttribute("cuentaSesion");
		if (cue == null) {	//SI NO HAY SESION
			redi.addFlashAttribute("mensaje", "Cuenta no introducida");
		return "redirect:/cuenta/numeroCuenta";
		}
		
		
		
		Cuenta cue1= icu.buscarPorCuenta(cue.getIdCuenta());		//GUARDAMOS EN LA VARIABLE EL ID DE LA CUENTA DE SESION
		Cuenta cue2= icu.buscarPorCuenta(cuentaDestino);			//GUARDAMOS EN LA VARIABLE EL ID DE LA CUENTA DE DESTINO
		
		
		
		if(cue2 == null) {											//COMPRUEBA SI AL CUENTA DE DESTINO EXISTE
			redi.addFlashAttribute("mensaje", "Cuenta de destino NO EXISTE!!!");
			return "redirect:/cuenta/transferenciaDestino";
		}
		if (cue1.getIdCuenta() == cue2.getIdCuenta()) {				//SI LA CUENTA DESDE DONDE VAS A REALIZAR LA TRANSFERENCIA ES AL MISMA, NO SE PUEDE REALIZAR LA TRANFERENCIA
			redi.addFlashAttribute("mensaje", "Esta es su cuenta. Introduzca otra cuenta");
			return "redirect:/cuenta/transferenciaDestino";
		}
		
		
		double resta= cue1.getSaldo() - cantidadSacar;		//GUARDO EN LA VARIABLE LA CANTIDAD QUE SE QUEDA EN LA CUENTA ORIGEN
		double suma= cue2.getSaldo() + cantidadSacar;		//GUARDO EN LA VARIABLE LA CANTIDAD QUE SE QUEDA EN LA CUENTA DESTINO
		
		if(resta < 0) {										//SI CANTIDAD A TRANSFERIR DA MENOR DE CERO, ON SE REALIZA LA TRANSFERENCIA
			redi.addFlashAttribute("mensaje", "No se puede realizar la operacion. SALDO INSUFICIENTE!!!");
			return "redirect:/cuenta/transferenciaDestino";
		}
		
			
		//PINTAMOS DATOS EN LASE DE DATOS
		Movimiento mov1= new Movimiento(0, cantidadSacar, new Date(), "Extraccion", cue1);
		cue1.setSaldo(resta);
		
		Movimiento mov2 = new Movimiento(0, cantidadSacar, new Date(), "Ingreso", cue2);
		cue2.setSaldo(suma);
		
		
			//ESTABLECE UNA CONDICION AL METODO Y SI ES 1 HACE EL INGRESO Y SI ES 0 NO LO HACE
			if(icu.altaIngre(mov1, cue1)  == 1 && icu.altaIngre(mov2, cue2) == 1) {
				model.addAttribute("mensaje","Transferencia realizada");
				return "index";
			} else {
				model.addAttribute("mensaje", "Transferencia no realizada");
				return "/cuenta/transferenciaDestino";
			}
		}
		
}
