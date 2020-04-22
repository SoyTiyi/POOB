package src.presentacion;
import javax.swing.*;
import java.awt.*;
/**
 * Esta clase nos muestra la ventana para la zona de juego 
 */
public class ZonaDeJuego extends JFrame{

    private static final long serialVersionUID = 1L;
    private JLabel backGround;
    /**
     * Este es el constructor para la ventana de juego
     */
    public ZonaDeJuego(){
        prepareElementos();
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


    public static void main(String[] args){
        ZonaDeJuego zona = new ZonaDeJuego();
        zona.setVisible(true);
    }
}