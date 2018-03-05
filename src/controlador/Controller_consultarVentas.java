package controlador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modelo.Modelo_ConsultaVentas;
import modelo.Modelo_DetalleFactura;
import modelo.datos.Factura;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Created by Jeison on 04/03/2018.
 */
public class Controller_consultarVentas implements Initializable{

    public Modelo_ConsultaVentas modelo_consultaVentas;

    public final ToggleGroup groupRadioButtons= new ToggleGroup();

    @FXML
    RadioButton rb_fecha_especifica, rb_fecha_intervalo;
    @FXML
    DatePicker dp_fecha_inicial, dp_fecha_final;
    @FXML
    Label label_hasta;

    @FXML
    TableView tabla_facturas;

    @FXML
    TableColumn columna_id_factura,columna_fechas;

    @FXML
    public void switchRadioButton(javafx.event.ActionEvent event){
        if (rb_fecha_especifica.selectedProperty().get()){
            dp_fecha_final.setVisible(false);
            label_hasta.setVisible(false);
        }
        else{
            dp_fecha_final.setVisible(true);
            label_hasta.setVisible(true);
        }
    }

    public void cargarFacturas(){
        ObservableList<Factura> datosTablaFacturas= FXCollections.observableArrayList(modelo_consultaVentas.datos.facturas);
        tabla_facturas.setItems(datosTablaFacturas);
    }



    @FXML
    public void consultarFacturasFechas(javafx.event.ActionEvent event)  {
        tabla_facturas.getItems().clear();
        try{

            Format formatter = new SimpleDateFormat("MM/dd/yyyy");
        LocalDate local= dp_fecha_inicial.getValue();
        Instant instant = Instant.from(local.atStartOfDay(ZoneId.systemDefault()));
        Date date1 = Date.from(instant);
        formatter.format(date1);
        if (rb_fecha_intervalo.isSelected()) {
            LocalDate local1= dp_fecha_final.getValue();
            Instant instant1 = Instant.from(local1.atStartOfDay(ZoneId.systemDefault()));
            Date date2 = Date.from(instant1);
            for (Factura factura:  modelo_consultaVentas.datos.facturas) {
                Date fechaFactura = factura.getFechaFactura();
                if (fechaFactura.compareTo(date1)>=0 && fechaFactura.compareTo(date2)<=0 ){
                    tabla_facturas.getItems().add(factura);
                }
            }
        }else{
            for (Factura factura:  modelo_consultaVentas.datos.facturas) {
                Date fechaFactura = factura.getFechaFactura();
                if (fechaFactura.equals(date1)){
                    tabla_facturas.getItems().add(factura);
                }
            }
        }
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Mensaje de alerta");
            alert.setHeaderText("ALERTA");
            alert.setContentText("Verificar las entradas de las fechas");

            alert.showAndWait();
        }

    }


    @FXML
    public void doubleClikEvent(javafx.event.ActionEvent event){
        try {
            if (tabla_facturas.getSelectionModel().getSelectedItem()!=null){
                Factura factura = (Factura) tabla_facturas.getSelectionModel().getSelectedItem();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../vista/detalleFacturaView.fxml"));
                Parent root = fxmlLoader.load();
                Controller_DetalleFactura controller_detalleFactura= fxmlLoader.getController();
                controller_detalleFactura.modelo=  new Modelo_DetalleFactura(factura);
                controller_detalleFactura.cargarDatos();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Mensaje de alerta");
                alert.setHeaderText("ALERTA");
                alert.setContentText("Se debe seleccionar una factura para ver su detalle.");

                alert.showAndWait();
            }

        } catch(Exception e) {
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rb_fecha_especifica.setToggleGroup(groupRadioButtons);
        rb_fecha_intervalo.setToggleGroup(groupRadioButtons);
        rb_fecha_intervalo.setSelected(true);

        columna_id_factura.setCellValueFactory(
                new PropertyValueFactory<Factura,String>("numeroFactura")
        );
        columna_fechas.setCellValueFactory(
                new PropertyValueFactory<Factura,String>("fechaFactura")
        );
    }





}
