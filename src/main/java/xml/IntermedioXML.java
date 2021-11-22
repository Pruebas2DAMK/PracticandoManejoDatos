package xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;
import pojo.Contenedor;
import pojo.ListaContenedor;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static db.Utilizar.importarDatos;

public class IntermedioXML {
    static XStream xStream;

    //***Crea un archivo XML perfecto sin fallos desde la lista de objetos contenedor***//
    public static void exportaAXml() throws IOException {
        xStream = new XStream();
        try( OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("./src/main/resources/xml/contenedores.xml"))){
            xStream.toXML(importarDatos(),osw); //recibe un objeto o lista de objetos y un metodo de escritura

        } catch (FileNotFoundException | SQLException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }

    //ESTE IMPORTAR FALLA POR COSA DE PERMISOS// si no se puede solucionar ahora dejarlo estar
    private static ListaContenedor importaDesdeXml(){
        ListaContenedor lista = new ListaContenedor();
        xStream = new XStream();
        xStream.addPermission(AnyTypePermission.ANY); //linea IMPORTANTISIMA para que funcione
        try(InputStreamReader isr = new InputStreamReader(new FileInputStream("./src/main/resources/xml/contenedores.xml"))) {
            xStream.fromXML(isr,lista);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
       return lista; //Todos los datos estan aqui escritos
    }

    public static void main(String[] args) throws IOException {
       importaDesdeXml().recorre();
        //exportaAXml();
    }

}



