package sample.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBManager {

    private static Connection connection;

    public DBManager() {

    }

   public static Connection getConnection() {

       if (connection == null) {
           try {

               Class.forName("com.mysql.cj.jdbc.Driver");
               String url = "jdbc:mysql://localhost/bdBoletaje?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
               connection = DriverManager.getConnection(url,
                       "root", "");
               System.out.println("Conexión exitosa a dbBoletaje ");

           } catch (SQLException ex) {
               //connection = null;
               Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);

           } catch (ClassNotFoundException e) {
               Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, e);
               // e.printStackTrace();
           }
       }
           return connection;
       }

       /**
        * Close the connection to the database if it is still open.
        *
        */
       public static void desconectar() {
           if (connection != null) {
               connection = null;
           }
       }
   }