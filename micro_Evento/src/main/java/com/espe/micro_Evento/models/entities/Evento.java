package com.espe.micro_Evento.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
@Table(name = "eventos")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El nombre del evento no puede estar vacío")
    @Column(nullable = false)
    private String nombre;

    @NotEmpty(message = "La descripción del evento no puede estar vacía")
    @Column(nullable = false)
    private String descripcion;

    @NotNull(message = "La duración no puede ser nula")
    @Positive(message = "La duración debe ser un número positivo")
    @Column(name = "duracion_horas", nullable = false)
    private Integer duracionHoras;

    @NotNull(message = "La fecha de inicio no puede ser nula")
    @Future(message = "La fecha de inicio debe ser futura")
    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(Integer duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}
