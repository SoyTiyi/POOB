package aplicacion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class AutomataCelular implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    static private int LONGITUD = 20;
    private Elemento[][] automata;
    private static AutomataCelular automataCelular=null;
    private String[] listaElementos={"Barrera","Virus","Celula"};
    private List<String> list = Arrays.asList(listaElementos);

    public AutomataCelular() {
        automata = new Elemento[LONGITUD][LONGITUD];
        for (int f = 0; f < LONGITUD; f++) {
            for (int c = 0; c < LONGITUD; c++) {
                automata[f][c] = null;
            }
        }
        algunosElementos();
    }


    private void resetAutomata(){
        for(int i=0;i<automata.length;i++){
            for(int j=0;j<automata.length;j++){
                if(automata[i][j]!=null){
                    automata[i][j]=null;
                }
            }
        }
    }

    public static AutomataCelular getAutomataCelular(){
        if(automataCelular==null){
            automataCelular = new AutomataCelular();
        }
        return automataCelular;
    }
    public int getLongitud() {
        return LONGITUD;
    }

    public Elemento getElemento(int f, int c) {
        return automata[f][c];
    }

    public void setElemento(int f, int c, Elemento nueva) {
        automata[f][c] = nueva;
    }

    public void nuevoAutomata() {
        automataCelular = new AutomataCelular();
    }

    public void algunosElementos() {
        Elemento indiana = new Celula(this, 1, 1);
        Elemento OO7 = new Celula(this, 2, 2);
        Elemento marx = new Izquierdosa(this, 3, 1);
        Elemento hegel = new Izquierdosa(this, 3, 2);
        Elemento suroeste = new Barrera(this, 15, 18);
        Elemento noreste = new Barrera(this, 1, 18);
        Elemento santiago = new Canibal(this, 2, 1);
        Elemento ricardo = new Canibal(this, 1, 17);
        Elemento virus = new Virus(this, 4, 1);
        Elemento john = new Conway(this, 5, 6);
        Elemento horton = new Conway(this, 5, 7);
        Elemento bloque1 = new Conway(this, 12, 0);
        Elemento bloque2 = new Conway(this, 12, 1);
        Elemento bloque3 = new Conway(this, 13, 0);
        Elemento bloque4 = new Conway(this, 13, 1);
        Elemento parpadea1 = new Conway(this, 7, 7);
        Elemento parpadea2 = new Conway(this, 7, 8);
        Elemento parpadea3 = new Conway(this, 7, 9);
    }

    public void salve(File file) throws automataExcepcion {
        try{
            if(!file.exists()){
                file.createNewFile();
            }
            ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream(file));
            out.writeObject(this);
            out.close();
        }
        catch(Exception e){
            throw new automataExcepcion(automataExcepcion.ERROR_AL_GUARDAR);
        }
        
    }

    public void salve01(File file) throws automataExcepcion {
        try{
            if(!file.exists()){
                file.createNewFile();
            }
            ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream(file));
            out.writeObject(this);
            out.close();
        }
        catch(IOException e){
            throw new automataExcepcion(automataExcepcion.ERROR_AL_GUARDAR);
        }
        
    }

    public void abra(File file) throws automataExcepcion {
        try{
            if(!file.exists()){
                file.createNewFile();
            }
            ObjectInputStream inp = new ObjectInputStream(new FileInputStream(file));
            automataCelular = (AutomataCelular) inp.readObject();
        }
        catch (Exception e){
            throw new automataExcepcion(automataExcepcion.ABRA);
        }
    }

    public void abra01(File file) throws automataExcepcion {
        try{
            if(!file.exists()){
                file.createNewFile();
            }
            ObjectInputStream inp = new ObjectInputStream(new FileInputStream(file));
            automataCelular = (AutomataCelular) inp.readObject();
        }
        catch (IOException e){
            throw new automataExcepcion(automataExcepcion.ERROR_AL_ABRIR);
        } catch (ClassNotFoundException e) {
            throw new automataExcepcion(automataExcepcion.CLASS_NOT_FOUND);
        }
    }

    public void exporte(File file) throws automataExcepcion{
        try{
            FileWriter out = new FileWriter(file);
            for(int i=0; i<automata.length ; i++){
                for(int j=0; j<automata.length; j++){
                    if(automata[i][j]!=null){
                        out.write(automata[i][j].toString()+"\n");
                    }
                }
            }
            out.close(); 
        }catch(Exception e){
            throw new automataExcepcion(automataExcepcion.ERROR_AL_EXPORTAR);
        }
    }

    public void exporte01(File file) throws automataExcepcion{
        try{
            FileWriter out = new FileWriter(file);
            for(int i=0; i<automata.length ; i++){
                for(int j=0; j<automata.length; j++){
                    if(automata[i][j]!=null){
                        out.write(automata[i][j].toString()+"\n");
                    }
                }
            }
            out.close(); 
        }catch(IOException e){
            throw new automataExcepcion(automataExcepcion.ERROR_AL_EXPORTAR);
        }
    }

    public void importe(File file) throws automataExcepcion{
        try{
            resetAutomata();
            BufferedReader in =new BufferedReader( new FileReader(file));
            String line = in.readLine();
            while(line != null){
                line = line.trim();
                String[] partes = line.split(" ");
                String tipo=partes[0], fila=partes[1], columna=partes[2];
                createElemento(tipo,fila,columna);
                line = in.readLine();
            }
        }
        catch(Exception e){

        }
    }

    public void importe01(File file) throws automataExcepcion{
        try{
            resetAutomata();
            BufferedReader in =new BufferedReader( new FileReader(file));
            String line = in.readLine();
            while(line != null){
                line = line.trim();
                String[] partes = line.split(" ");
                String tipo=partes[0], fila=partes[1], columna=partes[2];
                createElemento(tipo,fila,columna);
                line = in.readLine();
            }
        }
        catch(Exception e){
            throw new automataExcepcion(automataExcepcion.ERROR_AL_IMPORTAR);
        }
    }

    public void importe02(File file) throws automataExcepcion, AutomataCompilador{
        try{
            resetAutomata();
            BufferedReader in =new BufferedReader( new FileReader(file));
            String line = in.readLine();
            int cont = 1;
            while(line != null){
                line = line.trim();
                String[] partes = line.split(" ");
                compilador(partes, cont);
                String tipo=partes[0], fila=partes[1], columna=partes[2];
                createElemento02(tipo,fila,columna,cont);
                cont++;
                line = in.readLine();

            }
        }
        catch(IOException e){
            throw new automataExcepcion(automataExcepcion.ERROR_AL_IMPORTAR);
        }
    }

    public void importe03(File file) throws automataExcepcion, AutomataCompilador{
        try{
            resetAutomata();
            BufferedReader in =new BufferedReader( new FileReader(file));
            String line = in.readLine();
            int cont = 1;
            while(line != null){
                line = line.trim();
                String[] partes = line.split(" ");
                compilador(partes, cont);
                String tipo=partes[0], fila=partes[1], columna=partes[2];
                createElemento03(tipo,fila,columna,cont);
                cont++;
                line = in.readLine();

            }
        }
        catch(IOException e){
            throw new automataExcepcion(automataExcepcion.ERROR_AL_IMPORTAR);
        }
    }

    private void createElemento03(String nombre, String fila, String columna, int num) throws AutomataCompilador  {
        int i = Integer.parseInt(fila);
        int j = Integer.parseInt(columna);
        if(list.contains(nombre)){
            if(nombre.equals("Virus")){
                automata[i][j] = new Virus(this, i, j);
    
            }
            else if(nombre.equals("Celula")){
                automata[i][j] = new Celula(this, i, j);
            }
            else if(nombre.equals("Barrera")){
                automata[i][j] = new Barrera(this, i, j);
            }
        }
        else{
            throw new AutomataCompilador(AutomataCompilador.ELEMENT_NOT_CREATE, num, nombre);
        }

    }

    private void createElemento02(String nombre, String fila, String columna, int num) throws AutomataCompilador  {
        int i = Integer.parseInt(fila);
        int j = Integer.parseInt(columna);
        if(nombre.equals("Virus")){
            automata[i][j] = new Virus(this, i, j);

        }
        else if(nombre.equals("Celula")){
            automata[i][j] = new Celula(this, i, j);
        }
        else if(nombre.equals("Barrera")){
            automata[i][j] = new Barrera(this, i, j);
        }
        else{
            throw new AutomataCompilador(AutomataCompilador.CLASS_NOT_FOUND, num, nombre);
        }

    }

    private void createElemento(String nombre, String fila, String columna){
        int i = Integer.parseInt(fila);
        int j = Integer.parseInt(columna);
        if(nombre.equals("Virus")){
            automata[i][j] = new Virus(this, i, j);

        }
        else if(nombre.equals("Celula")){
            automata[i][j] = new Celula(this, i, j);
        }
        else{
            automata[i][j] = new Barrera(this, i, j);
        }

    }
    public String toString(Elemento elemento){
        String temp = elemento.getTipo()+" "+elemento.getFila()+" "+elemento.getColumna();
        return temp;
    }

    public void compilador(String[] lista, int numLinea) throws AutomataCompilador{
        if(lista[0].equals("false") || lista[0].equals("true")) throw new AutomataCompilador(AutomataCompilador.NAME_ITS_BOOLEAN,numLinea,lista[0]);
        if(!verificarNumero(lista[1])) throw new AutomataCompilador(AutomataCompilador.ROW_NOT_NUMBER,numLinea,lista[1]);
        if(!verificarNumero(lista[2])) throw new AutomataCompilador(AutomataCompilador.COLUMN_NOT_NUMBER, numLinea, lista[2]);
        if(lista[1].equals("true") || lista[1].equals("false")) throw new AutomataCompilador(AutomataCompilador.ROW_IS_BOOLEAN, numLinea, lista[1]);
        if(lista[2].equals("true") || lista[2].equals("false")) throw new AutomataCompilador(AutomataCompilador.COLUMN_IS_BOOLEAN, numLinea, lista[2]);


    }

    private boolean verificarNumero(String num){
        boolean flag = true;
        try{
            int n = Integer.parseInt(num);
        }
        catch(Exception e){
            flag=false;
        }
        return flag;
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
