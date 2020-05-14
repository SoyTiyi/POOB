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

    /**
     * Este es el constructor de la clase Turtle
     * @param xPosition
     * @param yPosition
     */
    public Turtle(int xPosition, int yPosition) {
        super(xPosition, yPosition);
    }
    
    /**
     * Este metodo nos retorna la imagen del premio
     * @return ImageIcon es la imagen dle objeto
     */
    @Override
    public ImageIcon getImage(){
        ImageIcon image = new ImageIcon(imagen.getClass().getResource("images/turtle.png"));
        return image;
    }

    /**
     * Este metodo nos evalua las ventajas de golpear el premio
     * @param velocidad
     * @param vida
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
    @Override
    public void actualizar(){
        restMovilidad=true;
    }

    /**
     * Este metodo nos retorna la velocidad
     * @return velocidad
     */
    @Override
    public int getVelocidad(){
        return velocidad;
    }

    /**
     * Este metodo nos retorna la nueva vida del jugador que la golpeo
     * @return vida
     */
    @Override
    public int getVida(){
        return vida;
    }

    /**
     * Este metodo devuelve un boolrano que dice si el contricante esta inmoviliado
     * @return cambiaRaDos
     */
    @Override
    public boolean getRestriccionEnemigo(){
        return cambioRaDos;
    }

    /**
     * Este metodo nos dice si el enemigo tendra el movimiento lento
     * @return restMovilidad
     */
    @Override
    public boolean getRestriccionMovilidad(){
        return restMovilidad;
    }
}