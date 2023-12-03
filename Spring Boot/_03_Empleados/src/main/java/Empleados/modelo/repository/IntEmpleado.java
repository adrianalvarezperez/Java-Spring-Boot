package Empleados.modelo.repository;

import java.util.List;

import Empleados.modelo.beans.Empleado;


public interface IntEmpleado {

				
	
				//MÉTODOS
				Empleado buscarUno(int idEmpleado);
				List<Empleado> buscarTodos();
				
				int altaEmpleado(Empleado empleado);
				boolean eliminarEmpleado(Empleado empleado);
				int editarEmpleado(Empleado empleado);
				int cancelarEmpleado(int idEmpleado);
				
				
}
