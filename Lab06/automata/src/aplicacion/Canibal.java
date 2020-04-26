package aplicacion;
import java.awt.Color;
/**
 * Write a description of class Medica here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Canibal extends Celula{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int fila;
    private int columna;
    private AutomataCelular automata;
    /**
     * Constructor for objects of class Medica
     */
    public Canibal(AutomataCelular ac, int fila, int columna){
        super(ac,fila,columna);
        this.fila=fila;
        this.columna=columna;
        automata=ac;
        color=Color.green;
        estadoActual='m'; estadoSiguiente='m';
    }
    
    public int getForma(){
        return 2;
    }
    
    public void decida(){
        Elemento vecinoIzquierda = automata.getElemento(fila,columna-1);
        Elemento vecinoDerecha = automata.getElemento(fila,columna+1);
        super.decida();
        if(vecinoIzquierda!=null){
            if(vecinoIzquierda.isVivo()){
                estadoActual='v';
            }
            else{
                estadoActual='m';
            }
        }
        else if(vecinoDerecha!=null){
            if(vecinoDerecha.isVivo()){
                estadoActual='v';
            }
            else{
                estadoActual='m';
            }
        }
    }
}
