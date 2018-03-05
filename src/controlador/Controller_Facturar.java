package controlador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.Modelo_Facturar;
import modelo.datos.Producto;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
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
    public TextField entrada_CantidadProd;

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

    @FXML
    public Button boton_Cancelar;

    //Elementos del view para pagar la compra
    @FXML
    public Pane pane_PagoCompra;

    //////////////////Tabla Carrito/////////////////////////////////////////
    @FXML
    public TableView tabla_CarritoCompra;

    @FXML
    public TableColumn colCarritoCompra_Codigo;

    @FXML
    public TableColumn colCarritoCompra_Nombre;

    @FXML
    public TableColumn colCarritoCompra_Precio;

    @FXML
    public TableColumn colCarritoCompra_Cantidad;
    ////////////////////////////////////////////////////////////////////////

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

    @FXML
    public Pane panel_Efectivo;

    @FXML
    public TextField entrada_Efectivo;

    @FXML
    public Button boton_Ok;

    @FXML
    public Pane panel_Tarjeta;

    @FXML
    public Pane panel_Credito;

    @FXML
    public Text texto_InfoFact;



    // Handlers de eventos del view para agregar productos
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        //Cofiguracion de columnas de tabla de productos
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

        //Cofiguracion de columnas de carrito
        colCarrito_Codigo.setCellValueFactory(
                new PropertyValueFactory<Producto, String>("codigo")
        );
        colCarrito_Nombre.setCellValueFactory(
                new PropertyValueFactory<Producto, String>("nombre")
        );
        colCarrito_Cantidad.setCellValueFactory(
                new PropertyValueFactory<Producto, String>("cantidad")
        );

        //Configuracion de columnas de carrito (compra)
        colCarritoCompra_Codigo.setCellValueFactory(
                new PropertyValueFactory<Producto, String>("codigo")
        );
        colCarritoCompra_Nombre.setCellValueFactory(
                new PropertyValueFactory<Producto, String>("nombre")
        );
        colCarritoCompra_Precio.setCellValueFactory(
                new PropertyValueFactory<Producto, String>("precio")
        );
        colCarritoCompra_Cantidad.setCellValueFactory(
                new PropertyValueFactory<Producto, String>("cantidad")
        );
    }

    @FXML
    public void handleBotonConfirmarVentaAction(ActionEvent event){
        modelo.datos.facturas.add(modelo.factura);
        modelo.actualizarInventario();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Factura registrada");
        alert.setContentText("Imprimiendo factura...");
        alert.showAndWait().filter(response -> response == ButtonType.OK);
        limpiarInterfaz();
    }

    @FXML
    public void handleBotonConfirmarFacturaAction(ActionEvent event){
        cargarTablaCarrito();
        pane_ListaProductos.setVisible(false);
        pane_PagoCompra.setVisible(true);
        modelo.factura.calcularTotal();
        desplegarInfoFactura();
    }

    @FXML
    public void handleBotonAgregarProductoAction(ActionEvent event){
        int idProducto = Integer.parseInt(entrada_IDProd.getText());
        int cantidadProd = Integer.parseInt(entrada_CantidadProd.getText());
        Producto productoAgregado = modelo.obtenerProducto(modelo.datos.productos, idProducto);
        if (productoAgregado != null) {
            Producto productoTemporal = new Producto(productoAgregado.getCodigo(), productoAgregado.getNombre(), productoAgregado.getPrecio(), cantidadProd);
            modelo.carrito.add(productoTemporal);
            modelo.factura.insertProductoFactura(productoTemporal, productoTemporal.getCantidad());
            ObservableList<Producto> datosCarrito = FXCollections.observableArrayList(modelo.carrito);
            tabla_Carrito.setItems(datosCarrito);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("ID de Producto inválido.");
            alert.showAndWait().filter(response -> response == ButtonType.OK);
        }
    }

    @FXML
    public void handleBotonAplicarDescuentoAction(ActionEvent event){
        int idEstudiante = Integer.parseInt(entrada_IDEstudiante.getText());
        if(modelo.esEstudiante(idEstudiante)){
            modelo.factura.calcularDescuento();
            desplegarInfoFactura();
            boton_Credito.setDisable(false);
            boton_AplicarDescuento.setDisable(true);
        } else{
        }
    }

    @FXML
    public void handleBotonEfectivoAction(ActionEvent event){
        modelo.factura.setMetodoPago("Efectivo");
        panel_Efectivo.setVisible(true);
        panel_Tarjeta.setVisible(false);
        panel_Credito.setVisible(false);
        desplegarInfoFactura();

    }

    @FXML
    public void handleBotonTarjetaAction(ActionEvent event){
        modelo.factura.setMetodoPago("Tarjeta");
        modelo.factura.setEfectivo(0);
        modelo.factura.setCambio(0);
        panel_Efectivo.setVisible(false);
        panel_Tarjeta.setVisible(true);
        panel_Credito.setVisible(false);
        desplegarInfoFactura();
        boton_ConfirmarVenta.setDisable(false);
    }

    @FXML
    public void handleBotonCreditoAction(ActionEvent event){
        modelo.factura.setMetodoPago("Credito");
        modelo.factura.setEfectivo(0);
        modelo.factura.setCambio(0);
        panel_Efectivo.setVisible(false);
        panel_Tarjeta.setVisible(false);
        panel_Credito.setVisible(true);
        desplegarInfoFactura();
        boton_ConfirmarVenta.setDisable(false);
    }

    @FXML
    public void handleBotonOkAction(ActionEvent event){
        double efectivo = Double.parseDouble(entrada_Efectivo.getText());
        modelo.factura.setEfectivo(efectivo);
        modelo.factura.calcularVuelto();
        desplegarInfoFactura();
        boton_ConfirmarVenta.setDisable(false);
    }

    @FXML
    public void handleBotonCancelarAction(ActionEvent event){
        Stage stage = (Stage) boton_Cancelar.getScene().getWindow();
        stage.close();
    }

    public void cargarTablaProductos(){
        ObservableList<Producto> datosTablaProducto = FXCollections.observableArrayList(modelo.datos.productos);
        tabla_Productos.setItems(datosTablaProducto);
    }

    public void cargarTablaCarrito(){
        ObservableList<Producto> datosTablaCarrito = FXCollections.observableArrayList(modelo.carrito);
        tabla_CarritoCompra.setItems(datosTablaCarrito);
    }

    public void desplegarInfoFactura(){
        texto_InfoFact.setText(modelo.construirInformacionPago());
    }

    public void limpiarInterfaz(){
        pane_ListaProductos.setVisible(true);
        pane_PagoCompra.setVisible(false);
        boton_Credito.setDisable(true);
        boton_ConfirmarVenta.setDisable(true);
        boton_AplicarDescuento.setDisable(false);
        panel_Efectivo.setVisible(false);
        panel_Tarjeta.setVisible(false);
        panel_Credito.setVisible(false);
        entrada_IDProd.setText("");
        entrada_CantidadProd.setText("1");
        entrada_IDEstudiante.setText("");
        modelo.carrito = new ArrayList<>();
        tabla_Carrito.getItems().clear();
        tabla_Productos.getItems().clear();
        modelo.crearNuevaFactura();
        cargarTablaProductos();
    }
}
