package aplicacion;

import javafx.scene.paint.Color;

public class Marbell implements Elemento {
    private int fila,columna;
    private MarbelGame marbelgame;
    private Color color;
    public Marbell(MarbelGame marbelgame, int fila, int columna, Color color) {
        this.fila=fila;
        this.columna=columna;
        this.color=color;
    }

    public int getColumna(){
        return columna;
    }

    public int getFila(){
        return fila;
    }

    public Color getColor(){
        return color;
    }

    @Override
    public boolean itsMarbel(){
        return true;
    }

}