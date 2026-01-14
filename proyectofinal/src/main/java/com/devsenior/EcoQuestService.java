package com.devsenior;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EcoQuestService {
    private Map<String, Voluntario> voluntarios;
    private Map<String, Mision> misiones;
    private Set<String> puntosEco;
    private Set<String> misionesCompletas;
    private Set<String> misionesAsignadas;

    public EcoQuestService(){
        this.voluntarios = new HashMap<>();
        this.misiones = new HashMap<>();
        this.puntosEco = new HashSet<>();
        this.misionesCompletas = new HashSet<>();
    }

    public void registrarVoluntario(Voluntario voluntario) {
        String id = voluntario.getId();
        if(voluntarios.containsKey(id)){
            throw new IllegalArgumentException("El voluntario con id " + id + " ya está registrado.");
        }
        voluntarios.put(voluntario.getId(), voluntario);       
    }

    public void agregarMision(Mision mision) {
        String id = mision.getId();
        if(misiones.containsKey(id)){
            throw new IllegalArgumentException("La misión con id " + id + " ya existe.");
        }
        misiones.put(mision.getId(), mision);

    }

    public void agregarPuntoEco(String puntoEco) {
        if(!puntosEco.add(puntoEco)){
            throw new IllegalArgumentException("El punto eco " + puntoEco + " ya existe.");
        }

    }

    public void completarMision(String idMision){
        if(!misiones.containsKey(idMision)){
            throw new IllegalArgumentException("La misión con id " + idMision + " no existe.");
        } if(!misionesCompletas.add(idMision)){
            throw new IllegalArgumentException("La misión con id " + idMision + " ya fue completada.");
        }
    }

    public void asignarMisionVoluntario(String idVoluntario, String idMision){
        if(!voluntarios.containsKey(idVoluntario)){
            throw new IllegalArgumentException("El voluntario no existe.");
        }if(!misiones.containsKey(idMision)){
            throw new IllegalArgumentException("La misión no existe.");
        }
        Voluntario v = voluntarios.get(idVoluntario);
            if(misionesAsignadas.contains(idMision)){
                throw new IllegalArgumentException("La misión ya fue asignada.");
        }
        v.getMisionesCompletadas().add(idMision);
        }
    
}

