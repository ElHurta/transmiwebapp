package data.DAO;

import data.Operaciones;
import model.Cliente;

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
}
