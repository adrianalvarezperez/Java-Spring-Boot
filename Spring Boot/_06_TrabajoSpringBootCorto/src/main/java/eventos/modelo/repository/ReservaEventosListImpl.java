package eventos.modelo.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import eventos.modelo.beans.Eventos;
import eventos.modelo.beans.Reservas;
import eventos.modelo.beans.Usuario;





@Repository
public class ReservaEventosListImpl implements IntReservaEventos {

	
	private List<Eventos> lista;
	private List<Usuario> lista2;
	private List<Reservas> lista3;
	public static int ultimoId;
	public static int nuevoCod;


	//------------------------------------------------------------------------------------------>

	
		public ReservaEventosListImpl() {
			lista=  new ArrayList<>();
			lista2= new ArrayList<Usuario>();
			lista3=  new ArrayList<>();
			cargarDatos();
			cargarDatos2();
		}

		private void cargarDatos() {			//MÉTODO PRIVADO CON LA LISTA DE INICIO CARGADA
			lista.add(new Eventos(1,"Boda","500 personas",35540,"activo",null,'s',new Date(), 100, 10, 15));
			lista.add(new Eventos(2,"Cumpleaños","10 personas", 120.57,"activo",null,'n',new Date(), 100, 120, 15));
			lista.add(new Eventos(3,"Concierto","50.000 personas", 3400334,"activo",null,'n',new Date(), 100, 120, 15));
			lista.add(new Eventos(4,"Despedida","50 personas",527.58,"activo",null,'n',new Date(), 100, 120, 15));
			lista.add(new Eventos(5,"Boda","100 personas",10298,"activo",null,'s',new Date(), 100, 120, 15));
			
			nuevoCod= 5;
		}
		
		
		private void cargarDatos2() {
			lista2.add(new Usuario(1, "pepe", "", "pepe@mail.com", "Pepe", "La treca", 1, new Date()));
			lista2.add(new Usuario(1, "juan", "", "juan@mail.com", "Juan", "La tuerca", 1, new Date()));
			
		}



	//------------------------------------------------------------------------------------------>


		//SETTER Y GETTER DE LISTA
		public List<Eventos> getLista() {
			return lista;
		}


		public void setLista(List<Eventos> lista) {
			this.lista = lista;
		}


	//------------------------------------------------------------------------------------------>


		//MÉTODOS QUE BUSCA UN EVENTO A TRAVÉS DE SU ID
		@Override
		public Eventos buscarUno(int idEvento) {			//DEVUELVE UNO

			for(Eventos ele: lista) {
				if(ele.getIdEvento() == idEvento) {
					return ele;
				}
			}
			return null;
		}

		
		//MÉTODO QUE BUSCA TODOS LOS EVENTOS DE LA LISTA
		@Override
		public List<Eventos> buscarTodos() {				//DEVUELVE TODOS
			return lista;
		}
		
		//MÉTODOS QUE BUSCA UNA RESERVA A TRAVÉS DE SU ID
		@Override
		public List<Reservas> findByEvento(int idReserva) {
			List<Reservas> reservaEvent = new ArrayList<>();
			for (Reservas rese: lista3) {
				if (rese.getEvento().getIdEvento() == idReserva) {
					reservaEvent.add(rese);
				}
			}
			return reservaEvent;
		}


