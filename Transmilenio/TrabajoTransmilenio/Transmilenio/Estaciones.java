import java.io.*;
import java.util.*;

public class Estaciones {
    private String nombre;
    private String nivelOcupacion;
    private Integer tiempoDeEspera;
    public Estaciones(String nombre, String nivelOcupacion, Integer tiempoDeEspera){
        this.nombre=nombre;
        this.nivelOcupacion=nivelOcupacion;
        this.tiempoDeEspera=tiempoDeEspera;
    }

    public String getNombre(){
        return nombre;
    }

    public Integer getTiempoDeEspera(){
        return tiempoDeEspera;
    }

    public String getNivelOcupacion(){
        return nivelOcupacion;
    }

    public static ArrayList<String> muestraContenidoArchivo(String archivo) throws FileNotFoundException, IOException{
        ArrayList<String> listaString = new ArrayList<String>();
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null){
            listaString.add(cadena);
        }
        b.close();
        return listaString;
    }

    public static void main(String[] args) throws IOException{
        muestraContenidoArchivo("/Users/santi/Desktop/POOB/clave.txt");
    }
}