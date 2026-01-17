package com.devsenior;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EcoQuestService {
    private Map<String, Voluntario> voluntarios;
    private Map<String, Mision> misiones;
    private Set<PuntoEco> puntosEco;
    private Set<String> misionesCompletas;
    private Set<String> misionesAsignadas;

    public EcoQuestService() {
        this.voluntarios = new HashMap<>();
        this.misiones = new HashMap<>();
        this.puntosEco = new HashSet<>();
        this.misionesCompletas = new HashSet<>();
    }

    public static String normalizarTexto(String texto){
        return Normalizer.normalize(texto, Normalizer.Form.NFD)
        .replaceAll("\\p{InCombiningDiacriticalMarks}+", "texto")
        .toLowerCase()
        .trim();
    }

    public void registrarVoluntario(Voluntario voluntario) {
        String id = voluntario.getId();
        if (voluntarios.containsKey(id)) {
            throw new IllegalArgumentException("El voluntario con id " + id + " ya está registrado.");
        }
        voluntarios.put(voluntario.getId(), voluntario);
    }

    public void agregarMision(Mision mision) {
        String id = mision.getId();
        if (misiones.containsKey(id)) {
            throw new IllegalArgumentException("La misión con id " + id + " ya existe.");
        }
        misiones.put(mision.getId(), mision);

    }

    public void agregarPuntoEco(PuntoEco puntoEco) {
        if (!puntosEco.add(puntoEco)) {
            throw new IllegalArgumentException(
                    "El punto ecológico con ID " + puntoEco.getId() + " ya existe.");
        }
    }

    public void completarMision(String idMision) {
        if (!misiones.containsKey(idMision)) {
            throw new IllegalArgumentException("La misión con id " + idMision + " no existe.");
        }
        if (!misionesCompletas.add(idMision)) {
            throw new IllegalArgumentException("La misión con id " + idMision + " ya fue completada.");
        }
    }

    public void asignarMisionVoluntario(String idVoluntario, String idMision) {
        if (!voluntarios.containsKey(idVoluntario)) {
            throw new IllegalArgumentException("El voluntario no existe.");
        }
        if (!misiones.containsKey(idMision)) {
            throw new IllegalArgumentException("La misión no existe.");
        }
        Voluntario v = voluntarios.get(idVoluntario);
        if (misionesAsignadas.contains(idMision)) {
            throw new IllegalArgumentException("La misión ya fue asignada.");
        }
        v.getMisionesCompletadas().add(idMision);
    }

    public List<Voluntario> voluntarioPorHabilidades(String habilidad){
        String habilidadNoemalizada = normalizarTexto(habilidad);
        return voluntarios.values().stream()
        .filter(v -> v.getHabilidades().contains(habilidadNoemalizada))
        .toList();
    }

    public void mostrarTopVoluntarios(){
        voluntarios.values().stream()
        .sorted((v1, v2) -> Integer.compare(v2.getMisionesCompletadas().size(), v1.getMisionesCompletadas().size()))
        .limit(3)
        .forEach(v ->
            System.out.println(v.getNombre() + " - Misiones: " +
            v.getMisionesCompletadas().size()));
    }
}
