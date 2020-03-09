

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CalmatfraTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CalmatfraTest
{
    @Test
    public void deberiaConsultar(){
        Calmatfra prueba = new Calmatfra();
        int[][][] lista= {{{1,2}}};
        prueba.asigne("a",lista);
        assertEquals(" 1/2 ",prueba.consulta("a"));
        int[][][] listaDos={{{1,5},{2,4},{6,7}}};
        prueba.asigne("b", listaDos);
        assertEquals(" 1/5 1/2 6/7 ",prueba.consulta("b"));
    }
    
    @Test
    public void noDeberiaConsultar(){
        Calmatfra prueba = new Calmatfra();
        int[][][] lista = {{{1,2}}};
        prueba.asigne("a",lista);
        assertTrue(!prueba.getHash().containsKey("b"));
    }
}
