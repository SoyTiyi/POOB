package src.aplicacion;

import javax.swing.ImageIcon;

/**
 * Congela al jugador rival por un tiempo de 2s
 */
public class Freezer extends Premio{

    private static final long serialVersionUID = 1L;

    public Freezer(int xPosition, int yPosition) {
        super(xPosition, yPosition);
    }

    /**
     * Este metodo nos retorna la imagen del premio
     */
    @Override
    public ImageIcon getImage(){
        ImageIcon image = new ImageIcon("C:/Users/santi/Desktop/POOB/FinalProyect/POOng/src/presentacion/images/freezer.png");
        return image;
    }
    
}