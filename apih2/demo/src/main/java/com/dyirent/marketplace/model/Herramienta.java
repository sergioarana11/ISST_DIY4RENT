package com.dyirent.marketplace.model;

import java.util.Date;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="Herramientas")
public class Herramienta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="titulo", length=255, nullable=false)
    private String titulo;

    @Column(name="descripcion", length=255, nullable=false)
    private String descripcion;

    @Column(name="precio", precision=10, scale=2, nullable=false)
    private BigDecimal precio;

    @Lob
    @Column(name="foto", nullable=true)
    private byte[] foto;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_publicacion", nullable=false)
    private Date fechaPublicacion;

    @Enumerated(EnumType.STRING)
    @Column(name="categoria", nullable=false)
    private Categoria categoria;

    @Column(name="ubicacion", nullable=false)
    private String ubicacion;

    @Column(name="medio_cobro", length=20, nullable=false)
    private String medioCobro;

    // getters y setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getMedioCobro() {
        return medioCobro;
    }

    public void setMedioCobro(String medioCobro) {
        this.medioCobro = medioCobro;
    }
}

enum Categoria {
    HERRAMIENTA_MANUAL,
    HERRAMIENTA_ELECTRICA,
    HERRAMIENTA_NEUMATICA
}
