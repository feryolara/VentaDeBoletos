package sample.controlador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.modelo.Cliente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OperacionesClientes {

    Statement stmt;


    public OperacionesClientes() {

    }

    public void insertCliente(Cliente clie) {

        try {
            stmt = DBManager.getConnection().createStatement();
            stmt.executeUpdate("insert into cliente(nombre, apellidos, direccion) " +
                    "values ('" + clie.getNombre() + "', '" + clie.getApellidos() + "', '" + clie.getDireccion() + "')");

        } catch (java.sql.SQLException ex) {
            ex.printStackTrace();
            System.out.println("SQLException:␣" + ex.getMessage());
            System.out.println("SQLState:␣" + ex.getSQLState());
            System.out.println("VendorError:␣" + ex.getErrorCode());
        }
    }

    public void update(Cliente clie) {

        try {
            stmt = DBManager.getConnection().createStatement();
            stmt.executeUpdate("update cliente set nombre ='"+clie.getNombre()+"', apellidos='"+clie.getApellidos()+
                    "', direccion='" + clie.getDireccion()+ "' where clienteID='" + clie.getId() + "'");
        } catch (java.sql.SQLException ex) {
            ex.printStackTrace();
            System.out.println("SQLException:␣" + ex.getMessage());
            System.out.println("SQLState:␣" + ex.getSQLState());
            System.out.println("VendorError:␣" + ex.getErrorCode());
        }
    }

    public void delete(int id){
        try {
            stmt = DBManager.getConnection().createStatement();
            stmt.executeUpdate("delete from cliente where clienteID="+id+"");
        } catch (java.sql.SQLException ex) {
            ex.printStackTrace();
            System.out.println("SQLException:␣" + ex.getMessage());
            System.out.println("SQLState:␣" + ex.getSQLState());
            System.out.println("VendorError:␣" + ex.getErrorCode());
        }
    }


   public ObservableList<Cliente> getAllClientes() {


        ObservableList<Cliente> clientes = FXCollections.observableArrayList();

        try {
            stmt = DBManager.getConnection().createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from cliente");
            resultSet.beforeFirst();
            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setClienteId(resultSet.getInt(1));
                cliente.setNombre(resultSet.getString(2));
                cliente.setApellidos(resultSet.getString(3));
                cliente.setDireccion(resultSet.getString(4));
                clientes.add(cliente);
                System.out.println(cliente);
            }

        } catch (java.sql.SQLException ex) {
            ex.printStackTrace();
            System.out.println("SQLException:␣" + ex.getMessage());
            System.out.println("SQLState:␣" + ex.getSQLState());
            System.out.println("VendorError:␣" + ex.getErrorCode());
        }
        return clientes;

    }
}
