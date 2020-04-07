package aplicacion;
import java.awt.*;
public class Tablero {
    /**
     * Esta clase nos dibuja el tablero y las fichas que se desean
     */
    private Token[][] mapa;
    private Token[][] mapaHuecos;
    private int tamaño;
    private int cantMarbell;
    private int cantBarrers;
    private Color color;

     public Tablero(int tamaño, int cantMarbell, int cantBarrers, Color color){
        this.tamaño=tamaño;
        this.cantMarbell=cantMarbell;
        this.cantBarrers=cantBarrers;
        this.color=color;
        createTable();
        createTokens();
     }

     /**
      * Este metodo nos crea el tablero dependiendo el tablero
      */
     private void createTable(){
        
     }

     /**
      * Este metodo crea las fichas y las ubica en la matriz mapa
      */
      private void createTokens(){

      }

      /**
       * Este metodo nos mueve todos los marbels dependiendo de la direccion
       * @param direccion
       */
      public void move(char direccion){
         for(int i=0;i<mapa.length;i++){
            for(int j=0;j<mapa.length;j++){
               mapa[i][j].move(direccion);
            }
         }
      }

}