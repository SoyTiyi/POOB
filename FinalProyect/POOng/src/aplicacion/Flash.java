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
}