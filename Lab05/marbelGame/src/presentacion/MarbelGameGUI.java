package presentacion;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import javax.swing.event.*;
//import java.util.*;

public class MarbelGameGUI extends JFrame {
    /**
     * Esta clase nos crea la interfaz grafica del juego
     */
    private static final long serialVersionUID = 1L;

    /* Esta variable nos muestra el titulo del juego*/
    private JLabel tituloJuego;

    /* Estos atributos corresponden a los objetos con los que interactua el usuario*/
    private JButton botonNuevo;
    private JButton botonAbrir;
    private JButton botonSalvarComo;
    /**
     * Este es el contructor nos permite crear los objetos y preparar los elementos de la interfaz grafica
     */
    private MarbelGameGUI() {
        prepareElementos();
        prepareElementosMenu();
        prepareAcciones();
    }

    /**
     * Este metodo nos permite preparar los elementos que tendra nuestra interfaz grafica
     */
    private void prepareElementos(){
        setLayout(null);
        setTitle("Marbell's Game");
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        setBounds(0,0,d.width/2,d.height/2);
        setLocationRelativeTo(null);
        setResizable(false);
        tituloJuego = new JLabel("Marbell's Game");
        tituloJuego.setBounds(300,20,300,30);
        add(tituloJuego);
    }

    /**
     * Este metodo nos prepara los elementos del menu
     */
    private void prepareElementosMenu(){
        botonAbrir = new JButton("Abrir");
        botonNuevo = new JButton("Nuevo");
        botonSalvarComo = new JButton("Salir");
        add(botonAbrir); add(botonNuevo); add(botonSalvarComo);
        botonAbrir.setBounds(300,120,100,40);
        botonNuevo.setBounds(300,170,100,40);
        botonSalvarComo.setBounds(300,220,100,40);
    }
    /**
     * Este metodo nos prepara las acciones de la interfaz grafica
     */
    private void prepareAcciones(){
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev){
                int dialogButton = JOptionPane.YES_NO_OPTION;
                JOptionPane.showConfirmDialog(null,"Esta seguro?","Alerta!",dialogButton);
                if(dialogButton == JOptionPane.YES_OPTION){
                    setVisible(false);
                    setDefaultCloseOperation(EXIT_ON_CLOSE);
                }
                else if(dialogButton == JOptionPane.NO_OPTION){
                    setVisible(true);
                    remove(dialogButton);
                }
            }
        });
    }

    /**
     * Este es el metodo principal y nos permite crear el objeto MerbelGameGUI 
     * @param args
     */
    public static void main(String args[]){
        MarbelGameGUI marbelGameGUI = new MarbelGameGUI();
        marbelGameGUI.setVisible(true);
    }
}