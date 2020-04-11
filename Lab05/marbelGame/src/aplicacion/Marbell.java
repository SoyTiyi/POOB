package aplicacion;

import java.awt.Color;

public class Marbell implements Elemento {
    private int fila,columna;
    private MarbelGame marbelgame;
    private Color color;
    private boolean haveHole;
    public Marbell(MarbelGame marbelgame, int fila, int columna, Color color, boolean haveHole) {
        this.haveHole=haveHole;
        this.fila=fila;
        this.columna=columna;
        this.color=color;
    }

    public void setHaveHole(boolean haveHole){
        this.haveHole=haveHole;
    }
    public int getColumna(){
        return columna;
    }

    public int getFila(){
        return fila;
    }
    @Override
    public Color getColor(){
        return color;
    }

    @Override
    public boolean itsMarbel(){
        return true;
    }

    @Override
    public boolean getHaveHole(){
        return haveHole;
    }

    @Override
    public int getForma(){
        return REDONDA;
    }

}