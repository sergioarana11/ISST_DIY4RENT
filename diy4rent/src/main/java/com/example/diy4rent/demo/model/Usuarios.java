package com.example.diy4rent.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import jakarta.validation.constraints.Email;

import java.util.UUID;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;

//import org.apache.commons.codec.DecoderException;
//import org.apache.commons.codec.binary.Base64;
//import org.apache.commons.codec.binary.Hex;


@Entity
@Table (name = "usuarios")
public class Usuarios {
    @Id
    private UUID uuid;
    @Column(name = "email")
    private String email;
    @Column(name = "dni")
    private String dni;
    @Column(name = "password")
    private String password;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido1")
    private String apellido1;
    @Column(name = "apellido2")
    private String apellido2; 
    @Column(name = "movil")
    private String movil; 
    @Column(name = "location")
    private String location;
    @Column(name = "charge_info")
    private String charge_info;


    public Usuarios() {
        // empty constructor body
    }

    public Usuarios(String email, String dni, String password, String nombre, String apellido1,
            String apellido2, String movil, String location, String charge_info) {
        this.uuid =  UUID.randomUUID();
        this.email = email;
        this.dni = dni;
        this.password = password;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.movil = movil;
        this.location = location;
        this.charge_info = charge_info;
    }

    public UUID getUuid() {
        return uuid;
     }
  
     public void setUuid(UUID uuid) {
        this.uuid = uuid;
     }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCharge_info() {
        return charge_info;
    }

    public void setCharge_info(String charge_info) {
        this.charge_info = charge_info;
    }
    


}

