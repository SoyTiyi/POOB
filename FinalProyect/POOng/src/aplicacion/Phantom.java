package src.aplicacion;

import javax.swing.ImageIcon;
import src.presentacion.*;
/**
 * Permite a la raqueta del jugador que le pegó al poder que en su siguiente
 * golpe a la pelota envie dos pelotas. Una pelota fantasma que será falsa y
 * otra que será la real pero invisible. Cuando la bola fantasma pasa al campo
 * rival desaparece y real se hace visible.
 */
public class Phantom extends Premio{

    private static final long serialVersionUID = 1L;
    private TenerImagen imagen = new TenerImagen();

    public Phantom(int xPosition, int yPosition) {
        super(xPosition, yPosition);
    }

    /**
     * Este metodo nos retorna la imagen del premio
     */
    @Override
    public ImageIcon getImage(){
        ImageIcon image = new ImageIcon(imagen.getClass().getResource("images/phantom.png"));
        return image;
    }
    
}