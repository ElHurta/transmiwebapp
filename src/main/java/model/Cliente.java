package model;

public class Cliente {
    private String idCliente;
    private String nCliente;
    private String apelCliente;

    public Cliente(String idCliente, String nCliente, String apelCliente) {
        this.idCliente = idCliente;
        this.nCliente = nCliente;
        this.apelCliente = apelCliente;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getnCliente() {
        return nCliente;
    }

    public void setnCliente(String nCliente) {
        this.nCliente = nCliente;
    }

    public String getApelCliente() {
        return apelCliente;
    }

    public void setApelCliente(String apelCliente) {
        this.apelCliente = apelCliente;
    }
}
