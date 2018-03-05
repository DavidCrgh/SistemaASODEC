package controlador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Modelo_DetalleFactura;

import modelo.datos.Factura;
import modelo.datos.LineaProducto;
import modelo.datos.Producto;
import sun.plugin2.liveconnect.JSExceptions;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Jeison on 04/03/2018.
 */
public class Controller_DetalleFactura  implements Initializable{

    public Modelo_DetalleFactura modelo;

    @FXML
    TableView tabla_detalleFactura;

    @FXML
    TableColumn columna_codigo,columna_nombre,columna_precio,columna_cantidad;

    @FXML
    Label label_numeroFactura,label_fechaFactura,label_metodo,label_cambio,label_descuento,label_efectivo,label_totalParcial,
            label_total;


    public void cargarDetalleFactura(){
        ObservableList<Producto> datosTablaFacturas= FXCollections.observableArrayList(modelo.factura.getCarrito());
        tabla_detalleFactura.setItems(datosTablaFacturas);
    }


    public void cargarDatos(){
        Factura factura =modelo.factura;
        label_numeroFactura.setText(String.valueOf(factura.getNumeroFactura()));
        label_fechaFactura.setText(factura.getFechaFactura().toString());
        label_descuento.setText(String.valueOf(factura.getDescuento()));
        label_metodo.setText(factura.getMetodoPago());
        label_efectivo.setText(String.valueOf(factura.getEfectivo()));
        label_cambio.setText(String.valueOf(factura.getCambio()));
        label_totalParcial.setText(String.valueOf(factura.getMontoTotal()));
        label_total.setText(String.valueOf(factura.getTotalFinal()));
        cargarDetalleFactura();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        columna_codigo.setCellValueFactory(
                new PropertyValueFactory<Factura,String>("codigo")
        );
        columna_nombre.setCellValueFactory(
                new PropertyValueFactory<Factura,String>("nombre")
        );
        columna_precio.setCellValueFactory(
                new PropertyValueFactory<Factura,String>("precio")
        );
        columna_cantidad.setCellValueFactory(
                new PropertyValueFactory<Factura,String>("cantidad")
        );
    }

}
