package aplicacion;

import java.awt.Color;

public class Marbel extends Token {

    /**
     * Este es el constructo para el objeto Marbel
     * @param xPosition
     * @param yPosition
     * @param color
     * @param itsMarbell
     */
    public Marbel(int xPosition, int yPosition, Color color, boolean itsMarbell) {
        super(xPosition, yPosition, color, itsMarbell);
    }

    /**
     * Este metodo mueve la marbel dependiendo de la direccion
     */
    public void move(char direccion){
        if(direccion == 'N'){

        }
        else if(direccion == 'S'){

        }
        else if(direccion == 'E'){

        }
        else{

        }
    }
}

