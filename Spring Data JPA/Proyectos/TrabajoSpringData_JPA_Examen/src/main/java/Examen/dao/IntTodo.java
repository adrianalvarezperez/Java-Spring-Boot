package Examen.dao;

import java.util.List;

import Examen.entityBeans.Departamento;
import Examen.entityBeans.Empleado;
import Examen.entityBeans.Perfile;





public interface IntTodo {

	
	int altaIngre(Empleado empleado);
	

	Departamento buscarUno(int idDepart);
	Perfile buscarUnoo(int idPerfil);
	Empleado buscarUnooo(int idEmpl);
	

	void eliminar(int idEmpl);
	int deleteById(int idEmpl);
	
	
	List<Empleado> buscarEmpleadoPorDepart(int idDepart);


	List<Empleado> buscarTodosEmple();

	
}
