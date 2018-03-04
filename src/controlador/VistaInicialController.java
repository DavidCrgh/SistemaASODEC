package controlador;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


/**
 * Created by Jeison on 04/03/2018.
 */
public class VistaInicialController {



    @FXML
    public void pressButton(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../vista/consultaVentasView.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            Stage principal= (Stage) ((Node) event.getSource()).getScene().getWindow();
            principal.hide();
            stage.show();
        } catch(Exception e) {
        }
    }

}
