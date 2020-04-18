import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Tablero{
    private ArrayList<Flota> flotas = new ArrayList<Flota>();
    private String ruta = "C:/Users/santi/Desktop/POOB";
    public Tablero(){

    }

    public void crearArchivo(){
        File file = new File(ruta);
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        int numFlotas = flotas.length;
        bw.write("El numero de flotas es : "+numFlotas+"/n");
        bw.write("Nombre de las flotas y su numero de maquinas"+"/n");
        for(Flota f: flotas){
            bw.write(f.getName()+" tiene "+f.getNumFlotas()+" maquinas"+"/n");
        }
        bw.close();
    }

    public void leerArchivo(String nombreArchivo){
        try{
            BufferedReader bin = new BufferedReader(new FileReader(nombreArchivo));
            String nombreFlota = bin.readLine();
            while(nombreFlota!=null){
                flotas.add(new Flota(nombreFlota));
                nombreFlota=bin.readLine();
            }
            bin.close();
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "El archivo no existe");
        }
    }
}