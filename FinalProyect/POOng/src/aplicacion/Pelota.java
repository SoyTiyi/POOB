package src.aplicacion;
import java.awt.*;


/**
 * Este metodo nos crea una pelota, la idea es qu extienda
 */
public class Pelota {

    private int x;
    private int y;
    private int dx=1;
    private int dy=1;
    private final int limiteX=Toolkit.getDefaultToolkit().getScreenSize().width/2+50;
    private final int limiteY=Toolkit.getDefaultToolkit().getScreenSize().height/2+50;;
    private final int ANCHO=15, ALTO=15;
    public Pelota(int x, int y){
        this.x=x;
        this.y=y;
    }

    public Rectangle getPelota(){
        return  new Rectangle(x,y,ANCHO,ALTO);
    }

    public void mover(){
        x+=dx;
        y+=dy;
        if(x > limiteX){
            dx=-dx;
        }
        if(x == 0){
            dx=-dx;
        }
        if(y > limiteY){
            dy=-dy;
        }
        if(y == 0){
            dy=-dy;
        }
        
    }
}