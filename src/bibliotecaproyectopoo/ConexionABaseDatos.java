
package bibliotecaproyectopoo;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConexionABaseDatos {
     
    Connection conectar = null;
    String usuario ="root";
    String pass = "root";
    String baseDatos = "bibliotecabasedatos2";
    String ip = "localhost";
    String puerto = "3306";
    
    String cadena = "jdbc:mysql://" +ip+":"+puerto+"/"+baseDatos;
    
    public Connection ConectarseABaseDeDatos (){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena,usuario,pass);
            
        } catch (Exception e) {
            System.out.println("No se pudo conectar a la base de datos.");
        }
        return conectar;
    }
    
}
