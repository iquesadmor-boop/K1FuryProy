package es.masanz.da.model;

public class Pelea {

    private Usuario peleador1;
    private Usuario peleador2;

    public Pelea() {
        this(null, null);
    }

    public Pelea(Usuario peleador1, Usuario peleador2) {
        this.peleador1 = peleador1;
        this.peleador2 = peleador2;
    }

    public Usuario getPeleador1() {
        return peleador1;
    }

    public void setPeleador1(Usuario peleador1) {
        this.peleador1 = peleador1;
    }

    public Usuario getPeleador2() {
        return peleador2;
    }

    public void setPeleador2(Usuario peleador2) {
        this.peleador2 = peleador2;
    }

    @Override
    public String toString() {
        return "PeleaDto{" +
                "peleador1=" + peleador1 +
                ", peleador2=" + peleador2 +
                '}';
    }
}
