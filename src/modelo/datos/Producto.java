package modelo.datos;

/**
 * Created by Jeison on 03/03/2018.
 */
public class Producto {

    private int codigo;
    private String nombre;
    private double precio;
    private int cantidad;


    public Producto(int pCodigo, String nombre, double precio, int cantidad) {
        this.codigo = pCodigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
