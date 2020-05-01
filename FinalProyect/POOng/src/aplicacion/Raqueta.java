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
    private final int limiteY=Toolkit.getDefaultToolkit().getScreenSize().height/2-58;
    /**
     * Este es el constructor de muestra clase raqueta
     */
    public Raqueta(int x, int y){
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
        if(EventoTeclado.w && y>0){
            y--;
        }

        if(EventoTeclado.s && y<limiteY){
            y++;
        }
        
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    /**
     * Este metodo maneja la logica del movimiento de la raqueta2
     */
    public void moveR2(){
        if(EventoTeclado.up && y>0){
            y--;
        }

        if(EventoTeclado.down && y<limiteY){
            y++;
        }
    }
}