package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller_Facturar implements Initializable{

    // Elementos del view para agregar productos al carrito
    @FXML
    public Pane pane_ListaProductos;

    @FXML
    public TableView tabla_Productos;

    @FXML
    public TextField entrada_IDProd;

    @FXML
    public Spinner spinner_Cantidad;

    @FXML
    public Button button_AgregarProd;

    @FXML
    public TableView tabla_Carrito;

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

    }

    @FXML
    public void handleBotonConfirmarFacturaAction(ActionEvent event){
        pane_ListaProductos.setVisible(false);
        pane_PagoCompra.setVisible(true);
    }

    @FXML
    public void handleBotonAgregarProductoAction(ActionEvent event){

    }
}
