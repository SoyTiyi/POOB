package src.presentacion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Esta clase nos crea la ventana para personalizar el juego 
 */
public class Configuracion extends JFrame{

    private static final long serialVersionUID = 1L;

    private JLabel backGround;
    private JLabel logoOpciones;
    private JButton okButton;
    private JLabel imageOk;
    /**
     * Este metodo es el constructor de la clase
     */
    public Configuracion(){
        prepareElementos();
        prepareOk();
        prepareAcciones();
    }


    /**
     * Este metodo nos prepara el boton ok para la configuracion
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
     * Este metodo nos prepara los elementos de la ventana
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
        ImageIcon imageLogo = new ImageIcon(getClass().getResource("images/Opciones.png"));
        logoOpciones = new JLabel(imageLogo);
        logoOpciones.setBounds(150,-10,410,170);
        backGround.add(logoOpciones);
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
}