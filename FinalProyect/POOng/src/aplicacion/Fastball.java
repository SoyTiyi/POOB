package src.aplicacion;

import javax.swing.ImageIcon;
import src.presentacion.*;
/**
 * Aumenta la velocidad de l pelota un 20%
 */
public class Fastball extends Premio{

    private static final long serialVersionUID = 1L;
    private int vida;
    private int velocidad=5;
    private boolean cambioRaDos=true;
    private TenerImagen imagen = new TenerImagen();

    public Fastball(int xPosition, int yPosition) {
        super(xPosition, yPosition);
    }
    
    /**
     * Este metodo nos retorna la imagen del premio
     */
    @Override
    public ImageIcon getImage(){
        ImageIcon image = new ImageIcon(imagen.getClass().getResource("images/fastball.png"));
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
     * Este metodo nos actualiza los valores dependiendo delp premio
     */
    private void actualizar(){
        velocidad-=velocidad*0.2;    
    }

    /**
     * Este metodo nos retorna la velocidad
     */
    @Override
    public int getVelocidad(){
        return velocidad;
    }

    /**
     * Este metodo nos retorna la nueva vida del jugador que la golpio
     */
    @Override
    public int getVida(){
        return vida;
    }

    /**
     * Este metodo devuelve un vooleano que dice si el contricante esta inmovilizado
     */
    @Override
    public boolean getRestriccionEnemigo(){
        return cambioRaDos;
    }
}