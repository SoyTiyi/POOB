package aplicacion;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AutomataCelular implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    static private int LONGITUD = 20;
    private Elemento[][] automata;

        
    public AutomataCelular() {
        automata=new Elemento[LONGITUD][LONGITUD];
        for (int f=0;f<LONGITUD;f++){
            for (int c=0;c<LONGITUD;c++){
                automata[f][c]=null;
            }
        }
        algunosElementos();
    }

    public int  getLongitud(){
        return LONGITUD;
    }

    public Elemento getElemento(int f,int c){
        return automata[f][c];
    }

    public void setElemento(int f, int c, Elemento nueva){
        automata[f][c]=nueva;
    }

    public void nuevoAutomata(){
        for(int i=0;i<LONGITUD;i++){
            for(int j=0;j<LONGITUD;j++){
                if(automata[i][j]!=null){
                    automata[i][j]=null;
                }
            }
        }
    }
    public void algunosElementos(){
        Elemento indiana = new Celula(this,1,1);
        Elemento OO7 = new Celula(this,2,2);
        Elemento marx = new Izquierdosa(this,3,1);
        Elemento hegel = new Izquierdosa(this,3,2);
        Elemento suroeste = new Barrera(this,15,18);
        Elemento noreste = new Barrera(this,1,18);
        Elemento santiago = new Canibal(this,2,1);
        Elemento ricardo = new Canibal(this,1,17);
        Elemento virus = new Virus(this,4,1);
        Elemento john = new Conway(this,5,6);
        Elemento horton  = new Conway(this,5,7);
        Elemento bloque1 = new Conway(this,12,0);
        Elemento bloque2 = new Conway(this,12,1);
        Elemento bloque3 = new Conway(this,13,0);
        Elemento bloque4 = new Conway(this,13,1);
        Elemento parpadea1 = new Conway(this,7,7);
        Elemento parpadea2 = new Conway(this,7,8);
        Elemento parpadea3 = new Conway(this,7,9);
    }
    
    public void salve(File file) throws automataExcepcion{ 
        /**
         * Metodo en construccion
         */
        try{
            if(!file.exists()){
                file.createNewFile();
            }
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(automata);
            oos.close();
        }
        catch(Exception e){
            System.out.println("ERROR");
        }
    }

    public void abra(File file) throws automataExcepcion{
        /**
         * Metodo en construccion
         */
    }

    public void exporte(File file) throws automataExcepcion{
        /**
         * Metodo en construccion
         */
        
    }

    public void importe(File file) throws automataExcepcion{
        /**
         * Metodo en construccion
         */
    }




    public void ticTac(){
        for(int i=0;i<automata.length;i++){
            for(int j=0;j<automata.length;j++){
                if(automata[i][j]!=null){
                    automata[i][j].cambie(); automata[i][j].decida();
                }
            }
        }
    }
}
