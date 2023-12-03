package Fabrica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Fabrica.entityBeans.Producto;






public interface IntProducto extends JpaRepository<Producto, Integer>{

}
