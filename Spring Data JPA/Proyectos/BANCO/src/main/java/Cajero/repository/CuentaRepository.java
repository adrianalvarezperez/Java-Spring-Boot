package Cajero.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Cajero.entityBeans.Cuenta;






public interface CuentaRepository extends JpaRepository<Cuenta, Integer>{

}
