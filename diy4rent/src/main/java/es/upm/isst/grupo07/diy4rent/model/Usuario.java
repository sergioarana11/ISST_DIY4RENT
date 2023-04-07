package es.upm.isst.grupo07.diy4rent.model;

import java.util.Arrays;

public class Usuario {

    private int id;
    private String email;
    private String password;
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String movil;

    private String ubicacion;
    private String mediopago;

    public Usuario(int id, String email, String password, String dni, String nombre, String apellido1, String apellido2,
            String movil, String ubicacion, String mediopago) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.movil = movil;
        this.ubicacion = ubicacion;
        this.mediopago = mediopago;
    }

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getMovil() {
        return movil;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getMediopago() {
        return mediopago;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDNI(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setMediopago(String mediopago) {
        this.mediopago = mediopago;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", email=" + email + ", password=" + password + ", dni=" + dni + ", nombre="
                + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", movil=" + movil + ", ubicacion="
                + ubicacion + ", mediopago=" + mediopago + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((dni == null) ? 0 : dni.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((apellido1 == null) ? 0 : apellido1.hashCode());
        result = prime * result + ((apellido2 == null) ? 0 : apellido2.hashCode());
        result = prime * result + ((movil == null) ? 0 : movil.hashCode());
        result = prime * result + ((ubicacion == null) ? 0 : ubicacion.hashCode());
        result = prime * result + ((mediopago == null) ? 0 : mediopago.hashCode());
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
        Usuario other = (Usuario) obj;
        if (id != other.id)
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (dni == null) {
            if (other.dni != null)
                return false;
        } else if (!dni.equals(other.dni))
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (apellido1 == null) {
            if (other.apellido1 != null)
                return false;
        } else if (!apellido1.equals(other.apellido1))
            return false;
        if (apellido2 == null) {
            if (other.apellido2 != null)
                return false;
        } else if (!apellido2.equals(other.apellido2))
            return false;
        if (movil == null) {
            if (other.movil != null)
                return false;
        } else if (!movil.equals(other.movil))
            return false;
        if (ubicacion == null) {
            if (other.ubicacion != null)
                return false;
        } else if (!ubicacion.equals(other.ubicacion))
            return false;
        if (mediopago == null) {
            if (other.mediopago != null)
                return false;
        } else if (!mediopago.equals(other.mediopago))
            return false;
        return true;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

}
