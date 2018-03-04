package modelo.datos;

import java.util.ArrayList;


/**
 * Created by Jeison on 03/03/2018.
 */
public class Factura {

    private int numeroFactura;
    private double montoTotal;
    private double descuento;
    private double efectivo;
    private double cambio;
    private ArrayList<LineaProducto> detalleFactura;

    public Factura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public void insertProductoFactura(Producto producto,int cantidad){
        detalleFactura.add(new LineaProducto(producto,cantidad));

    }



    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(double efectivo) {
        this.efectivo = efectivo;
    }

    public double getCambio() {
        return cambio;
    }

    public void setCambio(double cambio) {
        this.cambio = cambio;
    }
}
