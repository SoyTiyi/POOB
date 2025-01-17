package aplicacion;

import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.util.logging.Level;

/**
 * Este metodo registra una excepcion cuando ocurre
 */
public class Registro{
    public static String nombre="SINAP";
    
    public static void registre(Exception e){
        try{
            Logger logger=Logger.getLogger(nombre);
            logger.setUseParentHandlers(false);
            FileHandler file=new FileHandler(nombre+".log",true);
            file.setFormatter(new SimpleFormatter());
            logger.addHandler(file);
            logger.log(Level.SEVERE,e.toString(),e);
            file.close();
        }catch (Exception oe){
            oe.printStackTrace();
            System.exit(0);
        }
    }
}
    
