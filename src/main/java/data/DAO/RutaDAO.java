package data.DAO;

import data.Conexion;
import data.Operaciones;
import model.Cliente;
import model.Parada;
import model.Ruta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RutaDAO {
    Operaciones op;

    public RutaDAO() {op = new Operaciones();}

    public ArrayList<Ruta> queryAllRutas(){
        ArrayList<Ruta> rutasArray = new ArrayList<>();
        try {
            ResultSet resultSet = op.ConsultaEsp("SELECT * FROM Ruta");
            while(resultSet.next()){
                rutasArray.add(new Ruta(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)));
            }

        } catch (SQLException ex){
            System.out.println(ex);
        }
        return rutasArray;
    }

    public Ruta queryOneruta(String rutaID){
        try {
            ResultSet resultSet = op.ConsultaEsp("SELECT * FROM Ruta WHERE id_ruta="+rutaID);
            if(resultSet.next()){
                return new Ruta(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4));
            }

        } catch (SQLException ex){
            System.out.println(ex);
        }
        return null;
    }

    public String insertRuta(Ruta rutaInsert){
        try{
            PreparedStatement preparedStatement = Conexion.getInstance().getConnection().prepareStatement(
                    "INSERT INTO ruta(n_ruta, hora_ini_ruta, hora_end_ruta) VALUES(?,?,?);");

            preparedStatement.setString(1, rutaInsert.getnRuta());
            preparedStatement.setString(2, rutaInsert.getHoraIniRuta());
            preparedStatement.setString(3, rutaInsert.getHoraEndRuta());

            preparedStatement.executeUpdate();

            return "Inserción Completada con éxito";
        } catch (SQLException ex){
            System.out.println(ex);
        }
        return "No fue posible realizar la inserción del cliente, intentélo nuevamente";
    }
}
