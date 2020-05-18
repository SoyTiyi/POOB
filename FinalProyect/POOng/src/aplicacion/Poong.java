package src.aplicacion;

import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.awt.*;
/**
 * Esta clase es la encargada de controlar el juego
 */
public class Poong implements Serializable{
    private static final long serialVersionUID = 1L;
    private Pelota pelota;
    private Raqueta raqueta1;
    private Raqueta raqueta2;
    private static Poong poong=null;
    private int personajeUno;
    private int personajeDos;
    private String modo;
    private Premio premio;
    private int contPremio=0, contObjUno, contObjDos, contPro, contTres;
    private int esperaPremio, esperaObjUno, esperaObjDos;
    private Objetivo objetivoUno;
    private Objetivo objetivoDos;
    private int yEstre, yOb1, yOb2;
    private Random random = new Random();
    private Bloque bloque;
    private int vidaUno=100, vidaDos=100;
    private int velocidad=9;
    private ArrayList<Premio> premios = new ArrayList<Premio>();
    private int puntoMax;
    private boolean velProgresiva;
    private boolean velProgre;
    private int veloAnterior;
    private boolean act1, act2;
    /**
     * Esten es el constructor de la clase
     */
    private Poong(){
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        pelota = new Pelota(0,0);
        raqueta1 = new Raqueta(8,100);
        raqueta2 = new Raqueta((int)d.getWidth()/2+9,100);
        bloque = new Bloque(360,360);
        yEstre = random.nextInt(391-1); yOb1 = random.nextInt(391-1); yOb2 = random.nextInt(391-1);
        preparePremios();
        int index = (int) random.nextInt(8)+0;
        premio = premios.get(index);
        objetivoUno = new Objetivo(20, yOb1);
        objetivoDos = new Objetivo(700, yOb2);
        premio.setY(yEstre); objetivoUno.setY(yOb1); objetivoDos.setY(yOb2);
        esperaObjUno = (int) random.nextInt(5000)+10000; esperaObjDos = (int) random.nextInt(5000)+10000;
        esperaPremio=(int) random.nextInt(5000)+5000;
    }

    /**
     * Este metodo prepara los premios 
     */
    private void preparePremios(){
        premios.add(new Fastball(360, 700));
        premios.add(new Freezer(360, 720));
        premios.add(new Flash(360, 740));
        premios.add(new Turtle(360, 760));
        premios.add(new ColdRacket(360, 780));
        premios.add(new Phantom(360, 800));
        premios.add(new Energy(360, 820));
        premios.add(new ExamSorpresa(360,840));
    }

    /**
     * Este metodo le hace set al parametro velocidad
     * @param velocidad
     */
    public void setVelocidad(int velocidad){
        this.velocidad=velocidad;
    }

    /**
     * Este metodo devuelve la velocidad del juego
     * @return velocidad
     */
    public int getVelocidad(){
        return velocidad;
    }
    /**
     * Este metodo nos crea el premio
     */
    public void createPremio(){
        premio.setVisible(false);
        yEstre = random.nextInt(391-1);
        premio = premios.get(random.nextInt(7)+0);
        premio.setVisible(true);
        premio.setY(yEstre);
    }   

    /**
     * Este metodo es el encargado en el movimiento de los objetos y te los choques
     */
    public void move(){    
        contPremio++; contObjUno++; contObjDos++; contPro++; contTres++;
        pelota.mover(choque(raqueta1.getRaqueta()),choque(raqueta2.getRaqueta()));
        removeProgesive();
        pushPremio();
        pushBloque();
        hitPlayerOne();
        hitPlayerTwo();
        premioTime();
        hitObjetivoOne();
        timeObjetoUno();
        hitObjetivoDos();
        timeObjetivoDos();
        raqueta1.moveR1();
        raqueta2.moveR2();
        veloProgresiva();
        evalCongelacion();
    }

    /**
     * Este metodo nos evalua si alguna de las dos raquetas debe de estar golpeada
     */
    private void evalCongelacion(){
        if(pelota.getCongelacion()){
            if(pelota.getPlayerCong()==1 && pelota.getGolpeada1()){
                raqueta1.setMove(false);
                pelota.setCongelacion(false);
                pelota.numberCongelacion(0);
            }

            if(pelota.getPlayerCong()==2 && pelota.getGolpeada2()){
                raqueta2.setMove(false);
                pelota.setCongelacion(false);
                pelota.numberCongelacion(0);
            }
        }
    }

    /**
     * Este metodo nos decitbe que pasa cuando el tiempo del ObjetivoDos es igual a su contador
     */
    public void timeObjetivoDos(){
        if(contObjDos == esperaObjDos){
            contObjDos=0;
            esperaObjDos = random.nextInt(5000)+15000;
            createObjetivo(2);
        }
    }

