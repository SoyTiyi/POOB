package src.aplicacion;
import src.presentacion.*;

/**
 * Esta clase es la encargada de manejar el juego POONG
 */
public class Poong {

    public Poong(){

    }



    public static void main(String[] args){
        ZonaDeJuego ventana = new ZonaDeJuego("Normal");
        ventana.setVisible(true);
    }

}