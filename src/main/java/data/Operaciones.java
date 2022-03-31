package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Clase operaciones
/**
 * Funciona como base para realizar operaciones básicas dirigidas hacia la base de datos, las cuales pueden alteradas
 * por las clases que la instancien
 */
public class Operaciones {


    /**
     * Método de consulta específica:
     * @Param query Obtiene la consulta a realizar como tipo de Dato String
     * @Return rs Resulset que contiene las filas obtenidas de la consulta realizada
     */
    public ResultSet ConsultaEsp(String Query) throws SQLException {

        Conexion conexion = Conexion.getInstance();
        Statement stmt = conexion.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery(Query);
        return rs;
    }
}