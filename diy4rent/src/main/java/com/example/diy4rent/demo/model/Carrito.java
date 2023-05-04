package com.example.diy4rent.demo.model;

import jakarta.persistence.*;

/*
 * Autor: Heriberto y Alberto
 */

@Entity
@Table
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer carritoId;

    @ManyToOne
    @JoinColumn(name = "herramienta_uuid", referencedColumnName = "uuid")
    private Herramientas herramienta;

    @ManyToOne
    @JoinColumn(name = "usuario_uuid", referencedColumnName = "uuid")
    private Usuarios usuario;

    // public Carrito(Herramientas herramienta, Usuarios usuario) {
    // this.herramienta = herramienta;
    // this.usuario = usuario;
    // }
    public Carrito() {
    }

    public Carrito(Herramientas herramienta) {
        this.herramienta = herramienta;
    }

    // public Carrito(String herramientaUuid, UUID usuarioUuid) {
    // this.herramienta = new Herramientas();
    // this.herramienta.setUuid(herramientaUuid);
    // this.usuario = new Usuarios();
    // this.usuario.setUuid(usuarioUuid);

    // }
    public Integer getCarritoId() {
        return carritoId;
    }

    public void setCarritoId(Integer carritoId) {
        this.carritoId = carritoId;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Herramientas getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(Herramientas herramienta) {
        this.herramienta = herramienta;
    }
}
