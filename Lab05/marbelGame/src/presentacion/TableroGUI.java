package presentacion;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class TableroGUI extends JFrame{
    /**
     * Esta clase nos genera una nueva ventana en donde se encontrara el juego y el
     * tablero donde el usuario interactuara con el juego
     */
    
    private static final long serialVersionUID = 1L;

    /* Estos atributos hacen parte del panel de botones para mover las Marbels */
    private JPanel panelBotones;
    private JButton norte;
    private JButton sur;
    private JButton este;
    private JButton oeste;
    private JButton guardar;
    private JFileChooser fileChooser;
    /* Estos atriburos hacen parte del panel de informacion */
    private JPanel panelInformacion;

    //Estos atributos son necesarios para dibujar el tablero
    public static int tamaño;
    public static int cantMarbels;
    public static int cantBarriers;
    public static Color color;
    public JPanel espacioJuego;
    //Estos atributos son fundamentales para llevar la cuenta de movimientos,
    //fichas que se ubican y las que no
    private JLabel numMovimientos;
    private JLabel numUbicadas;
    private JLabel numNoUbicadas;
    private int cont=0;

    /**
     * Este metodo es el constructor de la ventana del juego
    */
    public TableroGUI(int tamaño, int cantMarbels, int cantBarriers, Color color){
        fileChooser = new JFileChooser();
        prepareElementosTablero();
        prepareTablero();
        prepareAcciones();
    }

    private void prepareElementosTablero(){
        setLayout(null);
        setTitle("Zona de Juego");
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        setBounds(0,0,d.width/2,d.height/2);
        setLocationRelativeTo(null);
        setResizable(false);
        prepareBotonesMovimientos();
        prepareElementosInformacion();
        guardar = new JButton("Guardar");
        guardar.setBounds(20,300,100,50);
        add(guardar);
    }

    private void prepareBotonesMovimientos(){
        panelBotones = new JPanel();
        panelBotones.setBounds(20,20,250,60);
        panelBotones.setBorder(BorderFactory.createLineBorder(Color.black));
        panelBotones.setLayout(new GridLayout(2,4));
        norte = new JButton("Norte");
        sur= new JButton("Sur");
        este = new JButton("Este");
        oeste = new JButton("Oeste");
        panelBotones.add(norte); panelBotones.add(sur); panelBotones.add(este); panelBotones.add(oeste);
        add(panelBotones);

    }

    private void prepareElementosInformacion(){
        panelInformacion = new JPanel();
        panelInformacion.setBounds(20,90,250,200);
        panelInformacion.setBorder(BorderFactory.createLineBorder(Color.black));
        panelInformacion.setLayout(null);
        JLabel movimientos = new JLabel("Movimientos :");
        movimientos.setBounds(10,40,80,20);
        numMovimientos = new JLabel(""+cont);
        numMovimientos.setBounds(100,40,30,20);
        JLabel ubicadas = new JLabel("Ubicadas :");
        ubicadas.setBounds(10,90,80,20);
        numUbicadas = new JLabel(""+cont);
        numUbicadas.setBounds(100,90,30,20);
        JLabel noUbicadas = new JLabel("No Ubicadas :");
        noUbicadas.setBounds(10,140,80,20);
        numNoUbicadas = new JLabel(""+cont);
        numNoUbicadas.setBounds(100,140,30,20);
        panelInformacion.add(movimientos); panelInformacion.add(ubicadas); panelInformacion.add(noUbicadas);
        panelInformacion.add(numMovimientos); panelInformacion.add(numUbicadas); panelInformacion.add(numNoUbicadas);
        add(panelInformacion);
    }

    private void prepareTablero(){
        espacioJuego = new JPanel();
        espacioJuego.setBounds(330, 20, 300, 300);
        espacioJuego.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel titulo = new JLabel("Aqui va el tablero");
        espacioJuego.add(titulo);
        add(espacioJuego);
    }

    private void prepareAcciones(){
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                setDefaultCloseOperation(EXIT_ON_CLOSE);
            }
        });
        norte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev){
                cont+=1;
                numMovimientos.setText(""+cont);
                /**
                 * Se debe implementar los movimientos en el tablero
                 */
            }
        });

        sur.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev){
                cont+=1;
                numMovimientos.setText(""+cont);
                /**
                 * Se debe de implementar los movimientos en el tablero
                 */
            }
        });

        este.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev){
                cont+=1;
                numMovimientos.setText(""+cont);
                /**
                 * Se debe de implementar los movimientos en el tablero
                 */
            }
        });

        oeste.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev){
                cont+=1;
                numMovimientos.setText(""+cont);
                /**
                 * Se debe de implementar los movimientos en el tablero
                 */
            }
        });

        guardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev){
                fileChooser.showSaveDialog(null);
            }
        });
    }
    
    public static void main(String args[]){
        TableroGUI tableroGUI = new TableroGUI(tamaño,cantMarbels,cantBarriers,color);
        tableroGUI.setVisible(true);
    }
}