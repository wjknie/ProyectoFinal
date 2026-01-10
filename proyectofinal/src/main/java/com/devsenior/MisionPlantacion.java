package com.devsenior;

import java.time.LocalDate;

public class MisionPlantacion extends Mision {

    public MisionPlantacion(String id, String descripcion, String ubicación, LocalDate fecha, String nivelDificultad) {
        super(id, descripcion, ubicación, fecha, nivelDificultad);
    }
}