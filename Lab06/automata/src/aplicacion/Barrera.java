package aplicacion;


/**
 * Write a description of class Barrera here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barrera extends Celula{
    private static final long serialVersionUID = 1L;
    /**
     * Constructor for objects of class Barrera
     */
    public Barrera(AutomataCelular ac, int fila, int columna){
        super(ac,fila,columna);
        estadoActual='m';
        estadoSiguiente='m';
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
