package modelo;

import modelo.datos.Cliente;
import modelo.datos.Factura;
import modelo.datos.Producto;

import java.util.ArrayList;

/**
 * Creado por David Valverde Garro - 2016034774
 * Fecha: 04-Mar-18 Tiempo: 12:55 PM
 */
public class Modelo_Facturar {

    public Data datos;

    public Factura factura;
    public ArrayList<Producto> carrito;

    public Modelo_Facturar(Data datos){
        this.datos = datos;
        crearNuevaFactura();
        carrito = new ArrayList<>();
    }

    public void actualizarInventario(){
        for(Producto p: carrito){
            Producto prodInventario = obtenerProducto(datos.productos, p.getCodigo());
            prodInventario.setCantidad(prodInventario.getCantidad() - p.getCantidad());
        }
    }

    public void crearNuevaFactura(){
        if (datos.facturas.size() > 0) {
            this.factura = new Factura(datos.facturas.get(datos.facturas.size() - 1).getNumeroFactura() + 1);
        } else {
            this.factura = new Factura(0);
        }
    }

    public Producto obtenerProducto(ArrayList<Producto> listaProductos, int id){
        for(Producto p: listaProductos){
            if(p.getCodigo() == id){
                return p;
            }
        }
        return null;
    }

    public boolean esEstudiante(int id){
        for(Cliente c: datos.clientes){
            if(c.getIdCliente() == id && c.isEstudiante()){
                return true;
            }
        }
        return false;
    }

    public String construirInformacionPago(){
        String info = "";
        info += "Número: " + factura.getNumeroFactura() + "\n";
        info += "Total: " + factura.getMontoTotal() + "\n";
        info += "Método de Pago: " + factura.getMetodoPago() + "\n";
        info += "Descuento: " + factura.getDescuento() + "\n";
        info += "Efectivo: " + factura.getEfectivo() + "\n";
        info += "Cambio: " + factura.getCambio() + "\n";
        info += "Total Final: " + factura.getTotalFinal() + "\n";

        return info;
    }
}
