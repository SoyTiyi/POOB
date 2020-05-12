package src.aplicacion;

import javax.swing.ImageIcon;
import src.presentacion.*;
/**
 * Aumenta la velocidad de l pelota un 20%
 */
public class Fastball extends Premio{

    private static final long serialVersionUID = 1L;
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
}