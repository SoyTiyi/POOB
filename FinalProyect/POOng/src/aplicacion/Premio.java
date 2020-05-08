package src.aplicacion;

import java.awt.*;
import java.io.Serializable;

import javax.swing.ImageIcon;
/**
 * Este metodo nos crea los premios para el juego
 */
public class Premio implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private int xPosition;
    private int yPosition;
    private final int lado=20;
    private boolean isVisible;
    /**
     * Este es el constructor de la clase
     */
    public Premio(int xPosition, int yPosition){
        isVisible=true;
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
     * Este metodo retorna si el premio es visible
     * @return
     */
    public boolean getVisible(){
        return isVisible;
    }

    /**
     * Este metodo le hace set al parametro isVisible
     */
    public void setVisible(boolean isVisible){
        this.isVisible=isVisible;
    }

    /**
     * Este metodo nos retorna la posicion en Y 
     */
    public int getY(){
        return yPosition;
    }

    /**
     * Este metodo nos hace set a la posicion en X
     */
    public void setX(int xPosition){
        this.xPosition = xPosition;
    }

    /**
     * Este metodo nos hace set a la posicion en Y
     */
    public void setY(int yPosition){
        this.yPosition = yPosition;
    }

    /**
     * Este metodo nos devuelve la imagen
     */
    public ImageIcon getImage(){
        return null;
    }

    /**
     * Este metodo reacciona al tener un choque 
     */
    public void choque(){
        
    }
}