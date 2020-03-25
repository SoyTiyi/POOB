package pruebas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

        Area area = new Area("Parque Chicamocha", 
        "Chicamocha Parck","Santander","","Parque recreativo");

        sinap.adicione("Parque Chicamocha", 
        "Chicamocha Parck","Santander","","Parque recreativo");

        assertEquals(sinap.getDetalles("Parque Chicamocha", "Chicamocha Parck").toString(), area.toString());
    }

    /**
     * Este metodo buscar añadir una ueva area pero desde el metodo adicionarDetalle
     */
    @Test
    public void deberiaAdicionarDetalleDeUnaNuevaArea(){
        Sinap sinap = new Sinap();
        Area area = new Area("Parque Chicamocha", 
        "Chicamocha Parck","Santander","","Parque recreativo");
        sinap.adicioneDetalles(area);
        assertEquals(sinap.getDetalles("Parque Chicamocha", "Chicamocha Parck").toString(), area.toString());
    }

    /**
     * Este metodo busca saber si el metodo toString si esta buscando las areas despues de añadir una
     */
    @Test
    public void deberiaListar(){
        Sinap sinap = new Sinap();
        Area area = new Area("Parque Chicamocha", 
        "Chicamocha Parck","Santander","","Parque recreativo");
        sinap.adicioneDetalles(area);
        sinap.toString();
        assertTrue(sinap.toString()!="");
    }

    /**
     * Este test nos muestra que pasa cuando se añade una nueva Area que no tiene
     * nombre internacional
     * 
     * @throws SINAPExcepcion
     */
    @Test
    public void deberiaDeMandarExcepcionPorFaltaDeName() throws SINAPExcepcion {
        Sinap sinap = new Sinap();
        sinap.adicione("Tuparro", "", "Vichada", "548.000", "Es una extensa sabana verde surcada por grandes ríos con potentes raudales y playas doradas, pequeñas"+
        "caños de aguas cristalinas, bosques de galería, morichales y saladillales, además de enormes rocas"+
        "cristalinas en forma de cerros redondeados.");
    }

    @Test
    public void deberiaDeMandarExcepcionPorAreaRepetida() throws SINAPExcepcion {
        Sinap sinap = new Sinap();
        sinap.adicione("Tuparro", "hh", "Vichada", "548.000", "Es una extensa sabana verde surcada por grandes ríos con potentes raudales y playas doradas, pequeñas"+
        "caños de aguas cristalinas, bosques de galería, morichales y saladillales, además de enormes rocas"+
        "cristalinas en forma de cerros redondeados.");
        sinap.adicione("Tuparro", "hh", "Vichada", "548.000", "Es una extensa sabana verde surcada por grandes ríos con potentes raudales y playas doradas, pequeñas"+
        "caños de aguas cristalinas, bosques de galería, morichales y saladillales, además de enormes rocas"+
        "cristalinas en forma de cerros redondeados.");
    }

    @Test
    public void deberiaDeMandarExcepcionPorUbicacionConNumero() throws SINAPExcepcion{
        Sinap sinap = new Sinap();
        sinap.adicione("Parque Chicamocha","Chicamocha Park","Bosa1","300.000","Es un parque turistico donde puedes subirte en diferentes atracciones al lado del cañon");
    }

    @Test
    public void deberiaDeMandarExcepcionPorUbicacionNula() throws SINAPExcepcion{
        Sinap sinap = new Sinap();
        sinap.adicione("Parque Chicamocha","Chicamocha Park","","300.000","Es un parque turistico donde puedes subirte en diferentes atracciones al lado del cañon");
    }

    @Test
    public void deberiaBuscar(){
        Sinap sinap = new Sinap();
        sinap.busque("Laguna");
    }
}