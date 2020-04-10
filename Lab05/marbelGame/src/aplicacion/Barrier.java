package aplicacion;

import javafx.scene.paint.Color;

public class Barrier implements Elemento {
    private int fila, columna;
    private MarbelGame marbelgame;
    private Color color;
    public Barrier (MarbelGame marbelgame,int fila, int columna, Color color){
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
    @Override
    public Color getColor(){
        return color;
    }

    @Override
    public boolean itsBarrier(){
        return true;
    }
}