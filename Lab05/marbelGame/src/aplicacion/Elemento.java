package aplicacion;

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
}
