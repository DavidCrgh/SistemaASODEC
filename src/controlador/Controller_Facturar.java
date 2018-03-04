package controlador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import modelo.Modelo_Facturar;
import modelo.datos.Producto;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller_Facturar implements Initializable{

    public Modelo_Facturar modelo;

    // Elementos del view para agregar productos al carrito
    @FXML
    public Pane pane_ListaProductos;

    //////////////////Tabla Productos///////////////////////////////////////
    @FXML
    public TableView tabla_Productos;

    @FXML
    public TableColumn colProd_Codigo;

    @FXML
    public TableColumn colProd_Nombre;

    @FXML
    public TableColumn colProd_Precio;

    @FXML
    public TableColumn colProd_Cantidad;

    ////////////////////////////////////////////////////////////////////////
    @FXML
    public TextField entrada_IDProd;

    @FXML
    public Spinner spinner_Cantidad;

    @FXML
    public Button button_AgregarProd;

    //////////////////Tabla Carrito/////////////////////////////////////////
    @FXML
    public TableView tabla_Carrito;

    @FXML
    public TableColumn colCarrito_Codigo;

    @FXML
    public TableColumn colCarrito_Nombre;

    @FXML
    public TableColumn colCarrito_Cantidad;
    ////////////////////////////////////////////////////////////////////////
    @FXML
    public Button button_ConfirmarFactura;

    //Elementos del view para pagar la compra
    @FXML
    public Pane pane_PagoCompra;

    @FXML
    public TableView tabla_CarritoCompra;

    @FXML
    public TextField entrada_IDEstudiante;

    @FXML
    public Button boton_AplicarDescuento;

    @FXML
    public Button boton_Efectivo;

    @FXML
    public Button boton_Tarjeta;

    @FXML
    public Button boton_Credito;

    @FXML
    public Button boton_ConfirmarVenta;

    // Handlers de eventos del view para agregar productos
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        colProd_Codigo.setCellValueFactory(
                new PropertyValueFactory<Producto, String>("codigo")
        );
        colProd_Nombre.setCellValueFactory(
                new PropertyValueFactory<Producto, String>("nombre")
        );
        colProd_Precio.setCellValueFactory(
                new PropertyValueFactory<Producto, String>("precio")
        );
        colProd_Cantidad.setCellValueFactory(
                new PropertyValueFactory<Producto, String>("cantidad")
        );

    }

    @FXML
    public void handleBotonConfirmarFacturaAction(ActionEvent event){
        pane_ListaProductos.setVisible(false);
        pane_PagoCompra.setVisible(true);
    }

    @FXML
    public void handleBotonAgregarProductoAction(ActionEvent event){

    }

    public void cargarListaProductos(){
        ObservableList<Producto> datosTablaProducto = FXCollections.observableArrayList(modelo.datos.productos);
        tabla_Productos.setItems(datosTablaProducto);
    }
}
