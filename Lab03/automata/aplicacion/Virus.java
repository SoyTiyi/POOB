package aplicacion;
import java.awt.Color;

/**
 * Write a description of class Virus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Virus implements Elemento{    
    private final static char VIVA='v', MUERTA='m';
    
    /**
     * Constructor for objects of class Virus
     */
    public Virus(AutomataCelular ac, int fila, int columna){
        
    }
    
    public int getForma(){
        return 2;
    }
    
}
