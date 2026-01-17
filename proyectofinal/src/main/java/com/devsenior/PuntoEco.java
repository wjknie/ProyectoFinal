package com.devsenior;

public class PuntoEco {
    private String id;
    private String nombre;
    private String tipoEcosistema;
    private String coordenadas;

    public PuntoEco(String id, String nombre, String tipoEcosistema, String coordenadas) {
        this.id = id;
        this.nombre = nombre;
        this.tipoEcosistema = tipoEcosistema;
        this.coordenadas = coordenadas;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoEcosistema() {
        return tipoEcosistema;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PuntoEco puntoEco = (PuntoEco) o;
        return id.equals(puntoEco.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}
