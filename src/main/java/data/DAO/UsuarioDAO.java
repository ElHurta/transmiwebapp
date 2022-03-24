package data.DAO;

import data.Operaciones;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    Operaciones op;

    public UsuarioDAO() {op = new Operaciones();}

    /**
     * Inicio de Sesión Mediante usuario y contraseña
     * @param nombreUsuario
     * @param contrasena
     * @return boolean
     */

    public boolean iniciarSesion(String nombreUsuario, String contrasena){
        try {
            ResultSet resultSet = op.ConsultaEsp("SELECT * FROM Usuario Where n_usuario = '"
                    + nombreUsuario + "' AND pw_usuario = '" + contrasena + "'");
            if(resultSet.next()){
                return true;
            }
        } catch (SQLException ex){
            System.out.println(ex);
        }
        return false;
    }

}
