package aplicacion;

/**
 * Este metodo es el encargado de hacer la simulacion de un compilador
 */
public class AutomataCompilador extends Exception{

    private static final long serialVersionUID = 1L;

    /**
     * Este es el constructor de la clase AutomataCompilador
     */
    public static final String NAME_ITS_BOOLEAN="El nombre es un booleano";
    public static final String ROW_NOT_NUMBER="La fila no es un numero";
    public static final String COLUMN_NOT_NUMBER="La columna no es un numero";
    public static final String CLASS_NOT_FOUND="El tipo de elemento no existe";
    public static final String ROW_IS_BOOLEAN="La fila es un booleano";
    public static final String COLUMN_IS_BOOLEAN="La columna es un booleano";
    public AutomataCompilador(String message, int numLinea, String palabra){
        super("En la linea "+numLinea+" la palabra "+palabra+" tiene el error: "+message);
    }
}