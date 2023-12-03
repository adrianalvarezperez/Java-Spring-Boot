package eventos.modelo.repository;

import java.util.ArrayList;
import java.util.List;

import eventos.modelo.beans.Tipo;






public class TipoListImpl implements IntTipo {

    private List<Tipo> lista;

    public TipoListImpl() {
        lista = new ArrayList<Tipo>();
        cargarDatos();
    }

    
    private void cargarDatos() {
        lista.add(new Tipo(1, "Concierto", "evento musica"));
        lista.add(new Tipo(2, "Despedida", "evento despedida"));
        lista.add(new Tipo(3, "cumple", "evento cumple"));
        lista.add(new Tipo(4, "boda", "evento boda"));
    }
    
    
    //BUSCA UN TIPO POR ID EN LA LISTA Y LA DEVUELVE
    @Override
    public Tipo findbyId(int idTipo) {
        for(Tipo ele: lista)
            if(ele.getIdTipo()==idTipo)
                return ele;
        return null;
    }





}