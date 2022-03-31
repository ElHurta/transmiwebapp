package data.DAO;

import data.Conexion;
import data.Operaciones;
import model.Bus;
import model.Cliente;
import model.Parada;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BusDAO {
    Operaciones op;

    public BusDAO() {op = new Operaciones();}

    public ArrayList<Bus> queryAllBuses(){
        ArrayList<Bus> busesArray = new ArrayList<>();
        RutaDAO rutaDAO = new RutaDAO();
        try {
            ResultSet resultSet = op.ConsultaEsp("SELECT * FROM Bus");
            while(resultSet.next()){
                busesArray.add(
                        new Bus(resultSet.getString(1),
                                resultSet.getInt(3),
                                resultSet.getString(4),
                                rutaDAO.queryOneruta(resultSet.getInt(2)+"")
                                )
                );
            }

        } catch (SQLException ex){
            System.out.println(ex);
        }
        return busesArray;
    }

    public Bus queryOneBus(String busID){
        try {
            ResultSet resultSet = op.ConsultaEsp("SELECT * FROM Bus WHERE placa_bus="+busID);
            if(resultSet.next()){
                RutaDAO rutaDAO = new RutaDAO();
                return new Bus(resultSet.getString(1),
                        resultSet.getInt(3),
                        resultSet.getString(4),
                        rutaDAO.queryOneruta(resultSet.getInt(2)+"")
                );
            }

        } catch (SQLException ex){
            System.out.println(ex);
        }
        return null;
    }

    public String insertBus(Bus busInsert){
        try{
            PreparedStatement preparedStatement = Conexion.getInstance().getConnection().prepareStatement(
                    "INSERT INTO bus VALUES(?,?,?,?);");

            preparedStatement.setString(1, busInsert.getPlaca_bus());
            preparedStatement.setInt(2, busInsert.getRuta().getIdRuta());
            preparedStatement.setInt(3, busInsert.getCapBus());
            preparedStatement.setString(4, busInsert.getTipoBus());

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
