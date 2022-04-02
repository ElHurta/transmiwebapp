package data.DAO;

import data.Conexion;
import data.Operaciones;
import model.Cliente;
import model.Parada;
import model.Ruta;
import model.RutaParada;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public String insertRuta(Ruta rutaInsert, String[] paradasIds){
        try{
            PreparedStatement preparedStatement = Conexion.getInstance().getConnection().prepareStatement(
                    "INSERT INTO ruta(n_ruta, hora_ini_ruta, hora_end_ruta) VALUES(?,?,?);", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, rutaInsert.getnRuta());
            preparedStatement.setString(2, rutaInsert.getHoraIniRuta());
            preparedStatement.setString(3, rutaInsert.getHoraEndRuta());

            RutaParadaDAO rutaParadaDAO = new RutaParadaDAO();
            ParadaDAO paradaDAO = new ParadaDAO();

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            
            int rutaId = 0;
            if(resultSet.next()){
                rutaId = resultSet.getInt(1);
            }

            int cont = 1;
            for (String parada: paradasIds) {
                rutaParadaDAO.insertRutaParada(new RutaParada(
                        this.queryOneruta(rutaId+""),
                        paradaDAO.queryOneParada(parada),
                        cont
                ));
                cont++;
            }

            return "Inserción Completada con éxito";
        } catch (SQLException ex){
            System.out.println(ex);
        }
        return "No fue posible realizar la inserción del cliente, intentélo nuevamente";
    }
}
