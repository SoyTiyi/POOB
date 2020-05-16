package src.aplicacion;

import javax.swing.ImageIcon;

import src.presentacion.*;
public class ExamSorpresa extends Premio{

    /**
     * Esta clase es la encargada de describir el comportamiento de la nueva sorpresa del examen
     */
    private static final long serialVersionUID = 1L;
    private boolean cambiaRaDos=true;
    private int velocidad=5;
    private int vida;
    private boolean inmunidad;
    private TenerImagen imagen = new TenerImagen();
    /**
     *  Este es el constructor de la clase
     * @param xPosition
     * @param yPosition
     */
    public ExamSorpresa(int xPosition, int yPosition) {
        super(xPosition, yPosition);
    }

    /**
     * Este metodo nos retorna la imagen del premio
     * @return ImageIcon, que es la imagen del objeto
     */
    @Override
    public ImageIcon getImage(){
        ImageIcon image = new ImageIcon(imagen.getClass().getResource("images/exam.png"));
        return image;
    }
    
    /**
     * Este metodono nos evalua las ventajas de golpear el premio
     * @param velocidad
     * @param vida
     */
    @Override
    public void choque(int velocidad, int vida){
        this.vida=vida;
        this.velocidad=velocidad;
        actualizar();
    }

    /**
     * Este metodo actualzia los valores dependiendo del premio
     */
    @Override
    public void actualizar(){
        inmunidad=true;
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
     * Este metodo retorna la nueva vida del jugador que la golpeo
     * @return vida nueva
     */
    @Override
    public int getVida(){
        return vida;
    }

    /**
     * Este metodo devuelve un biileano que dice si el contricante puede estar inmovilixado
     * @return cambiaRaDos;
     */
    @Override
    public boolean getRestriccionEnemigo(){
        return cambiaRaDos;
    }

    /**
     * Este merodo nos retorna si la raqueta al golpear el premio gana inmunidad
     */
    public boolean getInmunidad(){
        return inmunidad;
    }
}  