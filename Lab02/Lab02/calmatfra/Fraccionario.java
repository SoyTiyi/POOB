import java.util.*;
import java.lang.Math;
/**
 * Fraccionario
 * Esta clase implementa el tipo de dato Fraccionario; es decir, un n�mero racional que se pueden escribir de la forma p/q, donde p y q son enteros, con q <> 0
 * La implemantacion se hace mediante objetos inmutables
 * INV: El fraccionario se encuentra representado en forma irreductible.
 * @author E.C.I.
 *
 */
public class Fraccionario {
    private static ArrayList<Integer> factoresA;
    private static ArrayList<Integer> factoresB;
    private static ArrayList<Integer> menor;
    private static ArrayList<Integer> mayor;
    public ArrayList<Integer> fraccion= new ArrayList<Integer>();
    /**Calcula el maximo comun divisor de dos enteros
       * Lo implementaremos mediante el algoritmo recursivo
     * @param a primer entero
     * @param b segundo entero
     * @return el Maximo Comun Divisor de a y b
     */
  
    public static int mcd(int a,int b){
        ArrayList<Integer> facComunes;
        factoresA=factoresPrimos(Math.abs(a));
        factoresB=factoresPrimos(Math.abs(b));
        menor=menor(factoresA,factoresB);
        mayor=mayor(factoresA,factoresB);
        facComunes=factoresComunes(menor,mayor);
        return multList(facComunes);
    }  
    
    /**
     * Este metodo calcula los factores primos de cada numero
     * @param a numero entero
     * @return los factores primos dentro de un ArrayList
     */
    private static ArrayList factoresPrimos(int a){
        ArrayList<Integer> factores = new ArrayList<Integer>();
        factores.add(1);
        for(int i=2;i<a+1;i++){
            while(a%i==0){
                a=a/i;
                factores.add(i);
            }
        }
        return factores; 
    }
        
    /**
     * Este metodo envia cual es la lista con menor longitud
     * @param a ArrayList de enteros
     * @param b ArrayList de enteros
     * @return la lista con menor longitud
     */
    private static ArrayList<Integer> menor(ArrayList<Integer> a,ArrayList<Integer> b){
        if(a.size()<b.size()){
            return a;
        }
        else{
            return b;
        }
    }
    
    /**
     * Este metodo envia la lista con mayor longitud
     * @param a ArrayList de enteros
     * @param b ArrayLsit de enteros
     * @return la lista con mayor longitud
     */
    private static ArrayList<Integer> mayor(ArrayList<Integer> a,ArrayList<Integer> b){
        if(a.size()<b.size()){
            return b;
        }
        else{
            return a;
        }
    }
    
    /**
     * Este metodo envia en una lista los enteros que esten en las dos listas
     * @param a ArrayList de enteros
     * @param b ArrayList de enteros
     * @return facComunes ArrayList de enteros
     */
    private static ArrayList<Integer> factoresComunes(ArrayList<Integer> a, ArrayList<Integer> b){
        ArrayList<Integer> facComunes = new ArrayList<Integer>();
        for(int i=0;i<a.size();i++){
            if(b.contains(a.get(i))){
                facComunes.add(a.get(i));
            }
        }
        return facComunes;
    }
    
    /**
     * Este metodo multiplica los elementos del ArrayList
     * @param a ArrayList de enteros
     * @return resultado Entero
     */
    private static int multList(ArrayList<Integer> a){
        int resultado=1;
        for(int i=0;i<a.size();i++){
            resultado*=a.get(i);
        }
        return resultado;
    }
    
    /**Crea un nuevo fraccionario, dado el numerador y el denominador
     * @param numerador
     * @param denominador. denominador <> 0
     */
    public Fraccionario (int numerador, int denominador) {
        fraccion.add(numerador);
        fraccion.add(denominador);
        signos(fraccion);
        this.fraccion=simplificar(fraccion);
    }
    
    /**
     * Cambia el signo del denominador si este es negativo y le asigna el signo al numerador
     * @param fraccion ArrayList
     */
    public void signos(ArrayList<Integer> fraccion){
        if(fraccion.get(1)<0){
            fraccion.set(0,fraccion.get(0)*-1);
            fraccion.set(1,fraccion.get(1)*-1);
        }
    }
    
    /**Crea un fraccionario correspondiente a un entero
     * @param entero el entero a crear
     */
    public Fraccionario (int entero) {
        fraccion.add(entero);
        fraccion.add(1);
    }
    
