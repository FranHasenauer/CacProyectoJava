
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Persistencia {

    private Connection cn; //Conectar a la base de datos
    private ResultSet rs;  //Recibir datos de la base de datos
    private PreparedStatement ps; // ejecutar datos de la base de datos

    public String servidor, bbdd, usuario, clave, ejecutar;

    public Connection conectarse() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        
        servidor = "localhost";
bbdd="tp_final";
        usuario="root";
        clave="";
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            cn = DriverManager.getConnection("jdbc:mysql://" +  servidor + bbdd+usuario+clave);
        } catch (SQLException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    
    }

}
