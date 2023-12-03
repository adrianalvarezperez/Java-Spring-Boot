package Examen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Examen.entityBeans.Empleado;






public interface IntEmpleado extends JpaRepository<Empleado, Integer>{
		
	
		//SELECT LOS EMPLEADOS DE UN ID_DEPART
		@Query("select p from Empleado p where p.departamento.idDepar= ?1")
		public List<Empleado> empleadoByIdDepartamento(int idDepar);
	
	
}
