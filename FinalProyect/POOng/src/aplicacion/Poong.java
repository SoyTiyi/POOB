package src.aplicacion;

import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;
import java.awt.*;
/**
 * Esta clase es la encargada de controlar el juego
 */
public class Poong implements Serializable{
    private static final long serialVersionUID = 1L;
    /**
     * Este es el constructor de la clase
     */
    private Pelota pelota;
    private Raqueta raqueta1;
    private Raqueta raqueta2;
    private static Poong poong=null;
    private int personajeUno;
    private int personajeDos;
    private String modo;
    private Premio premio;
    private int contPremio=0, contObjUno, contObjDos;
    private int esperaPremio, esperaObjUno, esperaObjDos;
    private Objetivo objetivoUno;
    private Objetivo objetivoDos;
    private Random random = new Random();

    /**
     * Esten es el constructor de la clase
     */
    private Poong(){
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        pelota = new Pelota(0,0);
        raqueta1 = new Raqueta(8,100);
        raqueta2 = new Raqueta((int)d.getWidth()/2+9,100);
        premio = new Premio(360,random.nextInt(391-1));
        objetivoUno = new Objetivo(20, random.nextInt(391-1));
        objetivoDos = new Objetivo(700, random.nextInt(391-1));
        esperaObjUno = (int) random.nextInt(5000)+15000; esperaObjDos = (int) random.nextInt(5000)+15000;
        System.out.println(esperaObjUno+"   "+esperaObjDos);
        esperaPremio=(int) random.nextInt(5000)+10000;
    }

    /**
     * Este metodo nos crea el premio
     */
    public void createPremio(){
        if(premio == null){
            premio = new Premio(360,random.nextInt(391-1));
        }
        else{
            premio=null;
            premio = new Premio(360,random.nextInt(391-1));
        }
    }   

    /**
     * Este metodo es el encargado en el movimiento de los objetos y te los choques
     */
    public void move(){
        contPremio++; contObjUno++; contObjDos++;
        pelota.mover(choque(raqueta1.getRaqueta()),choque(raqueta2.getRaqueta()));
        if(premio!=null && choque(premio.getPremio())){
            premio=null;
        }
        if(contPremio==esperaPremio){
            contPremio=0;
            esperaPremio = random.nextInt(5000)+10000;
            createPremio();
        }
        if(objetivoUno!=null && choque(objetivoUno.getObjetivo())  || contPremio==10000){
            if(contPremio==10000){
                objetivoUno=null;
            }
            else{
                System.out.println("Golpee raqueta 1");
                pelota.sumScore2();
                objetivoUno=null;
            }
        }
        if(contObjUno == esperaObjUno){
            contObjUno=0;
            esperaObjUno = random.nextInt(5000)+15000;
            createObjetivo(1);
        }
        if(objetivoDos!=null && choque(objetivoDos.getObjetivo()) || contPremio==10000){
            if(contPremio==10000){
                objetivoDos=null;
            }
            else{
                System.out.println("Golpee raqueta 2");
                pelota.sumScore1();
                objetivoDos=null;
            }
        }
        if(contObjDos == esperaObjDos){
            contObjDos=0;
            esperaObjDos = random.nextInt(5000)+15000;
            createObjetivo(2);
        }
        raqueta1.moveR1();
        raqueta2.moveR2();
    }

    /**
     * Este metodo crea el objetivo
     * @return
     */
    private void createObjetivo(int num){
        if(num==1){
            objetivoUno = new Objetivo(10, random.nextInt(391-1));
        }
        else{
            objetivoDos = new Objetivo(700, random.nextInt(391-1));
        }
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
    public void salve(File file){
        try{
            if(!file.exists()){
                file.createNewFile();
            }
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(this);
            out.close();
            System.out.println(modo+" "+personajeUno+" "+personajeDos);
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }

    /**
     * Este metodo es el encargado de abrir el juego
     * @param file
     */
    public void abrir(File file){
        try{
            if(!file.exists()){
                file.createNewFile();
            }
            ObjectInputStream inp = new ObjectInputStream(new FileInputStream(file));
            poong = (Poong) inp.readObject();
            System.out.println(poong.modo);
        }
        catch(Exception e){
            System.out.println("ERROR");
        }
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
     */
    public void setPlayerDos(int num){
        personajeDos=num;
    }
}