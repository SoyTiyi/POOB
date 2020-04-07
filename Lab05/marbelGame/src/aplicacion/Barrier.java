package aplicacion;

import java.awt.Color;

public class Barrier extends Token {
    /**
     * Este es el constructor del objeto Barrier
     * @param xPosition
     * @param yPosition
     * @param color
     * @param itsMarbell
     */
    public Barrier(int xPosition, int yPosition, Color color, boolean itsMarbell) {
        super(xPosition, yPosition, color, itsMarbell);
    }

}