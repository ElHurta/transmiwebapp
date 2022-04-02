package data.DAO;

import data.Conexion;
import data.Operaciones;
import model.Ruta;
import model.RutaParada;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RutaParadaDAO {
    Operaciones op;

    public RutaParadaDAO() {op = new Operaciones();}

    public ArrayList<RutaParada> queryAllRutaParadasByRuta(String rutaID){
        ArrayList<RutaParada> paradasArray = new ArrayList<>();
        try {
            ResultSet resultSet = op.ConsultaEsp("SELECT * FROM rutaparada WHERE id_ruta = " + rutaID + " ORDER BY pos_parada");
            RutaDAO rutaDAO = new RutaDAO();
            Ruta rutaSearched = rutaDAO.queryOneruta(rutaID);
            ParadaDAO paradaDAO = new ParadaDAO();
            if(rutaSearched != null){
                while(resultSet.next()){
                    paradasArray.add(new RutaParada(rutaSearched, paradaDAO.queryOneParada(resultSet.getString(2)), resultSet.getInt(3)));
                }
            }
        } catch (SQLException ex){
            System.out.println(ex);
        }
        return paradasArray;
    }

    public void insertRutaParada(RutaParada rutaParada){
        try{
            PreparedStatement preparedStatement = Conexion.getInstance().getConnection().prepareStatement(
                    "INSERT INTO rutaparada VALUES(?,?,?);");

            preparedStatement.setInt(1, rutaParada.getRuta().getIdRuta());
            preparedStatement.setInt(2, rutaParada.getParada().getIdParada());
            preparedStatement.setInt(3, rutaParada.getPosParada());

            preparedStatement.executeUpdate();

        } catch (SQLException ex){
            System.out.println(ex);
        }
    }
}
