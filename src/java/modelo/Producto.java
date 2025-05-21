
package modelo;

/**
 * Clase que representa un producto del sistema de aire acondicionado.
 * Contiene atributos básicos como nombre, precio, stock, BTU y marca.
 *
 * @author Pablo.T
 * @version 1.0
 * @since 2025-05-21
 */

public class Producto {
    
    private int id_producto;
    private String nombre;
    private int precio;
    private int stock;
    private int btu;
    private String marca;

    public Producto() {
    }

    public Producto(int id_producto, String nombre, int precio, int stock, int btu, String marca) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.btu = btu;
        this.marca = marca;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getBtu() {
        return btu;
    }

    public void setBtu(int btu) {
        this.btu = btu;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Producto{" + "id_producto=" + id_producto + ", nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + ", btu=" + btu + ", marca=" + marca + '}';
    }
    
    
    
}
