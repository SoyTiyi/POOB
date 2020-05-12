package src.aplicacion;

import javax.swing.ImageIcon;
import src.presentacion.*;
/**
 * Congela al jugador rival por un tiempo de 2s
 */
public class Freezer extends Premio{

    private static final long serialVersionUID = 1L;
    private boolean cambiaRaDos;
    private int velocidad=5;
    private int vida;
    private TenerImagen imagen = new TenerImagen();

    public Freezer(int xPosition, int yPosition) {
        super(xPosition, yPosition);
    }

    /**
     * Este metodo nos retorna la imagen del premio
     */
    @Override
    public ImageIcon getImage(){
        ImageIcon image = new ImageIcon(imagen.getClass().getResource("images/freezer.png"));
        return image;
    }

    /**
     * Este metodo nos evalua las ventajas de golperar el premio
     */
    @Override
    public void choque(int velocidad, int vida){
        this.vida=vida;
        this.velocidad=velocidad;
        actualizar();
    }

    /**
     * Este metodo actualiza los valores dependiendo del premio
     */
    private void actualizar(){
        cambiaRaDos=false;
    }

    /**
     * Este merodo retorna la velocidad 
     */
    @Override
    public int getVelocidad(){
        return velocidad;
    }

    /**
     * Este metodo retorna la nueva vida del jugador que la golpio
     */
    @Override
    public int getVida(){
        return vida;
    }

    /**
     * Este metodo devuelve un booleano que dice si el contricante puede moverse
     */
    @Override
    public boolean getRestriccionEnemigo(){
        return cambiaRaDos;
    }
}