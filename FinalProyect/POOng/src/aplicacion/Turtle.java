package src.aplicacion;

import javax.swing.ImageIcon;

/**
 * Hace que el jugador contraria se mueva más despacio por un tiempo de 3s
 */
public class Turtle extends Premio{

    private static final long serialVersionUID = 1L;

    public Turtle(int xPosition, int yPosition) {
        super(xPosition, yPosition);
    }
    
    /**
     * Este metodo nos retorna la imagen del premio
     */
    @Override
    public ImageIcon getImage(){
        ImageIcon image = new ImageIcon("C:/Users/santi/Desktop/POOB/FinalProyect/POOng/src/presentacion/images/turtle.png");
        return image;
    }
}