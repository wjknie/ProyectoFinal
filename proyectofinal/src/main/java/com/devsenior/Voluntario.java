package com.devsenior;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Voluntario {
    private String nombre;
    private String id;
    private List<String> habilidades;
    private Set<String> misionesCompletadas;

    public Voluntario(String nombre, String id, List<String> habilidades) {
        this.nombre = nombre;
        this.id = EcoQuestService.normalizarTexto(id);
        this.habilidades = habilidades.stream()
            .map(EcoQuestService::normalizarTexto)
            .toList();
        this.misionesCompletadas = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public Set<String> getMisionesCompletadas() {
        return misionesCompletadas;
    }

    @Override
    public String toString() {
        return "Voluntario Nombre = " + nombre + ", id = " + id + ", habilidades = " + habilidades + ", misiones completadas = "
                + misionesCompletadas + "]";
    }
    
    
    
}
