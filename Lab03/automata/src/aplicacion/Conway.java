package aplicacion;

import java.awt.Color;
/**
 * Write a description of class Conway here.
 * 
 * @author (Santiago Martinez and Ricardo Amaya) 
 * @version (1.0)
 */
public class Conway extends Celula
{
    private int fila;
    private int columna;
    private AutomataCelular automata;
    /**
     * Constructor for objects of class Conway
     */
    public Conway(AutomataCelular ac, int fila, int columna){
        super(ac,fila,columna);
        automata=ac;
        this.fila=fila;
        this.columna=columna;
        estadoActual='v';
        color = Color.blue;
    }

    private int verVecinos(){
        int vivas=0;
        if(fila<19 && columna<19 && fila>0 && columna>0){
            if(automata.getElemento(fila,columna+1)!= null && automata.getElemento(fila,columna+1).isVivo()){vivas++;}
            if(automata.getElemento(fila+1,columna+1)!= null && automata.getElemento(fila+1,columna+1).isVivo()){vivas++;}
            if(automata.getElemento(fila+1,columna)!= null && automata.getElemento(fila+1,columna).isVivo()){vivas++;}
            if(automata.getElemento(fila,columna-1)!= null && automata.getElemento(fila,columna-1).isVivo()){vivas++;}
            if(automata.getElemento(fila+1,columna-1)!= null && automata.getElemento(fila+1,columna-1).isVivo()){vivas++;}
            if(automata.getElemento(fila-1,columna+1)!= null && automata.getElemento(fila-1,columna+1).isVivo()){vivas++;}
            if(automata.getElemento(fila-1,columna-1)!= null && automata.getElemento(fila-1,columna-1).isVivo()){vivas++;}
            if(automata.getElemento(fila-1,columna)!= null && automata.getElemento(fila-1,columna).isVivo()){vivas++;}
        }
        else{
            vivas=fronterasX();
        }
        return vivas; 
    }
    
    private int fronterasX(){
        int vivas=0;
        if(fila==0 && columna>0 && columna<19){
            if(automata.getElemento(fila,columna+1)!= null && automata.getElemento(fila,columna+1).isVivo()){vivas++;}
            if(automata.getElemento(fila,columna-1)!= null && automata.getElemento(fila,columna-1).isVivo()){vivas++;}
            if(automata.getElemento(fila+1,columna+1)!= null && automata.getElemento(fila+1,columna+1).isVivo()){vivas++;}
            if(automata.getElemento(fila+1,columna-1)!= null && automata.getElemento(fila+1,columna-1).isVivo()){vivas++;}
            if(automata.getElemento(fila+1,columna)!= null && automata.getElemento(fila+1,columna).isVivo()){vivas++;}
        }
        else if(fila==19 && columna>0 && columna<19){
            if(automata.getElemento(fila,columna+1)!= null && automata.getElemento(fila,columna+1).isVivo()){vivas++;}
            if(automata.getElemento(fila,columna-1)!= null && automata.getElemento(fila,columna-1).isVivo()){vivas++;}
            if(automata.getElemento(fila-1,columna+1)!= null && automata.getElemento(fila-1,columna+1).isVivo()){vivas++;}
            if(automata.getElemento(fila-1,columna-1)!= null && automata.getElemento(fila-1,columna-1).isVivo()){vivas++;}
            if(automata.getElemento(fila-1,columna)!= null && automata.getElemento(fila-1,columna).isVivo()){vivas++;}
        }
        else{
            vivas=fronterasY();
        }
        return vivas;
    }
    
    private int fronterasY(){
        int vivas=0;
        if(columna==0 && fila>0 && fila<19){
            if(automata.getElemento(fila,columna+1)!= null && automata.getElemento(fila,columna+1).isVivo()){vivas++;}
            if(automata.getElemento(fila-1,columna)!= null && automata.getElemento(fila-1,columna).isVivo()){vivas++;}
            if(automata.getElemento(fila-1,columna+1)!= null && automata.getElemento(fila-1,columna+1).isVivo()){vivas++;}
            if(automata.getElemento(fila+1,columna)!= null && automata.getElemento(fila+1,columna).isVivo()){vivas++;}
            if(automata.getElemento(fila+1,columna+1)!= null && automata.getElemento(fila+1,columna+1).isVivo()){vivas++;}
        }
        else if(columna==19 && fila>0 && fila<19){
            if(automata.getElemento(fila,columna+1)!= null && automata.getElemento(fila,columna+1).isVivo()){vivas++;}
            if(automata.getElemento(fila,columna-1)!= null && automata.getElemento(fila,columna-1).isVivo()){vivas++;}
            if(automata.getElemento(fila-1,columna+1)!= null && automata.getElemento(fila-1,columna+1).isVivo()){vivas++;}
            if(automata.getElemento(fila-1,columna-1)!= null && automata.getElemento(fila-1,columna-1).isVivo()){vivas++;}
            if(automata.getElemento(fila-1,columna)!= null && automata.getElemento(fila-1,columna).isVivo()){vivas++;}
        }
        else{
            vivas=esquinas();
        }
        return vivas;
    }
    
    private int esquinas(){
        int vivas=0;
        if(columna==0 && fila==0){
            if(automata.getElemento(fila,columna+1)!=null && automata.getElemento(fila,columna+1).isVivo()){vivas++;}
            if(automata.getElemento(fila+1,columna+1)!=null && automata.getElemento(fila+1,columna+1).isVivo()){vivas++;}
            if(automata.getElemento(fila+1,columna)!=null && automata.getElemento(fila+1,columna).isVivo()){vivas++;}
        }
        else if(fila==0 && columna==19){
            if(automata.getElemento(fila-1,columna)!=null && automata.getElemento(fila-1,columna).isVivo()){vivas++;}
            if(automata.getElemento(fila+1,columna-1)!=null && automata.getElemento(fila+1,columna-1).isVivo()){vivas++;}
            if(automata.getElemento(fila+1,columna)!=null && automata.getElemento(fila+1,columna).isVivo()){vivas++;}
        }
        else if(fila==19 && columna==0){
            if(automata.getElemento(fila,columna+1)!=null && automata.getElemento(fila,columna+1).isVivo()){vivas++;}
            if(automata.getElemento(fila-1,columna+1)!=null && automata.getElemento(fila-1,columna+1).isVivo()){vivas++;}
            if(automata.getElemento(fila-1,columna)!=null && automata.getElemento(fila-1,columna).isVivo()){vivas++;}
        }
        else{
            if(automata.getElemento(fila,columna-1)!=null && automata.getElemento(fila,columna-1).isVivo()){vivas++;}
            if(automata.getElemento(fila-1,columna-1)!=null && automata.getElemento(fila-1,columna-1).isVivo()){vivas++;}
            if(automata.getElemento(fila-1,columna)!=null && automata.getElemento(fila-1,columna).isVivo()){vivas++;}
        }
        return vivas;
    }
    
    @Override
    public void decida(){
        int vecinasVivas = verVecinos();
        //System.out.println(vecinasVivas);
        if((vecinasVivas==2 || vecinasVivas==3) && estadoActual=='v'){
            estadoSiguiente='v';
        }
        if(vecinasVivas==3 && estadoActual=='m'){
            estadoSiguiente='v';
        }
        if(vecinasVivas==1 || vecinasVivas>3){
            System.out.println(fila+" "+columna+"entre al que no era"+vecinasVivas);
            estadoSiguiente='m';
        }
    }
}
