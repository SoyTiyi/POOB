package src.aplicacion;

import java.awt.*;
import java.io.Serializable;
import java.util.Random;


/**
 * Este metodo nos crea una pelota, la idea es qu extienda
 */
public class Pelota implements Serializable{

    private static final long serialVersionUID = 1L;
    private int x;
    private int y;
    private int moveX=1;
    private int moveY=1;
    private final int limiteX=Toolkit.getDefaultToolkit().getScreenSize().width/2+35;
    private final int limiteY=Toolkit.getDefaultToolkit().getScreenSize().height/2+2;
    private final int ANCHO=15, ALTO=15;
    private int score1=0, score2=0;
    private Random random = new Random();
    private boolean golpeRaqueta1;
    private boolean golpeRaqueta2;
    private boolean peloCong;
    private boolean golpeadaRa1;
    private boolean golpeadaRa2;
    private int playerCong;

    /**
     * Este es el constructor de la clase pelota
     * @param x
     * @param y
     */
    public Pelota(int x, int y){
        this.x=x;
        this.y=y;
    }

    /**
     * Este metodo retorna la pelota
     * @return Rectangle
     */
    public Rectangle getPelota(){
        return  new Rectangle(x,y,ANCHO,ALTO);
    }

    /**
     * Este metodo gestiona el movimiento de la pelota
     * @param choqueUno
     * @param choqueDos
     */
    public void mover(boolean choqueUno, boolean choqueDos){
        x+=moveX;
        y+=moveY;
        if(choqueUno){moveX=-moveX; x=35; golpeRaqueta1=true; golpeRaqueta2=false; if(peloCong && playerCong==1) {golpeadaRa1=true;}} 
        if(choqueDos){moveX=-moveX; x=675; golpeRaqueta2=true; golpeRaqueta1=false;if(peloCong && playerCong==2) {golpeadaRa2=true;}}
        if(x > limiteX ){
            x=300; y=300;
            moveX=-moveX;
            score1+=1;
        }
        if(x < 0){
            x=300; y=300;
            moveX=-moveX;
            score2+=1;
        }
        if(y > limiteY){moveY=-moveY;}
        if(y == 0){moveY=-moveY;}
    }
    
    /**
     * Este metodo retorna la velocidad en la se mueve la pelota
     * @return moveX
     */
    public int getVelocidad(){
        return moveX;
    }

    /**
     * Este metodo cambia la variable que se le suma al cambio de la posicion x y y 
     */
    public void cambiarEjes(){
        moveX++; moveY++;
    }

    /**
     * Este metodo devuelve el puntaje del primer jugador
     * @return String score1
     */
    public String getScore1(){
        return score1+"";
    }

    /**
     * Este metodo devuelve el puntaje del segundo jugador
     * @return String score2
     */
    public String getScore2(){
        return score2+"";
    }

    /**
     * Este metodo retorna la posicion x de la pelota
     * @param x
     */
    public void setPositionX(int x){
        this.x=x;
    }

    /**
     * Este metodo devuelve la posicion y de la pelota
     * @param y
     */
    public void setPositionY(int y){
        this.y=y;
    }

    /**
     * Este metodo nos sume los puntos al golpear el objetivo del jugador Uno
     */
    public void sumScore1(){
        try{
            score1+= random.nextInt(score1/2)+2;
        } catch(Exception e){
            score1+=2;
        }
    }

    /**
     * Este metodo nos suma los puntos al golpear el objetivo del jugador Dos
     */
    public void sumScore2(){
        try{
            score2+= random.nextInt(score2/2)+2;
        } catch(Exception e){
            score2+=2;
        }
    }

    /**
     * Este metodo retorn la posicion Y
     * @return y
     */
    public int getY(){
        return y;
    }

    /**
     * Este metodo retorna la posicion X
     * @return x
     */
    public int getX(){
        return x;
    }

    /**
     * Este metodo nos indica que jugador golpeo la pelota
     * @return numero del player
     */
    public int getPersonPush(){
        if(golpeRaqueta1!=false || golpeRaqueta2!=false){
            if(golpeRaqueta1){
                return 1;
            }
            else{
                return 2;
            }
        }
        else{
            return 0;
        }
    }

    /**
     * Este metodono nos devuelve el atributo que nos indica si la pelota puede congelar
     * @return peloCong
     */
    public boolean getCongelacion(){
        return peloCong;
    }

    /**
     * Este metodo le hace set a la variable peloCong
     */
    public void setCongelacion(boolean peloCong){
        this.peloCong=peloCong;
    }

    /**
     * Este metodo retorna el jugador que debe de ser congelado
     * @return playerCong
     */
    public int getPlayerCong(){
        return playerCong;
    }

    /**
     * Este metodo nos indica que raqueta debe de ser congelada al ser chocada 
     * @param playerCong
     */
    public void numberCongelacion(int playerCong){
        this.playerCong=playerCong;
    }

    /**
     * Este metodo nos devuelve el booleano que nos indica si la raqueta uno debe de estar congelada 
     * @return golpeadaRa1
     */
    public boolean getGolpeada1(){
        return golpeadaRa1;
    }

    /**
     * Este metodono nos devuelve el booleano que nos infica si la raqueta dps debe de estar congelada
     */
    public boolean getGolpeada2(){
        return golpeadaRa2;
    }
}