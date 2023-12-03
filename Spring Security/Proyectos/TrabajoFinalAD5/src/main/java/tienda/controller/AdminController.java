package tienda.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tienda.modelo.dao.ClienteDao;
import tienda.modelo.dao.CompraDao;
import tienda.modelo.dao.RolDao;
import tienda.modelo.dao.UsuarioDao;
import tienda.modelo.beans.Compra;
import tienda.modelo.beans.Rol;
import tienda.modelo.beans.Usuario;




@Controller
@RequestMapping("/admin")
public class AdminController {
	
	
	@Autowired
	private CompraDao iCompra;
	@Autowired
	private RolDao irole;
	@Autowired
	private ClienteDao iClienteDao;
	@Autowired
	private UsuarioDao udao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
//------------------------------------------------------------------------------------------------------------------------------------------------->
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}
	
	
//------------------------------------------------------------------------------------------------------------------------------------------------->		
	
	
	@GetMapping("/compras")
	public String compras(Model model) {
		List<Compra> compras = iCompra.buscarComprasDelDia();
		model.addAttribute("compras", compras);
		return "adminCompras";
	}
	
	
//------------------------------------------------------------------------------------------------------------------------------------------------->
	
	
	@GetMapping("/clientes")
	public String usuariosConCompras(Model model, HttpSession sesion) {
		List<Usuario> clientes = iClienteDao.buscarUsuariosConCompras();
		model.addAttribute("clientes", clientes);
		return "adminClientes";
	}
	
	
//------------------------------------------------------------------------------------------------------------------------------------------------->
	
	
	@GetMapping("/altaAdmin")
	public String altaAdmin() {
		return "altaAdmin";
	}
	
	
	@PostMapping("/altaAdmin")
	public String altaAdmin(Model model, RedirectAttributes ratt,
			@RequestParam(name="nombre")String nombre, @RequestParam(name="apellido")String apellido,
			@RequestParam(name="fechaNacimiento")Date fechaNacimiento, @RequestParam(name="email")String email, 
			@RequestParam(name="password")String password){
		
		
		Usuario usuario = new Usuario(0, email, nombre, apellido, email, 1, fechaNacimiento, passwordEncoder.encode(password));
		usuario.setEnabled(1);
		usuario.setFechaNacimiento(new Date());
	 	usuario.addRol(irole.findById(Rol.ROL_ADMINISTRADOR));
	 	usuario.setUsername(usuario.getEmail());
	 	if (udao.registro(usuario)) {
	 		ratt.addAttribute("mensaje", "Administrador registrado");
	 	} else {
	 		model.addAttribute("mensaje", "El Administrador ya existe");
	 	}
	 	return "altaAdmin";
	}
	
}

