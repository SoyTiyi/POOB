package src.aplicacion;

import javax.swing.ImageIcon;

/**
 * Permite que la raqueta del jugador que le pegó al poder convertir a la bola
 * en congeladora. De esta forma cuando golpee al jugador rival, este se
 * congelara por 3s
 */
public class ColdRacket extends Premio{

    private static final long serialVersionUID = 1L;

    public ColdRacket(int xPosition, int yPosition) {
        super(xPosition, yPosition);
    }
    
    /**
     * Este metodo nos retorna la imagen del premio
     */
    @Override
    public ImageIcon getImage(){
        ImageIcon image = new ImageIcon("C:/Users/santi/Desktop/POOB/FinalProyect/POOng/src/presentacion/images/cold.png");
        return image;
    }
}