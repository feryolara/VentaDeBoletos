package sample.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import sample.controlador.OperacionesClientes;
import sample.modelo.Cliente;

import static sample.vista.VistaPanelDerecho.tabla;

public class VistaPanelIzquierdo extends VBox {

    Label lbl1= new Label ("Agregar nuevo cliente");
    TextField txtname = new TextField();
    TextField txtapellido = new TextField();
    TextField txtdireccion = new TextField();

    Button btnguardar = new Button("Guardar");
    Button btnmodificar = new Button ("Modificar");
    Button btnborrar = new Button ("Borrar");

    OperacionesClientes op = new OperacionesClientes();
    int tempId;


    public VistaPanelIzquierdo(){

        //poner los botones del mismo tamaño
        btnguardar.setPrefWidth(150);
        btnmodificar.setPrefWidth(150);
        btnborrar.setPrefWidth(150);

        //muestra una indicacion en el textfield para que el usuario
        //sepa que va a poner en ese textfield
        txtname.setPromptText("Ingrese su nombre.");
        txtname.setFocusTraversable(false);

        txtapellido.setPromptText("Ingrese su apellido.");
        txtapellido.setFocusTraversable(false);

        txtdireccion.setPromptText("Ingrese su direccion.");
        txtdireccion.setFocusTraversable(false);

        //mejorar la apariencia para el usuario -- pintar los botones y el texto dentro de ellos
        btnguardar.setStyle("-fx-background-color:#021723;-fx-font-size:18;-fx-text-fill:#FFF");
        btnborrar.setStyle("-fx-background-color:#021723;-fx-font-size:18;-fx-text-fill:#FFF");
        btnmodificar.setStyle("-fx-background-color:#021723;-fx-font-size:18;-fx-text-fill:#FFF");
        lbl1.setStyle("-fx-font-size:20px;-fx-text-fill:#FFF"); //pinta el label de blanco para que se aprecie mejor
        this.setStyle("-fx-background-color:#0D3A55"); //color de fondo del pane
        this.setSpacing(15); //separa los componentes
        this.setPadding(new Insets(25)); //separa el panel de las orillas
        this.setAlignment(Pos.CENTER); //posiciona los componentes en el centro
        this.getChildren().addAll(lbl1,txtname,txtapellido,txtdireccion,btnguardar,btnmodificar,btnborrar);

        //actions

        btnguardar.setOnMouseClicked(e ->{

            Cliente clie = new Cliente();
            clie.setNombre(txtname.getText());
            clie.setApellidos(txtapellido.getText());
            clie.setDireccion(txtdireccion.getText());
            op.insertCliente(clie);
            tabla.setItems(op.getAllClientes());
            txtname.setText("");
            txtapellido.setText("");
            txtdireccion.setText("");

        });

        btnmodificar.setOnMouseClicked(e->{
            Cliente clie = new Cliente();
            clie.setClienteId(tempId);
            clie.setNombre(txtname.getText());
            clie.setApellidos(txtapellido.getText());
            clie.setDireccion(txtdireccion.getText());
            op.update(clie);

            tabla.setItems(op.getAllClientes());

        });

        btnborrar.setOnMouseClicked(e->{
            op.delete(tempId);
            tabla.setItems(op.getAllClientes());
        });
    }
}