    /**
     * Este metodo nos describe que pasa cuando el tiempo del ObjetivoDos llega a su fin o es golpeado por el jugador
     */
    public void hitObjetivoDos(){
        if(objetivoDos.getVisible() && (choque(objetivoDos.getObjetivo()) || contPremio==10000)){
            if(contPremio==10000){
                objetivoDos.setVisible(false);
            }
            else{
                pelota.sumScore1();
                objetivoDos.setVisible(false);
            }
        }
    }

    /**
     * Este metodo nos describa que pasa cuando el tiempo del ObjetivoUno es igual a su contador
     */
    public void timeObjetoUno(){
        if(contObjUno == esperaObjUno){
            contObjUno=0;
            esperaObjUno = random.nextInt(5000)+15000;
            createObjetivo(1);
        }
    }

    /**
     * Este metodo nos describe que pasa cuando el tiempo del ObjetivoUno llega a su fin o es golpeado por el jugador
     */
    public void hitObjetivoOne(){
        if(objetivoUno.getVisible() && (choque(objetivoUno.getObjetivo())  || contPremio==10000)){
            if(contPremio==10000){
                objetivoUno.setVisible(false);
            }
            else{
                pelota.sumScore2();
                objetivoUno.setVisible(false);;
            }
        }
    }

    /**
     * Este metodo nos dice que pasa cuando el tiempo del premio es igual al contador
     */
    public void premioTime(){
        if(contPremio==esperaPremio){
            contPremio=0;
            esperaPremio = random.nextInt(5000)+10000;
            createPremio();
        }
    }

    /**
     * Este metodo nos describe que pasa cuando el segundo jugador es golpeado por un bloque
     */
    private void hitPlayerTwo(){
        if(bloque.getVisible() && choque(bloque.getBloque(), raqueta2.getRaqueta())){
            bloque.setVisible(false);
            int vida = raqueta2.getVida()/2;
            raqueta2.sumVida(-vida);
        }
    }

    /**
     * Este metodo nos describe que pasa cuando el primer jugador es golpeado por un bloque 
     */
    private void hitPlayerOne(){
        if(bloque.getVisible() && choque(bloque.getBloque(), raqueta1.getRaqueta())){
            bloque.setVisible(false);
            int vida = raqueta1.getVida()/2;
            raqueta1.sumVida(-vida);
        }
    }
    /**
     * Este metodo nos indica el movimiento del bloque cuando es golpado por un jugador 
     */
    private void pushBloque(){
        if(bloque.getVisible()){
            int num = pelota.getPersonPush();
            if(num!=0){
                if(num==1) bloque.move(1);
                else bloque.move(2);
            }
            else{
                bloque.setVisible(false);
            }
        }
    }

    /**
     * Este metodo nos reinicia la velocidad cuando ya se choca al otro jugador despues de haber golpeado el premio Flash, el cual acelera la pelota
     */
    private void removeProgesive(){
        if(pelota.getPersonPush()==1 && act2){
            act2=false;
            velProgre=false;
            velocidad=veloAnterior;
        }
        if(pelota.getPersonPush()==2 && act1){
            act1=false;
            velProgre=false;
            velocidad=veloAnterior;
        }
    }

    /**
     * Este metedo nos actualiza los valores al golpear el premio dependiendo del jugador que la golpeo
     */
    private void pushPremio(){
        if(premio.getVisible() && choque(premio.getPremio())){
            premio.setVisible(false);
            bloque.setVisible(true);
            int num = pelota.getPersonPush();
            if(num==1){
                premio.choque(velocidad, raqueta1.getVida());
                actualizar(1);
                bloque.setX(470); bloque.setY(random.nextInt(390-1));
            }
            else{
                premio.choque(velocidad, raqueta2.getVida());
                actualizar(2);
                bloque.setX(270); bloque.setY(random.nextInt(390-1));
            }
        }
    }
    /**
     * Este metodo nos gestiona la velocidad progresiva 
     */
    private void veloProgresiva(){
        if(contPro==1000 && velProgresiva){
            if(velocidad>1){
                contPro=0;
                velocidad--;
            }
        }
        if(contTres==300 && velProgre){
            if(velocidad>1){
                contTres=0;
                velocidad--;
            }
        }
    }

    /**
     * Este metodo crea el objetivo
     * @param numero del objeto 
     */
    private void createObjetivo(int num){
        if(num==1){
            yOb1 = random.nextInt(391-1);
            objetivoUno.setVisible(true);
            objetivoUno.setY(yOb1);
        }
        else{
            yOb2 = random.nextInt(391-1);
            objetivoDos.setVisible(true);
            objetivoDos.setY(yOb2);
        }

    }

    /**
     * Este metodo retorna los puntos maximos
     * @return puntoMax
     */
    public int getPuntos(){
        return puntoMax;
    }

    /**
     * Este metodo nos hace set a la variable puntosMax
     * @param puntoMax
     */
    public void setPuntos(int puntoMax){
        this.puntoMax=puntoMax;
    }

