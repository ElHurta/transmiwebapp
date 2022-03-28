package data.DAO;

import data.Conexion;
import data.Operaciones;
import model.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO {
    Operaciones op;

    public ClienteDAO() {op = new Operaciones();}

    public ArrayList<Cliente> queryAllClients(){
        ArrayList<Cliente> clientsArray = new ArrayList<>();
        try {
            ResultSet resultSet = op.ConsultaEsp("SELECT * FROM Cliente");
            while(resultSet.next()){
                clientsArray.add(new Cliente(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3)));
            }

        } catch (SQLException ex){
            System.out.println(ex);
        }
        return clientsArray;
    }

    public Cliente queryOneClient(String clientID){
        try {
            ResultSet resultSet = op.ConsultaEsp("SELECT * FROM Cliente WHERE id_cliente="+clientID);
            if(resultSet.next()){
                return new Cliente(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
            }

        } catch (SQLException ex){
            System.out.println(ex);
        }
        return null;
    }

    public String insertCliente(Cliente clienteInsert){
        try{
            PreparedStatement preparedStatement = Conexion.getInstance().getConnection().prepareStatement(
                    "INSERT INTO cliente VALUES(?,?,?);");

            preparedStatement.setString(1, clienteInsert.getIdCliente());
            preparedStatement.setString(2, clienteInsert.getnCliente());
            preparedStatement.setString(3, clienteInsert.getApelCliente());

            preparedStatement.executeUpdate();
            return "Inserción Completada con éxito";
        } catch (SQLException ex){
            System.out.println(ex);
        }
        return "No fue posible realizar la inserción del cliente, intentélo nuevamente";
    }

    public String updateCliente(Cliente clienteUpdate, String idCliente){
        try {
            PreparedStatement preparedStatement = Conexion.getInstance().getConnection().prepareStatement(
                    "UPDATE Cliente SET id_cliente = ?, n_cliente = ?, apel_cliente = ?" +
                            " WHERE id_cliente = ?");

            preparedStatement.setString(1, clienteUpdate.getIdCliente());
            preparedStatement.setString(2, clienteUpdate.getnCliente());
            preparedStatement.setString(3, clienteUpdate.getApelCliente());
            preparedStatement.setString(4, idCliente);

            preparedStatement.executeUpdate();
            return "Actualización realizada Exitosamente";

        }catch (Exception e){
            System.out.println(e + " Error en actualizacion de Cliente");
        }
        return "Error al realizar la actualización";
    }
}
