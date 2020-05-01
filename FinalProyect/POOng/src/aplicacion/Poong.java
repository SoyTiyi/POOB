package src.aplicacion;

import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
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
    private Poong(){
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        pelota = new Pelota(0,0);
        raqueta1 = new Raqueta(8,100);
        raqueta2 = new Raqueta((int)d.getWidth()/2+9,100);
    }

    public void move(){
        pelota.mover(choque(raqueta1.getRaqueta()),choque(raqueta2.getRaqueta()));
        raqueta1.moveR1();
        raqueta2.moveR2();
    }

    private boolean choque(Rectangle r){
        return pelota.getPelota().intersects(r);    
    }

    public Pelota getPelota(){
        return pelota;
    }

    public Raqueta getRaquetaUno(){
        return raqueta1;
    }

    public Raqueta getRaquetaDos(){
        return raqueta2;
    }

    public static Poong getPong(){
        if(poong == null){
            poong = new Poong();
        }
        return poong;
    }

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

    public int getJugadorUno(){
        return personajeUno;
    }

    public int getJugadorDos(){
        return personajeDos;
    }

    public String getModo(){
        return modo;
    }

    public void setModo(String modo){
        this.modo=modo;
    }

    public void setPlayerUno(int num){
        personajeUno=num;
    }

    public void setPlayerDos(int num){
        personajeDos=num;
    }
}