package src.aplicacion;

import java.awt.*;
import java.io.Serializable;
/**
 * Este metodo nos crea los objetivos los cuales nos dan mas puntos 
 */
public class Objetivo implements Serializable{

    private static final long serialVersionUID = 1L;
    private int xPosition;
    private int yPosition;
    private final int ANCHO=5;
    private final int ALTO=10;
    private boolean isVisible;

    /**
     * Este es el constructor de la clase
     * @param xPosition
     * @param yPosition
     */
    public Objetivo(int xPosition, int yPosition){
        isVisible=true;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    /**
     * Este metodo retorna el parametro isVisible
     * @return isVisible
     */
    public boolean getVisible(){
        return isVisible;
    }

    /**
     * Este metodo le hace set al parametro isVisible
     * @param isVisible
     */
    public void setVisible(boolean isVisible){
        this.isVisible=isVisible;
    }

    /**
     * Este metodono nos retorna el objetivo
     * @return Rectangle
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
     * @return xPosition
     */
    public int getX(){
        return xPosition;
    }

    /**
     * Este metodo nos retorna la posicion en Y
     * @return yPosition
     */
    public int getY(){
        return yPosition;
    }

    /**
     * Este emetodo hace set a la posicion en Y
     * @param yPosition
     */
    public void setY(int yPosition){
        this.yPosition=yPosition;
    }

    /**
     * Estre metodo hace set a la posicion en X
     * @param xPosition
     */
    public void setX(int xPosition){
        this.xPosition=xPosition;
    }
}