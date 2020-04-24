package src.aplicacion;
import java.awt.*;


/**
 * Este metodo nos crea una pelota, la idea es qu extienda
 */
public class Pelota {

    private int x;
    private int y;
    private int moveX=1;
    private int moveY=1;
    private final int limiteX=Toolkit.getDefaultToolkit().getScreenSize().width/2+35;
    private final int limiteY=Toolkit.getDefaultToolkit().getScreenSize().height/2+2;
    private final int ANCHO=15, ALTO=15;
    public Pelota(int x, int y){
        this.x=x;
        this.y=y;
    }

    public Rectangle getPelota(){
        return  new Rectangle(x,y,ANCHO,ALTO);
    }

    public void mover(boolean choqueUno, boolean choqueDos){
        x+=moveX;
        y+=moveY;
        if(choqueUno){moveX=-moveX; x=35;}
        if(choqueDos){moveX=-moveX; x=675;}
        if(x > limiteX){moveX=-moveX;}
        if(x == 0){moveX=-moveX;}
        if(y > limiteY){moveY=-moveY;}
        if(y == 0){moveY=-moveY;}
        
    }
}