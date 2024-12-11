package com.intercambioregalos.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Participante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;

    @Column(unique = true, nullable = false)
    private String email;

    private String emailAsignado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getEmailAsignado() {
        return emailAsignado;
    }

    public void setEmailAsignado(String emailAsignado) {
        this.emailAsignado = emailAsignado;
    }
}
