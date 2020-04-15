
public class Tramos {
    private String nombreTramo;
    private int distancia;

    public Tramos(String nombreTramo, int distancia){
        this.nombreTramo=nombreTramo;
        this.distancia=distancia;
    }

    public String getNombre(){
        return nombreTramo;
    }

    public int getDistancia(){
        return distancia;
    }
}