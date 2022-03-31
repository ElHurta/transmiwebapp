package data.DAO;

import data.Conexion;
import data.Operaciones;
import model.Parada;
import model.Ruta;
import model.RutaParada;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RutaParadaDAO {
    Operaciones op;

    public RutaParadaDAO() {op = new Operaciones();}

    public ArrayList<RutaParada> queryAllParadasByRuta(String rutaID){
        ArrayList<RutaParada> paradasArray = new ArrayList<>();
        try {
            ResultSet resultSet = op.ConsultaEsp("SELECT * FROM rutaparada WHERE id_ruta = " + rutaID);
            RutaDAO rutaDAO = new RutaDAO();
            Ruta rutaSearched = rutaDAO.queryOneruta(rutaID);
            ParadaDAO paradaDAO = new ParadaDAO();
            if(rutaSearched != null){
                while(resultSet.next()){
                    paradasArray.add(new RutaParada(rutaSearched, paradaDAO.queryOneParada(resultSet.getString(2))));
                }
            }
        } catch (SQLException ex){
            System.out.println(ex);
        }
        return paradasArray;
    }

    public String insertRutaParada(Ruta rutaInsert){
        try{
            PreparedStatement preparedStatement = Conexion.getInstance().getConnection().prepareStatement(
                    "INSERT INTO rutaparada VALUES(?,?,?);");

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
