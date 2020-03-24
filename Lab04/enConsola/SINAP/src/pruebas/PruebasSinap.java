package pruebas;
import org.junit.Test;

import aplicacion.*;
public class PruebasSinap{

    /**
     * Esta prueba lo que busca es verificar que el metodo adicionarCinco sirve correctamente
     */
    
     @Test
    public void deberiaAdicionarCinco(){
        Sinap sinap = new Sinap();
        sinap.adicioneCinco();
    }

    /**
     * Esta prueba lo que busca es verificar que se puede añadir un nueva nueva area
     * 
     * @throws SINAPExcepcion
     */
    @Test
    public void deberiaAdicionarUnaNuevaArea() throws SINAPExcepcion {
        Sinap sinap = new Sinap();
        sinap.adicione("Santuario de Flora Isla de la Corota", 
        "La Corota Island Flora Sanctuary","Pasto","","Alberga un santuario de flora y fauna protegido a nivel internacional");
    }

    /**
     * Este metodo buscar añadir una ueva area pero desde el metodo adicionarDetalle
     */
    @Test
    public void deberiaAdicionarDetalleDeUnaNuevaArea(){
        Sinap sinap = new Sinap();
        Area area = new Area("Santuario de Flora Isla de la Corota", "La Corota Island Flora Sanctuary","Pasto","","Alberga un santuario de flora y fauna protegido a nivel internacional");
        sinap.adicioneDetalles(area);
    }

    /**
     * Este metodo busca saber si el metodo toString si esta buscando las areas despues de añadir una
     */
    @Test
    public void deberiaListar(){
        Sinap sinap = new Sinap();
        Area area = new Area("Santuario de Flora Isla de la Corota", "La Corota Island Flora Sanctuary","Pasto","","Alberga un santuario de flora y fauna protegido a nivel internacional");
        sinap.adicioneDetalles(area);
        sinap.toString();
    }

    /**
     * Este test nos muestra que pasa cuando se añade una nueva Area que no tiene
     * nombre internacional
     * 
     * @throws SINAPExcepcion
     */
    @Test
    public void deberiaExplotarPorFaltaDeName() throws SINAPExcepcion {
        Sinap sinap = new Sinap();
        sinap.adicione("Tuparro", "", "Vichada", "548.000", "Es una extensa sabana verde surcada por grandes ríos con potentes raudales y playas doradas, pequeñas"+
        "caños de aguas cristalinas, bosques de galería, morichales y saladillales, además de enormes rocas"+
        "cristalinas en forma de cerros redondeados.");
    }
}