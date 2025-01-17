package presentacion;

import aplicacion.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class AutomataGUI extends JFrame{

    private JButton botonReloj;
    private JMenuBar mb;
    private JMenu menu1;
    private JMenuItem iniciar, salir, salve, abra, exporte, importe;
    private JLabel lFila;
    private JLabel lColumna;
    private JTextField tFila;
    private JTextField tColumna;
    private JPanel panelControl;
    private JPanel panelNueva;
    private JPanel panelBNueva;
    private JButton botonViva;
    private JButton botonLatente;
    private JFileChooser fileChooser = new JFileChooser();
    private FotoAutomata foto;
    private AutomataCelular automata = null;

    public AutomataGUI(AutomataCelular ac) {
        super("Automata celular");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        automata = ac;
        foto = new FotoAutomata(automata);
        setSize(new Dimension(800, 700));
        prepareElementos();
        prepareAcciones();
        prepareAccionesMenu();

    }

    private void prepareElementos() {
        setResizable(false);

        botonReloj = new JButton("Tic-tac");

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(foto, BorderLayout.NORTH);
        getContentPane().add(botonReloj, BorderLayout.SOUTH);

        mb = new JMenuBar();
        menu1 = new JMenu("Opciones");
        iniciar = new JMenuItem("iniciar");
        salir = new JMenuItem("salir");
        salve = new JMenuItem("salve");
        abra = new JMenuItem("abra");
        exporte = new JMenuItem("exporte");
        importe = new JMenuItem("importe");
        menu1.add(iniciar);
        menu1.add(salir);
        menu1.add(salve);
        menu1.add(abra);
        menu1.add(exporte);
        menu1.add(importe);
        mb.add(menu1);
        setJMenuBar(mb);
        foto.repaint();
    }

    private void prepareAccionesMenu() {
        opcionExporte();
        opcionImporte();
        opcionSalvar();
        opcionAbra();
        opcionIniciar();
        opcionSalir();

    }

    private void opcionSalir() {
        salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void opcionIniciar() {
        iniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                automata.nuevoAutomata();
                foto.actualizar();
            }
        });
    }

    private void opcionExporte() {
        exporte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fileChooser.showOpenDialog(fileChooser);
                File file = fileChooser.getSelectedFile();
                try {
                    automata.exporte(file);
                } catch (automataExcepcion e1) {
                    System.out.println(e1.EXPORTE);
                }
            }
        });
    }

    private void opcionImporte(){
        importe.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                fileChooser.showOpenDialog(fileChooser);
                File file = fileChooser.getSelectedFile();
                try {
                    automata.importe03(file);
                    foto.actualizar();
                } catch (automataExcepcion e1) {
                    System.out.println(e1.IMPORTE);               
                } catch (AutomataCompilador e1) {
                    System.out.println(e1.getMessage());
                }
            }
        });
    }

    private void opcionAbra(){
        abra.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                fileChooser.showOpenDialog(fileChooser);
                File file = fileChooser.getSelectedFile();
                try{
                    automata.abra(file);
                    foto.actualizar();
                } catch (automataExcepcion e1){
                    System.out.println(e1.ABRA);
                }
            }
        });
    }

    private void opcionSalvar(){
        salve.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                fileChooser.showSaveDialog(fileChooser);
                File file = fileChooser.getSelectedFile();
                try{
                    automata.salve(file);
                } catch (automataExcepcion e1){
                    System.out.println(e1.SALVE);
                }
            }
        });
    }
    private void prepareAcciones(){

        botonReloj.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    botonRelojAccion();
                }
            });

    }

    private void botonRelojAccion() {
        automata = AutomataCelular.getAutomataCelular();
        automata.ticTac();
        foto.repaint();
    }

    public static void main(String[] args) {
        AutomataCelular ac=  AutomataCelular.getAutomataCelular();
        AutomataGUI ca=new AutomataGUI(ac);
        ca.setVisible(true);

    }  
}

class FotoAutomata extends JPanel{
    public static int TAMANO=40;
    private AutomataCelular automata;

    public FotoAutomata(AutomataCelular ac) {
        setBackground(Color.white);
        automata=ac;
        setPreferredSize(new Dimension(800,800)); 		

    }

    public void actualizar(){
        automata=AutomataCelular.getAutomataCelular();
        repaint();
    }

    public void setAutomata(AutomataCelular automata){
        this.automata=automata;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        for (int f=0;f<=automata.getLongitud();f++){
            g.drawLine(f*TAMANO,0,f*TAMANO,automata.getLongitud()*TAMANO);
        }
        for (int c=0;c<=automata.getLongitud();c++){
            g.drawLine(0,c*TAMANO,automata.getLongitud()*TAMANO,c*TAMANO);
        }		
        for (int f=0;f<automata.getLongitud();f++){
            for(int c=0;c<automata.getLongitud();c++){
                if (automata.getElemento(f,c)!=null){
                    g.setColor(automata.getElemento(f,c).getColor());
                    if (automata.getElemento(f,c).getForma()==Elemento.CUADRADA){                  
                        if (automata.getElemento(f,c).isVivo()){
                            g.drawRoundRect(TAMANO*c+3,TAMANO*f+3,35,35,5,5);
                        }else{
                            g.fillRoundRect(TAMANO*c+3,TAMANO*f+3,35,35,5,5);    

                        }
                    }else {
                        if (automata.getElemento(f,c).isVivo()){
                            g.fillOval(TAMANO*c+10,TAMANO*f+10,20,20);
                        } else {
                            g.drawOval(TAMANO*c+10,TAMANO*f+10,20,20);
                        }
                    }
                }
            }
        }
    }
}