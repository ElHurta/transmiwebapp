package model;

public class Tarjeta {
    private int idTarjeta;
    private double saldoTarjeta;
    private String estTarjeta;

    private Cliente cliente;

    public Tarjeta(int idTarjeta, double saldoTarjeta, String estTarjeta, Cliente cliente) {
        this.idTarjeta = idTarjeta;
        this.saldoTarjeta = saldoTarjeta;
        this.estTarjeta = estTarjeta;
        this.cliente = cliente;
    }

    public Tarjeta(double saldoTarjeta, String estTarjeta, Cliente cliente) {
        this.saldoTarjeta = saldoTarjeta;
        this.estTarjeta = estTarjeta;
        this.cliente = cliente;
    }

    public int getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(int idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public double getSaldoTarjeta() {
        return saldoTarjeta;
    }

    public void setSaldoTarjeta(double saldoTarjeta) {
        this.saldoTarjeta = saldoTarjeta;
    }

    public String getEstTarjeta() {
        return estTarjeta;
    }

    public void setEstTarjeta(String estTarjeta) {
        this.estTarjeta = estTarjeta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
