package controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class Controller_Facturar {

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
    public Button boton_Confirmar;
}
