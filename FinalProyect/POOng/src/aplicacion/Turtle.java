package src.aplicacion;

import javax.swing.ImageIcon;
import src.presentacion.*;
/**
 * Hace que el jugador contraria se mueva más despacio por un tiempo de 3s
 */
public class Turtle extends Premio{

    private static final long serialVersionUID = 1L;
    private TenerImagen imagen = new TenerImagen();
    private int vida;
    private int velocidad=5;
    private boolean cambioRaDos=true;
    private boolean restMovilidad;
    public Turtle(int xPosition, int yPosition) {
        super(xPosition, yPosition);
    }
    
    /**
     * Este metodo nos retorna la imagen del premio
     */
    @Override
    public ImageIcon getImage(){
        ImageIcon image = new ImageIcon(imagen.getClass().getResource("images/turtle.png"));
        return image;
    }

    /**
     * Este metodo nos evalua las ventajas de golpear el premio
     */
    @Override
    public void choque(int velocidad, int vida){
        this.vida=vida;
        this.velocidad=velocidad;
        actualizar();
    }

    /**
     * Este metodo nos actualiza los valores dependiendo del premio
     */
    private void actualizar(){
        restMovilidad=true;
    }

    /**
     * Este metodo nos retorna la velocidad
     */
    @Override
    public int getVelocidad(){
        return velocidad;
    }

    /**
     * Este metodo nos retorna la nueva vida del jugador que la golpeo
     */
    @Override
    public int getVida(){
        return vida;
    }

    /**
     * Este metodo devuelve un boolrano que dice si el contricante esta inmoviliado
     */
    @Override
    public boolean getRestriccionEnemigo(){
        return cambioRaDos;
    }

    /**
     * Este metodo nos dice si el enemigo tendra el movimiento lento
     */
    @Override
    public boolean getRestriccionMovilidad(){
        return restMovilidad;
    }
}