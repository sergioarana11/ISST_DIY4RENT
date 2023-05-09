package com.example.diy4rent.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.diy4rent.demo.model.Herramientas;

public interface IHerramientaRepo extends JpaRepository<Herramientas, String> {

    Herramientas findByUuid(String uuid);

    List<Herramientas> findByCategory(String category);

    List<Herramientas> findByTitleContaining(String title);

}
