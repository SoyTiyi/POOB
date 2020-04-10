package aplicacion;

import javafx.scene.paint.Color;

public interface Elemento {
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
}
