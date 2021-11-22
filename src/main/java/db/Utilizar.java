package db;

import pojo.Contenedor;
import pojo.ListaContenedor;
import pojo.Prioridad;
import singleton.DatabaseConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class Utilizar {

    private static Connection con;

    static {
        try {
            con = DatabaseConnection.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String query;
    private static Statement statement;
    private static ResultSet rs;

    //***PASAR DE BD A OBJETOS CONTENEDOR***//
    public static ListaContenedor importarDatos() throws SQLException {
        ListaContenedor contenedores = new ListaContenedor();

        query="SELECT * FROM contenedor";
        statement = con.createStatement();
        rs = statement.executeQuery(query);

        while (rs.next()) {
            contenedores.add(new Contenedor(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),Prioridad.valueOf(rs.getString(5))));
        }
        return contenedores;
    }

    //***MAIN***//
    public static void main(String[] args) throws SQLException {
    importarDatos().recorre();
    }
}
