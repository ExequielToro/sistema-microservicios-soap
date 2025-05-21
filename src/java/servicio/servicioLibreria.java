
package servicio;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import modelo.Producto;
import modelo.ProductoDao;

/**
 * Servicio web SOAP para gestión de productos.
 * Expone operaciones CRUD para productos mediante procedimientos almacenados en Oracle.
 *
 * @author Pablo.T
 * @version 1.0
 * @since 2025-05-21
 */

@WebService(serviceName = "servicioLibreria")
public class servicioLibreria {

    
    
    @WebMethod(operationName = "consultarProducto")
    @WebResult(name="productos")
    public List<Producto> consultar_producto() {
        
        ProductoDao objPd = new ProductoDao();
        List<Producto> listaProducto = objPd.fun_mostrarProducto();
        return listaProducto;
    }
    
    @WebMethod(operationName = "consultarunProducto")
    @WebResult(name="productos")
    public Producto consultar_un_producto(
            @WebParam(name = "codigo_producto") int codigo_producto) {
        
        ProductoDao objPd = new ProductoDao();
        Producto objProd = objPd.fun_mostrarunProducto(codigo_producto);
        return objProd;
    }
    
    
    @WebMethod(operationName = "sumar")
    @WebResult(name="sumaNumero")
    public int sumar(@WebParam(name = "numero1") int num1,
                     @WebParam(name = "numero2") int num2 ) {
        int sum =0;
        sum = num1+num2;
        return sum;
    }
    
    
     @WebMethod(operationName = "ingresarProducto")
    @WebResult(name="resultado")
    public boolean  ingresarProducto(@WebParam(name = "precio_producto") int  precio_producto,
                                  @WebParam(name = "btu") int  btu,
                                  @WebParam(name = "marca") String  marca,
                                  @WebParam(name = "nombre_producto") String  nombre,
                                  @WebParam(name = "stock_producto") int  stock) {
        
        
        
          ProductoDao objPd = new ProductoDao();  
         boolean result = objPd.fun_ingresarProducto(precio_producto, 
                 btu,marca,nombre,stock );
         return result;     
    }
    
    @WebMethod(operationName = "eliminarProducto")
    @WebResult(name="resultado")
    public boolean  eliminarProducto(@WebParam(name = "id_producto") int  id_producto) {
        
         ProductoDao objPd = new ProductoDao();  
         boolean result = objPd.fun_eliminarProducto(id_producto);
         return result;
    }
    
    public boolean actualizarStockProducto(
    @WebParam(name = "codigo_producto") int codigo_producto,
    @WebParam(name = "cantidad_stock") int cantidad_stock,
    @WebParam(name = "precio_precio") int precio_precio,
    @WebParam(name = "btu_producto") int btu_producto,
    @WebParam(name = "marca_producto") String marca_producto,
    @WebParam(name = "nombre_producto") String nombre_producto
) {
    ProductoDao objPd = new ProductoDao();  
    boolean result = objPd.fun_actualizarProducto(
        codigo_producto, 
        precio_precio, 
        btu_producto, 
        marca_producto, 
        nombre_producto, 
        cantidad_stock
    );
    return result;      
}}
