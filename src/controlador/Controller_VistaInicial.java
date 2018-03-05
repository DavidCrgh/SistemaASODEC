package controlador;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
import modelo.Modelo_ConsultaVentas;
import modelo.Modelo_Facturar;


/**
 * Created by Jeison on 04/03/2018.
 */
public class Controller_VistaInicial {

    public Modelo_Facturar modelo_facturar;
    public Modelo_ConsultaVentas modelo_consultaVentas;


    @FXML
    public void handleBotonConsultarAction(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../vista/consultaVentasView.fxml"));
            Parent root = fxmlLoader.load();
            Controller_consultarVentas controller_consultarVentas = fxmlLoader.getController();
            controller_consultarVentas.modelo_consultaVentas = modelo_consultaVentas;
            controller_consultarVentas.cargarFacturas();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            Stage principal= (Stage) ((Node) event.getSource()).getScene().getWindow();
            principal.hide();
            stage.showAndWait();
            principal.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleBotonFacturarAction(ActionEvent event){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../vista/facturar.fxml"));
            Parent root = fxmlLoader.load();
            Controller_Facturar controller_facturar = fxmlLoader.getController();
            controller_facturar.modelo = modelo_facturar;
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            Stage principal= (Stage) ((Node) event.getSource()).getScene().getWindow();
            principal.hide();
            controller_facturar.cargarTablaProductos();
            stage.showAndWait();
            principal.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
