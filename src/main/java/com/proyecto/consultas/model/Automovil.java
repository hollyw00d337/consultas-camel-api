package com.proyecto.consultas.model; // <--- Fíjate que esto coincida

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "automoviles")
public class Automovil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelo;
    private Integer anio;
    private String color;
    private LocalDateTime fechaRegistro = LocalDateTime.now();

    public Automovil() {}

    public Automovil(String modelo, Integer anio, String color) {
        this.modelo = modelo;
        this.anio = anio;
        this.color = color;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public Integer getAnio() { return anio; }
    public void setAnio(Integer anio) { this.anio = anio; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }
}
