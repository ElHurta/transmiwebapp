package model;

public class Cliente {
    private String id_cliente;
    private String n_cliente;
    private String apel_cliente;

    public Cliente(String id_cliente, String n_cliente, String apel_cliente) {
        this.id_cliente = id_cliente;
        this.n_cliente = n_cliente;
        this.apel_cliente = apel_cliente;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getN_cliente() {
        return n_cliente;
    }

    public void setN_cliente(String n_cliente) {
        this.n_cliente = n_cliente;
    }

    public String getApel_cliente() {
        return apel_cliente;
    }

    public void setApel_cliente(String apel_cliente) {
        this.apel_cliente = apel_cliente;
    }
}
