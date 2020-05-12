package src.aplicacion;

import javax.swing.ImageIcon;
import src.presentacion.*;
/**
 * Hace que el jugador contraria se mueva más despacio por un tiempo de 3s
 */
public class Turtle extends Premio{

    private static final long serialVersionUID = 1L;
    private TenerImagen imagen = new TenerImagen();


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
}