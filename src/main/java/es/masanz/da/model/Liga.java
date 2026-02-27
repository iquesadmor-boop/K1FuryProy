package es.masanz.da.model;

import java.util.ArrayList;
import java.util.List;

public class Liga {
    private int id;
    private String nombre;
    private String fechaInicio;
    private String fechaFin;
    private Usuario campeon;
    private boolean estaActiva;

    private List<Usuario> listaPeleadores = new ArrayList<>();

    public Liga() {this(0, "", "", "", null, false, null);}

    public Liga(int id, String nombre, String fechaInicio, String fechaFin, Usuario campeon, boolean estaActiva, List<Usuario> listaPeleadores) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.campeon = campeon;
        this.estaActiva = estaActiva;
        this.listaPeleadores = listaPeleadores;
    }
}