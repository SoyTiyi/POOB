package src.aplicacion;

import javax.swing.ImageIcon;

/**
 * Aumenta la velocidad de l pelota un 20%
 */
public class Fastball extends Premio{

    private static final long serialVersionUID = 1L;

    public Fastball(int xPosition, int yPosition) {
        super(xPosition, yPosition);
    }
    
    /**
     * Este metodo nos retorna la imagen del premio
     */
    @Override
    public ImageIcon getImage(){
        ImageIcon image = new ImageIcon("C:/Users/santi/Desktop/POOB/FinalProyect/POOng/src/presentacion/images/fastball.png");
        return image;
    }
}