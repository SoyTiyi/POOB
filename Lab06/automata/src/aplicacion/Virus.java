package aplicacion;
import java.awt.Color;
import java.io.Serializable;

/**
 * Write a description of class Virus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Virus implements Elemento, Serializable{    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private final static char MUERTA = 'm';
    protected Color color;
    private int fila;
    private int columna;
    private AutomataCelular automata;
    protected char estadoActual;
    private int edad;
    /**
     * Constructor for objects of class Virus
     */
    public Virus(AutomataCelular ac, int fila, int columna){
        automata=ac;
        this.fila=fila;
        this.columna=columna;
        estadoActual=MUERTA;
        edad=1;
        color=Color.pink;
        automata.setElemento(fila,columna,(Elemento)this);
    }
    
    public int getFila(){
        return fila;
    }
    
    public int getColumna(){
        return columna;
    }
    
    public final Color getColor(){
        return color;
    }
    
    public int getForma(){
        return 2;
    }
    
    public void decida(){
        edad++;
    }
    
    public final void cambie(){
        if(edad>5 && automata.getElemento(fila,columna+1)==null){
            if(columna<19){
                Virus hijo = new Virus(automata,fila,columna+1);
            }
        }
    }

    /**
     * Este metodo nos devuelve el tipo de el elemento
     */
    @Override
    public String getTipo(){
        return "Virus";
    }
}
