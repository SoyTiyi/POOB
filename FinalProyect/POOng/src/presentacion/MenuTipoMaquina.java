package src.presentacion;
import javax.swing.*;
/**
 * Esta clase nos muestra la interfaz grafica para escoger el tipo de maquina 
 */
public class MenuTipoMaquina extends JFrame{

    private static final long serialVersionUID = 1L;

    /**
     * Este es el constructor de la clase
     */
    public MenuTipoMaquina(){

    }


    /**
     * Este metodo nos visuliza la ventana de los tipos de maquinas
     * @param args
     */
    public static void main(String[] args){
        MenuTipoMaquina menu = new MenuTipoMaquina();
        menu.setVisible(true);
    }
}