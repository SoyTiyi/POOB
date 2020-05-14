package src.aplicacion;
import java.awt.event.*;

/**
 * Esta clase nos permitira crear los eventos de las teclas oprimidas
 */
public class EventoTeclado extends KeyAdapter{

    public static boolean w, s, up, down;

    /**
     * Este metodo nos dice si se oprime alguna tecla
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e){
        int id = e.getKeyCode();
        if(id == KeyEvent.VK_W){
            w=true;
        }

        if(id == KeyEvent.VK_S){
            s=true;
        }

        if(id == KeyEvent.VK_UP){
            up=true;
        }

        if(id == KeyEvent.VK_DOWN){
            down=true;
        }
    }

    /**
     * Este metodo nos dice si una tecla se dejo de oprimir y cambia su estado
     * @param e 
     */
    @Override
    public void keyReleased(KeyEvent e){
        int id = e.getKeyCode();
        if(id == KeyEvent.VK_W){
            w=false;
        }

        if(id == KeyEvent.VK_S){
            s=false;
        }

        if(id == KeyEvent.VK_UP){
            up=false;
        }

        if(id == KeyEvent.VK_DOWN){
            down=false;
        }

    }
}