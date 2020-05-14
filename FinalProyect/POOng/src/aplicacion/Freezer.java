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

    /**
     * Este es el constructor de la clase Freezer
     * @param xPosition
     * @param yPosition
     */
    public Freezer(int xPosition, int yPosition) {
        super(xPosition, yPosition);
    }

    /**
     * Este metodo nos retorna la imagen del premio}
     * @return ImageIcon es la imagen del objeto
     */
    @Override
    public ImageIcon getImage(){
        ImageIcon image = new ImageIcon(imagen.getClass().getResource("images/freezer.png"));
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
     * Este metodo actualiza los valores dependiendo del premio
     */
    @Override
    public void actualizar(){
        cambiaRaDos=false;
    }

    /**
     * Este metodo retorna la velocidad 
     * @return velocidad
     */
    @Override
    public int getVelocidad(){
        return velocidad;
    }

    /**
     * Este metodo retorna la nueva vida del jugador que la golpeo
     * @return vida
     */
    @Override
    public int getVida(){
        return vida;
    }

    /**
     * Este metodo devuelve un booleano que dice si el contricante puede inmovilizado
     * @return cambiaRaDos
     */
    @Override
    public boolean getRestriccionEnemigo(){
        return cambiaRaDos;
    }
}