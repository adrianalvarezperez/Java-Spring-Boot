package es.teod.actividadfinal.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.teod.actividadfinal.modelo.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}
