package com.example.diy4rent.demo.model;

import jakarta.persistence.*;

@Entity
public class Confirmacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean confirmado;

    @OneToOne
    private Herramientas herramienta;

    public Confirmacion() {
    }

    public Confirmacion(boolean confirmado, Herramientas herramienta) {
        this.confirmado = confirmado;
        this.herramienta = herramienta;
    }

    // getters y setters
}
