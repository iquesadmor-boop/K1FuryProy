package es.masanz.da.controller;

public class Registro {

    private int id;
    private int peso; //El id del peso
    private int arbitro; //El id del arbitro
    private int peleador1; //El id de el peleador 1.
    private int peleador2; //El id de el peleador 2.
    private int ganador; //El id del ganador.

    public Registro(){this(0,0,0,0,0,0);}

    public Registro(int id, int peso, int arbitro, int peleador1, int peleador2, int ganador) {
        this.id = id;
        this.peso = peso;
        this.arbitro = arbitro;
        this.peleador1 = peleador1;
        this.peleador2 = peleador2;
        this.ganador = ganador;
    }

    // region Getters and Setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getArbitro() {
        return arbitro;
    }

    public void setArbitro(int arbitro) {
        this.arbitro = arbitro;
    }

    public int getPeleador1() {
        return peleador1;
    }

    public void setPeleador1(int peleador1) {
        this.peleador1 = peleador1;
    }

    public int getPeleador2() {
        return peleador2;
    }

    public void setPeleador2(int peleador2) {
        this.peleador2 = peleador2;
    }

    public int getGanador() {
        return ganador;
    }

    public void setGanador(int ganador) {
        this.ganador = ganador;
    }

    //endregion

    public String toXml() {
        StringBuilder sb = new StringBuilder();
        sb.append("<registro>");
        sb.append("<peso>").append(peso).append("</peso>");
        sb.append("<arbitro>").append(arbitro).append("</arbitro>");
        sb.append("<peleador1>").append(peleador1).append("</peleador1>");
        sb.append("<peleador2>").append(peleador2).append("</peleador2>");
        sb.append("<ganador>").append(ganador).append("</ganador>");
        sb.append("</registro>");
        return sb.toString();
    }
}
