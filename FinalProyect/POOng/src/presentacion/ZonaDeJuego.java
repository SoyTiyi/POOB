package src.presentacion;
import javax.swing.*;
import src.aplicacion.Pelota;
import java.awt.*;
import java.awt.event.*;
/**
 * Esta clase nos muestra la ventana para la zona de juego 
 */
public class ZonaDeJuego extends JFrame{

    private static final long serialVersionUID = 1L;
    private JLabel backGround;
    private String modo;
    private TableroJuego tablero;
    /**
     * Este es el constructor para la ventana de juego
     */
    public ZonaDeJuego(String modo){
        this.modo=modo;
        prepareElementos();
        prepareAcciones();
        prepareTablero();
    }

    /**
     * Este metodo nos prepara la plantilla en donde se ubicara los objetos para el juego
     */
    private void prepareTablero(){
        tablero = new TableroJuego();
        backGround.add(tablero);
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
        ImageIcon back = new ImageIcon("C:/Users/santi/Desktop/POOB/FinalProyect/POOng/src/presentacion/images/background1.png");
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
    }

    public static void main(String[] args){
        ZonaDeJuego zona = new ZonaDeJuego("");
        zona.setVisible(true);
    }
}

class TableroJuego extends JPanel{

    /**
     *Esta clase nos permite adquierir la plantilla en donde se jugara
     */
    private static final long serialVersionUID = 1L;

    /**
     * Este es el encargado de dibujar el tablero en donde se 
     */
    private Pelota pelota;
    public TableroJuego(){
        pelota = new Pelota(0,0);
        prepareElementos();
    }

    /**
     * Este metodo nos permite preparar los elemntos los cuales seran las raquetas y las pelotas
     */
    private void prepareElementos(){
        setBackground(Color.black);
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        setSize(d.width/2+50,d.height/2+50);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.white);
        dibujar(g2);
        actualizar();
    }

    public void dibujar(Graphics2D g){
        g.fill((Shape) pelota.getPelota());
    }
    
    public void actualizar(){
        pelota.mover();
    }
}