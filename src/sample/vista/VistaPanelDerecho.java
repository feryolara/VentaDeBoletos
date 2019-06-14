package sample.vista;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sample.controlador.DBManager;
import sample.controlador.OperacionesClientes;
import sample.modelo.Cliente;


public class VistaPanelDerecho extends VBox  {

    HBox buscarPanel = new HBox();

    TextField txtBuscar = new TextField();
    Button btnBuscar = new Button("Buscar");

   static TableView <Cliente> tabla= new TableView();

    OperacionesClientes op = new OperacionesClientes();

    public VistaPanelDerecho() {
        TableColumn<Cliente, Integer> columnId =  new TableColumn("ID");
        TableColumn<Cliente, String> columNombre =  new TableColumn("Nombre");
        TableColumn<Cliente, String> columnApellido =  new TableColumn("Apellido");
        TableColumn<Cliente, String> columnDireccion =  new TableColumn("Direccion");


        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnApellido.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        columnDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));


        tabla.getColumns().addAll(columnId,columNombre,columnApellido,columnDireccion);
        tabla.setItems(op.getAllClientes());



       // buscarPanel.maxWidth(1000);
        //tabla.setMaxSize(550,550);
        //tabla.setMinSize(200,200);

       //tabla.setMaxWidth(500);
        buscarPanel.getChildren().addAll(txtBuscar,btnBuscar);
        buscarPanel.setSpacing(20);
        buscarPanel.setPadding(new Insets(20));
        this.setPadding(new Insets(20));
        buscarPanel.setAlignment(Pos.CENTER);
        buscarPanel.setPrefWidth(1000);
        tabla.setPrefSize(700,900);
        tabla.setPrefWidth(1000);
        this.getChildren().addAll(buscarPanel,tabla);

        tabla.setOnMouseClicked(e -> {

            Cliente client = tabla.getSelectionModel().getSelectedItem();
            Main.pane.txtname.setText(client.getNombre());
            Main.pane.txtapellido.setText(client.getApellidos());
            Main.pane.txtdireccion.setText(client.getDireccion());
            Main.pane.tempId=client.getId();


        });



    }

}