    /**
     * Este metodo actualiza los valores dependiendo del premio 
     * @param player
     */
    private void actualizar(int player){
        if(player==1){
            velocidad=premio.getVelocidad();
            raqueta1.setVida(premio.getVida());
            raqueta2.setMove(premio.getRestriccionEnemigo());
            velProgre = premio.getVelocidadProgresiva(); if(velProgre){ 
                veloAnterior = velocidad; act1=true; contTres=0;
            }
            raqueta2.setMovilidad(premio.getRestriccionMovilidad());
            raqueta1.setInmunidad(premio.getInmunidad());
            pelota.setCongelacion(premio.getCongelacion()); if(premio.getCongelacion()){pelota.numberCongelacion(2);}
        }
        else{
            velocidad=premio.getVelocidad();
            raqueta2.setVida(premio.getVida());
            raqueta1.setMove(premio.getRestriccionEnemigo());
            velProgre = premio.getVelocidadProgresiva(); if(velProgre){ 
                veloAnterior = velocidad; act2=true; contTres=0;
            }
            raqueta1.setMovilidad(premio.getRestriccionMovilidad());
            raqueta2.setInmunidad(premio.getInmunidad());
            pelota.setCongelacion(premio.getCongelacion()); if(premio.getCongelacion()){pelota.numberCongelacion(1);}

        }
    }

    /**
     * Este metodo nos devuelve la vida de la primera Raqueta
     * @return vidaUno
     */
    public String getVidaUno(){
        return vidaUno+"";
    }

    /**
     * Este metodo nos devuelve la vida de la segunda raqueta
     * @return vidaDos
     */
    public String getVidaDos(){
        return vidaDos+"";
    }

    /**
     * Este metodo retorna el objetivo del jugador 1 
     * @return objetivoUno
     */
    public Objetivo getObjUno(){
        return objetivoUno;
    }

    /**
     * Este metodo retorna el objetivo del jugador 2 
     * @return objetivoDos
     */
    public Objetivo getObjDos(){
        return objetivoDos;
    }

    /**
     * Este metodo nos retorna el premio 
     * @return premio
     */
    public Premio getPremio(){
        return premio;
    }

    /**
     * Este metodo nos dice si se genero algun choque con la pelota
     * @return booleano
     */
    private boolean choque(Rectangle r){
        return pelota.getPelota().intersects(r);    
    }

    /**
     * Este metodo evalua el choque entre dos Rectangulos
     * @return booleano
     */
    private boolean choque(Rectangle r1, Rectangle r2){
        return r1.intersects(r2);
    }

    /**
     * Este metodo retorna la pelota
     * @return pelota
     */
    public Pelota getPelota(){
        return pelota;
    }

    /**
     * Este metdo retorna la raqueta numero 1
     */
    public Raqueta getRaquetaUno(){
        return raqueta1;
    }

    /**
     * Este metodo retorna la raqueta nuemro 2
     */
    public Raqueta getRaquetaDos(){
        return raqueta2;
    }

    /**
     * Este metodo nos retorna el objeto poong 
     */
    public static Poong getPong(){
        if(poong == null){
            poong = new Poong();
        }
        return poong;
    }

    /**
     * Este metodo es el encargado de guardar el juego en un archivo
     * @param file
     */
    public void salve(File file) throws PoongException{
        try{
            if(!file.exists()){
                file.createNewFile();
            }
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(this);
            out.close();
        }
        catch(Exception e){
            throw new PoongException(PoongException.ERROR_AL_SALVAR);
        }
    }

    /**
     * Este metodo es el encargado de abrir el juego
     * @param file
     */
    public void abrir(File file) throws PoongException{
        try{
            if(!file.exists()){
                file.createNewFile();
            }
            ObjectInputStream inp = new ObjectInputStream(new FileInputStream(file));
            poong = (Poong) inp.readObject();
            inp.close();
        }
        catch(Exception e){
            throw new PoongException(PoongException.ERROR_AL_ABRIR);
        }
    }  

    /**
     * Este metodo nos hace set al booleano que nos indica si la velocidad es progresiva
     * @param bool 
     */
    public void setVelProgresiva(boolean bool){
        velProgresiva=bool;
    }

    /**
     * Este metodo retorna el numero de la imagen del jugador uno
     * @return presonajeUno
     */
    public int getJugadorUno(){
        return personajeUno;
    }

    /**
     * Este metodo retorna el numero de la imagen del jugador dos
     * @return presonajeDos
     */
    public int getJugadorDos(){
        return personajeDos;
    }

    /**
     * Este metodo retrona el modo
     * @return modo
     */
    public String getModo(){
        return modo;
    }

    /**
     * Este metodo le hace set al modo
     * @param modo
     */
    public void setModo(String modo){
        this.modo=modo;
    }

    /**
     * Este metodo hace set al numero del primer jugador
     * @param num
     */
    public void setPlayerUno(int num){
        personajeUno=num;
    }

    /**
     * Este metodo hace set al numero del segundo jugador
     * @param num
     */
    public void setPlayerDos(int num){
        personajeDos=num;
    }

    /**
     * Este metodo nos retonrla la forma del bloque
     * @return bloque
     */
    public Bloque getBloque(){
        return bloque;
    }
}