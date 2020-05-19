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
    private int velocidad;
    private int vida;
    private boolean phantom;

    /**
     * Este es el constructor del Objeto Phantom
     * @param xPosition
     * @param yPosition
     */
    public Phantom(int xPosition, int yPosition) {
        super(xPosition, yPosition);
    }

    /**
     * Este metodo nos retorna la imagen del premio
     * @return ImageIcon es la imagen del objeto
     */
    @Override
    public ImageIcon getImage(){
        ImageIcon image = new ImageIcon(imagen.getClass().getResource("images/phantom.png"));
        return image;
    }

    /**
     * Este metodo nos evalua las ventajas de golpear el premio
     * @param velocidad
     * @param vida
     */
    @Override 
    public void choque(int velocidad, int vida){
        this.velocidad=velocidad;
        this.vida=vida;
        actualizar();
    }

    /**
     * Este metodo nos actualiza los valores dependiendo del premio
     */
    @Override
    public void actualizar(){
        phantom=true;
    }
    
    /**
     * Este metodo nos retorna la velocidad
     * @return velocidad
     */
    @Override
    public int getVelocidad(){
        return velocidad;
    }

    /**
     * Este metodo nos retorna la nueva vida del jugador que la polpeo
     * @return vida
     */
    @Override
    public int getVida(){
        return vida;
    }

    /**
     * Este metodo devuelve un booleano que dice si el contricante esta inmovilizado
     * @return cambiaRaDos
     */
    public boolean getRestriccionEnemigo(){
        return true;
    }

    /**
     * Este metodo nos indica si tiene la pelota la ventaja de fantasma
     * @return phantom
     */
    @Override
    public boolean getPhantom(){
        return phantom;
    }
}