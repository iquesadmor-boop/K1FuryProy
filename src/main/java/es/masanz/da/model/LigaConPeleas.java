package es.masanz.da.model;

import java.util.ArrayList;
import java.util.List;

public class LigaConPeleas {
    private String nombreLiga;
    private List<Pelea> peleas;

    public LigaConPeleas() {
        this("SIN_NOMBRE");
    }

    public LigaConPeleas(String nombreLiga) {
        this.nombreLiga = nombreLiga;
        this.peleas = new ArrayList<>();
    }

    public void addPelea(Pelea pelea) {
        peleas.add(pelea);
    }

    public String getNombreLiga() {
        return nombreLiga;
    }

    public void setNombreLiga(String nombreLiga) {
        this.nombreLiga = nombreLiga;
    }

    public List<Pelea> getPeleas() {
        return peleas;
    }

    public void setPeleas(List<Pelea> peleas) {
        this.peleas = peleas;
    }

    @Override
    public String toString() {
        return "LigaConPeleasDto{" +
                "nombreLiga='" + nombreLiga + '\'' +
                ", peleas=" + peleas +
                '}';
    }

}
