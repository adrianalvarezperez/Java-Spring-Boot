package productosFamilia.modelo.repository;

import java.util.List;

import productosFamilia.modelo.beans.Familia;


public interface IntFamilia {
	
     Familia finById(int idFamilia);
	 List<Familia> findAll();
	 
	 int insertarFamilia(Familia familia);
	 int modificarFamilia(Familia familia);
	 int eliminarFamilia(Familia familia);
	 int eliminarFamilia(int  idFamilia);
	 

}
