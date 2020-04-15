import java.util.HashMap;
import java.io.*;
import java.util.*;

public class Transmilenio{
    /**
     * Esta clase tiene los servicios deseados para el sistema
     */

     /* Esta lista tiene el nombre de las estaciones */
    private static ArrayList<Estaciones> estaciones;
    private ArrayList<Rutas> rutas;
    private ArrayList<Troncales> troncales;
    private HashMap<String,Integer> tiempoEsperaEstacion;
    private String[][] recorrido;
    private SortedMap<String, Integer> ordenarPorNumeroDeEstaciones;
    private HashMap<String,Rutas> hashRuta;
    private Rutas tempoRuta;
    /**
     * Este es nuestro constructor para la clase Transmilenio
     */
    public Transmilenio(ArrayList<Estaciones> estaciones,ArrayList<Rutas> rutas, ArrayList<Troncales> troncales){
        this.estaciones=estaciones;
        this.rutas=rutas;
        this.troncales=troncales;
        tiempoEsperaEstacion = new HashMap<String,Integer>();
        construirHashMapEstacionesTiempo();
    }


    /**
     * Este metodo nos llena el HashMap con llave Nombre de la estacion y clave tiempoDeEspera de cada estacion
     */
    private void construirHashMapEstacionesTiempo(){
        for(Estaciones p: estaciones){
            tiempoEsperaEstacion.put(p.getNombre(),p.getTiempoDeEspera());
        }
    }

    /**
     * Este metodo devuelve el tiempo de espera de una estacion, este es el servicio numero 1
     * @param nombreEstacion
     * @return int el cual es el tiempo de espera de la estacion buscada
     */
    public int servicioNumero1(String nombreEstacion){
        return tiempoEsperaEstacion.get(nombreEstacion);
    }


    /**
     * Este metodo construye el TreeMap para el servicio numero 4
     */
    private void construirTreeMapMejorEstacion(String nombreAB){
        ordenarPorNumeroDeEstaciones = new TreeMap<String, Integer>(new Comparator<String>(){
            public int compare(String o1, String o2)
            {
                return o1.compareTo(o2);
            }
        });
        String[] parts = nombreAB.split("_");
        for(Rutas r: rutas){
            if(r.verificaSiTieneEsasEstaciones(parts[0], parts[1])){
                ordenarPorNumeroDeEstaciones.put(r.getNombre(),r.estacionesDeDiferencia(parts[0], parts[1]));
            }
        }


    }
    /**
     * Este metodo nos devuelve la mejor ruta sin la necesidad de hacer trasbordo para llegar de una estacion A a una estacion B
     * @param estacionA es un String, hace referencia al nombre de la estacion A
     * @param estacionB es un String, hace referencia al nombre de la esatcion B
     * @return es un String, es el nombre de la mejor ruta sin hacer trasbordo
     */
    public String servicioNumero4(String estacionA, String estacionB){
        String nombreAB = estacionA+"_"+estacionB;
        construirTreeMapMejorEstacion(nombreAB);
        return ordenarPorNumeroDeEstaciones.firstKey();
    }

    /**
     * Este metodo retorna el tiempo de recorrido de un plan de ruta
     * @param recorrido es un String[][], hace referencia al recorrido que se quiere realizar
     * @return el timepo del recorrido
     */
    public int servicioNumero6(String[][] recorrido){
        int cont=0;
        this.recorrido=recorrido;
        for(int i=0;i<recorrido.length;i++){
            if(recorrido[i][1]!=null){
                Rutas ruta = hashRuta.get(recorrido[i][1]);
                tempoRuta=ruta;
                cont+=ruta.darTiempoEstimadoEstacion(recorrido[i][0]);
            }
            else{
                cont+=tempoRuta.darTiempoEstimadoEstacion(recorrido[i][0]);
            }
        }
        return cont;
    }

    /**
     * Este metodo nos llena un HashMap con llave el nombre de la ruta y con clave el objeto ruta
     */
    public void llenarHashMapRuta(){
        for(Rutas r: rutas){
            hashRuta.put(r.getNombre(),r);
        }
    }

    public static void añadirEstacion(String direccionArchivo) throws FileNotFoundException, IOException{
        ArrayList<String> listaString = Estaciones.muestraContenidoArchivo(direccionArchivo);
        for(String s:listaString){
            /**
             * Este for es para verificar que si esta leyendo el archivo .txt
             */
            System.out.println(s);
        }
        Estaciones nuevaEstacion = new Estaciones(listaString.get(0), listaString.get(1), Integer.parseInt(listaString.get(2)));
        estaciones.add(nuevaEstacion);
    }

    public static void crearFichero() throws IOException {
        String ruta = "/Users/santi/Desktop/POOB/estacionEscrita.txt";
        File archivo = new File(ruta);
        BufferedWriter bw;
        if(archivo.exists()){
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("Ya estaba creado el archivo");
        }
        else{
            bw = new BufferedWriter(new FileWriter(archivo));
            String nombre = estaciones.get(0).getNombre();
            String nivel = estaciones.get(0).getNivelOcupacion();
            String tiempo = estaciones.get(0).getTiempoDeEspera()+"";
            bw.write(nombre+"\n"+nivel+"\n"+tiempo);
        }
    }

    public static void main(String[] args) throws IOException{
        añadirEstacion("/Users/santi/Desktop/POOB/estacion.txt");
        crearFichero();
    }
}