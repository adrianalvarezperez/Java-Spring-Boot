package Examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Examen.entityBeans.Departamento;

public interface IntDepartamento extends JpaRepository<Departamento, Integer>{

}
