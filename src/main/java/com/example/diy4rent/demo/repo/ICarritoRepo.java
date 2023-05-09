package com.example.diy4rent.demo.repo;

import com.example.diy4rent.demo.model.Carrito;
import com.example.diy4rent.demo.model.Herramientas;
import com.example.diy4rent.demo.model.Usuarios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ICarritoRepo extends JpaRepository<Carrito, Integer> {
    List<Carrito> findByUsuario(Usuarios usuario);
    Carrito findByHerramientaAndUsuario(Herramientas herramienta, Usuarios usuario);
    Carrito findByHerramienta(Herramientas herramienta);
    List<Carrito> findAll();
}
