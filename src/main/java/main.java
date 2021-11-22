import db.Modificar;
import pojo.Contenedor;
import pojo.ListaContenedor;
import pojo.Prioridad;
import xml.IntermedioXML;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import static db.Modificar.*;
import static db.Utilizar.importarDatos;
import static json.IntermedioJSON.exportaAJson;
import static xml.IntermedioXML.exportaAXml;

public class main {
    public static void main(String[] args) throws SQLException, IOException, InterruptedException {
        System.out.println("Bienvenido a este programa de mierda de prueba\n-------------------------------------------------------");
        ListaContenedor lista = importarDatos();
        do{

            System.out.println("¿Que desea Hacer?\n" +
                    "A) Visualizar datos\n" +
                    "B)Exportar a XML\n" +
                    "C)Exportar a JSON\n" +
                    "D)Añadir Contenedor\n" +
                    "E)Eliminar Contenedor\n" +
                    "F)Buscar Contenedor\n" +
                    "G)Cambiar Prioridad Contenedor\n" +
                    "H)Salir");
            Scanner sc = new Scanner(System.in);
            String respuesta = sc.nextLine();
            respuesta = respuesta.toUpperCase();
            switch (respuesta){
                case "A":
                    lista.recorre();
                    break;
                case "B":
                    exportaAXml();
                    break;
                case "C":
                    exportaAJson();
                    break;
                case "D":
                    while (true){
                        System.out.println("Introduce ID:Introduce tamaño del contenedor:Introduce el tipo de mercancia:Introduce una descripcion:Introduce una prioridad para el contenedor");
                        String datos = sc.nextLine();
                        String[] datosSeparados= datos.split(":");
                        int id = Integer.parseInt(datosSeparados[0]);
                        int tam = Integer.parseInt(datosSeparados[1]);
                        String tipo_mercancia = datosSeparados[2];
                        String descripcion =datosSeparados[3];
                        Prioridad prioridad = Prioridad.valueOf(datosSeparados[4].toUpperCase());
                        if (datosSeparados.length == 5){
                           anyadeContenedor(new Contenedor(id,tam,tipo_mercancia,descripcion,prioridad));
                           break;
                        }
                    }
                    break;
                case "E":
                    System.out.println("Pasame el identificador del contenedor que quieres eliminar");
                    int id = sc.nextInt();
                    try{
                        borraContenedor(importarDatos().busca(id));
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    break;
                case "F":
                    System.out.println("Dame un identificador de contenedor");
                    try{
                        System.out.println(importarDatos().busca(sc.nextInt()).toString());
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case "G":
                    System.out.println("id del contenedor:nueva prioridad");
                    String salida[] = sc.nextLine().split(":");
                    if (salida.length == 2) {
                        id = Integer.parseInt(salida[0]);
                        Prioridad prioridad = Prioridad.valueOf(salida[1].toUpperCase());
                        modificaContenedorPrioridad(importarDatos().busca(id), prioridad);
                        break;
                    }

                case "H":
                    System.exit(0);
                default:
                    System.out.println("Valor no reconocido");
            }

        }
        while(true);
    }
}
