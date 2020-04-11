package aplicacion;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MarbelGameTest {


    @Test
    public void deberiaCrearConElementosPredeterminados(){
        MarbelGame marbelgame = new MarbelGame(4, 3, 3);
        assertEquals("[0 , 1 , 0 , 0 , ]1 , B , 1 , 0 , ]H , 0 , 0 , H , ]0 , H , 0 , 0 , ]", marbelgame.pintarNazi());
    }

    @Test
    public void deberiaHacerElMove(){
        MarbelGame marbelgame = new MarbelGame(4,3,3);
        marbelgame.move('N');
        assertEquals("[0 , 1 , 0 , 0 , ]0 , B , 0 , 0 , ]1 , 0 , 0 , H , ]0 , H , 1 , 0 , ]", marbelgame.pintarNazi());
    }
}