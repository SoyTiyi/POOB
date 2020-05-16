package src.pruebas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import src.aplicacion.*;

public class pruebasPoong {
    
    /**
     * Este prueba nos indica que al crear la clase Poong las raquetaUno tiene inmunidad como lo vimos en la prueba de aceptacion
     */
    @Test
    public void raquetaUnoTieneInmunidad(){
        Poong poong = Poong.getPong();
        Raqueta raquetaUno = poong.getRaquetaUno();
        assertEquals(raquetaUno.getInmunidad(), true);
    }

    /**
     * Esta prueba nos indica que crar la clase Poong la raquetaDos tiene inmunidad como lo vimos en la prueba de aceptacion
     */
    @Test
    public void raquetaDosTieneInmunidad(){
        Poong poong = Poong.getPong();
        Raqueta raquetaDos = poong.getRaquetaDos();
        assertEquals(raquetaDos.getInmunidad(), true);
    }
}