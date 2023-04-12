package com.example.diy4rent.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.diy4rent.demo.model.Herramientas;

public interface IHerramientaRepo extends JpaRepository<Herramientas, String> {
        
}
