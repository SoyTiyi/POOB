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

        add(backGround);
    }

    /**
     * Este metodo prepara los botones con los que interactua el usuario
     */
    private void prepareBotones(){
        
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