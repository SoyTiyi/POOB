package aplicacion;
import java.awt.*;

public class Token {
    /**
     * Esta clase nos crea las fichas que pueden ir en el tablero
     * ya sea una barrer o una marbell, como atriburos necesarios
     */
    protected int xPosition;
    protected int yPosition;
    protected Color color;
    private final Color colorBarrera = Color.black;
    /**
     * Este es el constructor para crear la ficha deseada
     * @param xPosition
     * @param yPosition
     * @param color
     * @param itsMarbell
     */
    public Token(int xPosition, int yPosition, Color color, boolean itsMarbell){
        this.xPosition=xPosition;
        this.yPosition=yPosition;
        if(itsMarbell){
            this.color=color;
        }
        else{
            this.color=colorBarrera;
        }
    }

    /**
     * Este metodo mueve la ficha, se debe de implementar cuando es marbell
     * @param direccion, hace referencia a la direccion en donde se mueve las marbell
     */
    public void move(char direccion){

    }

}