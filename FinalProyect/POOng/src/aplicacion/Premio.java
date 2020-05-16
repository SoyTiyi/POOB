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
     * @param xPosition
     * @param yPosition
     */
    public Premio(int xPosition, int yPosition){
        isVisible=true;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    /**
     * Este metodo retorna el premio
     * @return Rectangle
     */
    public Rectangle getPremio(){
        return new Rectangle(xPosition,yPosition,lado,lado);
    }

    /**
     * Este metodo nos retorna la posicion en X
     * @param xPosition
     */
    public int getX(){
        return xPosition;
    }

    /**
     * Este metodo retorna si el premio es visible
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
     * Este metodo nos retorna la posicion en Y 
     * @return yPosition
     */
    public int getY(){
        return yPosition;
    }

    /**
     * Este metodo nos hace set a la posicion en X
     * @param xPosition
     */
    public void setX(int xPosition){
        this.xPosition = xPosition;
    }

    /**
     * Este metodo nos hace set a la posicion en Y
     * @param yPosition
     */
    public void setY(int yPosition){
        this.yPosition = yPosition;
    }

    /**
     * Este metodo nos devuelve la imagen
     * @return ImageIcon es la imagen del objeto
     */
    public ImageIcon getImage(){
        return null;
    }

    /**
     * Este metodo reacciona al tener un choque 
     * @param velocidad
     * @param vida
     */
    public void choque(int velocidad, int vida){
        
    }

    /**
     * Este metodo devuelve la nueva velocidad
     * @return velocidad
     */
    public int getVelocidad(){
        return 5;
    }

    /**
     * Este metodo devuelve la nueva vida de la raqueta
     * @return vida
     */
    public int getVida(){
        return 50;
    }

    /**
     * Este metodo devuelve la nueva resgtriccion al enemigo
     * @return true
     */
    public boolean getRestriccionEnemigo(){
        return true;
    }

    /**
     * Este metodo se encarga de hacernos saber si la velocidad sera progesiva
     * despues del choque con el premio
     * @return velPro
     */
    public boolean getVelocidadProgresiva(){
        return false;
    }

    /**
     * Este metodo nos dice si el enemigo tendra el movimiento lento
     * @return cambiaRaDos
     */
    public boolean getRestriccionMovilidad(){
        return false;
    }

    /**
     * Este metodo nos actualiza los valores dependiendo del premio golpeado
     */
    public void actualizar(){

    }

    /**
     *  Este metodo nos retorna si la raqueta gana inmunidad al golperar el premio
     */
    public boolean getInmunidad(){
        return false;
    }
}