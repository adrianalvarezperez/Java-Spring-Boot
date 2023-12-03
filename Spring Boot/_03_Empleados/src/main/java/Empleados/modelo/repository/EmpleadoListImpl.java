package Empleados.modelo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Empleados.modelo.beans.Empleado;





@Repository
public class EmpleadoListImpl implements IntEmpleado {

	
			private List<Empleado>  listilla;
			public static int nuevoCod;
			
			public EmpleadoListImpl() {
				listilla= new ArrayList<>();
				cargarDatos();
			}
			

//--------------------------------------------------------------------------------->	
			
			
			private void cargarDatos() {	//METODO PRIVADO
				
				listilla.add(new Empleado(114,"Rafael",110000,"activo"));
				listilla.add(new Empleado(115,"Koo",100000,"activo"));
				listilla.add(new Empleado(116,"Baida",10000,"activo"));
				listilla.add(new Empleado(117,"Colmenares",11000,"activo"));
				listilla.add(new Empleado(118,"Himuro",120000,"activo"));
				
				nuevoCod= 118;
			}


//--------------------------------------------------------------------------------->	

			
			//SETTER Y GETTER DE LISTILLA
			public List<Empleado> getListilla() {
				return listilla;
			}


			public void setListilla(List<Empleado> listilla) {
				this.listilla = listilla;
			}			
			
			
//--------------------------------------------------------------------------------->
			
			
			////MÉTODOS NOS DEVUELVE UN EVENTO A TRAVÉS DE SU ID
			@Override
			public Empleado buscarUno(int idEmpleado) {
				
				for(Empleado ele: listilla) {
					if(ele.getIdEmpleado() == idEmpleado) {
						return ele;
					}
				}
				return null;
			}


			//BUSCA TODOS LOS EVENTOS DE LA LISTA
			@Override
			public List<Empleado> buscarTodos() {
				return listilla;
			}


//--------------------------------------------------------------------------------->	

			//CREA UN NUEVO EVENTO
			@Override
			public int altaEmpleado(Empleado empleado) {
				if(!listilla.contains(empleado)) {			//SI LA LISTA "NO CONTIENE" AL EMPLEADO 
					empleado.setIdEmpleado(++nuevoCod);		//GENERA CODIGOS NUEVOS DESDE EL ULTIMO
					listilla.add(empleado);					//LO DA DE ALTA
					return 1;
				} else {
					return 0;
				}
				
			}



			//CANCELA UN EVENTO Y LO PONE A CANCELADO
			@Override
			public int cancelarEmpleado(int idEmpleado) {
		        Empleado empleado = buscarUno(idEmpleado);
		        if(empleado == null)
		            return 0;
		        empleado.setEstado("Cancelado");
		            return 1;

		    }


			//ELIMINA UN EVENTO DE LA LISTA Y LA DEVUELVE
			@Override
			public boolean eliminarEmpleado(Empleado empleado) {
					return listilla.remove(empleado);
			}
			
			
			//MUESTRA VALORES EVENTO
			@Override
			public int editarEmpleado(Empleado empleado) {
				int i = listilla.indexOf(empleado);
				if (i == -1)
					return 0;
				else
					return (listilla.set(i, empleado) != null)?1:0;
			}
			
			
}
