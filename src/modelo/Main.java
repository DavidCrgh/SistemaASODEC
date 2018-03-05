package modelo;

import controlador.Controller_VistaInicial;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../vista/vistaInicial.fxml"));
        Parent root = loader.load();
        Controller_VistaInicial controladorInicio = loader.getController();
        Data datos = new Data();
        controladorInicio.modelo_facturar = new Modelo_Facturar(datos);
        controladorInicio.modelo_consultaVentas=new Modelo_ConsultaVentas(datos);
        primaryStage.setTitle("Sistema ASOTEC");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
