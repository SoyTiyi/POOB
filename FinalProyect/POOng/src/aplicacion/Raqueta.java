package src.aplicacion;
import java.awt.*;
import java.io.Serializable;
/**
 * Este clase nos crea las raquetas de juego
 */
public class Raqueta implements Serializable {

    private static final long serialVersionUID = 1L;
    private int x;
    private int y;
    private final int ANCHO=25;
    private final int ALTO=80;
    private boolean canMove;
    private final int limiteY=Toolkit.getDefaultToolkit().getScreenSize().height/2-58;
    private int vida=100;
    private int cont=0;
    private int espera=0;
    /**
     * Este es el constructor de muestra clase raqueta
     */
    public Raqueta(int x, int y){
        canMove=true;
        this.x=x;
        this.y=y;
    }

    /**
     * Este metodo detorna un elemento de tipo raqueta
     * @return
     */
    public Rectangle getRaqueta(){
        return new Rectangle(x,y,ANCHO,ALTO);
    }

    /**
     * Este metodo maneja la logica del movimiento de la raqueta1
     */
    public void moveR1(){
        if(canMove){
            if(cont==20){
                vida--;
                cont=0;
            }
    
            if(EventoTeclado.w && y>0){
                cont++;
                y--;
            }
    
            if(EventoTeclado.s && y<limiteY){
                cont++;
                y++;
            }
        }
        else{
            if(espera==2000){
                espera=0; canMove=true;
            }
            else{
                espera++;
            }
        }
    }

    /**
     * Este metodo devuelve la posicion en X de la raqueta
     * @return x
     */
    public int getX(){
        return x;
    }

    /**
     * Este metodo devuelve la posicion en Y de la raqueta
     * @return y
     */
    public int getY(){
        return y;
    }

    /**
     * Este metodo maneja la logica del movimiento de la raqueta2
     */
    public void moveR2(){

        if(canMove){
            if(cont==40){
                vida--;
                cont=0;
            }
    
            if(EventoTeclado.up && y>0){
                cont++;
                y--;
            }
    
            if(EventoTeclado.down && y<limiteY){
                cont++;
                y++;
            }
        }
        else{
            if(espera==2000){
                espera=0; canMove=true;
            }
            else{
                espera++;
            }
        }
    }

    /**
     * Este metodo nos dice si es posible que la raqueta que se mueva
     */
    public boolean getMove(){
        return canMove;
    }

    /**
     * Este metodo le hace set a la variable canMove
     */
    public void setMove(boolean canMove){
        this.canMove=canMove;
    }

    /**
     * Este metodo devuelve la vida de la primera raqueta
     */
    public int getVida(){
        return vida;
    }

    /**
     * Este metodo le hace set a la vida
     */
    public void setVida(int vida){
        this.vida=vida;
    }

    /**
     * Este metodo le resta o suma vida a la raqueta
     */
    public void sumVida(int vida){
        this.vida+=vida;
    }
}