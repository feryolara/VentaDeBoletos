package sample.vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import sample.controlador.DBManager;
import sample.controlador.OperacionesClientes;
import sample.modelo.Cliente;

public class Main extends Application {

    static VistaPanelIzquierdo pane = new VistaPanelIzquierdo();

    static VistaPanelDerecho pane2 = new VistaPanelDerecho();
    @Override
    public void start(Stage primaryStage) throws Exception{

        HBox main = new HBox();

        main.getChildren().addAll(pane,pane2);

        //VistaPanelIzquierdo.prefWithProperty()
        Scene scene = new Scene(main,1000,500);
        primaryStage.setTitle("Examen Uch Lara");
        primaryStage.setMinHeight(550);
        primaryStage.setScene(scene);
        primaryStage.show();
        pane2.setMaxWidth(700);

        DBManager accesoBD = new DBManager();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
