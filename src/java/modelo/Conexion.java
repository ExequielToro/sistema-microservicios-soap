/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 
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