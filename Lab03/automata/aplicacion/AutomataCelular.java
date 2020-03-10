package aplicacion;

import java.util.*;

public class AutomataCelular{
    static private int LONGITUD=20;
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

    public void algunosElementos(){
        Elemento indiana = new Celula(this,1,1);
        Elemento OO7 = new Celula(this,2,2);
        Elemento marx = new Izquierdosa(this,3,1);
        Elemento hegel = new Izquierdosa(this,3,2);
        Elemento suroeste = new Barrera(this,15,18);
        Elemento noreste = new Barrera(this,1,18);
        Elemento santiago = new Canibal(this,3,3);
        Elemento ricardo = new Canibal(this,1,17);
        Elemento virus = new Virus(this,4,1);
        Elemento john = new Conway(this,5,1);
        Elemento horton  = new Conway(this,5,2);
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
