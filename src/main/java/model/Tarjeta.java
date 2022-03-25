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
}
