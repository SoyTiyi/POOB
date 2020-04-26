package pruebas;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;
import aplicacion.*;
public class pruebas {

    /**
     * Este metodo nos prueba que abre un archivo que existe
     */
    @Test
    public void deberiaAbrir(){
        AutomataCelular automata = AutomataCelular.getAutomataCelular();
        try{
            File file = new File("C:/Users/santi/Desktop/dosClicks.dat");
            automata.abra01(file);
        }
        catch(automataExcepcion e){
            e.printStackTrace();
        }
    }

    /**
     * Este metodo nos prueba que deberia de mandar error 
     */
    @Test
    public void noDeberiaAbrir(){
        AutomataCelular automata = AutomataCelular.getAutomataCelular();
        try{
            File file = new File("C:/Users/santi/Desktop/skere.dat");
            automata.abra01(file);
            fail("No mando excepcion");
        }
        catch(automataExcepcion e){
            assertEquals(automataExcepcion.ERROR_AL_ABRIR, e.getMessage());
        }
    }

    /**
     * Este metodo nos prueba que deberia de salvar un archivo 
     */
    @Test
    public void deberiaSalvar(){
        AutomataCelular automata = AutomataCelular.getAutomataCelular();
        try{
            File file = new File("C:/Users/santi/Desktop/prueba.dat");
            automata.salve01(file);
        }
        catch(automataExcepcion e){
            e.printStackTrace();
        }
    }

    /**
     * Este metodo nos prueba que deberia de mandar excepcion si no existe el archivo
     */
    @Test
    public void noDeberiaSalvar(){
        AutomataCelular automata = AutomataCelular.getAutomataCelular();
        try{
            File file = new File("");
            automata.salve01(file);
            fail("No entro a la excepcion");
        }
        catch(automataExcepcion e){
            assertEquals(automataExcepcion.ERROR_AL_GUARDAR, e.getMessage());
        }
    }

    /**
     * Este metodo nos comprueba de que se deberia de importar un archivo
     */
    @Test
    public void deberiaImportar(){
        AutomataCelular automata = AutomataCelular.getAutomataCelular();
        try{
            File file = new File("C:/Users/santi/Desktop/tresClicks.txt");
            automata.importe01(file);
        }
        catch(automataExcepcion e){
            e.printStackTrace();
        }
    }

    /**
     * Este metodo nos comprueba de que se deberia de importar un archivo
     */
    @Test
    public void noDeberiaImportar(){
        AutomataCelular automata = AutomataCelular.getAutomataCelular();
        try{
            File file = new File("");
            automata.importe01(file);
            fail("No entro a la excepcion");
        }
        catch(automataExcepcion e){
            assertEquals(automataExcepcion.ERROR_AL_IMPORTAR, e.getMessage());
        }
    }

    /**
     * Este metodo nos comprueba que deberia de exportar un archivo
     */
    @Test

    public void deberiaExportar(){
        AutomataCelular automata = AutomataCelular.getAutomataCelular();
        try{
            File file = new File("C:/Users/santi/Desktop/prueba.txt");
            automata.exporte01(file);
        }
        catch(automataExcepcion e){
            e.printStackTrace();
        }
    }

    /**
     * Este metodo nos deberia de comprobar que no deberia de exportar cuando la direccion no existe
     */
    @Test

    public void noDeberiaExportar(){
        AutomataCelular automata = AutomataCelular.getAutomataCelular();
        try{
            File file = new File("");
            automata.exporte01(file);
            fail("No entro a la excepcion");
        }
        catch(automataExcepcion e){
            assertEquals(automataExcepcion.ERROR_AL_EXPORTAR, e.getMessage());
        }
    }
}