package src.presentacion;
import javax.swing.*;
import java.awt.*;
/**
 * Esta clase nos muestra la interfaz grafica para escoger el tipo de maquina 
 */
public class MenuTipoMaquina extends JFrame{

    private static final long serialVersionUID = 1L;

    /**
     * Este es el constructor de la clase
     */
    private JLabel backGround;
    private JLabel logoTipo;
    private JButton lazy;
    private JButton expert;
    private JButton snipe;
    private JButton greedy;
    private JLabel imageLazy;
    private JLabel imageExpert;
    private JLabel imageSnipe;
    private JLabel imageGreedy;

    public MenuTipoMaquina(){
        getContentPane().setBackground(Color.black);
        prepareElementos();
    }

    /**
     * Este metodo nos prepara los elementos con los que interactua el usuario
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
        ImageIcon imagen = new ImageIcon("C:/Users/santi/Desktop/POOB/FinalProyect/POOng/src/presentacion/images/Tipo.png");
        logoTipo = new JLabel(imagen);
        logoTipo.setBounds(90,5,550,170);
        backGround.add(logoTipo);
        prepareBotones();
        add(backGround);
    }

    /**
     * Este metodo prepara los botones con los que interactua el usuario
     */
    private void prepareBotones(){
        lazy = new JButton();
        lazy.setBounds(160, 200, 150, 40);
        lazy.setOpaque(false); lazy.setContentAreaFilled(false); lazy.setBorderPainted(false);
        ImageIcon imagenLazy = new ImageIcon("C:/Users/santi/Desktop/POOB/FinalProyect/POOng/src/presentacion/images/lazy.png");
        imageLazy = new JLabel(imagenLazy);
        imageLazy.setBounds(160,200,150,40);
        expert = new JButton();
        expert.setBounds(420, 200, 150, 40);
        expert.setOpaque(false); expert.setContentAreaFilled(false); expert.setBorderPainted(false);
        ImageIcon imagenExpert = new ImageIcon("C:/Users/santi/Desktop/POOB/FinalProyect/POOng/src/presentacion/images/Expert.png");
        imageExpert = new JLabel(imagenExpert);
        imageExpert.setBounds(420, 200, 150, 40);
        snipe = new JButton();
        snipe.setBounds(160, 300, 150, 40);
        snipe.setOpaque(false); snipe.setContentAreaFilled(false); snipe.setBorderPainted(false);
        ImageIcon imagenSnipe = new ImageIcon("C:/Users/santi/Desktop/POOB/FinalProyect/POOng/src/presentacion/images/Sniper.png");
        imageSnipe = new JLabel(imagenSnipe);
        imageSnipe.setBounds(160, 300, 150, 40);
        greedy = new JButton();
        greedy.setBounds(420, 300, 150, 40);
        greedy.setOpaque(false); greedy.setContentAreaFilled(false); greedy.setBorderPainted(false);
        ImageIcon imagenGreedy = new ImageIcon("C:/Users/santi/Desktop/POOB/FinalProyect/POOng/src/presentacion/images/greedy.png");
        imageGreedy = new JLabel(imagenGreedy);
        imageGreedy.setBounds(420,300,150,40);
        backGround.add(lazy);backGround.add(imageLazy);  backGround.add(expert); backGround.add(imageExpert); backGround.add(snipe); backGround.add(expert); backGround.add(imageExpert); backGround.add(imageSnipe); backGround.add(greedy); backGround.add(imageGreedy);
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