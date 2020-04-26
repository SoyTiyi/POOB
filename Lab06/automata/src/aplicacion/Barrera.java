package aplicacion;

import java.awt.Color;

/**
 * Write a description of class Barrera here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Barrera implements Elemento {
    private static final long serialVersionUID = 1L;
    /**
     * Constructor for objects of class Barrera
     */
    private int fila, columna;
    private final static char MUERTA='m';
    protected char estadoActual;
    protected char estadoSiguiente;
    private AutomataCelular automata;
    private int edad;
    protected Color color;
    public Barrera(AutomataCelular ac, int fila, int columna) {
        automata = ac;
        this.fila = fila;
        this.columna = columna;
        estadoActual = MUERTA;
        estadoSiguiente = MUERTA;
        edad=0;
        automata.setElemento(fila, columna, (Elemento)this);
        color=Color.green;
    }

    public int getForma() {
        return 2;
    }

    /**
     * Este metodo nos devuelve el tipo de este elemento
     */
    @Override
    public String getTipo() {
        return "Barrera";
    }

    @Override
    public Color getColor() {
        return color;
    }

    public final boolean isVisvo(){
        return false;
    }

    public final int edad(){
        return edad;
    }
    @Override
    public String toString(){
        return getTipo()+" "+getFila()+" "+getColumna();
    }
}
