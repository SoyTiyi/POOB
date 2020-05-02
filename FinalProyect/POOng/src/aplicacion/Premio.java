package src.aplicacion;

import java.awt.*;
/**
 * Este metodo nos crea los premios para el juego
 */
public class Premio{
    
    private int xPosition;
    private int yPosition;
    private final int lado=20;

    /**
     * Este es el constructor de la clase
     */
    public Premio(int xPosition, int yPosition){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    /**
     * Este metodo retorna el premio
     */
    public Rectangle getPremio(){
        return new Rectangle(xPosition,yPosition,lado,lado);
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