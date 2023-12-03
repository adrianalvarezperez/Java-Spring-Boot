package tienda.modelo.beans;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_USUARIO")
	private int idUsuario;
	private String username;
	private String nombre;
	private String apellidos;
	private String email;
	private int enabled;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_NACIMIENTO")
	private Date fechaNacimiento;

	//bi-directional many-to-one association to Compra
	@OneToMany(mappedBy="usuario")
	private List<Compra> compras;
	
	private String password;

	//uni-directional many-to-many association to Roles
	@ManyToMany
	@JoinTable(
		name="roles_usuarios"
		, joinColumns={
			@JoinColumn(name="ID_USUARIO")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_ROL")
			}
		)
	private List<Rol> roles;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="USUARIO_DIRECCION"
		, joinColumns={
			@JoinColumn(name="ID_USUARIO")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_DIRECCION")
			}
		)
	private List<Direccione> direcciones;
	
	@ManyToMany
	@JoinTable(
		name="USUARIO_TARJETA"
		, joinColumns={
			@JoinColumn(name="ID_USUARIO")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_TARJETA")
			}
		)
	
	private List<TarjetasBancaria> tarjetasBancarias;

	
	public Usuario() {
	}

	
	public Usuario(int idUsuario, String username, String nombre, String apellidos, String email, int enabled,
			Date fechaNacimiento, String password) {
		super();
		this.idUsuario = idUsuario;
		this.username = username;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.enabled = enabled;
		this.fechaNacimiento = fechaNacimiento;
		this.password = password;
	}


	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getApellidos() {
		return this.apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getEnabled() {
		return this.enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	public List<Compra> getCompras() {
		return compras;
	}
	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}
	public List<Direccione> getDirecciones() {
		return direcciones;
	}
	public void setDirecciones(List<Direccione> direcciones) {
		this.direcciones = direcciones;
	}
	public List<TarjetasBancaria> getTarjetasBancarias() {
		return tarjetasBancarias;
	}
	public void setTarjetasBancarias(List<TarjetasBancaria> tarjetasBancarias) {
		this.tarjetasBancarias = tarjetasBancarias;
	}
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Rol> getPerfiles() {
		return this.roles;
	}
	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
	public void addRol(Rol rol) {
		if (roles == null)
			roles = new ArrayList<>();
		roles.add(rol);
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public List<Rol> getRoles() {
		return roles;
	}
}