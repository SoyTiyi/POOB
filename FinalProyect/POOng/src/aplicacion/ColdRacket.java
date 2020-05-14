package src.aplicacion;

import java.io.Serializable;

import javax.swing.ImageIcon;
import src.presentacion.*;
/**
 * Permite que la raqueta del jugador que le pegó al poder convertir a la bola
 * en congeladora. De esta forma cuando golpee al jugador rival, este se
 * congelara por 3s
 */
public class ColdRacket extends Premio {

    private static final long serialVersionUID = 1L;
    private TenerImagen imagen = new TenerImagen();

    /**
     * Este es el constructor de la clase ColdRacket
     * @param xPosition
     * @param yPosition
     */
    public ColdRacket(int xPosition, int yPosition) {
        super(xPosition, yPosition);
    }
    
    /**
     * Este metodo nos retorna la imagen del premio
     */
    @Override
    public ImageIcon getImage(){
        ImageIcon image = new ImageIcon(imagen.getClass().getResource("images/cold.png"));
        return image;
    }
}