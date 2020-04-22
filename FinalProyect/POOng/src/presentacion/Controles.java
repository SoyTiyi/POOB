package src.presentacion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Esta clase nos muestra los controles dependiendo del modo
 */
public class Controles extends JFrame{

    
    private static final long serialVersionUID = 1L;

    private JLabel backGround;
    private JLabel logoControles;
    private JLabel playerUno;
    private JLabel playerDos;
    private JButton okButton;
    private JButton atras;
    private JLabel imageAtras;
    private JLabel imageOk;
    /**
     * Este es el constructor de la clase
     * @param modo
     */
    public Controles(String modo){
        prepareElementos();
        if(modo.equals("")){
            prepareElementosUno();
        }
        else{
            prepareElementosDos();;
        }
        prepareOk();
        prepareAtras();
        prepareAcciones();
    }

    /**
     * Este metodo prepara el boton OK
     */
    private void prepareOk(){
        okButton = new JButton();
        okButton.setOpaque(false); okButton.setContentAreaFilled(false); okButton.setBorderPainted(false);
        okButton.setBounds(570, 330, 140,60);
        backGround.add(okButton);
        ImageIcon imagenOk = new ImageIcon("C:/Users/santi/Desktop/POOB/FinalProyect/POOng/src/presentacion/images/Ok.png");
        imageOk = new JLabel(imagenOk);
        imageOk.setBounds(570, 330, 135, 60);
        backGround.add(imageOk);
    }
    /**
     * Este metodo prepara el fondo del entorno grafico
     */
    private void prepareElementos(){
        setLayout(null);
        setTitle("Controles");
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
        ImageIcon imagen = new ImageIcon("C:/Users/santi/Desktop/POOB/FinalProyect/POOng/src/presentacion/images/Controles.png");
        logoControles = new JLabel(imagen);
        logoControles.setBounds(90,5,550,150);
        backGround.add(logoControles);
        add(backGround);
    }

    /**
     * Este metodo nos prepara las imagenes para cuando juega un solo jugador 
     */
    private void prepareElementosUno(){
        ImageIcon imagePlaUno = new ImageIcon("C:/Users/santi/Desktop/POOB/FinalProyect/POOng/src/presentacion/images/Player1G.png");
        playerUno = new JLabel(imagePlaUno);
        playerUno.setBounds(110, 170, 220, 70);
        backGround.add(playerUno);
        ImageIcon imageA = new ImageIcon("C:/Users/santi/Desktop/POOB/FinalProyect/POOng/src/presentacion/images/A.png");
        ImageIcon imageD = new ImageIcon("C:/Users/santi/Desktop/POOB/FinalProyect/POOng/src/presentacion/images/D.png");
        JLabel teclaA = new JLabel(imageA); JLabel teclaD = new JLabel(imageD);
        teclaA.setBounds(130, 250, 60, 60); teclaD.setBounds(230, 250, 60, 60);
        backGround.add(teclaA); backGround.add(teclaD);
        ImageIcon imageP = new ImageIcon("C:/Users/santi/Desktop/POOB/FinalProyect/POOng/src/presentacion/images/Pausa.png");
        JLabel pausa = new JLabel(imageP);
        pausa.setBounds(450, 170, 160, 60);
        ImageIcon imageTeclaP = new ImageIcon("C:/Users/santi/Desktop/POOB/FinalProyect/POOng/src/presentacion/images/P.png");
        JLabel teclaP = new JLabel(imageTeclaP);
        teclaP.setBounds(500, 250, 45, 60);
        backGround.add(pausa); backGround.add(teclaP);
    }

    /**
     * Este metodo nos prepara el boton para devolvernos 
     */
    private void prepareAtras(){
        atras = new JButton();
        atras.setOpaque(false); atras.setContentAreaFilled(false); atras.setBorderPainted(false);
        atras.setBounds(20, 20 , 50 , 50);
        ImageIcon imagenAtras = new ImageIcon("C:/Users/santi/Desktop/POOB/FinalProyect/POOng/src/presentacion/images/Atras.png");
        imageAtras = new JLabel(imagenAtras);
        imageAtras.setBounds(20, 20, 50, 50);
        backGround.add(atras); backGround.add(imageAtras);
    }

    /**
     * Este metodo nos prepara las imagenes cuando van a jugar dos jugadores
     */
    private void prepareElementosDos(){

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

        atras.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                setVisible(false);
                MenuMaquinas menu = new MenuMaquinas();
                menu.setVisible(true);
            }
        });
    }
    /**
     * Este metodo nos visualiza la ventana 
     * @param args
     */
    public static void main(String[] args){
        Controles controles = new Controles("");
        controles.setVisible(true);
    }
}