package model;

public class Bus {
    private String placa_bus;
    private int capBus;
    private String tipoBus;

    private Ruta ruta;

    public Bus(String placa_bus, int capBus, String tipoBus, Ruta ruta) {
        this.placa_bus = placa_bus;
        this.capBus = capBus;
        this.tipoBus = tipoBus;
        this.ruta = ruta;
    }

    public Bus(String placa_bus, int capBus, String tipoBus) {
        this.placa_bus = placa_bus;
        this.capBus = capBus;
        this.tipoBus = tipoBus;
    }

    public String getPlaca_bus() {
        return placa_bus;
    }

    public void setPlaca_bus(String placa_bus) {
        this.placa_bus = placa_bus;
    }

    public int getCapBus() {
        return capBus;
    }

    public void setCapBus(int capBus) {
        this.capBus = capBus;
    }

    public String getTipoBus() {
        return tipoBus;
    }

    public void setTipoBus(String tipoBus) {
        this.tipoBus = tipoBus;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }
}
