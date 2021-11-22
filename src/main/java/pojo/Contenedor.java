package pojo;

import java.io.Serializable;

public class Contenedor implements Serializable {

 //***ATRIBUTOS***//
 private int id;
 private int tamanyo;
 private String tipo_mercancia;
 private String descripcion;
 private Prioridad prioridad;

    //***CONSTRUCTORES***//
    public Contenedor(int id, int tamanyo, String tipo_mercancia, String descripcion, Prioridad prioridad) {
        this.id = id;
        this.tamanyo = tamanyo;
        this.tipo_mercancia = tipo_mercancia;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
    }

    public Contenedor(int id, int tamanyo, String tipo_mercancia, Prioridad prioridad) {
        this.id = id;
        this.tamanyo = tamanyo;
        this.tipo_mercancia = tipo_mercancia;
        this.prioridad = prioridad;
        this.descripcion = null;
    }

    //***Getters***//
    public int getId() {
        return id;
    }
    public int getTamanyo() {
        return tamanyo;
    }
    public String getTipo_mercancia() {
        return tipo_mercancia;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public Prioridad getPrioridad() {
        return prioridad;
    }

    //**Setters***//
    public void setTamanyo(int tamanyo) {
        this.tamanyo = tamanyo;
    }
    public void setTipo_mercancia(String tipo_mercancia) {
        this.tipo_mercancia = tipo_mercancia;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }
    //**ToString**//


    @Override
    public String toString() {
        return "Contenedor{" +
                "id=" + id +
                ", tamanyo=" + tamanyo +
                ", tipo_mercancia='" + tipo_mercancia + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", prioridad=" + prioridad +
                '}';
    }
}