package src.aplicacion;
import java.awt.*;
import java.io.Serializable;

/**
 * Esta es la clase encargada para crear el objeto bloque
 */
public class Bloque implements Serializable{

    private static final long serialVersionUID = 1L;
    private int xPosition;
    private int yPosition;
    private boolean isVisible;
    private final int limiteX=Toolkit.getDefaultToolkit().getScreenSize().width/2+35;
    /**
     * Este es el constructor de la clase
     */
    public Bloque(int xPosition, int yPosition){
        isVisible=false;
        this.xPosition=xPosition;
        this.yPosition=yPosition;
    }

    /**
     * Este metodo nos retorna el rectangulo del bloque
     */
    public Rectangle getBloque(){
        return new Rectangle(xPosition,yPosition,10,20);
    }

    /**
     * Este metodo retorna la posicion en X
     */
    public int getX(){
        return xPosition;
    }

    /**
     * Este metodo retorna la posicion en Y
     */
    public int getY(){
        return yPosition;
    }

    /**
     * Este metodo le hace set en la posicion X
     */
    public void setX(int xPosition){
        this.xPosition=xPosition;
    }

    /**
     * Este metodo le hace set en la posicion Y
     */
    public void setY(int yPosition){
        this.yPosition=yPosition;
    }

    /**
     * Este metodo retorna si el objeto es visible
     */
    public boolean getVisible(){
        return isVisible;
    }

    /**
     * Este metodo le hace set a la variable isVisible
     */
    public void setVisible(boolean isVisible){
        this.isVisible=isVisible;
    }

    /**
     * Este metodo mueve los bloques 
     */
    public void move(int num){
        if(num==1){
            if(xPosition<limiteX){
                xPosition+=1;
            }
            else{
                isVisible=false;
            }
        }
        else{
            if(xPosition>0){
                xPosition-=1;
            }
            else{
                isVisible=false;
            }
        }
    }
}