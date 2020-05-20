package src.aplicacion;
import java.awt.*;
import java.io.Serializable;
/**
 * Este clase nos crea las raquetas de juego
 */
public class Raqueta implements Serializable {

    private static final long serialVersionUID = 1L;
    private int x;
    private int y;
    private final int ANCHO=25;
    private final int ALTO=80;
    private boolean canMove;
    private final int limiteY=Toolkit.getDefaultToolkit().getScreenSize().height/2-58;
    private int vida=100;
    private int cont=0;
    private int espera=0;
    private boolean restMovilidad;
    private int contMovilidad=1;
    private boolean inmunidad;
    private String modo;
    private int xDireccion;
    private int yDireccion;
    /**
     * Este es el constructor de muestra clase raqueta
     * @param x
     * @param y
     */
    public Raqueta(int x, int y){
        canMove=true;
        this.x=x;
        this.y=y;
    }

    /**
     * Este metodo detorna un elemento de tipo raqueta
     * @return Rectangle
     */
    public Rectangle getRaqueta(){
        return new Rectangle(x,y,ANCHO,ALTO);
    }

    /**
     * Este metodo nos hace set a la variable modo 
     */
    public void setModo(String modo){
        this.modo=modo;
    }

    /**
     * Este metodo nos retorna el modo en el que la raqueta 
     */
    public String getModo(){
        return modo;
    }

    /**
     * Este metodo maneja la logica del movimiento de la raqueta1
     */
    public void moveR1(){
        if(canMove){
            if(cont==20){
                vida--;
                cont=0;
            }
            if(restMovilidad){
                if(contMovilidad%3==0){
                    if(contMovilidad==3000){restMovilidad=false; contMovilidad=0;}
                    else{
                        contMovilidad++;
                        if(!modo.equals("maquina")){
                            if(EventoTeclado.w && y>0){cont++; y--;}
                            if(EventoTeclado.s && y<limiteY){cont++; y++;}
                        }
                        else{moveR1Maquina();}
                    }
                }
                else{contMovilidad++;}
            }
            else{
                if(!modo.equals("maquina")){
                    if(EventoTeclado.w && y>0){cont++; y--;}
                    if(EventoTeclado.s && y<limiteY){cont++; y++;}
                }
                else{moveR1Maquina();}
                
            }
        }
        else{
            if(espera==2000){
                espera=0; canMove=true;
            }
            else{
                espera++;
            }
        }
    }

    /**
     * Este metodo nos mueve la raqueta con movimiento R1 si esta es maquina
     */
    private void moveR1Maquina(){
        if(xDireccion==-1 && yDireccion==1 && y<limiteY){
            cont++;
            y++;
        }
        if(xDireccion==-1 && yDireccion==-1 && y>0){
            cont++;
            y--;
        }
    }

    /**
     * Este metodo nos hace set en el parametro restMovilidad
     * @param restMovilidad
     */
    public void setMovilidad(boolean restMovilidad){
        this.restMovilidad=restMovilidad;
    }

    /**
     * Este metodo nos da el valor del parametro restMovilidad
     * @return restMovilidad
     */
    public boolean getMovilidad(){
        return restMovilidad;
    }

    /**
     * Este metodo devuelve la posicion en X de la raqueta
     * @return x
     */
    public int getX(){
        return x;
    }

    /**
     * Este metodo devuelve la posicion en Y de la raqueta
     * @return y
     */
    public int getY(){
        return y;
    }

    /**
     * Este metodo maneja la logica del movimiento de la raqueta2
     */
    public void moveR2(){

        if(canMove){
            if(cont==40){
                vida--;
                cont=0;
            }
            if(restMovilidad){
                if(contMovilidad%3==0){
                    if(contMovilidad==3000){contMovilidad=0;restMovilidad=false;}
                    else{
                        contMovilidad++;
                        if(!modo.equals("maquina")){
                            if(EventoTeclado.up && y>0){cont++;y--;}
                            if(EventoTeclado.down && y<limiteY){cont++;y++;}
                        }
                        else{moveR2Maquina();}
                    }
                }
                else{ contMovilidad++;}
            }
            else{
                if(!modo.equals("maquina")){
                    if(EventoTeclado.up && y>0){cont++;y--;}
                    if(EventoTeclado.down && y<limiteY){cont++;y++;}
                }
                else{moveR2Maquina();}
            }
        }
        else{
            if(espera==2000){
                espera=0; canMove=true;
            }
            else{
                espera++;
            }
        }
    }

    /**
     * Este metodo nos mueve la raqueta con movimiento R2 si esta esta en maquina
     */
    private void moveR2Maquina(){
        if(xDireccion==1 && yDireccion==1 && y>0){
            cont++;
            y--;
        }
        if(xDireccion==1 && yDireccion==-1 && y<limiteY){
            cont++;
            y++;
        }
    }

    /**
     * Este metodo nos dice si es posible que la raqueta que se mueva
     * @return canMove
     */
    public boolean getMove(){
        return canMove;
    }

    /**
     * Este metodo le hace set a la variable canMove
     * @param canMove
     */
    public void setMove(boolean canMove){
        this.canMove=canMove;
    }

    /**
     * Este metodo devuelve la vida de la primera raqueta
     * @return vida
     */
    public int getVida(){
        return vida;
    }

    /**
     * Este metodo le hace set a la vida
     * @param vida
     */
    public void setVida(int vida){
        this.vida=vida;
    }

    /**
     * Este metodo le resta o suma vida a la raqueta
     * @param vida
     */
    public void sumVida(int vida){
        if(vida<0){
            if(inmunidad){
                inmunidad=false;
            }
            else{
                this.vida+=vida;
            }
        }
        else{
            this.vida+=vida;
        }
    }

    /**
     * Este metodono nos retorna el booleano que dice si la raqueta tiene inmunidad
     * @return inmunidad
     */
    public boolean getInmunidad(){
        return inmunidad;
    }

    /**
     * Este metodo nos hace set a la variable inmunidad
     * @param inmunidad
     */
    public void setInmunidad(boolean inmunidad){
        this.inmunidad=inmunidad;
    }

    /**
     * Este metodo hace set a la direccion X en donde se deberia mover la raqueta si esta en un modo maquina
     */
    public void setDireccionX(int xDireccion){
        this.xDireccion=xDireccion;
    }

    /**
     * Este metodo hace set a la deireccion Y en donde se deberia mover la raqueta si esta en un modo maquina
     */
    public void setDireccionY(int yDireccion){
        this.yDireccion=yDireccion;
    }
}