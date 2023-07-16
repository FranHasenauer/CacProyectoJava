
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Persistencia {

    //Retorna la conexion
    private Connection cn;
    //Recibe los datos que vienen de la bbdd
    private ResultSet rs;
    //Recibe la orden de la busqueda 
    private PreparedStatement ps;
    
    private ResultSetMetaData rsm;

    public String servidor, bbdd, usuario, clave, ejecutar;

    public Connection conectarse() {
        try {
            Class.forName("com.mysql.jdbc.driver");

            servidor = "localhost:8080/";
            bbdd = "tp_final";
            usuario = "root";
            clave = "";

            cn = DriverManager.getConnection("jdbc:mysql://" + servidor + bbdd+"?autoReconnect=true&useSSL=false" + usuario + clave);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cn;

    }
//.-.-.-.-..--.-.-..-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.--..
    public ResultSet consultaSql(String busqueda){
        try {
            ps=conectarse().prepareStatement(busqueda);
      
        rs=ps.executeQuery();
        rsm=rs.getMetaData();
          } catch (SQLException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
}
