package src.aplicacion;

import java.awt.Toolkit;
import javax.swing.*;
import java.awt.*;
/**
 * Esta clase es la encargada de controlar el juego
 */
public class Poong {
    /**
     * Este es el constructor de la clase
     */
    private Pelota pelota;
    private Raqueta raqueta1;
    private Raqueta raqueta2;
    public Poong(){
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        pelota = new Pelota(0,0);
        raqueta1 = new Raqueta(8,100);
        raqueta2 = new Raqueta((int)d.getWidth()/2+9,100);
    }

    public void move(){
        pelota.mover(choque(raqueta1.getRaqueta()),choque(raqueta2.getRaqueta()));
        raqueta1.moveR1();
        raqueta2.moveR2();
    }

    private boolean choque(Rectangle r){
        return pelota.getPelota().intersects(r);    
    }

    public Pelota getPelota(){
        return pelota;
    }

    public Raqueta getRaquetaUno(){
        return raqueta1;
    }

    public Raqueta getRaquetaDos(){
        return raqueta2;
    }
}