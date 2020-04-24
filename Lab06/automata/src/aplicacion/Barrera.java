package aplicacion;


/**
 * Write a description of class Barrera here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barrera extends Celula{
    /**
     * Constructor for objects of class Barrera
     */
    private int fila;
    private int columna;
    private AutomataCelular automata;
    public Barrera(AutomataCelular ac, int fila, int columna){
        super(ac,fila,columna);
        this.fila=fila;
        this.columna=columna;
        estadoActual='m';
        estadoSiguiente='m';
        automata=ac;
    }
    
    public int getForma(){
        return 2;
    }
}
