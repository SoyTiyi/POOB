package aplicacion;
import java.awt.Color;
/**
 * Write a description of class Izquierdosa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Izquierdosa extends Celula{
    /**
     * Constructor for objects of class Izquierdosa
     */
    private int fila;
    private int columna;
    private AutomataCelular automata;
    public Izquierdosa(AutomataCelular ac, int fila, int columna){
        super(ac,fila,columna);
        this.fila=fila;
        this.columna=columna;
        automata=ac;
        color= Color.red;
    }
    
    public void decida(){
        Elemento vecino = automata.getElemento(fila,columna+1);
        super.decida();
        if(vecino!=null){
            if(vecino.isVivo()){
                estadoActual='m';
            }
        }
    }
}
