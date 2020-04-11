package aplicacion;

import java.awt.Color;

public class Hole implements Elemento{
    private int fila;
    private int columna;
    private Color color;
    public Hole(MarbelGame marbelgame, int fila, int columna, Color color){
        this.fila=fila;
        this.columna=columna;
        this.color=color;
    }

    @Override
    public int getForma(){
        return REDONDA;
    }
    public int getFila(){
        return fila;
    }

    public int getColumna(){
        return columna;
    }
    
    @Override
    public Color getColor(){
        return color;
    }

    @Override
    public boolean itsHole(){
        return true;
    }
}