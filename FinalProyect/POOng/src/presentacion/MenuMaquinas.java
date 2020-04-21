package src.presentacion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Esta clase es la encargada de mostrar los diferentes modos que tiene el juego
 */
public class MenuMaquinas extends JFrame{
    private static final long serialVersionUID = 1L;

    private JLabel logoModo;
    private JButton playerVSplayer;
    private JButton playerVScpu;
    private JButton cpuVScpu;
    private JLabel imagePP;
    private JLabel imagePC;
    private JLabel imageCC;
    private JLabel backGround;
    /**
     * Este es el constructor de la clase
     */
    public MenuMaquinas() {
        getContentPane().setBackground(Color.black);
        prepareElementos();
        prepareAcciones();
    }

    /**
     * Este metodo nos prepara los elementos con los que interactua el ususario
     */
    private void prepareElementos(){
        setLayout(null);
        setTitle("Modos");
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
        ImageIcon imagen = new ImageIcon("C:/Users/santi/Desktop/POOB/FinalProyect/POOng/src/presentacion/images/Modos.png");
        logoModo = new JLabel(imagen);
        logoModo.setBounds(90,5,550,170);
        backGround.add(logoModo);
        playerVSplayer = new JButton();
        playerVSplayer.setBounds(175, 200, 150, 40);
        playerVSplayer.setOpaque(false); playerVSplayer.setContentAreaFilled(false); playerVSplayer.setBorderPainted(false);
        ImageIcon imagenPVP = new ImageIcon("C:/Users/santi/Desktop/POOB/FinalProyect/POOng/src/presentacion/images/playerVSplayer.png");
        imagePP = new JLabel(imagenPVP);
        imagePP.setBounds(175,200,150,40);
        playerVScpu = new JButton();
        playerVScpu.setBounds(435, 200, 150, 40);
        playerVScpu.setOpaque(false); playerVScpu.setContentAreaFilled(false); playerVScpu.setBorderPainted(false);
        ImageIcon imagePVC = new ImageIcon("C:/Users/santi/Desktop/POOB/FinalProyect/POOng/src/presentacion/images/playerVScpu.png");
        imagePC = new JLabel(imagePVC);
        imagePC.setBounds(435, 200, 150, 40);
        cpuVScpu = new JButton();
        cpuVScpu.setBounds(305,300,150,40);
        cpuVScpu.setOpaque(false); cpuVScpu.setContentAreaFilled(false); cpuVScpu.setBorderPainted(false);
        ImageIcon imageCVC = new ImageIcon("C:/Users/santi/Desktop/POOB/FinalProyect/POOng/src/presentacion/images/cpuVScpu.png");
        imageCC = new JLabel(imageCVC);
        imageCC.setBounds(305, 300, 150, 40);
        backGround.add(playerVSplayer); backGround.add(imagePP); backGround.add(playerVScpu); backGround.add(imagePC); backGround.add(cpuVScpu); backGround.add(imageCC);
        add(backGround);
    }

    /**
     * Este metodo nos prepara las acciones de los objetos con los que interactua el usuario
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
        MenuMaquinas menu = new MenuMaquinas();
        menu.setVisible(true);
    }
}