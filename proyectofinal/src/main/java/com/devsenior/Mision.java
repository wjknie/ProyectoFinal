package com.devsenior;

import java.time.LocalDate;

public class Mision {
    private String id;
    private String descripcion;
    private String ubicación;
    private LocalDate fecha;
    private String nivelDificultad;

    public Mision(String id, String descripcion, String ubicación, LocalDate fecha, String nivelDificultad) {
        this.id = id;
        this.descripcion = descripcion;
        this.ubicación = ubicación;
        this.fecha = fecha;
        this.nivelDificultad = nivelDificultad;
    }

    public String getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUbicación() {
        return ubicación;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getNivelDificultad() {
        return nivelDificultad;
    }
}