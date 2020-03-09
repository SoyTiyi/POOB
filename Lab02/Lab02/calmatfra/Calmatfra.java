/** Calculadora.java
 * Representa una calculadora de matrices de fraccionarios
 * @author ESCUELA 2018-01
 */

import java.util.HashMap;
public class Calmatfra{

    private HashMap<String, Matriz> variables;
    //Consultar en el API Java la clase HashMap
    private boolean ok;
    public Calmatfra(){
        variables= new HashMap<String,Matriz>();
    }

    /**
     * Este metodo asigna a una variable una matriz
     * @param variable, nombre que llevara la matriz
     * @param matriz, elementos de la matriz
     */
    public void asigne(String variable, int [][][] matriz){
        ok=true;
        Matriz mat = new Matriz (matriz) ;
        variables.put(variable,mat);
    }

    // Los operadores binarios : + (suma), - (resta), . (multiplique elemento a elemento), * (multiplique matricial)
    public void opere(String respuesta, String operando1, char operacion, String operando2){
        if(operacion=='+'){
            Matriz opeOne = variables.get(operando1);
            Matriz opeTwo = variables.get(operando2);
            variables.put(respuesta,opeOne.sume(opeTwo));
        }
        else{
            Matriz opeOne = variables.get(operando1);
            Matriz opeTwo = variables.get(operando2);
            variables.put(respuesta,opeOne.reste(opeTwo));
        }
    }
    
    /**
     * Este metodo retorna el valor de la matriz dependiendo de la variable
     * @param variable String
     * @return valores de la matriz
     */
    public String consulta(String variable){
        ok=true;
        Matriz valor= variables.get(variable);
        String respuesta = valor.toString().replace("/n","");
        return respuesta;
    }
    
    public HashMap getHash(){
        return variables;
    }
    public boolean ok(){
        return this.ok;
    }
}
    



