package json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import pojo.Contenedor;
import pojo.ListaContenedor;

import java.io.*;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

import static db.Utilizar.importarDatos;

public class IntermedioJSON {
    static Gson gson;

    //***Exporta a Json***//
    public static void exportaAJson(){
        gson = new Gson();
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("./src/main/resources/json/contenedores.json"))){
            gson.toJson(importarDatos(),bw);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    //***Importa a Json***//
    public static ListaContenedor importaAJson() throws FileNotFoundException {
        ListaContenedor listaContenedor = new ListaContenedor();
        gson = new Gson();
        try(BufferedReader br = new BufferedReader(new FileReader("./src/main/resources/json/contenedores.json"))){
           listaContenedor = gson.fromJson(br, ListaContenedor.class); //Linea importante sin TypeToken
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaContenedor;
    }

    public static void main(String[] args) throws FileNotFoundException {
        importaAJson().recorre();
       // exportaAJson(); //funciona sin complicaciones gracias al objeto que engloba la lista de objetos
    }
}
