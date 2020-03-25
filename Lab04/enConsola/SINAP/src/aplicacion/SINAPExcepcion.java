package aplicacion;
public class SINAPExcepcion extends Exception{
    /**
     *Esta clase crea las excepciones para la clase SINAP lo que nos permite reducir errores para el usuario
     */
    private static final long serialVersionUID = 1L;
    public static final String NO_INTERNATIONAL_NAME= "No tiene nombre internacional, por lo cual no se crea el area";
    public static final String AREA_REPETIDA= "El area esta ya adicionada, no se adicionara de nuevo";
    public static final String UBICACION_TIENE_NUMERO="La ubicacion contiene un numero o es nula, esto es invalido";
    
    public SINAPExcepcion(String message){
        super(message);
    }
} 