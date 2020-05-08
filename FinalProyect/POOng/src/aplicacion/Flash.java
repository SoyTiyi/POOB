package src.aplicacion;

import javax.swing.ImageIcon;

/**
 * Acela la pelota hasta que el jugador contrario la devuelva o la deje ir.
 * Luego de eso seguirá teniendo la velocidad que tenia antesde ser ralentizada
 */
public class Flash extends Premio{

    private static final long serialVersionUID = 1L;

    public Flash(int xPosition, int yPosition) {
        super(xPosition, yPosition);
    }
    
    /**
     * Este metodo nos retorna la imagen del premio
     */
    @Override
    public ImageIcon getImage(){
        ImageIcon image = new ImageIcon("C:/Users/santi/Desktop/POOB/FinalProyect/POOng/src/presentacion/images/flash.png");
        return image;
    }
}