package data.DAO;

import data.Operaciones;
import model.Cliente;
import model.Tarjeta;

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

}
