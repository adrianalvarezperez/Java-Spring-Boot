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

import Cajero.dao.CuentaMovimientoDao;
import Cajero.entityBeans.Cuenta;
import Cajero.entityBeans.Movimiento;




@Controller
@RequestMapping("/cuenta")
public class gestionCuentaMovimiento {

	
	
	@Autowired
	private CuentaMovimientoDao icm;
	
	
//------------------------------------------------------------------------------------->
	
	
	//ACCEDEMOS AL JSP
	@GetMapping("/entrar")
	public String sesion() {
		return "iniciarSesion";
	}
	
	
	//VIENE DEL FORMULARIO CON DATOS
	@PostMapping("/abrir")
	public String abrir(HttpSession sesion, @RequestParam("idCuenta")int idCuenta, Model model) {
		Cuenta cuenta= icm.buscarPorCuenta(idCuenta); 	//GUARDA EN LA VARIABLE LA BUSQUEDA QUE HACE A LA BASE DE DATOS CON ID_CUENTA PASADO POR PARAMETROS
		if(cuenta != null) { 	//SI EL ID_CUENTA ES DISTINTO A NULL NOS LOGUEA
			model.addAttribute("mensaje", "Cuenta logueado");
			sesion.setAttribute("cuentaSesion", cuenta);	//ABRE LA SESION
			sesion.setAttribute("movimientosSesion", icm.buscarMovimientoPorCuenta(idCuenta)); //SACA LOS MOVIMIENTOS DEL ID_CUENTA DE LA SESION
			return "index";
		}
		model.addAttribute("mensaje", "Numero de cuenta incorrecto");
		return "iniciarSesion";
	}
	
	
	//CIERRA LA SESION
	@GetMapping("/cerrar")
	public String cerrar(HttpSession sesion, RedirectAttributes redi) {
		if(sesion.getAttribute("cuentaSesion") != null)		//SI LA SESION ES DISTINTO A NULL LA ENTRA
			redi.addFlashAttribute("mensaje", "Sesion cerrada");
			sesion.removeAttribute("cuentaSesion");			//CIERRA LA SESION
			sesion.removeAttribute("movimientosSesion");	//CIERRA LOS MOVIMIENTOS
			return "redirect:/inicio";
	}
	
	
//------------------------------------------------------------------------------------->	
	
	
	//ACCESO AL JSP
	@GetMapping("/ingreso")
	public String ingreso() {
		return "ingresar";
	}
	
	
	//VIENE DEL FORMULARIO CON DATOS
	@PostMapping("/realizarIngreso")
	public String realizarIngreso(Model model, HttpSession sesion, @RequestParam(name= "cantidad", defaultValue= "0") int cantidadIngreso) {
			Cuenta cuenta= (Cuenta) sesion.getAttribute("cuentaSesion");	//MIRA QUE HAYA ALGUNA CUENTA EN SESION
			if(cuenta == null) {		//SI LA CUENTA ES IGUAL A NULL
				model.addAttribute("mensaje", "Cuenta no introducida");
				return "iniciarSesion";
			}
			
			Cuenta cuenta1= icm.buscarPorCuenta(cuenta.getIdCuenta());	//GUARDAMOS EN LA VARIABLE AL CUENTA DE LA SESION
			double suma= cuenta1.getSaldo() + cantidadIngreso;			//GUARDAMOS EN LA VARIABLE LA CANTIDAD TOTAL DESPUES DEL INGRESO
	
	
			//PINTAMOS EN LA BASE DE DATOS
			Movimiento movimiento= new Movimiento(0, cantidadIngreso, new Date(), "Ingreso", cuenta1);
			cuenta1.setSaldo(suma);
			
			
			if(icm.alta(movimiento, cuenta1) == 1) {	//DA DE ALTA EL MOVIMIENTO Y EL INGRESO
				model.addAttribute("mensaje", "Ingreso realizado");
				sesion.setAttribute("cuentaSesion", cuenta1);	//ACTUALIZAR EL SALDO DE LA CUENTA EN SESION
				sesion.setAttribute("movimientosSesion", icm.buscarMovimientoPorCuenta(cuenta.getIdCuenta())); 		//ACTUALIZA EL MOVIMIENTO DE LA CUENTA EN SESION
				return "redirect:/inicio";
			} else {
				model.addAttribute("mensaje", "Ingreso no realizado");
				return "redirect:/inicio";
			}	
			
	}
	
	
//------------------------------------------------------------------------------------->
	
	
	//ACCESO AL JSP
	@GetMapping("/extraccion")
	public String extraer() {
		return "extraer";
	}
	
	
	//TRAE DATOS DEL FORMULARIO
	@PostMapping("/realizarExtraccion")
	public String realizarExtracion(Model model, HttpSession sesion, @RequestParam(name="cantidad", defaultValue="0") int cantidadExtraer) {
		Cuenta cuenta= (Cuenta) sesion.getAttribute("cuentaSesion");	//MIRA QUE HAYA ALGUNA CUENTA EN SESION
		if(cuenta == null) {	//SI CUENTA ES IGUAL A NULL
			model.addAttribute("mensaje", "Cuenta no introducida");
			return "iniciarSesion";
		}
		
		
		
		Cuenta cuenta1= icm.buscarPorCuenta(cuenta.getIdCuenta());	//GUARDAMOS EN LA VARIABLE AL CUENTA DE LA SESION
		double resta= cuenta1.getSaldo() - cantidadExtraer;			//GUARDAMOS EN AL VARIABLE EL TOTAL DESPUES DE LA EXTRACCION
		
		
		//PINTAMOS EN LA BASE DE DATOS
		Movimiento movimiento= new Movimiento(0, cantidadExtraer, new Date(), "Ingreso", cuenta1);
		cuenta1.setSaldo(resta);
		
		
		
		if(icm.alta(movimiento, cuenta1) == 1) {	//DA DE ALTA EL MOVIMIENTO Y LA EXTRACCION
			model.addAttribute("mensaje", "Extraccion realizada");
			sesion.setAttribute("cuentaSesion", cuenta1);	//ACTUALIZA EL SALDO DE LA CUENTA EN SESION
			sesion.setAttribute("movimientosSesion", icm.buscarMovimientoPorCuenta(cuenta.getIdCuenta()));	//ACTUALIZA LOS MOVIMIENTOS DE LA CUENTA EN SESION
			return "redirect:/inicio";
		}
			model.addAttribute("mensaje", "Extraccion no realizada");
			return "redirect:/inicio";
	}
	
	
//------------------------------------------------------------------------------------->
	
	
	//ACCESO AL JSP
	@GetMapping("/transferencia")
	public String transferencia() {
		return "transferencia";
	}
	
	
	//TRAE DATOS DEL FORMULARIO
	@PostMapping("/transferencia2")
	public String transferencia2(HttpSession sesion, @RequestParam(name="cantidad", defaultValue="0") double cantidadSacar, @RequestParam(name="idCuenta") int cuentaDestino, Model model) {
		
		Cuenta cuenta= (Cuenta) sesion.getAttribute("cuentaSesion");	//GUARDA EN CUENTA LA SESION SI HAY ALGUNA CUENTA
		if(cuenta == null) {	//SI CUENTA ES IGUAL A NULL
			model.addAttribute("mensaje", "Cuenta no introducida");
			return "redirect:/cuenta/iniciarSesion";
		}
		
		
		
		Cuenta cuenta1= icm.buscarPorCuenta(cuenta.getIdCuenta());	//GUARDA EN LA VARIABLE EL ID_CUENTA DE LA SESION
		Cuenta cuenta2= icm.buscarPorCuenta(cuentaDestino);			//GUARDA EN LA VARIABLE LA CUENTA DE DESTINO
		
		
		
		if(cuenta2 == null) {	//SI CUENTA ES IGUAL A NULL
			model.addAttribute("mensaje", "Cuenta de destino NO EXISTE!!!");
			return "redirect:/cuenta/transferencia";
		}
		
		
		
		if(cuenta1.getIdCuenta() == cuenta2.getIdCuenta()) {	//SI CUENTA SESION ES IGUAL A CUENTA DESTINO
			model.addAttribute("mensaje", "Esta es su numero de cuenta, introduzca otra cuenta");
			return "redirect:/cuenta/transferencia";
		}
		
		
			
		double resta= cuenta1.getSaldo() - cantidadSacar;		//LE RESTA A CUENTA1 EL TOTAL MENOS LA CANTIDAD A SACAR
		double suma= cuenta2.getSaldo() + cantidadSacar;		//LE SUMA A CUENTA2 EL TOTAL MAS LA CANTIDAD A METER
		
		
		
		if(resta < 0) {		//SI LA RESTA ES MENOS QUE 0
			model.addAttribute("mensaje", "No se puede realizar la operacion. SALDO INSUFICIENTE!!!");
			return "redirect:/cuenta/transferencia";
		}
		
		
		
		//PINTA EN LA BASE DE DATOS DE LA CUENTA1
		Movimiento movimiento1= new Movimiento(0, cantidadSacar, new Date(), "Extraccion", cuenta1);
		cuenta1.setSaldo(resta);
		
		
		
		//PINTA EN LA BASE DE DATOS DE LA CUENTA2
		Movimiento movimiento2= new Movimiento(0, cantidadSacar, new Date(), "Ingreso", cuenta2);
		cuenta2.setSaldo(suma);
		
		
		
		//DA DE ALTA EL MOVIMIENTO EN LA CUENTA 1 Y DA DE ALTA EL MOVIMIENTO EN LA CUENTA2
		if(icm.alta(movimiento1, cuenta1) == 1 && icm.alta(movimiento2, cuenta2) == 1) {
			model.addAttribute("mensaje", "Transferencia realizada");
			sesion.setAttribute("movimientosSesion", icm.buscarMovimientoPorCuenta(cuenta.getIdCuenta()));		//ACTUALIZA LOS MOVIMIENTOS DE LA CUENTA EN SESION
			sesion.setAttribute("cuentaSesion", cuenta1);	//ACTUALIZA EL SALDO DE LA CUENTA EN SESION
			return "redirect:/inicio";
		} else {
			model.addAttribute("mensaje", "Transferencia no realizada");
			return "redirect:/cuenta/transferencia";
		}
	}
	
	
}
