package model;

public class Ruta {
    private int idRuta;
    private String nRuta;
    private String horaIniRuta;
    private String horaEndRuta;

    public Ruta(int idRuta, String nRuta, String hora_ini_ruta, String horaEndRuta) {
        this.idRuta = idRuta;
        this.nRuta = nRuta;
        this.horaIniRuta = hora_ini_ruta;
        this.horaEndRuta = horaEndRuta;
    }

    public Ruta(String nRuta, String horaIniRuta, String horaEndRuta) {
        this.nRuta = nRuta;
        this.horaIniRuta = horaIniRuta;
        this.horaEndRuta = horaEndRuta;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public String getnRuta() {
        return nRuta;
    }

    public void setnRuta(String nRuta) {
        this.nRuta = nRuta;
    }

    public String getHoraIniRuta() {
        return horaIniRuta;
    }

    public void setHoraIniRuta(String horaIniRuta) {
        this.horaIniRuta = horaIniRuta;
    }

    public String getHoraEndRuta() {
        return horaEndRuta;
    }

    public void setHoraEndRuta(String horaEndRuta) {
        this.horaEndRuta = horaEndRuta;
    }
}
