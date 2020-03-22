package pruebas;

import aplicacion.*;
public class PruebasSinap{

    public void deberiaAdicionarCinco(){
        Sinap sinap = new Sinap();
        sinap.adicioneCinco();
    }

    public void deberiaAdicionarUnaNuevaArea(){
        Sinap sinap = new Sinap();
        sinap.adicione("Santuario de Flora Isla de la Corota", 
        "La Corota Island Flora Sanctuary","Pasto","","Alberga un santuario de flora y fauna protegido a nivel internacional");
    }

    public void deberiaAdicionarDetalleDeUnaNuevaArea(){
        Sinap sinap = new Sinap();
        Area area = new Area("Santuario de Flora Isla de la Corota", "La Corota Island Flora Sanctuary","Pasto","","Alberga un santuario de flora y fauna protegido a nivel internacional");
        sinap.adicioneDetalles(area);
    }

}