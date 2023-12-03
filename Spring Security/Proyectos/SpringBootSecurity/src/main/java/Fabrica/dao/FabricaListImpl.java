package Fabrica.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Fabrica.beans.Perfile;
import Fabrica.beans.Producto;
import Fabrica.beans.Usuario;
import Fabrica.repository.PerfileRepository;
import Fabrica.repository.ProductoRepository;
import Fabrica.repository.UsuarioRepository;






@Service
public class FabricaListImpl implements IntFabricaDao{
	
	
	@Autowired
	private ProductoRepository iprod;
	@Autowired
	private PerfileRepository iperf;
	@Autowired
	private UsuarioRepository iusu;
	
	

	@Override
	public int insertarProducto(Producto producto) {
		int filas =0;
		try {
			iprod.save(producto);
			filas=1;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	
	@Override
	public Producto buscarUno(int codigo) {
		// TODO Auto-generated method stub
		return iprod.findById(codigo).orElse(null);
	}

	
	@Override
	public List<Producto> buscarTodos() {
		// TODO Auto-generated method stub
		return iprod.findAll();
	}

	
	@Override
	public List<Producto> buscarporFamilia(int codigoFamilia) {
		// TODO Auto-generated method stub
		return iprod.findPorFamilia(codigoFamilia);
	}

	@Override
	public List<Producto> buscarPormarcayColor(String marca, String color) {
		// TODO Auto-generated method stub
		return iprod.findByColorAndMarca(color, marca);
	}

	
	@Override
	public int borrarProducto(int codigo) {
		int filas = 0;
		try {
			iprod.deleteById(codigo);
			filas=1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	
	@Override
	public int modificarProducto(Producto producto) {
		int filas = 0;
		Producto p1 = null;
		try {
			p1 = iprod.getOne(producto.getCodigo());
			p1 = producto;
			iprod.save(p1);
			filas=1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	}
	
	
	
//------------------------------------------------------------------------------------>	
	
	
	
	@Override
	public Perfile findById(int idPerfil) {
		// TODO Auto-generated method stub
		return iperf.findById(idPerfil).orElse(null);
	}
	
	
	
//------------------------------------------------------------------------------------>	
	
	
	
	@Override
	public Usuario findById(String username) {
		// TODO Auto-generated method stub
		return iusu.findById(username).orElse(null);
	}
	
	
	@Override
	public boolean registro(Usuario usuario) {
		if (findById(usuario.getUsername()) == null) {
				iusu.save(usuario);
				return true;
		}
		return false;
	}
}
