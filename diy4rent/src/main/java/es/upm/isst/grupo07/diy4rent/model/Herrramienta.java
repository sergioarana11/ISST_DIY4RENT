package es.upm.isst.grupo07.diy4rent.model;

import java.util.Arrays;
import java.util.Date;

import javafx.scene.image.Image;

public class Herrramienta {
    private int id;
    private String titulo;
    private String descripcion;
    private double precio;
    private Image foto;
    private Date fechapubli;
    private Categoria categoria;
    private String ubicacion;
    private String mediocobro;

    public Herrramienta(int id, String titulo, String descripcion, double precio, Image foto, Date fechapubli,
            Categoria categoria, String ubicacion, String mediocobro) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.foto = foto;
        this.fechapubli = fechapubli;
        this.categoria = categoria;
        this.ubicacion = ubicacion;
        this.mediocobro = mediocobro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public Date getFechapubli() {
        return fechapubli;
    }

    public void setFechapubli(Date fechapubli) {
        this.fechapubli = fechapubli;
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

    public String getMediocobro() {
        return mediocobro;
    }

    public void setMediocobro(String mediocobro) {
        this.mediocobro = mediocobro;
    }

    public Herrramienta() {
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
        result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
        long temp;
        temp = Double.doubleToLongBits(precio);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((foto == null) ? 0 : foto.hashCode());
        result = prime * result + ((fechapubli == null) ? 0 : fechapubli.hashCode());
        result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
        result = prime * result + ((ubicacion == null) ? 0 : ubicacion.hashCode());
        result = prime * result + ((mediocobro == null) ? 0 : mediocobro.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Herrramienta other = (Herrramienta) obj;
        if (id != other.id)
            return false;
        if (titulo == null) {
            if (other.titulo != null)
                return false;
        } else if (!titulo.equals(other.titulo))
            return false;
        if (descripcion == null) {
            if (other.descripcion != null)
                return false;
        } else if (!descripcion.equals(other.descripcion))
            return false;
        if (Double.doubleToLongBits(precio) != Double.doubleToLongBits(other.precio))
            return false;
        if (foto == null) {
            if (other.foto != null)
                return false;
        } else if (!foto.equals(other.foto))
            return false;
        if (fechapubli == null) {
            if (other.fechapubli != null)
                return false;
        } else if (!fechapubli.equals(other.fechapubli))
            return false;
        if (categoria != other.categoria)
            return false;
        if (ubicacion == null) {
            if (other.ubicacion != null)
                return false;
        } else if (!ubicacion.equals(other.ubicacion))
            return false;
        if (mediocobro == null) {
            if (other.mediocobro != null)
                return false;
        } else if (!mediocobro.equals(other.mediocobro))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Herrramienta [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", precio=" + precio
                + ", foto=" + foto + ", fechapubli=" + fechapubli + ", categoria=" + categoria + ", ubicacion="
                + ubicacion + ", mediocobro=" + mediocobro + "]";
    }

}
