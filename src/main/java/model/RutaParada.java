package model;

public class RutaParada {
    private Ruta ruta;
    private Parada parada;
    private int posParada;

    public RutaParada(Ruta ruta, Parada parada, int posParada) {
        this.ruta = ruta;
        this.parada = parada;
        this.posParada = posParada;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public Parada getParada() {
        return parada;
    }

    public void setParada(Parada parada) {
        this.parada = parada;
    }

    public int getPosParada() {
        return posParada;
    }
}
