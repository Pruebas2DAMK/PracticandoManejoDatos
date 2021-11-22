package pojo;

//***ENUM DE LA PRIORIDAD***//
public enum Prioridad {
    ALTA("Alta"),
    MEDIA("Media"),
    BAJA("Baja");

    private String salida;

    Prioridad(String salida) {
    }

    public String getSalida() {
        return salida;
    }

}
