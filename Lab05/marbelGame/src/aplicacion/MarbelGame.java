package aplicacion;
import java.awt.*;
public class MarbelGame {

    /**
     * Esta clase se encarga de implementar la logica detras del juego
     */
    private int tamaño;
    private int cantMarbel;
    private int cantBarrier;
    private Color color;
    private Tablero tablero;
     /**
      * Este es el constructor para la clase MarbelGame
      */
     public MarbelGame(int tamaño, int cantMarbel, int cantBarrier, Color color){
        this.tamaño=tamaño;
        this.cantMarbel=cantMarbel;
        this.cantBarrier=cantBarrier;
        this.color=color;
        tablero = new Tablero(tamaño,cantMarbel, cantBarrier, color);
     }

     /**
      * Este metodo nos mueve el tablero dependiendo a donde se levante 
      * @param letter, hace referencia a las cordenadas ya sea Norte(N), Sur(S), Este(E) y Oeste(O)
      */
     public void move(char letter){

     }

     /**
      * Este metodo actualiza el tablero dependiendo de el movimiento que se haya hecho antes
      */
     public void refresque(){
         
     }
}