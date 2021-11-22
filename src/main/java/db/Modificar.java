package db;

import pojo.Contenedor;
import pojo.Prioridad;
import singleton.DatabaseConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Modificar {
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

    public Modificar() throws SQLException, IOException, ClassNotFoundException {
    }
    //***AÑADIR CONTENEDOR***//
    public static void anyadeContenedor(Contenedor contenedor) throws SQLException {
        query = "INSERT INTO contenedor (id, tamanyo, tipo_mercancia,descripcion,prioridad)VALUES ("+
                contenedor.getId()+","+contenedor.getTamanyo()+",\'"+contenedor.getTipo_mercancia()+
                "\',\'"+contenedor.getDescripcion()+"\',\'"+contenedor.getPrioridad()+"\')";
        statement = con.createStatement();
        statement.executeUpdate(query);

    }

    //***ELIMINA CONTENEDOR***//
    public static void borraContenedor(Contenedor contenedor) throws SQLException {
        query = "DELETE FROM contenedor WHERE id ="+contenedor.getId();
        statement = con.createStatement();
        statement.executeUpdate(query);

    }

    //***MODIFICA CONTENEDOR***// Creo que haria uno para cada campo
    public static void modificaContenedorPrioridad(Contenedor contenedor,Prioridad prioridad) throws SQLException {
        query = "UPDATE contenedor set prioridad = \'"+prioridad+"\' WHERE id = "+contenedor.getId();
        statement = con.createStatement();
        statement.executeUpdate(query);
    }



    //***PRUEBAS***//
    public static void main(String[] args) throws SQLException {
        Contenedor c1 = new Contenedor(3,50,"Ropa de Running","Tallas hasta 3XL", Prioridad.MEDIA);
        //anyadeContenedor(c1);
        //modificaContenedorPrioridad(c1,Prioridad.BAJA);
        //borraContenedor(c1);
    }

}
