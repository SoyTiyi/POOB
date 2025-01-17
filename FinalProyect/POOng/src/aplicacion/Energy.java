package src.aplicacion;

import javax.swing.ImageIcon;
import src.presentacion.*;
/**
 * Otroga al jugador el 50% de la fortaleza perdida.
 */
public class Energy extends Premio{

    private static final long serialVersionUID = 1L;
    private boolean cambiaRaDos;
    private int velocidad=5;
    private int vida;
    private TenerImagen imagen = new TenerImagen();

    
    /**
     * Este es el constructor de la Clase Energy 
     * @param xPosition
     * @param yPosition
     */
    public Energy(int xPosition, int yPosition) {
        super(xPosition, yPosition);
    }
    
    /**
     * Este metodo nos retorna la imagen del premio
     * @return ImageIcon, que es la imagen del objeto
     */
    @Override
    public ImageIcon getImage(){
        ImageIcon image = new ImageIcon(imagen.getClass().getResource("images/energy.png"));
        return image;
    }

    /**
     * Este metodo nos evalua las ventajas de golpear el premio
     * @param velocidad
     * @param vida
     */
    @Override 
    public void choque(int velocidad, int vida){
        this.velocidad = velocidad;
        this.vida = vida;
        actualizar();
    }

    /**
     * Este metodo actualiza los valores dependiendo del premio
     */
    @Override
    public void actualizar(){
        if(vida<=50){
            cambiaRaDos=true;
            vida+=vida/2;
        }
        else{
            cambiaRaDos=true;
            vida=100;
        }
    }

    /**
     * Este metodo retorna la velocidad
     * @return velocidad nueva
     */
    @Override
    public int getVelocidad(){
        return velocidad;
    }

    /**
     * Este metodo retorna la nueva vida del jugador que la golpio
     * @return vida nueva
     */
    @Override
    public int getVida(){
        return vida;
    }

    /**
     * Este metodo devuelve un booleao que dice si el contricante puede moverse despues
     * @retrun cambiaRaDos
     */
    @Override
    public boolean getRestriccionEnemigo(){
        return cambiaRaDos;
    }
}