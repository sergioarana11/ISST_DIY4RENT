package com.example.diy4rent.demo.controllers;

import com.example.diy4rent.demo.model.Carrito;
import com.example.diy4rent.demo.model.Herramientas;
import com.example.diy4rent.demo.model.Usuarios;
import com.example.diy4rent.demo.repo.ICarritoRepo;
import com.example.diy4rent.demo.repo.IHerramientaRepo;
import com.example.diy4rent.demo.repo.IUsuarioRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CarritoController {

    /*
     * Autor: Heriberto Montalvo y Alberto Sánchez
     */

    @Autowired
    private ICarritoRepo carritoRepo;
    @Autowired
    private IUsuarioRepo UsuarioRepo;
    @Autowired
    private IHerramientaRepo herramientaRepo;

    @PostMapping("/agregar")
    public ResponseEntity<String> agregarAlCarrito(@RequestParam("herramienta_uuid") String herramienta_uuid) {
        System.out.println("Método agregarAlCarrito llamado con herramienta_uuid: " +
                herramienta_uuid);
        Herramientas herramienta = herramientaRepo.findByUuid(herramienta_uuid);
        if (herramienta == null) {
            return ResponseEntity.badRequest().build();
        }

        Carrito carrito = carritoRepo.findByHerramienta(herramienta);
        if (carrito != null) {
            String mensaje = "La herramienta " + herramienta.getTitle() +
                    " ya ha sido agregada al carrito.";
            String botonHtml = "<button onclick=\"location.href='/'; return false;\">Ir al inicio</button>";
            String respuestaHtml = mensaje + "<br>" + botonHtml;
            return ResponseEntity.ok().body(respuestaHtml);
        }

        carrito = new Carrito(herramienta);
        System.out.println("Carrito creado: " + carrito);
        carritoRepo.save(carrito);
        System.out.println("Carrito guardado: " + carrito);

        String mensaje = "La herramienta " + herramienta.getTitle() +
                " ha sido agregada al carrito.";
        String botonHtml = "<button onclick=\"location.href='/'; return false;\">Ir al inicio</button>";
        String respuestaHtml = mensaje + "<br>" + botonHtml;
        return ResponseEntity.ok().body(respuestaHtml);
    }

    @GetMapping(value = "/carrito")
    public ModelAndView getCarrito() {
        Logger logger = LoggerFactory.getLogger(CarritoController.class); // inicializar el logger
        logger.info("Mostrando vista del carrito..."); // agregar información de registro
        ModelAndView modelAndView = new ModelAndView("carrito.html");
        List<Carrito> carritos = carritoRepo.findAll();
        // System.out.println("Working view");
        // System.out.println(herramientas.get(0).getUuid());
        modelAndView.addObject("carritos", carritos);
        return modelAndView;
    }

}
