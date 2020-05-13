package src.aplicacion;

import javax.swing.ImageIcon;
import src.presentacion.*;
/**
 * Acela la pelota hasta que el jugador contrario la devuelva o la deje ir.
 * Luego de eso seguirá teniendo la velocidad que tenia antesde ser ralentizada
 */
public class Flash extends Premio{

    private static final long serialVersionUID = 1L;
    private TenerImagen imagen = new TenerImagen();
    private int vida;
    private int velocidad;
    private boolean veloPro;
    private boolean cambiaRaDos=true;
    public Flash(int xPosition, int yPosition) {
        super(xPosition, yPosition);
    }
    
    /**
     * Este metodo nos retorna la imagen del premio
     */
    @Override
    public ImageIcon getImage(){
        ImageIcon image = new ImageIcon(imagen.getClass().getResource("images/flash.png"));
        return image;
    }

    /**
     * Este netodo nos evalua las ventajas de golpear el premio
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
        veloPro=true;
    }

    /**
     * Este metodo retorna la velocidad
     */
    @Override
    public int getVelocidad(){
        return velocidad;
    }

    /**
     * Este metodo retorna la nueva vida del jugador que la polpeo
     */
    @Override
    public int getVida(){
        return vida;
    }
    /**
     * Este metodo debuelve un booleano que dice si el contricante puede moverse
     */
    @Override
    public boolean getRestriccionEnemigo(){
        return cambiaRaDos;
    }

    /**
     * Este metodo se encarga de hacernos saber si la velocidad sera progresiva
     * despues del choque con el premio
     */
    @Override
    public boolean getVelocidadProgresiva(){
        return veloPro;
    }
}