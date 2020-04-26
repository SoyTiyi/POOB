package aplicacion;


/**
 * Esta clase es la encargada de manejar las exception
 */
public class automataExcepcion extends Exception{

    private static final long serialVersionUID = 1L;
    public static final String SALVE="Opcion salve en construcción";
    public static final String ABRA="Opcion abra en construccion";
    public static final String EXPORTE="Opcion exporte en construccion";
    public static final String IMPORTE="Opcion importe en construccion";
    public static final String ERROR_AL_ABRIR="Se presento un error al abrir";
    public static final String ERROR_AL_GUARDAR="Se presento un error al guardar";

    public automataExcepcion(String message){
        super(message);
    }
}