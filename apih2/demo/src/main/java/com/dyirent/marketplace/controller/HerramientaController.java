package com.dyirent.marketplace.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dyirent.marketplace.model.Herramienta;
import com.dyirent.marketplace.repository.HerramientaRepository;

@RestController
@RequestMapping("/herramientas")
public class HerramientaController {
    @Autowired
    private HerramientaRepository herramientaRepository;

    @PostMapping("/publicar")
    public ResponseEntity<?> publicarHerramienta(@RequestBody Herramienta herramienta) {
        // Aquí se guarda la herramienta en la base de datos utilizando el repositorio
        herramientaRepository.save(herramienta);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
