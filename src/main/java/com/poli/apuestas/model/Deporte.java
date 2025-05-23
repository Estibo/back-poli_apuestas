package com.poli.apuestas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "deporte")
public class Deporte {

    @Id
    @Column(name = "id_deporte")
    private int id;

    @Column(name = "nombre_deporte")
    private String nombre;

    public Deporte() {}

    public Deporte(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    @Override
    public String toString() {
        return "Deporte{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
