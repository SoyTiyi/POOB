package src.presentacion;

import javax.swing.*;

import src.aplicacion.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
/**
 * Esta clase nos muestra la ventana para la zona de juego 
 */
public class ZonaDeJuego extends JFrame{

    private static final long serialVersionUID = 1L;
    private JLabel backGround;
    private String modo;
    private TableroJuego tablero;
    private Timer timer;
    private Poong poong;
    private JFileChooser fileChooser = new JFileChooser();
    /**
     * Este es el constructor para la ventana de juego
     */
    public ZonaDeJuego(String modo, Poong poong){
        this.poong=poong;
        this.modo=modo;
        prepareElementos();
        prepareAcciones();
        prepareTablero();
        setVisible(true);
    }

    /**
     * Este metodo nos prepara la plantilla en donde se ubicara los objetos para el juego
     */
    private void prepareTablero(){
        tablero = new TableroJuego(poong);
        backGround.add(tablero);
    }

    /**
     * Este metodo lee el archivo 
     */
    public void opcionAbrir(File file){
        poong.abrir(file);
        poong = Poong.getPong();
        tablero.actualizar();
    }

    /**
     * Este metodo es el encargado de salvar el archivo
     */
    public void opcionSalve(){
        fileChooser.showSaveDialog(fileChooser);
        File file = fileChooser.getSelectedFile();
        poong.salve(file);
    }

    /**
     * Este metodo prepara los elementos con los que interactua el usuario
     */
    private void prepareElementos(){
        setLayout(null);
        setTitle("Zona de Juego");
        setIconImage(new ImageIcon(getClass().getResource("images/icon2.png")).getImage());
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        setBounds(0,0,d.width/2+50,d.height/2+50);
        setLocationRelativeTo(null);
        setResizable(false);
        ImageIcon back = new ImageIcon("C:/Users/santi/Desktop/POOB/FinalProyect/POOng/src/presentacion/images/background.jpg");
        backGround = new JLabel(back);
        backGround.setBounds(0,0,d.width/2+50,d.height/2+50);
        backGround.setLayout(null);
        add(backGround);
    }

    /**
     * Este metodo nos prepara las acciones de los bojetos con los que interactua el usuario
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
                    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                }
            }
        });
        timer = new Timer(5,new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tablero.actualizar();
                tablero.repaint();
            }
        });
        timer.start();
        addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                int id = e.getKeyCode();
                if(id == KeyEvent.VK_G){
                    timer.stop();
                    opcionSalve();
                    System.exit(0);
                }

                if(id == KeyEvent.VK_P){
                    if(timer.isRunning()){
                        timer.stop();
                    }
                    else{
                        timer.start();
                    }
                }
            }
        });
        addKeyListener(new EventoTeclado());
    }

    /**
     * 
     * Metodo principal para mostrar la ventana
     */
    public static void main(String[] args){
        ZonaDeJuego zona = new ZonaDeJuego("",Poong.getPong());
        zona.setVisible(true);
    }
}
