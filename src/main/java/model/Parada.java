package model;

public class Parada {
    private int id_parada;
    private String n_parada;
    private String tipo_parada;

    public Parada(int id_parada, String n_parada, String tipo_parada) {
        this.id_parada = id_parada;
        this.n_parada = n_parada;
        this.tipo_parada = tipo_parada;
    }

    public int getId_parada() {
        return id_parada;
    }

    public void setId_parada(int id_parada) {
        this.id_parada = id_parada;
    }

    public String getN_parada() {
        return n_parada;
    }

    public void setN_parada(String n_parada) {
        this.n_parada = n_parada;
    }

    public String getTipo_parada() {
        return tipo_parada;
    }

    public void setTipo_parada(String tipo_parada) {
        this.tipo_parada = tipo_parada;
    }
}
