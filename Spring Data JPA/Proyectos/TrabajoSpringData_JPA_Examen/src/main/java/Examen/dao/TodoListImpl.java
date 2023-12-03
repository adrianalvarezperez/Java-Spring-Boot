package Examen.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Examen.entityBeans.Departamento;
import Examen.entityBeans.Empleado;
import Examen.entityBeans.Perfile;
import Examen.repository.IntDepartamento;
import Examen.repository.IntEmpleado;
import Examen.repository.IntPerfil;





@Repository
public class TodoListImpl implements IntTodo{


	@Autowired
	private IntEmpleado  iemp;
	@Autowired
	private IntDepartamento  idep;
	@Autowired
	private IntPerfil  iper;
	

//------------------------------------------------------------------------------------->
	
	
		@Override
		public int altaIngre(Empleado empleado) {
			try {
				iemp.save(empleado);							//SAVE ---> DA DE ALTA O MODIFICA 
				return 1;
			}catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		}
	

//------------------------------------------------------------------------------------->
		
	
		@Override
		public Departamento buscarUno(int idDepart) {
			return idep.findById(idDepart).orElse(null);		//BUSCA POR ID_DEPARTAMENTO
											
		}
		
		
//------------------------------------------------------------------------------------->
		
		
		@Override
		public Perfile buscarUnoo(int idPerfil) {
			return iper.findById(idPerfil).orElse(null);		//BUSCA POR ID_PERFIL
													
		}
		
		
//------------------------------------------------------------------------------------->
	
		
		@Override
		public Empleado buscarUnooo(int idEmpl) {
			return iemp.findById(idEmpl).orElse(null);			//BUSCA POR ID_EMPLEADO
													
		}
		
		
//------------------------------------------------------------------------------------->
		
		
		@Override
		public void eliminar(int idEmpl) {
			
			 iemp.deleteById(idEmpl);				//LO BORRA								
		}
		
		
		
		@Override
		public int deleteById(int idEmpl) {
			try {
				iemp.deleteById(idEmpl);			//LO BORRA OTRA OPCION
				return 1;
			}catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		}
		
		
//------------------------------------------------------------------------------------->

		
		//SACA LOS EMPLEADOS DE UN DEPARTAMENTO
		@Override
		public List<Empleado> buscarEmpleadoPorDepart(int idDepart){
			return iemp.empleadoByIdDepartamento(idDepart);
		}
		
		
//------------------------------------------------------------------------------------->
		
		
		//SACA TODOS LOS EMPLEADOS
		@Override
		public List<Empleado> buscarTodosEmple(){
			return iemp.findAll();
		}
			
}
