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
        Celula indiana = new Celula(this,1,1);
        Celula OO7 = new Celula(this,2,2);
        Celula marx = new Izquierdosa(this,3,1);
        Celula hegel = new Izquierdosa(this,3,2);
        Celula barrera = new Barrera(this,4,1);
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
