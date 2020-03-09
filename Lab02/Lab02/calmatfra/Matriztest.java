

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Matriztest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Matriztest
{
    @Test
    public void deberiaSumar(){
        int [][][] lista1 = {{{1,2}}};
        int[][][] lista2 = {{{3,5}}};
        Matriz matriz1 = new Matriz (lista1);
        Matriz matriz2 = new Matriz (lista2);
        Calmatfra cal = new Calmatfra();
        cal.getHash().put("x",matriz1.sume(matriz2));
        assertEquals(" 11/10 ",cal.consulta("x"));
    }
    
    @Test
    public void deberiaRestar(){
        int [][][] lista1 = {{{8,2}}};
        int[][][] lista2 = {{{3,5}}};
        Matriz matriz1 = new Matriz (lista1);
        Matriz matriz2 = new Matriz (lista2);
        Calmatfra cal = new Calmatfra();
        cal.getHash().put("x",matriz1.reste(matriz2));
        assertEquals(" 17/5 ",cal.consulta("x"));
    }
}
