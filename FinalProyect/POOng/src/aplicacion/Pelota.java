package src.aplicacion;
import java.awt.*;
import java.io.Serializable;


/**
 * Este metodo nos crea una pelota, la idea es qu extienda
 */
public class Pelota implements Serializable{

    private static final long serialVersionUID = 1L;
    private int x;
    private int y;
    private int moveX=1;
    private int moveY=1;
    private final int limiteX=Toolkit.getDefaultToolkit().getScreenSize().width/2+35;
    private final int limiteY=Toolkit.getDefaultToolkit().getScreenSize().height/2+2;
    private final int ANCHO=15, ALTO=15;
    private int score1=0, score2=0;

    /**
     * Este es el constructor de la clase pelota
     * @param x
     * @param y
     */
    public Pelota(int x, int y){
        this.x=x;
        this.y=y;
    }

    /**
     * Este metodo retorna la pelota
     */
    public Rectangle getPelota(){
        return  new Rectangle(x,y,ANCHO,ALTO);
    }

    /**
     * Este metodo gestiona el movimiento de la pelota
     */
    public void mover(boolean choqueUno, boolean choqueDos){
        x+=moveX;
        y+=moveY;
        if(choqueUno){moveX=-moveX; x=35;}
        if(choqueDos){moveX=-moveX; x=675;}
        if(x > limiteX ){
            x=300; y=300;
            moveX=-moveX;
            score1+=1;
        }
        if(x < 0){
            x=300; y=300;
            moveX=-moveX;
            score2+=1;
        }
        if(y > limiteY){moveY=-moveY;}
        if(y == 0){moveY=-moveY;}
    }

    /**
     * Este metodo devuelve el puntaje del primer jugador
     */
    public String getScore1(){
        return score1+"";
    }

    /**
     * Este metodo devuelve el puntaje del segundo jugador
     */
    public String getScore2(){
        return score2+"";
    }

    /**
     * Este metodo retorna la posicion x de la pelota
     */
    public void setPositionX(int x){
        this.x=x;
    }

    /**
     * Este metodo devuelve la posicion y de la pelota
     */
    public void setPositionY(int y){
        this.y=y;
    }
}