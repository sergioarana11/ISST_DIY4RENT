package com.example.diy4rent.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.diy4rent.demo.model.Herramientas;
import com.example.diy4rent.demo.repo.IHerramientaRepo;

@Service
public class HerramientaService {

    @Autowired
    private IHerramientaRepo herramientaRepo;

    public void guardarHerramienta(Herramientas herramienta) {
        herramientaRepo.save(herramienta);
    }
}