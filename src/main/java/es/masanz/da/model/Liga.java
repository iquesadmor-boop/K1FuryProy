package es.masanz.da.model;

public class Liga {
    private int id;
    private String nombre;
    private int peso;
    private String fechaInicio;
    private String fechaFin;
    private int campeon;
    private boolean estaActiva;

    public Liga() {
        this(0,"",0,"","",0,false);
    }

    public Liga(int id, String nombre, int peso, String fechaInicio, String fechaFin, int campeon, boolean estaActiva) {
        this.id = id;
        this.nombre = nombre;
        this.peso = peso;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.campeon = campeon;
        this.estaActiva = estaActiva;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getCampeon() {
        return campeon;
    }

    public void setCampeon(int campeon) {
        this.campeon = campeon;
    }

    public boolean isEstaActiva() {
        return estaActiva;
    }

    public void setEstaActiva(int estaActiva) {
        if (estaActiva == 1){
            this.estaActiva = true;
        } else {this.estaActiva = false;}
    }
}