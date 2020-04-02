package GUI.presentacion;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class GameGUI extends JFrame implements ActionListener{
    /**
     * Esta clase nos crea la interfaz grafica del juego
     */
    private static final long serialVersionUID = 1L;

    /* Estas contantes son aquellas dimensiones para la ventana principal */
    private static final int ANCHO_PREFERIDO = 450;
    private static final int ALTO_PREFERIDO = 450;

    /* Esta variable nos muestra el titulo del juego*/
    private JLabel tituloJuego;

    /* Estas variables son aquellas que nos ayudan a crear los botones para el menu */
    private JButton botonJugar;
    private JButton botonCargarJuego;
    private JButton botonCerrar;

    private GameGUI() {
        setLayout(null);
        setTitle("Marbell's Game");
        setBounds(0,0,ANCHO_PREFERIDO,ALTO_PREFERIDO);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        prepareElementos();
        prepararTitulos();
    }

    private void prepararTitulos(){
        tituloJuego = new JLabel("Marbell's Game");
        tituloJuego.setBounds(175,20,300,30);
        add(tituloJuego);
    }
    private void prepareElementos(){
       botonJugar = new JButton("Jugar");
       botonCargarJuego= new JButton("Cargar");
       botonCerrar = new JButton("Cerrar");
       botonJugar.setBounds(175,150,100,40); botonCargarJuego.setBounds(175,250,100,40); botonCerrar.setBounds(175,350,100,40);
       add(botonJugar); add(botonCargarJuego); add(botonCerrar);
       botonJugar.addActionListener(this);
       botonCargarJuego.addActionListener(this);
       botonCerrar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == botonJugar){

        }
        else if(e.getSource() == botonCargarJuego){

        }
        else if(e.getSource() == botonCerrar){
            System.exit(0);
        }
    }

    public static void main(String args[]){
        GameGUI gameGUI = new GameGUI();
    }
}