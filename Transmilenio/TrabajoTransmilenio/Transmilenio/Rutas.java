import java.util.ArrayList;
import java.util.*;

public class Rutas {
    private String nombre;
    private Estaciones[] estaciones;
    private ArrayList<String> nombresEstaciones;
    private HashMap<String,Estaciones> hashEstacionesNombre;
    public Rutas(String nombre, Estaciones[] estaciones){
        this.nombre=nombre;
        this.estaciones=estaciones;
        nombresEstaciones = new ArrayList<String>();
    }

    public String getNombre(){
        return nombre;
    }

    public void construyeListaDeNombres(){
        for(int i=0; i<estaciones.length; i++){
            nombresEstaciones.add(estaciones[i].getNombre());
        }
    }

    public boolean verificaSiTieneEsasEstaciones(String estacionA, String estacionB){
        if(nombresEstaciones.contains(estacionA) && nombresEstaciones.contains(estacionB)){
            return true;
        }
        else{
            return false;
        }
    }

    public int estacionesDeDiferencia(String estacionA, String estacionB){
        return nombresEstaciones.indexOf(estacionB) - nombresEstaciones.indexOf(estacionB);
    }

    public void llenarHashRutaNombre(){
        for(Estaciones e: estaciones){
            hashEstacionesNombre.put(e.getNombre(),e);
        }
    }

    public int darTiempoEstimadoEstacion(String nombreEstacion){
        return hashEstacionesNombre.get(nombreEstacion).getTiempoDeEspera();
    }
}