package aplicacion;

import java.awt.*;

public interface Elemento {
    int REDONDA=1;
    int CUADRADA=2;
    default boolean itsMarbel(){
        return false;
    }

    default boolean itsBarrier(){
        return false;
    }

    default boolean itsHole(){
        return false;
    }

    default void move(char direccion){

    }
    default Color getColor(){
        return Color.BLACK;
    }

    default void setHaveHole(boolean haveHole){

    }

    default boolean getHaveHole(){
        return false;
    }

    default int getForma(){
        return REDONDA;
    }
}