    /**
     * Simplifica el numerador y el denominador
     * @param a ArrayList de enteros
     * @return a ArrayList de enteros simplificados
     */
    public ArrayList<Integer> simplificar(ArrayList<Integer> a){
        int menor=Math.min(Math.abs(a.get(0)),Math.abs(a.get(1)));
        for(int i=2;i<menor+1;i++){
            while(a.get(0)%i==0 && a.get(1)%i==0){
                a.set(0,a.get(0)/i);
                a.set(1,a.get(1)/i);
            }
        }
        return a;
    }
     /**Crea un fraccionario, a partir de su representacion mixta. 
     * El numero creado es enteroMixto + numeradorMixto/denominadorMixto
     * @param enteroMixto la parte entera del numero
     * @param numeradorMixto el numerador de la parte fraccionaria
     * @param denominadorMixto el denominador de la parte fraccionaria. denominadorMixto<>0
     */
    public Fraccionario (int enteroMixto, int numeradorMixto, int denominadorMixto) {

    }

    /**
     * Un fraccionario p/q esta escrito en forma simplificada si q es un entero positivo y 
     * el maximo comun divisor de p y q es 1.
     * @return El numerador simplificado del fraccionario
     */
    public int numerador() {
        return fraccion.get(0);
    }
    
    /**
     * Este metodo cambia el numerador
     * @param a nuevo numerador
     */
    public void setNumerador(int a){
        fraccion.set(0,a);
    }
    
    /**
     * Este metodo cambia el numerador
     * @param a nuevo denominador
     */
    public void setDenominador(int a){
        fraccion.set(1,a);
    }
    
    /**
     * Un fraccionario p/q esta escrito en forma simplificada si q es un entero Positivo y 
     * el maximo comun divisor de p y q es 1.
     * @return el denominador simplificado del fraccionario
     */
    public int denominador() {
        return fraccion.get(1);
    }
    
    /**
     * Este metodo retorna el mcm de dos numeros
     * @param a entero
     * @param b entero
     * @return resultado que es el mcm de a y b 
     */
    public int mcm(int a ,int b){
        if(a%b==0 || b%a==0){
            if(a>b){
                return a;
            }
            else{
                return b;
            }
        }
        else{
            if((a*b)%2==0){
                if(((a*b)/2)%a==0 && ((a*b)/2)%b==0){
                    return (a*b)/2;
                }
                else{
                    return a*b;
                }
            }
            else{
                return a*b;
            }
        }
    }
    
    /**
    /**Suma este fraccionario con otro fraccionario
     * @param otro es otro fraccionario
     * @return este+otro
     */
    public Fraccionario sume (Fraccionario otro) {     
        int mcm=mcm(fraccion.get(1),otro.denominador());
        Fraccionario respuesta = new Fraccionario(1);
        respuesta.setNumerador(((mcm/otro.denominador())*otro.numerador())+(mcm/fraccion.get(1))*fraccion.get(0));
        respuesta.setDenominador(mcm);
        return respuesta;
    }
    
    /**
     * Resta este fraccionario con otro fraccionario
     * @param otro es otro fraccionario
     * @return este+otro
     */
    public Fraccionario reste (Fraccionario otro) {     
        int mcm=mcm(fraccion.get(1),otro.denominador());
        Fraccionario respuesta = new Fraccionario(1);
        respuesta.setNumerador((mcm/fraccion.get(1))*fraccion.get(0)-((mcm/otro.denominador())*otro.numerador()));
        respuesta.setDenominador(mcm);
        return respuesta;
    }
    
    /**Multiplica este fraccionario con otro fraccionario
     * @param otro El otro fraccionario
     * @return este * otro
     */
    public Fraccionario multiplique (Fraccionario otro) {
        return null;
    }
    
    
    /**Divide este fraccionario sobre otro fraccionario
     * @param otro El otro fraccionario
     * @return este * otro
     */
    public Fraccionario divida (Fraccionario otro) {
        return null;
    }
      
    @Override
    public boolean equals(Object obj) {
        return equals((Fraccionario)obj);
    }    
    
    /**Compara este fraccionario con otro fraccionario
     * @param otro eL otro fraccionario
     * @return true si este fraccionario es igual matem�ticamente al otro fraccionario, False d.l.c.
     */
    public boolean equals (Fraccionario otro) {
        if(fraccion.get(0) == 0 && otro.numerador()==0){
           return true;
        }
        else{
            if(fraccion.get(0) == otro.numerador() && fraccion.get(1) == otro.denominador()){
                return true;
            }
            else{
                return false;
            }
        }
    }


    /** Calcula la representacion en cadena de un fraccionario en formato mixto simplificado
     * @see java.lang.Object#toString(java.lang.Object)
     */
    @Override
    public String toString() {
        return fraccion.get(0)+"/"+fraccion.get(1);
    }
    
}
