package src.presentacion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
    private JButton atras;
    private JLabel imageLazy;
    private JLabel imageExpert;
    private JLabel imageSnipe;
    private JLabel imageGreedy;
    private JLabel imageAtras;

    /**
     * Este es el constructor de la clase
     */
    public MenuTipoMaquina(){
        getContentPane().setBackground(Color.black);
        prepareElementos();
        prepareAcciones(); 
    }

    /**
     * Este metodo nos prepara el boton que nos devuelve a la ventana anterior
     */
    private void prepareAtras(){
        atras = new JButton();
        atras.setOpaque(false); atras.setContentAreaFilled(false); atras.setBorderPainted(false);
        atras.setBounds(20, 20 , 50 , 50);
        ImageIcon imagenAtras = new ImageIcon(getClass().getResource("images/Atras.png"));
        imageAtras = new JLabel(imagenAtras);
        imageAtras.setBounds(20, 20, 50, 50);
        backGround.add(atras); backGround.add(imageAtras);
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
        ImageIcon back = new ImageIcon(getClass().getResource("images/background.jpg"));
        backGround = new JLabel(back);
        backGround.setBounds(0,0,d.width/2+50,d.height/2+50);
        backGround.setLayout(null);
        ImageIcon imagen = new ImageIcon(getClass().getResource("images/Tipo.png"));
        logoTipo = new JLabel(imagen);
        logoTipo.setBounds(90,5,550,170);
        backGround.add(logoTipo);
        prepareBotones();
        prepareAtras();
        add(backGround);
    }

    /**
     * Este metodo prepara los botones con los que interactua el usuario
     */
    private void prepareBotones(){
        lazy = new JButton();
        lazy.setBounds(160, 200, 150, 40);
        lazy.setOpaque(false); lazy.setContentAreaFilled(false); lazy.setBorderPainted(false);
        ImageIcon imagenLazy = new ImageIcon(getClass().getResource("images/lazy.png"));
        imageLazy = new JLabel(imagenLazy);
        imageLazy.setBounds(160,200,150,40);
        expert = new JButton();
        expert.setBounds(420, 200, 150, 40);
        expert.setOpaque(false); expert.setContentAreaFilled(false); expert.setBorderPainted(false);
        ImageIcon imagenExpert = new ImageIcon(getClass().getResource("images/Expert.png"));
        imageExpert = new JLabel(imagenExpert);
        imageExpert.setBounds(420, 200, 150, 40);
        snipe = new JButton();
        snipe.setBounds(160, 300, 150, 40);
        snipe.setOpaque(false); snipe.setContentAreaFilled(false); snipe.setBorderPainted(false);
        ImageIcon imagenSnipe = new ImageIcon(getClass().getResource("images/Sniper.png"));
        imageSnipe = new JLabel(imagenSnipe);
        imageSnipe.setBounds(160, 300, 150, 40);
        greedy = new JButton();
        greedy.setBounds(420, 300, 150, 40);
        greedy.setOpaque(false); greedy.setContentAreaFilled(false); greedy.setBorderPainted(false);
        ImageIcon imagenGreedy = new ImageIcon(getClass().getResource("images/greedy.png"));
        imageGreedy = new JLabel(imagenGreedy);
        imageGreedy.setBounds(420,300,150,40);
        backGround.add(lazy);backGround.add(imageLazy);  backGround.add(expert); backGround.add(imageExpert); backGround.add(snipe); backGround.add(expert); backGround.add(imageExpert); backGround.add(imageSnipe); backGround.add(greedy); backGround.add(imageGreedy);
    }

    /**
     * Este metodo nos configura las acciones para los objetos con los que interactua el usuario
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

        lazy.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                setVisible(false);
                Controles controles = new Controles("lazy");
                controles.setVisible(true);
            }
        });

        expert.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                setVisible(false);
                Controles controles = new Controles("expert");
                controles.setVisible(true);
            }
        });

        snipe.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                setVisible(false);
                Controles controles = new Controles("snipe");
                controles.setVisible(true);
            }
        });

        greedy.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                setVisible(false);
                Controles controles = new Controles("greedy");
                controles.setVisible(true);
            }
        });
        
        atras.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                setVisible(false);
                MenuMaquinas menu = new MenuMaquinas();
                menu.setVisible(true);
            }
        });
    }
}