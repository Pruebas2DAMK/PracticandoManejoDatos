package pojo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static db.Utilizar.importarDatos;

//para el xml es necesario, a la hora de convertir es indiferente, pero al importar si lo requiere
public class ListaContenedor {
    private List<Contenedor> contenedores;

    public ListaContenedor() {
        this.contenedores = new ArrayList<>();
    }
    public void add(Contenedor contenedor){
        contenedores.add(contenedor);
    }
    public void recorre(){
        contenedores.forEach(e->{
            System.out.println(e.toString());
        });
    }
    public Contenedor busca(int id) throws SQLException {
        final Contenedor[] busqueda = new Contenedor[1];
       contenedores.forEach(e->{
           if (e.getId() == id){
               busqueda[0] = e;
           }
       });
        return busqueda[0];
    }

}
