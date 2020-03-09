/**
 * @author ECI, 2019
 *
 */
public class Matriz{

    private Fraccionario [][] matriz;
    /**
     * Retorna una matriz dados sus elementos. Los fraccionarios se representan como {numerador, denominador}
     */
    
    public static boolean esMatriz (int [][][] elementos){
        return false;
    }
    
    /**
     * Este metodo crea una matriz a partir de un cubo de enteros
     * @param elementos de tipo int
     */
    public Matriz (int [][][] elementos) {
        matriz = new Fraccionario [elementos.length][elementos[0].length];
        for(int i=0;i<elementos.length;i++){
            for(int j=0;j<elementos[0].length;j++){
                matriz[i][j]=new Fraccionario(elementos[i][j][0],elementos[i][j][1]);
            }
        }
    }    
    
    private Fraccionario[][] getMatriz(){
        return matriz;
    }
    
    /**
     * Retorna una matriz dados sus elementos. 
     */
    public  Matriz (Fraccionario  elementos[][]) {
        matriz = new Fraccionario [elementos.length][elementos[0].length];
        for(int i=0;i<elementos.length;i++){
            for(int j=0;j<elementos[0].length;j++){
                matriz[i][j]=elementos[i][j];
            }
        }
    }
   
    
     /**
     * Retorna una matriz dada su diagonal. 
     */    
    public Matriz (Fraccionario d []){

    }    

    /**
     * Retorna una matriz de un numero repetido dada su dimension. 
     */
    public Matriz (Fraccionario e, int f, int c) {

    }
    
    /**
     * Retorna una matriz identidad dada su dimension. 
     */
    public Matriz (int n) {
    }
    
    
    public Matriz dimension(){
        return null;
    }
    
    
    public Fraccionario get(int f, int c){
        return matriz[f][c];
    }
    
    /**
     * Compara esta matriz con otra
     */
    public boolean equals (Matriz otra) {
        return false;
    }

    /** 
     * Compara esta matriz con otra
     */
    @Override
    public boolean equals(Object otra) {
            return false;
    }
    
    
    /** 
     * Retorna una cadena con los datos de la matriz alineado a derecha por columna
     * @return answer que es los datos alineado a derecha por columna 
    */
    @Override
    public String toString () {
        String answer = "";
        for(int i=0;i<matriz.length;i++){
            answer +=" ";
            for(int j=0;j<matriz[0].length;j++){
                answer += matriz[i][j].toString()+" ";
            }
        }
        return answer;
    }   
    
    private int getFila(){
        return matriz.length;
    }
    
    private int getColumna(){
        return matriz[0].length;
    }
    
    //Retorna la matriz con el numero de filas o columnas
    public Matriz sume(Matriz m){
        int filas = m.getFila();
        int columnas = m.getColumna();
        Fraccionario [][] ele = new Fraccionario[filas][columnas];
        if(matriz.length==filas && matriz[0].length==columnas){
            for(int i=0;i<filas;i++){
                for(int j=0;j<columnas;j++){
                    Fraccionario fra = matriz[i][j].sume(m.get(i,j));
                    ele[i][j]=fra;
                }
            }
            Matriz answer = new Matriz(ele);
            return answer;
        }
        else{
            return null;
        }
    }
    
    /**
     * Este metodo resta dos matrices
     * @param m es otra matriz
     * @return answer de tipo matriz 
     */
    public Matriz reste(Matriz m){
        int filas = m.getFila();
        int columnas = m.getColumna();
        Fraccionario [][] ele = new Fraccionario[filas][columnas];
        if(matriz.length==filas && matriz[0].length==columnas){
            for(int i=0;i<filas;i++){
                for(int j=0;j<columnas;j++){
                    Fraccionario fra = matriz[i][j].reste(m.get(i,j));
                    ele[i][j]=fra;
                }
            }
            Matriz answer = new Matriz(ele);
            return answer;
        }
        else{
            return null;
        }
    }
}
