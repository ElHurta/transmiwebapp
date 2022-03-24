package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {

    private static Conexion instancia;
    private static Connection connection;

    private Conexion(){
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/TransmiDB",
                    "root",
                    "123"
            );
        }catch (ClassNotFoundException | SQLException ex){
            System.out.println(ex);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    // Patrón Singleton
    /**
     * Obtiene la instancia que conecta a la base de datos, de no existir, crea dicha instancia
     */
    public static Conexion getInstance() throws SQLException{
        if(instancia == null) {
            instancia = new Conexion();
        } else if(instancia.getConnection().isClosed()) {
            instancia = new Conexion();
        }
        return instancia;
    }
}
