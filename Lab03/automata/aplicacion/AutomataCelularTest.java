package aplicacion;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CelulaTest.
 *
 * @author  (Santiago Martinez y Ricardo Amaya)
 * @version (1.0)
 */
public class AutomataCelularTest{
    private AutomataCelular ac;
    @Test
    public void deberiaCrear(){
        AutomataCelular ac = new AutomataCelular();
    }
    
    @Test
    public void deberiaEstarEnLaMatriz(){
        AutomataCelular ac = new AutomataCelular();
        boolean primeraCelula = null!=ac.getElemento(1,1);
        boolean segundaCelula = null!=ac.getElemento(1,2);
        assertTrue((primeraCelula && segundaCelula));
    }
    
    @Test
    public void deberiaTenerLongitudCuarenta(){
        AutomataCelular ac = new AutomataCelular();
        int longitud = ac.getLongitud();
        assertEquals(20,longitud);
    }
    
    @Test
    public void pruebaCelulaIzquierdosa(){
        AutomataCelular ac = new AutomataCelular();
        ac.ticTac(); ac.ticTac(); ac.ticTac();
    }
    
    @Test 
    public void pruebaBarrera(){
        AutomataCelular ac = new AutomataCelular();
        ac.ticTac(); ac.ticTac(); ac.ticTac();
    }
    
    @Test
    public void pruebasCanibalUno(){
        AutomataCelular ac = new AutomataCelular();
        ac.ticTac();
    }
    
    @Test
    public void pruebasCanibalDos(){
        AutomataCelular ac = new AutomataCelular();
        ac.ticTac(); ac.ticTac(); ac.ticTac();
    }
    
    @Test
    public void debeCrearVirus(){
        AutomataCelular ac = new AutomataCelular();
        ac.ticTac();
    }
    
    @Test
    public void deberiaReproducirse(){
        AutomataCelular ac = new AutomataCelular();
        ac.ticTac(); ac.ticTac(); ac.ticTac(); ac.ticTac(); ac.ticTac(); ac.ticTac();
        ac.ticTac();
    }
    
    @Test
    public void deberiaMoririJuegoDeLaVida(){
        AutomataCelular ac = new AutomataCelular();
        ac.ticTac();
    }
}
