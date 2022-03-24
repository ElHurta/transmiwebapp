package model;

public class Ruta {
    private int id_ruta;
    private String n_ruta;
    private String hora_ini_ruta;
    private String hora_end_ruta;

    public Ruta(int id_ruta, String n_ruta, String hora_ini_ruta, String hora_end_ruta) {
        this.id_ruta = id_ruta;
        this.n_ruta = n_ruta;
        this.hora_ini_ruta = hora_ini_ruta;
        this.hora_end_ruta = hora_end_ruta;
    }

    public int getId_ruta() {
        return id_ruta;
    }

    public void setId_ruta(int id_ruta) {
        this.id_ruta = id_ruta;
    }

    public String getN_ruta() {
        return n_ruta;
    }

    public void setN_ruta(String n_ruta) {
        this.n_ruta = n_ruta;
    }

    public String getHora_ini_ruta() {
        return hora_ini_ruta;
    }

    public void setHora_ini_ruta(String hora_ini_ruta) {
        this.hora_ini_ruta = hora_ini_ruta;
    }

    public String getHora_end_ruta() {
        return hora_end_ruta;
    }

    public void setHora_end_ruta(String hora_end_ruta) {
        this.hora_end_ruta = hora_end_ruta;
    }
}
