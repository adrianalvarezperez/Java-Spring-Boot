package tienda.modelo.beans;

public class LocalidadCount implements ILocalidadCount {
	
	
	private String localidad;
	private int cantidad;
	
	
	public LocalidadCount(String localidad, int cantidad) {
		super();
		this.localidad = localidad;
		this.cantidad = cantidad;
	}
	

	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
