package modelo;

import modelo.datos.Cliente;
import modelo.datos.Factura;
import modelo.datos.Producto;

import java.util.ArrayList;

/**
 * Created by Jeison on 04/03/2018.
 */
public class Data {

    private ArrayList<Cliente> clientes;
    private ArrayList<Producto> productos;
    private ArrayList<Factura> facturas;


    public Data() {
        productos= new ArrayList<>();
        clientes= new ArrayList<>();
        facturas = new ArrayList<>();

        productos.add(new Producto(1,"Sardina del Mar",575,30));
        productos.add(new Producto(2,"Chocolate milán",150,5));
        productos.add(new Producto(3,"Flauta de pollo",800,20));
        productos.add(new Producto(1,"Flauta de Carne",800,13));
        productos.add(new Producto(1,"Agua",1100,30));

        Cliente cliente1= new Cliente(1,"Jeison Esquivel",true);
        Cliente cliente2= new Cliente(2,"David Valpene",true);
        Cliente cliente3= new Cliente(3,"Nicolas Cage",false);
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

    }






}
