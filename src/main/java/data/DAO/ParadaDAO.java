package data.DAO;

import data.Conexion;
import data.Operaciones;
import model.Cliente;
import model.Parada;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ParadaDAO {
    Operaciones op;

    public ParadaDAO() {op = new Operaciones();}

    public ArrayList<Parada> queryAllParadas(){
        ArrayList<Parada> paradasArray = new ArrayList<>();
        try {
            ResultSet resultSet = op.ConsultaEsp("SELECT * FROM Parada");
            while(resultSet.next()){
                paradasArray.add(new Parada(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)));
            }

        } catch (SQLException ex){
            System.out.println(ex);
        }
        return paradasArray;
    }

    public Parada queryOneParada(String paradaID){
        try {
            ResultSet resultSet = op.ConsultaEsp("SELECT * FROM Parada WHERE id_parada="+paradaID);
            if(resultSet.next()){
                return new Parada(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3));
            }

        } catch (SQLException ex){
            System.out.println(ex);
        }
        return null;
    }

    public String insertParada(Parada paradaInsert){
        try{
            PreparedStatement preparedStatement = Conexion.getInstance().getConnection().prepareStatement(
                    "INSERT INTO parada(n_parada, tipo_parada) VALUES(?,?);");

            preparedStatement.setString(1, paradaInsert.getnParada());
            preparedStatement.setString(2, paradaInsert.getTipoParada());

            preparedStatement.executeUpdate();
            return "Inserción Completada con éxito";
        } catch (SQLException ex){
            System.out.println(ex);
        }
        return "No fue posible realizar la inserción del cliente, intentélo nuevamente";
    }

    public String updateParada(Parada paradaUpdate, String idParada){
        try {
            PreparedStatement preparedStatement = Conexion.getInstance().getConnection().prepareStatement(
                    "UPDATE Parada SET n_parada = ?, tipo_parada = ?" +
                            " WHERE id_parada = ?");

            preparedStatement.setString(1, paradaUpdate.getnParada());
            preparedStatement.setString(2, paradaUpdate.getTipoParada());
            preparedStatement.setInt(3, Integer.parseInt(idParada));

            preparedStatement.executeUpdate();
            return "Actualización realizada Exitosamente";

        }catch (Exception e){
            System.out.println(e + " Error en actualizacion de Cliente");
        }
        return "Error al realizar la actualización";
    }
}
