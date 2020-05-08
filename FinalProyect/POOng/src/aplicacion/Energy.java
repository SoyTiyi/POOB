package src.aplicacion;

import javax.swing.ImageIcon;

/**
 * Otroga al jugador el 50% de la fortaleza perdida.
 */
public class Energy extends Premio{

    private static final long serialVersionUID = 1L;
    private boolean cambiaVel;
    private boolean cambiaRaUno;
    private boolean cambiaRaDos;

    public Energy(int xPosition, int yPosition) {
        super(xPosition, yPosition);
    }
    
    /**
     * Este metodo nos retorna la imagen del premio
     */
    @Override
    public ImageIcon getImage(){
        ImageIcon image = new ImageIcon("C:/Users/santi/Desktop/POOB/FinalProyect/POOng/src/presentacion/images/energy.png");
        return image;
    }

    /**
     * Este metodo nos evalua las ventajas de golpear el premio
     */
    @Override 
    public void choque(){

    }
}