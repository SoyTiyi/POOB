package src.presentacion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import src.aplicacion.*;
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
    private String modo;
    /**
     * Este es el constructor de la clase
     * @param modo
     */
    public Controles(String modo){
        this.modo=modo;
        prepareElementos();
        if(modo.equals("dos")){
            prepareElementosDos();
        }
        if(modo.equals("uno")){
            prepareElementosUno();
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
        ImageIcon imagenOk = new ImageIcon(getClass().getResource("images/Ok.png"));
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
        ImageIcon back = new ImageIcon(getClass().getResource("images/background.jpg"));
        backGround = new JLabel(back);
        backGround.setBounds(0,0,d.width/2+50,d.height/2+50);
        backGround.setLayout(null);
        ImageIcon imagen = new ImageIcon(getClass().getResource("images/Controles.png"));
        logoControles = new JLabel(imagen);
        logoControles.setBounds(90,5,550,150);
        backGround.add(logoControles);
        add(backGround);
    }

    /**
     * Este metodo nos prepara las imagenes para cuando juega un solo jugador 
     */
    private void prepareElementosUno(){
        ImageIcon imagePlaUno = new ImageIcon(getClass().getResource("images/Player1G.png"));
        playerUno = new JLabel(imagePlaUno);
        playerUno.setBounds(110, 170, 220, 70);
        backGround.add(playerUno);
        ImageIcon imageA = new ImageIcon(getClass().getResource("images/A.png"));
        ImageIcon imageD = new ImageIcon(getClass().getResource("images/D.png"));
        JLabel teclaA = new JLabel(imageA); JLabel teclaD = new JLabel(imageD);
        teclaA.setBounds(130, 250, 60, 60); teclaD.setBounds(230, 250, 60, 60);
        backGround.add(teclaA); backGround.add(teclaD);
        ImageIcon imageP = new ImageIcon(getClass().getResource("images/Pausa.png"));
        JLabel pausa = new JLabel(imageP);
        pausa.setBounds(450, 170, 160, 60);
        ImageIcon imageTeclaP = new ImageIcon(getClass().getResource("images/P.png"));
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
        ImageIcon imagenAtras = new ImageIcon(getClass().getResource("images/Atras.png"));
        imageAtras = new JLabel(imagenAtras);
        imageAtras.setBounds(20, 20, 50, 50);
        backGround.add(atras); backGround.add(imageAtras);
    }

    /**
     * Este metodo nos prepara las imagenes cuando van a jugar dos jugadores
     */
    private void prepareElementosDos(){
        ImageIcon imagePlaUno = new ImageIcon(getClass().getResource("images/Player1.png"));
        playerUno = new JLabel(imagePlaUno);
        playerUno.setBounds(40, 170, 220, 70);
        backGround.add(playerUno);
        ImageIcon imageA = new ImageIcon(getClass().getResource("images/A.png"));
        ImageIcon imageD = new ImageIcon(getClass().getResource("images/D.png"));
        JLabel teclaA = new JLabel(imageA); JLabel teclaD = new JLabel(imageD);
        teclaA.setBounds(70, 260, 60, 60); teclaD.setBounds(170, 260, 60, 60);
        backGround.add(teclaA); backGround.add(teclaD);
        ImageIcon imagePlaDos = new ImageIcon(getClass().getResource("images/Player2.png"));
        playerDos = new JLabel(imagePlaDos);
        playerDos.setBounds(240, 170, 220, 70);
        backGround.add(playerDos);
        ImageIcon imageDer = new ImageIcon(getClass().getResource("images/Izquierda.png"));
        ImageIcon imageIzq = new ImageIcon(getClass().getResource("images/Derecha.png"));
        JLabel teclaDer = new JLabel(imageDer); JLabel teclaIzq = new JLabel(imageIzq);
        teclaDer.setBounds(270, 260, 60, 60); teclaIzq.setBounds(370, 260, 60, 60);
        backGround.add(teclaDer); backGround.add(teclaIzq);
        ImageIcon imageP = new ImageIcon(getClass().getResource("images/Pausa.png"));
        JLabel pausa = new JLabel(imageP);
        pausa.setBounds(450, 170, 160, 60);
        ImageIcon imageTeclaP = new ImageIcon(getClass().getResource("images/P.png"));
        JLabel teclaP = new JLabel(imageTeclaP);
        teclaP.setBounds(500, 260, 45, 60);
        backGround.add(pausa); backGround.add(teclaP);
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

        okButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                setVisible(false);
                ZonaDeJuego zona = new ZonaDeJuego(modo,Poong.getPong());
                zona.setVisible(true);
            }
        });

        atras.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                setVisible(false);
                if(modo.equals("")){
                    MenuMaquinas menu = new MenuMaquinas();
                    menu.setVisible(true); 
                }
                else{
                    MenuTipoMaquina menu = new MenuTipoMaquina();
                    menu.setVisible(true);
                }
            }
        });
    }
}