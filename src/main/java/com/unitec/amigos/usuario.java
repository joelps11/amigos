package com.unitec.amigos;

import org.springframework.data.annotation.Id;

public class usuario {
    private String nombre;
    //Volvemos al correo el id para efectos de repositorio de la bd
    @Id
    private String email;
    private int edad;

    public usuario() {
    }

    @Override
    public String toString() {
        return "usuario{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", edad=" + edad +
                '}';
    }

    //Zona de getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
