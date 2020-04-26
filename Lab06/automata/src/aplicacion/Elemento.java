package aplicacion;
import java.awt.Color;

public interface Elemento{ 
  int REDONDA = 1;
  int CUADRADA = 2;
  
  default void decida(){
  };
   
  default void cambie(){
  };

  default int getFila(){
    return 10;
  }
  
  default int getColumna(){
    return 10;
  }
  
  default int getForma(){
      return REDONDA;
  }
  
  Color getColor();
  
  default boolean isVivo(){
      return false;
  }
  
  default String getTipo(){
    return "Celula";
  }
}
