package modelo.datos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * Created by Jeison on 03/03/2018.
 */
public class Factura {
    private int numeroFactura;
    private double montoTotal;
    private double totalFinal;
    private double descuento;
    private double efectivo;
    private Date fechaFactura;
    private double cambio;
    private String metodoPago;
    private double descuentoPorcentual;
    private ArrayList<LineaProducto> detalleFactura;
    private ArrayList<Producto> carrito;

    public Factura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
        this.detalleFactura = new ArrayList<>();
        this.descuentoPorcentual = 0.4;
        this.metodoPago = "S/D";
    }

    public void insertProductoFactura(Producto producto,int cantidad){
        detalleFactura.add(new LineaProducto(producto,cantidad));

    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
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

    public ArrayList<LineaProducto> getDetalleFactura() {
        return detalleFactura;
    }

    public void setDetalleFactura(ArrayList<LineaProducto> detalleFactura) {
        this.detalleFactura = detalleFactura;
    }

    public void calcularTotal(){
        double total = 0.0;
        for(LineaProducto p: detalleFactura){
            total += (p.getProducto().getPrecio() * p.getCantidad());
        }

        this.montoTotal = total;
        this.totalFinal = total;
    }

    public void calcularDescuento(){
        this.descuento = montoTotal * descuentoPorcentual;
        this.totalFinal = montoTotal * (1 - descuentoPorcentual);
    }

    public void calcularVuelto(){
        this.cambio = efectivo - totalFinal;
    }

    public double getTotalFinal() {
        return totalFinal;
    }

    public void setTotalFinal(double totalFinal) {
        this.totalFinal = totalFinal;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Date getFechaFactura() {
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        formatoFecha.format(fechaFactura);
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        formatoFecha.format(fechaFactura);
        this.fechaFactura = fechaFactura;
    }

    public void setCarrito(ArrayList<Producto> carrito) {
        this.carrito = carrito;
    }

    public ArrayList<Producto> getCarrito() {
        return carrito;
    }
}