	//------------------------------------------------------------------------------------------>
		
				
		//CREA UN NUEVO EVENTO
		@Override
		public int nuevoEvento(Eventos evento) {
			if(!lista.contains(evento)) {			//SI LA LISTA "NO CONTIENE" EL EVENTO
				evento.setIdEvento(++nuevoCod);		//GENERA CODIGOS NUEVOS DESDE EL ULTIMO
				lista.add(evento);					//LO DA DE ALTA
				return 1;
			} else {
				return 0;
			}

		}

		
	//------------------------------------------------------------------------------------------>
		
		
		//MUESTRA VALORES EVENTO
		@Override
		public int editarEvento(Eventos evento) {
			int pos= lista.indexOf(evento);
			if(pos == -1) {
				return 0;
			} else {
				return(lista.set(pos, evento) != null)? 1 : 0;
			}
		}

		
	//------------------------------------------------------------------------------------------>
		
		
		//PONE UN EVENTO AL ESTADO DE CANCELADO
		@Override
		public int cancelarEvento(int idEvento) {
	        Eventos evento = buscarUno(idEvento);
	        if(evento == null)
	            return 0;
	        evento.setEstado("Cancelado");
	            return 1;

	    }
		
		
		//PONE UN EVENTO DESTACADO AL ESTADO DE n
		@Override
		public int cancelarEventoDestacado(int idEvento) {
	        Eventos evento = buscarUno(idEvento);
	        if(evento == null)
	            return 0;
	        evento.setDestacado('n');
	            return 1;

	    }

		
	//------------------------------------------------------------------------------------------>
		
		
		//ELIMINA UN EVENTO AL COMPLETO DE LA LISTA
		@Override
		public boolean eliminarEvento(Eventos evento) {
			return lista.remove(evento);
		}


	//------------------------------------------------------------------------------------------>

		
		//BUSCA EN LA LISTA TODOS LOS EVENTOS ACTIVOS Y LOS MUESTRA
		public List<Eventos> buscarActivos() {
	        List<Eventos> activos = new ArrayList<>();

	        for (Eventos ele : lista) {
	            if(ele.getEstado().equals("activo")) {
	                activos.add(ele);
	            }
	        }
	        return activos;
	    }
		
		
		//BUSCA EN LA LISTA TODOS LOS EVENTOS CANCELADOS Y LOS MUESTRA
		public List<Eventos> buscarCancelados() {
	        List<Eventos> cancelados = new ArrayList<>();

	        for (Eventos ele : lista) {
	            if(ele.getEstado().equals("Cancelado")) {
	                cancelados.add(ele);
	            }
	        }
	        return cancelados;
	    }
		
		
	//------------------------------------------------------------------------------------------>
		
		
		//BUSCA EN LA LISTA TODOS LOS EVENTOS DESTACADOS Y LOS MUESTRA
				public List<Eventos> buscarDestacados() {
			        List<Eventos> activos = new ArrayList<>();

			        for (Eventos ele : lista) {
			            if(ele.getDestacado() == 's') {
			                activos.add(ele);
			            }
			        }
			        return activos;
			    }
				
				//BUSCA EN LA LISTA TODOS LOS EVENTOS NO DESTACADOS Y LOS MUESTRA
						public List<Eventos> buscarNoDestacados() {
					        List<Eventos> activos = new ArrayList<>();

					        for (Eventos ele : lista) {
					            if(ele.getDestacado() == 'n') {
					                activos.add(ele);
					            }
					        }
					        return activos;
					    }
				
						
	//------------------------------------------------------------------------------------------>				
				
			//MÉTODO QUE COMPRUEBA USUARIO Y PASSWORD INTRODUCIDOS SIN IGUALES AL DE LA LISTA
			@Override
			public Usuario findByUsernameAndPassword(String username, String password) {
				for (Usuario usu: lista2) {
						if (usu.getUsername().equals(username) && usu.getPassword().equals(password)) {
								return usu;
						}
				}
								return null;
			}
		
			
//------------------------------------------------------------------------------------------>			
			
			//MÉTODO PARA CREAR UNA RESERVA
			@Override
			public int nuevaReserva(Reservas reserva) {
				ultimoId = ultimoId + 1;
				reserva.setIdReserva(ultimoId);
				lista3.add(reserva);
				return 1;
			}

			public static void setUltimoId(int ultimoId) {
				ReservaEventosListImpl.ultimoId = ultimoId;
			}

			
			//MÉTODO PARA CALCULAR EL AFORO RESTANTE 
			public int calcularAforoRestante(Eventos evento) {
				List<Reservas> reservas = this.findByEvento(evento.getIdEvento());
				int reservasTotales = 0;
				for (Reservas reserva: reservas) {
					reservasTotales += reserva.getCantidad();
				}

				return evento.getAforoMaximo() - reservasTotales;
			}
						
						
}

		

