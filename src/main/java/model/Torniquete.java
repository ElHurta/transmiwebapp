package model;

public class Torniquete {
    private int id_torniquete;
    private String est_torniquete;

    private Bus bus;
    private Parada Parada;

    public Torniquete(int id_torniquete, String est_torniquete, Bus bus) {
        this.id_torniquete = id_torniquete;
        this.est_torniquete = est_torniquete;
        this.bus = bus;
    }

    public Torniquete(int id_torniquete, String est_torniquete, model.Parada parada) {
        this.id_torniquete = id_torniquete;
        this.est_torniquete = est_torniquete;
        Parada = parada;
    }

    public Torniquete(int id_torniquete, String est_torniquete) {
        this.id_torniquete = id_torniquete;
        this.est_torniquete = est_torniquete;
    }

    public int getId_torniquete() {
        return id_torniquete;
    }

    public void setId_torniquete(int id_torniquete) {
        this.id_torniquete = id_torniquete;
    }

    public String getEst_torniquete() {
        return est_torniquete;
    }

    public void setEst_torniquete(String est_torniquete) {
        this.est_torniquete = est_torniquete;
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
