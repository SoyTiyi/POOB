package src.aplicacion;
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
    private int velocidad;
    private int vida;
    private boolean peloCong;
    private boolean cambiaRaDos=true;

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

    /**
     *  Este metodo nos evalua las ventajas de golperar el premio
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
     * Este metodo actualiza los valores dependiendo del premio
     */
    @Override
    public void actualizar(){
        peloCong=true;
    }

    /**
     * Este metodono retorna la velocidad
     * @return velocidad
     */
    @Override
    public int getVelocidad(){
        return velocidad;
    }

    /**
     * Este metodo retorna la nueva vida del jugador que la golpeo
     * @return vida
     */
    @Override
    public int getVida(){
        return vida;
    }

    /**
     * Este metodo devuevle un booleano que dice si el contricante puede moverse
     * @return cambiaRaDos
     */
    @Override
    public boolean getRestriccionEnemigo(){
        return cambiaRaDos;
    }

    /**
     * Este metodo nos retorna si la pelota puede congelar al jugador
     */
    @Override
    public boolean getCongelacion(){
        return peloCong;
    }
}