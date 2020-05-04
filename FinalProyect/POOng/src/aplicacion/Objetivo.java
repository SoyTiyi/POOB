package src.aplicacion;

import java.awt.*;
/**
 * Este metodo nos crea los objetivos los cuales nos dan mas puntos 
 */
public class Objetivo{
    
    private int xPosition;
    private int yPosition;
    private final int ANCHO=5;
    private final int ALTO=10;

    /**
     * Este es el constructor de la clase
     */
    public Objetivo(int xPosition, int yPosition){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    /**
     * Este metodono nos retorna el objetivo
     */
    public Rectangle getObjetivo(){
        return new Rectangle(xPosition,yPosition,ANCHO,ALTO);
    }

    /**
     * Este metodo nos prepara el tiempo random de los objetivos
     */
    public void prepareObjetivos(){

    }
    /**
     * Este metodo nos retorna la posicion en X
     */
    public int getX(){
        return xPosition;
    }

    /**
     * Este metodo nos retorna la posicion en Y
     */
    public int getY(){
        return yPosition;
    }
}