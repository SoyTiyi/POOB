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
    private JButton botonCerrar;
    private JButton botonGuardar;
    private JFileChooser fileChooser;
    /**
     * Este es el contructor nos permite crear los objetos y preparar los elementos de la interfaz grafica
     */
    private MarbelGameGUI() {
        fileChooser = new JFileChooser();
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
        botonGuardar = new JButton("Guardar");
        botonCerrar = new JButton("Cerrar");
        add(botonAbrir); add(botonNuevo); add(botonCerrar); add(botonGuardar);
        botonNuevo.setBounds(300,120,100,40);
        botonAbrir.setBounds(300,170,100,40);
        botonGuardar.setBounds(300,220,100,40);
        botonCerrar.setBounds(300,270,100,40);
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

        botonCerrar.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent ev){
                System.exit(0);
            }
        });

        botonAbrir.addActionListener(new ActionListener() {
            public void actionPerformed( ActionEvent ev){
                fileChooser.showOpenDialog(null);
                /**
                 * Al seleccionar el archivo este sera utilizado para cargar la partida
                 * que deseamos seguir jugando
                 */
            }
        });

        botonGuardar.addActionListener(new ActionListener() {
            public void actionPerformed( ActionEvent ev){
                fileChooser.showSaveDialog(null);
                /**
                 * Al seleccionar el archivo este sera utilizado para huardar la partida
                 * en la que estabamos 
                 */
            }
        });

        botonNuevo.addActionListener(new ActionListener() {
            public void actionPerformed( ActionEvent ex) {
                ConfiguracionGUI configuracionGUI = new ConfiguracionGUI();
                configuracionGUI.setVisible(true);
                setVisible(false);
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