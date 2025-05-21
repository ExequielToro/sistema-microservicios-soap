
package modelo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;


/**
 * Clase DAO (Data Access Object) que gestiona la conexión entre la aplicación y la base de datos
 * para operaciones CRUD sobre la entidad Producto.
 * Utiliza procedimientos almacenados de Oracle para realizar las operaciones.
 *
 * @author Pablo.T
 * @version 1.0
 * @since 2025-05-21
 */

public class ProductoDao {
    Conexion conn;

    public ProductoDao() {
        
        conn = new Conexion();
    }
    
    
    
    public List<Producto> fun_mostrarProducto()
    {
        Connection acceso = conn.getCnn();
        Producto objProd = null;
        List<Producto> lista = new ArrayList();
        try {
            CallableStatement cs = acceso.prepareCall("{call PRODUCTO_pkg.proc_mostrarTodosProducto(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = (ResultSet) cs.getObject(1);
            while (rs.next())
            {
                objProd = new Producto();
                objProd.setId_producto(rs.getInt(1));
                objProd.setNombre(rs.getString(2));
                objProd.setPrecio(rs.getInt(3));
                objProd.setStock(rs.getInt(4));
                objProd.setBtu(rs.getInt(5));
                objProd.setMarca(rs.getString(6));
                lista.add(objProd);
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    
    }            
    
    public Producto fun_mostrarunProducto(int p_id_producto)
    {
        Connection acceso = conn.getCnn();
        Producto objProd = new Producto();
        
        try {
            CallableStatement cs = acceso.prepareCall("{call PRODUCTO_pkg.proc_mostrarUnProducto(?,?)}");
            cs.setInt(1, p_id_producto);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = (ResultSet) cs.getObject(2);
            while (rs.next())
            {
                
                objProd.setId_producto(rs.getInt(1));
                objProd.setNombre(rs.getString(2));
                objProd.setPrecio(rs.getInt(3));
                objProd.setStock(rs.getInt(4));
                objProd.setBtu(rs.getInt(5));
                objProd.setMarca(rs.getString(6));
               
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return objProd;
    
    }   

public boolean fun_actualizarProducto(int idProducto, Integer precio, Integer btu, String marca, String nombre, Integer stock) {
    Connection acceso = conn.getCnn();
    boolean result = false;

    try {
        CallableStatement cs = acceso.prepareCall("{call Producto_pkg.upd(?,?,?,?,?,?)}");
        cs.setInt(1, precio);
        cs.setInt(2, btu);
        cs.setString(3, marca);
        cs.setInt(4, idProducto);
        cs.setString(5, nombre);
        cs.setInt(6, stock);

        int filasAfectadas = cs.executeUpdate();
        if (filasAfectadas > 0) {
            result = true;
        }

    } catch (SQLException ex) {
        Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
    }

    return result;
}

public boolean fun_eliminarProducto(int p_id_producto) {
    Connection acceso = conn.getCnn();
    boolean result = false;
    
    try {
        CallableStatement cs = acceso.prepareCall("{call Producto_pkg.del(?)}");
        cs.setInt(1, p_id_producto);
        
        int rowsAffected = cs.executeUpdate();
        
        if (rowsAffected > 0) {
            result = true;
        }
    } catch (SQLException ex) {
        Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return result;
}


public boolean fun_ingresarProducto(
            int p_PRECIO,
            int p_BTU,
            String p_MARCA,
            String p_NOMBRE,
            int p_STOCK)
{
    Connection acceso = conn.getCnn();
    boolean result = false;
    
        try {
            
            CallableStatement cs = acceso.prepareCall("{call Producto_pkg.ins(?,?,?,?,?)}");
            cs.setInt(1, p_PRECIO);
            cs.setInt(2, p_BTU);
            cs.setString(3, p_MARCA);
            cs.setString(4, p_NOMBRE);
            cs.setInt(5,p_STOCK);
            
            if (!cs.execute())
                result = true;
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    
    
}



}

