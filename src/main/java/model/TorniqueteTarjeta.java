package model;

public class TorniqueteTarjeta {
    private Torniquete torniquete;
    private Tarjeta tarjeta;

    public TorniqueteTarjeta(Torniquete torniquete, Tarjeta tarjeta) {
        this.torniquete = torniquete;
        this.tarjeta = tarjeta;
    }

    public Torniquete getTorniquete() {
        return torniquete;
    }

    public void setTorniquete(Torniquete torniquete) {
        this.torniquete = torniquete;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }
}
