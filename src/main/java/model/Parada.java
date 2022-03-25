package model;

public class Parada {
    private int idParada;
    private String nParada;
    private String tipoParada;

    public Parada(int idParada, String nParada, String tipo_parada) {
        this.idParada = idParada;
        this.nParada = nParada;
        this.tipoParada = tipo_parada;
    }

    public int getIdParada() {
        return idParada;
    }

    public void setIdParada(int idParada) {
        this.idParada = idParada;
    }

    public String getnParada() {
        return nParada;
    }

    public void setnParada(String nParada) {
        this.nParada = nParada;
    }

    public String getTipoParada() {
        return tipoParada;
    }

    public void setTipoParada(String tipoParada) {
        this.tipoParada = tipoParada;
    }
}
