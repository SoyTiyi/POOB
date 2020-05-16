package src.presentacion;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import src.aplicacion.*;
import javax.swing.*;
import javax.swing.ImageIcon;

/**
 * Esta clase nos crea el menu principal en donde
 * tenemos las opciones de juego
 * 
 * @author Santiago Martinez
 * @version 1.0
 */
public class MenuPOOng extends JFrame{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * Esta clase se encarga de presentar la ventana principal Se encarga de la
     * creacion de los objetos con los que interactua el usuario
     */
    private JButton botonJugar;
    private JButton botonAbrir;
    private JButton botonSalir;
    private JLabel logoPong;
    private JLabel imageJugar;
    private JLabel imageAbrir;
    private JLabel imageCerrar;
    private JLabel backGround;
    private JFileChooser fileChooser = new JFileChooser();

     /**
      * Esta clase es el constructor de nuestra ventana para el menu de POOng
      */
    public MenuPOOng(){
        getContentPane().setBackground(Color.black);
        prepareElementos();
        prepareAcciones();
    }

    /**
     * Este metodo nos prepara los elementos de la ventana
    */
    private void prepareElementos(){
        setLayout(null);
        setTitle("Menu");
        setIconImage(new ImageIcon(getClass().getResource("images/icon2.png")).getImage());
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        setBounds(0,0,d.width/2+50,d.height/2+50);
        setLocationRelativeTo(null);
        setResizable(false);
        ImageIcon back = new ImageIcon(getClass().getResource("images/background.jpg"));
        backGround = new JLabel(back);
        backGround.setBounds(0,0,d.width/2+50,d.height/2+50);
        backGround.setLayout(null);
        prepareBotones();
        add(backGround);
    }

    /**
     * Este metodo nos prepara los objetos con los que interactua el usuario
     */
    private void prepareBotones(){
        ImageIcon imagen = new ImageIcon(getClass().getResource("images/poong.png"));
        logoPong = new JLabel(imagen);
        logoPong.setBounds(90,5,550,170);
        backGround.add(logoPong);
        botonJugar = new JButton();
        botonJugar.setBounds(300, 180, 130, 50);
        botonJugar.setOpaque(false); botonJugar.setContentAreaFilled(false); botonJugar.setBorderPainted(false);;
        ImageIcon imagenJugar = new ImageIcon(getClass().getResource("images/Jugar.png"));
        imageJugar = new JLabel(imagenJugar);
        imageJugar.setBounds(300,180,130,50);
        botonAbrir= new JButton();
        botonAbrir.setBounds(300, 250, 130, 50);
        botonAbrir.setOpaque(false); botonAbrir.setContentAreaFilled(false); botonAbrir.setBorderPainted(false);
        ImageIcon imagenAbrir = new ImageIcon(getClass().getResource("images/Abrir.png"));
        imageAbrir = new JLabel(imagenAbrir);
        imageAbrir.setBounds(300, 250, 130, 50);
        botonSalir = new JButton();
        botonSalir.setBounds(300, 320, 130, 50);
        botonSalir.setOpaque(false); botonSalir.setContentAreaFilled(false); botonSalir.setBorderPainted(false);
        ImageIcon imagenSalir = new ImageIcon(getClass().getResource("images/Cerrar.png"));
        imageCerrar = new JLabel(imagenSalir);
        imageCerrar.setBounds(300, 320, 130, 50);
        backGround.add(botonJugar); backGround.add(imageJugar); backGround.add(botonAbrir); backGround.add(imageAbrir); backGround.add(botonSalir); backGround.add(imageCerrar);
    }
    
    /**
     * Este metodo prepara las acciones para los objetos con los que se interactua 
     * 
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

        botonSalir.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                int dialogButton = JOptionPane.YES_NO_OPTION;
                JOptionPane.showConfirmDialog(null,"Esta seguro?","Alerta!",dialogButton);
                if(dialogButton == JOptionPane.YES_OPTION){
                    setVisible(false);
                    System.exit(0);
                }
                else if(dialogButton == JOptionPane.NO_OPTION){
                    remove(dialogButton);
                }
            }
        });

        botonJugar.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                setVisible(false);
                MenuMaquinas menu = new MenuMaquinas();
                menu.setVisible(true);
            }
        });

        botonAbrir.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                int returnVal = fileChooser.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    Poong poong = Poong.getPong();
                    poong.abrir(file);
                    ZonaDeJuego zona = new ZonaDeJuego("",Poong.getPong());
                    zona.setVisible(true);
                }
            }
        });
    }
    
     /**
      * Este metodo nos permite arrancar el programa y visualizar la pantalla
      */
     public static void main(String args[]){
         MenuPOOng menu = new MenuPOOng();
         menu.setVisible(true);
     }
}