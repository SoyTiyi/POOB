

public class Marbell{
    /**
     * Esta clase gestiona el funcionamiento del juego Marbells Game
     * 
     * @author Santiago Martinez Martinez
     * @version 1.0
     */
    private int tamaño;
    private String color;
    private int xPosition;
    private int yPosition;
    private int moviminetosHechos=0;
    private int numBarreras;
    private int numMarbells;
    // La clase Elemento tiene como hijos a los objetos Marbell y Barrera
    private Elementos[][] tablero;
    /**
     * Este es el constructor de la clase Marbells, esta clase nos permite generar el tablero, mover cada marbel dependiendo del movimiento que el usuario quiera
     * @param tamaño hace referencia al tamaño del tablero deseado
     * @param color hace referencua al color que deseamos para el tablero
     * @param numBarreras hace referencia al numero de barreras que deseamos poner en el tablero
     * @param numMarbells hace referencia al numero de Marbells que deseamos poner en el tablero
     */
    public Marbell(int tamaño, String color, int numBarreras, int numMarbells){
        this.tamaño=tamaño;
        this.color=color;
        this.numBarreras=numBarreras;
        this.numMarbells=numMarbells;
        tablero = new Elementos[tamaño][tamaño];
    }
    /**
     * Este metodo crear la cantidad de Marbells que desea el usuario
     */
    public void crearMarbells(){}

    /**
     * Este metodo crea la cantidad de Barreras que desea el usuario
     */
    public void crearBarreras(){}

    /**
     * Este metodo realiza el movimiento dependiendo de la cordenada que se desea, en este metodo tambien contamos los movimientos hechos
     * @param cordenada hace referencia a que lado se quiere levantar el tablero (Norte,Sur,Este y Oeste)
     */
    public void move(String cordenada){
        moviminetosHechos+=1;
    }

    /**
     * Este metodo reconfigura el tablero al insertar la Marbells en su agujero deseado 
     */
    public void reconfigurarTablero(){}
}