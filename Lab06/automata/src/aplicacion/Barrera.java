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
    private AutomataCelular automata;
    public Barrera(AutomataCelular ac, int fila, int columna){
        super(ac,fila,columna);
        estadoActual='m';
        estadoSiguiente='m';
        automata=ac;
    }
    
    public int getForma(){
        return 2;
    }

    /**
     * Este metodo nos devuelve el tipo de este elemento
     */
    @Override
    public String getTipo(){
        return "Barrera";
    }
}
