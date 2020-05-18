package src.aplicacion;


/**
 * Esta clase nos maneja las excepciones que pueden ocurrir cuando pase un error
 */
public class PoongException extends Exception{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public static final String ERROR_AL_SALVAR="Se presento un error al savar el archivo";
    public static final String ERROR_AL_ABRIR="Se presento un error al abrir el archivo";
    public PoongException(String message){
        super(message);
    }
}