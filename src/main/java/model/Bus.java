package model;

public class Bus {
    private String placa_bus;
    private int cap_bus;
    private String tipo_bus;

    private Ruta ruta;

    public Bus(String placa_bus, int cap_bus, String tipo_bus, Ruta ruta) {
        this.placa_bus = placa_bus;
        this.cap_bus = cap_bus;
        this.tipo_bus = tipo_bus;
        this.ruta = ruta;
    }

    public String getPlaca_bus() {
        return placa_bus;
    }

    public void setPlaca_bus(String placa_bus) {
        this.placa_bus = placa_bus;
    }

    public int getCap_bus() {
        return cap_bus;
    }

    public void setCap_bus(int cap_bus) {
        this.cap_bus = cap_bus;
    }

    public String getTipo_bus() {
        return tipo_bus;
    }

    public void setTipo_bus(String tipo_bus) {
        this.tipo_bus = tipo_bus;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }
}
