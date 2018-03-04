package modelo;

/**
 * Created by Jeison on 03/03/2018.
 */
public class LineaProducto {
    private Producto producto;
    private int cantidad;

    public LineaProducto(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
