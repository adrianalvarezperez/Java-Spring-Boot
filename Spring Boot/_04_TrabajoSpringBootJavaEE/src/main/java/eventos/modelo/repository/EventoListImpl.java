package eventos.modelo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import eventos.modelo.beans.Eventos;






@Repository
public class EventoListImpl implements IntEvento {



	
	private List<Eventos> lista;
	public static int nuevoCod;


//------------------------------------------------------------------------------------------>

	public EventoListImpl() {
		lista=  new ArrayList<>();
		cargarDatos();
	}

	private void cargarDatos() {			//MÉTODO PRIVADO
		lista.add(new Eventos(1,"Boda","500 personas",35540,"activo",null,'s'));
		lista.add(new Eventos(2,"Cumpleaños","10 personas", 120.57,"activo",null,'n'));
		lista.add(new Eventos(3,"Concierto","50mil personas", 3400334,"activo",null,'n'));
		lista.add(new Eventos(4,"Despedida","50 personas",527.58,"activo",null,'n'));
		lista.add(new Eventos(5,"Boda","100 personas",10298,"activo",null,'s'));
		
		nuevoCod=5;
	}


//------------------------------------------------------------------------------------------>


	//SETTER Y GETTER DE LISTILLA
	public List<Eventos> getLista() {
		return lista;
	}


	public void setLista(List<Eventos> lista) {
		this.lista = lista;
	}


//------------------------------------------------------------------------------------------>


	//MÉTODOS NOS DEVUELVE UN EVENTO A TRAVÉS DE SU ID
	@Override
	public Eventos buscarUno(int idEvento) {			//DEVUELVE UNO

		for(Eventos ele: lista) {
			if(ele.getIdEvento() == idEvento) {
				return ele;
			}
		}
		return null;
	}

	//BUSCA TODOS LOS EVENTOS DE LA LISTA
	@Override
	public List<Eventos> buscarTodos() {				//DEVUELVE TODOS
		return lista;
	}


//------------------------------------------------------------------------------------------>
	//CREA UN NUEVO EVENTO
	@Override
	public int nuevoEvento(Eventos evento) {
		if(!lista.contains(evento)) {			//SI LA LISTA "NO CONTIENE" AL EMPLEADO
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
	//PONE UN EVENTO A CANCELADO
	@Override
	public int cancelarEvento(int idEvento) {
        Eventos evento = buscarUno(idEvento);
        if(evento == null)
            return 0;
        evento.setEstado("Cancelado");
            return 1;

    }

//------------------------------------------------------------------------------------------>
	//ELIMINA UN EVENTO DE LA LISTA Y LA DEVUELVE
	@Override
	public boolean eliminarEvento(Eventos evento) {
		return lista.remove(evento);
	}


//------------------------------------------------------------------------------------------>

	//BUSCA EN LA LISTA TODOS LOS EVENTOS ACTIVOS
	public List<Eventos> buscarActivos() {
        List<Eventos> activos = new ArrayList<>();

        for (Eventos ele : lista) {
            if(ele.getEstado().equals("activo")) {
                activos.add(ele);
            }
        }
        return activos;
    }
	
	
	
	//BUSCA EN LA LISTA TODOS LOS EVENTOS CANCELADOS
	public List<Eventos> buscarCancelados() {
        List<Eventos> cancelados = new ArrayList<>();

        for (Eventos ele : lista) {
            if(ele.getEstado().equals("Cancelado")) {
                cancelados.add(ele);
            }
        }
        return cancelados;
    }


}
