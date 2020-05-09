package src.aplicacion;

import javax.swing.ImageIcon;

/**
 * Otroga al jugador el 50% de la fortaleza perdida.
 */
public class Energy extends Premio{

    private static final long serialVersionUID = 1L;
    private boolean cambiaRaDos;
    private int velocidad=5;
    private int vida;

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
    public void choque(int velocidad, int vida){
        this.velocidad = velocidad;
        this.vida = vida;
        actualizar();
    }

    /**
     * Este metodo actualiza los valores dependiendo del premio
     */
    private void actualizar(){
        if(vida<=50){
            vida+=vida/2;
        }
        else{
            vida=100;
        }
    }

    /**
     * Este metodo retorna la velocidad
     */
    @Override
    public int getVelocidad(){
        return velocidad;
    }

    /**
     * Este metodo retorna la nueva vida del jugador que la golpio
     */
    @Override
    public int getVida(){
        return vida;
    }

    /**
     * Este metodo devuelve un booleao que dice si el contricante puede moverse despues
     */
    @Override
    public boolean getRestriccionEnemigo(){
        return cambiaRaDos;
    }
}