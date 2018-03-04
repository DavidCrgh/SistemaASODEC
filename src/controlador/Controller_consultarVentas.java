package controlador;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import modelo.Data;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Jeison on 04/03/2018.
 */
public class Controller_consultarVentas {

    public Data datos;
    public final ToggleGroup groupRadioButtons= new ToggleGroup();
    @FXML
    RadioButton rb_fecha_especifica,rb_fecha_intervalo;

    public Controller_consultarVentas(Data pDatos) {
       this.datos=pDatos;
    }


    @FXML
    public void initialize() {
        System.out.println("second");
    }

//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        rb_fecha_especifica.setToggleGroup(groupRadioButtons);
//        rb_fecha_especifica.setSelected(true);
//        rb_fecha_intervalo.setToggleGroup(groupRadioButtons);
//    }


}
