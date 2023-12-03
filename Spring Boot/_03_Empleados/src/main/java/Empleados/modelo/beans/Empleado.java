package Empleados.modelo.beans;

import java.io.Serializable;
import java.util.Objects;

public class Empleado implements Serializable{
	
	
	
			//PROPIEDADES
			private static final long serialVersionUID = 1L;
			private int idEmpleado;
			private String nombre;
			private double salario;
			private String estado;
			private Departamento departamento;
			
			
//--------------------------------------------------------------------------------->	
			
			
			//CONSTRUCTOR CON PARAMETROS
			public Empleado(int idEmpleado, String nombre, double salario, String estado) {
				super();
				this.idEmpleado = idEmpleado;
				this.nombre = nombre;
				this.salario = salario;
				this.estado = estado;
			}


			//CONTRUCTOR VACIO
			public Empleado() {
				super();
			}

			
//--------------------------------------------------------------------------------->	
			
			
			//SETTER --> CAMBIAN VALORES O IMPRIMEN DENTRO
			//GETTER --> RETORNAN VALORES O IMPRIMEN FUERA
			public int getIdEmpleado() {
				return idEmpleado;
			}


			public void setIdEmpleado(int idEmpleado) {
				this.idEmpleado = idEmpleado;
			}


			public String getNombre() {
				return nombre;
			}


			public void setNombre(String nombre) {
				this.nombre = nombre;
			}


			public double getSalario() {
				return salario;
			}


			public void setSalario(double salario) {
				this.salario = salario;
			}


			public String getEstado() {
				return estado;
			}


			public void setEstado(String estado) {
				this.estado = estado;
			}
			
			
			public Departamento getDepartamento() {
				return departamento;
			}


			public void setDepartamento(Departamento departamento) {
				this.departamento = departamento;
			}
			
			
//--------------------------------------------------------------------------------->			


			//HASCODE --> NUMERO
			@Override
			public int hashCode() {
				return Objects.hash(idEmpleado);
			}

			
			//EQUAL --> COMPARA SI SON IGUALES
			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (!(obj instanceof Empleado))
					return false;
				Empleado other = (Empleado) obj;
				return idEmpleado == other.idEmpleado;
			}

			
//--------------------------------------------------------------------------------->		
			
			
			//TOSTRING --> IMPRIME DATOS
			@Override
			public String toString() {
				return "Empleado [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", salario=" + salario
						+ ", estado=" + estado + ", departamento=" + departamento + "]";
			}

			
	
}
