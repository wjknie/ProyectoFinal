package com.devsenior;

import java.time.LocalDate;

public class MisionEducacion extends Mision {

    public MisionEducacion(String id, String descripcion, String ubicación, LocalDate fecha, String nivelDificultad) {
        super(id, descripcion, ubicación, fecha, nivelDificultad);
    }
}
