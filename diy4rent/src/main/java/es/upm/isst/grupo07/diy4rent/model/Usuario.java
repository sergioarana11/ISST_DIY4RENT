package es.upm.isst.grupo07.diy4rent.model;

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
        return "Usuario [id=" + id + ", email=" + email + ", password=" + password + ", DNI=" + DNI + ", nombre="
                + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", movil=" + movil + ", ubicacion="
                + ubicacion + ", mediopago=" + mediopago + "]";
    }

    
      
}
