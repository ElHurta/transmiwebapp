package model;

public class Torniquete {
    private int idTorniquete;
    private String estTorniquete;

    private Bus bus;
    private Parada Parada;

    public Torniquete(int idTorniquete, String estTorniquete, Bus bus) {
        this.idTorniquete = idTorniquete;
        this.estTorniquete = estTorniquete;
        this.bus = bus;
    }

    public Torniquete(int idTorniquete, String estTorniquete, model.Parada parada) {
        this.idTorniquete = idTorniquete;
        this.estTorniquete = estTorniquete;
        Parada = parada;
    }

    public Torniquete(int idTorniquete, String estTorniquete) {
        this.idTorniquete = idTorniquete;
        this.estTorniquete = estTorniquete;
    }

    public int getIdTorniquete() {
        return idTorniquete;
    }

    public void setIdTorniquete(int idTorniquete) {
        this.idTorniquete = idTorniquete;
    }

    public String getEstTorniquete() {
        return estTorniquete;
    }

    public void setEstTorniquete(String estTorniquete) {
        this.estTorniquete = estTorniquete;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public model.Parada getParada() {
        return Parada;
    }

    public void setParada(model.Parada parada) {
        Parada = parada;
    }
}
