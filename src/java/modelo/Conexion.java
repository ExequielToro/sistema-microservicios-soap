
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que gestiona la conexión con la base de datos Oracle.
 * <p>
 * Esta clase se encarga de establecer y cerrar la conexión con la base de datos,
 * utilizando el driver JDBC de Oracle. Es utilizada por las capas superiores
 * para interactuar con la base de datos sin preocuparse por los detalles de conexión.
 * </p>
 *
 * @author Pablo Toro
 * @version 1.0
 * @since 2025-05-21
 */

public class Conexion {
    private Connection cnn;

    public Conexion() {
        this.conectar();
    }

    public Connection getCnn() {
        return cnn;
   
 }
    public void setCnn(Connection cnn) {
        this.cnn = cnn;
    }
    
    private void conectar() {
        try{
        Class.forName("oracle.jdbc.OracleDriver");
        
       // LOCALHOST
       
       
        String BaseDeDatos = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
        cnn= DriverManager.getConnection(BaseDeDatos,"airesbd","1234");
            if(cnn==null)
            {
                System.out.println("Conexion fallida");
            }
        }
        catch(ClassNotFoundException | SQLException e)
        {System.out.println("error"+e);}
        
    }
    
    public void desonectarBD() {
        try {
            this.getCnn().close();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
        }

    }

    
}