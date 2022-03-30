package data.DAO;

import data.Conexion;
import data.Operaciones;
import model.Cliente;
import model.Tarjeta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TarjetaDAO {

    Operaciones op;

    public TarjetaDAO() {op = new Operaciones();}

    public ArrayList<Tarjeta> queryAllCards(){
        ArrayList<Tarjeta> cardsArray = new ArrayList<>();
        try {
            ResultSet resultSet = op.ConsultaEsp("SELECT * FROM tarjeta");

            ClienteDAO clienteDAO = new ClienteDAO();

            while(resultSet.next()){
                Cliente clienteTar = clienteDAO.queryOneClient(resultSet.getString(2));
                cardsArray.add(new Tarjeta(
                        resultSet.getInt(1),
                        resultSet.getDouble(3),
                        resultSet.getString(4),
                        clienteTar
                ));
            }

        } catch (SQLException ex){
            System.out.println(ex);
        }
        return cardsArray;
    }

    public Tarjeta queryOneTarj(String tarjetaId){
        try {
            ClienteDAO clienteDAO = new ClienteDAO();
            ResultSet resultSet = op.ConsultaEsp("SELECT * FROM Tarjeta WHERE id_tarjeta="+tarjetaId);
            if(resultSet.next()){
                Cliente clienteTar = clienteDAO.queryOneClient(resultSet.getString(2));
                return new Tarjeta(resultSet.getInt(1),
                        resultSet.getDouble(3),
                        resultSet.getString(4),
                        clienteTar);
            }

        } catch (SQLException ex){
            System.out.println(ex);
        }
        return null;
    }

    public String insertTarjeta(Tarjeta tarjetaInsert){
        try{
            PreparedStatement preparedStatement = Conexion.getInstance().getConnection().prepareStatement(
                    "INSERT INTO tarjeta(id_cliente, saldo_tarjeta, est_tarjeta) VALUES(?,?,?);");

            preparedStatement.setString(1, tarjetaInsert.getCliente().getIdCliente());
            preparedStatement.setDouble(2, tarjetaInsert.getSaldoTarjeta());
            preparedStatement.setString(3, tarjetaInsert.getEstTarjeta());

            preparedStatement.executeUpdate();
            return "Inserción Completada con éxito";
        } catch (SQLException ex){
            System.out.println(ex);
        }
        return "No fue posible realizar la inserción del cliente, intentélo nuevamente";
    }

    public String updateTarjeta(Tarjeta tarjetaUpdate, String idTarjeta){
        try {
            PreparedStatement preparedStatement = Conexion.getInstance().getConnection().prepareStatement(
                    "UPDATE Tarjeta SET id_cliente = ?, saldo_tarjeta = ?, est_tarjeta = ?" +
                            " WHERE id_tarjeta = ?");

            preparedStatement.setString(1, tarjetaUpdate.getCliente().getIdCliente());
            preparedStatement.setDouble(2, tarjetaUpdate.getSaldoTarjeta());
            preparedStatement.setString(3, tarjetaUpdate.getEstTarjeta());
            preparedStatement.setInt(4, Integer.parseInt(idTarjeta));

            preparedStatement.executeUpdate();
            return "Actualización realizada Exitosamente";

        }catch (Exception e){
            System.out.println(e + " Error en actualizacion de Tarjeta");
        }
        return "Error al realizar la actualización";
    }

}
