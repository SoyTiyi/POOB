package aplicacion;

import javafx.scene.paint.Color;

public class Hole implements Elemento{
    private int fila;
    private int columna;
    private MarbelGame marbelgame;
    private Color color;
    public Hole(MarbelGame marbelgame, int fila, int columna, Color color){
        this.marbelgame=marbelgame;
        this.fila=fila;
        this.columna=columna;
        this.color=color;
    }

    public int getFila(){
        return fila;
    }

    public int getColumna(){
        return columna;
    }

    public Color getColor(){
        return color;
    }

    @Override
    public boolean itsHole(){
        return true;
    }
}