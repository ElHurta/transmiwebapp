package model;

public class RutaParada {
    private Ruta ruta;
    private Parada parada;

    public RutaParada(Ruta ruta, Parada parada) {
        this.ruta = ruta;
        this.parada = parada;
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
}
