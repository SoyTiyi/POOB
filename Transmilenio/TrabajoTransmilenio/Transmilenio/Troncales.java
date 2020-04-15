
public class Troncales {
    private String nombre;
    private int promedioRecorrido;

    public Troncales(String nombre, int promedioRecorrido){
        this.nombre=nombre;
        this.promedioRecorrido=promedioRecorrido;
    }

    public String getNombre(){
        return nombre;
    }

    public int getPromedioRecorrido(){
        return promedioRecorrido;
    }
}