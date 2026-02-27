package es.masanz.da.model;

import java.util.ArrayList;
import java.util.List;

public class Liga {
    private int id;
    private String peso;
    private String fechaInicio;
    private String fechaFin;
    private Usuario campeon;
    private boolean estaActiva;

    public Liga() {this(0, "", "", "", null, false);}

    public Liga(int id, String peso, String fechaInicio, String fechaFin, Usuario campeon, boolean estaActiva) {
        this.id = id;
        this.peso = peso;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.campeon = campeon;
        this.estaActiva = estaActiva;
    }
}