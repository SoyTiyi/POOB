package presentacion;
import aplicacion.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

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
    private JButton reiniciar;
    private JFileChooser fileChooser;
    /* Estos atriburos hacen parte del panel de informacion */
    private JPanel panelInformacion;
    private Font fuente = new Font("Times New Roman",Font.BOLD,12);
    //Estos atributos son necesarios para dibujar el tablero
    public static int tamaño;
    public static int cantMarbels;
    public static int cantBarriers;
    public static Color colorTablero;
    public static Color colorLineas;
    public JPanel espacioJuego;
    //Estos atributos son fundamentales para llevar la cuenta de movimientos,
    //fichas que se ubican y las que no
    private JLabel numMovimientos;
    private JLabel numUbicadas;
    private JLabel numNoUbicadas;
    private int cont=0;
    private MarbelGame marbelgame;

    /**
     * Este metodo es el constructor de la ventana del juego
    */
    public TableroGUI(int tamaño, int cantMarbels, int cantBarriers, Color colorTablero, Color colorLineas){
        TableroGUI.tamaño = tamaño;
        TableroGUI.cantMarbels = cantMarbels;
        TableroGUI.cantBarriers = cantBarriers;
        TableroGUI.colorTablero = colorTablero;
        TableroGUI.colorLineas = colorLineas;
        marbelgame = new MarbelGame(tamaño, cantMarbels, cantBarriers);
        fileChooser = new JFileChooser();
        prepareElementosTablero();
        prepareTablero();
        prepareAcciones();
    }

    private void prepareElementosTablero(){
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        setTitle("Zona de Juego");
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        setBounds(0,0,d.width/2,d.height/2);
        setLocationRelativeTo(null);
        setResizable(false);
        prepareBotonesMovimientos();
        prepareElementosInformacion();
        guardar = new JButton("Guardar"); guardar.setBackground(Color.red); guardar.setForeground(Color.black); guardar.setBorder(new LineBorder(Color.black));
        guardar.setFont(fuente);
        guardar.setBounds(20,300,100,50);
        reiniciar = new JButton("Reiniciar"); reiniciar.setBackground(Color.red); reiniciar.setForeground(Color.black); reiniciar.setBorder(new LineBorder(Color.black));
        reiniciar.setBounds(140,300,100,50);
        add(reiniciar);
        add(guardar);
    }

    private void prepareBotonesMovimientos(){
        panelBotones = new JPanel();
        panelBotones.setBounds(20,20,250,60);
        panelBotones.setBorder(BorderFactory.createLineBorder(Color.black));
        panelBotones.setLayout(new GridLayout(2,4));
        norte = new JButton("Norte"); norte.setFont(fuente); norte.setBackground(Color.red); norte.setForeground(Color.black); norte.setBorder(new LineBorder(Color.black));
        sur= new JButton("Sur"); sur.setFont(fuente); sur.setBackground(Color.red); sur.setForeground(Color.black); sur.setBorder(new LineBorder(Color.black));
        este = new JButton("Este"); este.setFont(fuente); este.setBackground(Color.red); este.setForeground(Color.black); este.setBorder(new LineBorder(Color.black));
        oeste = new JButton("Oeste"); oeste.setFont(fuente); oeste.setBackground(Color.red); oeste.setForeground(Color.black); oeste.setBorder(new LineBorder(Color.black));
        panelBotones.add(norte); panelBotones.add(sur); panelBotones.add(este); panelBotones.add(oeste);
        add(panelBotones);

    }

    private void prepareElementosInformacion(){
        panelInformacion = new JPanel();
        panelInformacion.setBackground(Color.black);
        panelInformacion.setBorder(new LineBorder(Color.red));
        panelInformacion.setBounds(20,90,250,200);
        panelInformacion.setLayout(null);
        JLabel movimientos = new JLabel("Movimientos :"); movimientos.setForeground(Color.red);
        movimientos.setBounds(10,40,80,20);
        numMovimientos = new JLabel(""+cont); numMovimientos.setForeground(Color.red);
        numMovimientos.setBounds(100,40,30,20);
        JLabel ubicadas = new JLabel("Ubicadas :"); ubicadas.setForeground(Color.red);
        ubicadas.setBounds(10,90,80,20);
        numUbicadas = new JLabel(""+0); numUbicadas.setForeground(Color.red);
        numUbicadas.setBounds(100,90,30,20);
        JLabel noUbicadas = new JLabel("No Ubicadas :"); noUbicadas.setForeground(Color.red);
        noUbicadas.setBounds(10,140,80,20);
        numNoUbicadas = new JLabel(""+0); numNoUbicadas.setForeground(Color.red);
        numNoUbicadas.setBounds(100,140,30,20);
        panelInformacion.add(movimientos); panelInformacion.add(ubicadas); panelInformacion.add(noUbicadas);
        panelInformacion.add(numMovimientos); panelInformacion.add(numUbicadas); panelInformacion.add(numNoUbicadas);
        add(panelInformacion);
    }

    public void refresque(){
        espacioJuego.repaint();
    }

    private void prepareTablero(){
        espacioJuego = new FotoTablero(marbelgame, tamaño,colorTablero, colorLineas); espacioJuego.setBackground(colorTablero); 
        espacioJuego.setBounds(330, 20, 300, 300);
        add(espacioJuego);
    }

    private void mesajeDeQueGano(){
        JOptionPane.showMessageDialog(null, "Ganaste!");
    }

    private void prepareAcciones(){
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                setDefaultCloseOperation(EXIT_ON_CLOSE);
            }
        });
        norte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev){
                if(!numUbicadas.getText().equals(cantMarbels+"")){
                    cont+=1;
                    numMovimientos.setText(""+cont);
                    marbelgame.move('N');
                    numUbicadas.setText(marbelgame.getPosicionadas()+""); numNoUbicadas.setText(marbelgame.getNoPosicionadas()+"");
                    refresque();
                }
                else{
                    mesajeDeQueGano();
                }
            }
        });

        sur.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev){
                if(!numUbicadas.getText().equals(cantMarbels+"")){
                    cont+=1;
                    numMovimientos.setText(""+cont);
                    marbelgame.move('S');
                    numUbicadas.setText(marbelgame.getPosicionadas()+""); numNoUbicadas.setText(marbelgame.getNoPosicionadas()+"");
                    refresque();
                }
                else{
                    mesajeDeQueGano();
                }
            }
        });

        este.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev){
                if(!numUbicadas.getText().equals(cantMarbels+"")){
                    cont+=1;
                    numMovimientos.setText(""+cont);
                    marbelgame.move('E');
                    numUbicadas.setText(marbelgame.getPosicionadas()+""); numNoUbicadas.setText(marbelgame.getNoPosicionadas()+"");
                    refresque();
                }
                else{
                    mesajeDeQueGano();
                }
            }
        });

        oeste.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev){
                if(!numUbicadas.getText().equals(cantMarbels+"")){
                    cont+=1;
                    numMovimientos.setText(""+cont);
                    marbelgame.move('O');
                    numUbicadas.setText(marbelgame.getPosicionadas()+""); numNoUbicadas.setText(marbelgame.getNoPosicionadas()+"");
                    refresque();
                }
                else{
                    mesajeDeQueGano();
                }
            }
        });

        guardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev){
                fileChooser.showSaveDialog(null);
            }
        });

        reiniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev){
                cont=0;
                numMovimientos.setText(""+cont);
                numUbicadas.setText(""+0);
                numNoUbicadas.setText(""+0);
                marbelgame.reiniciar();
                espacioJuego.repaint();
            }
        });
    }
    
    public static void main(String args[]){
        TableroGUI tableroGUI = new TableroGUI(4,3,3,Color.white,Color.black);
        tableroGUI.setVisible(true);
    }
}

class FotoTablero extends JPanel{
    /**
     *Esta clase nos crea el diseño del tablero
     */
    private static final long serialVersionUID = 1L;
    private int hola;
    private MarbelGame tablero;
    private int tamaño;
    private Color color;

    public FotoTablero(MarbelGame marbelgame, int tamaño, Color colorTablero, Color colorLineas){
        this.tablero=marbelgame;
        this.tamaño=tamaño;
        hola=300/tamaño;
        this.color=colorLineas;
        setPreferredSize(new Dimension(300,300));
    }

    public void setTablero(MarbelGame marbelgame){
        this.tablero=marbelgame;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(color);
        for(int i=0;i<tamaño;i++){
            g.drawLine(i*hola, 0, i*hola,hola*tamaño);
        }
        for(int i=0;i<tamaño;i++){
            g.drawLine(0, i*hola, tamaño*hola, i*hola);
        
        }
        for(int i=0;i<tamaño;i++){
            for(int j=0;j<tamaño;j++){
                if(tablero.getElentoPosicionada(i, j)!=null){
                    g.setColor(tablero.getElentoPosicionada(i, j).getColor());
                    if(tablero.getElentoPosicionada(i, j) instanceof Marbell){
                        g.drawOval(hola * j +hola/10, hola*i +hola/10, hola/2+hola/10+10, hola/2+hola/10+10);
                        g.fillOval(hola * j +hola/7 , hola*i +hola/7, hola/2+hola/10, hola/2+hola/10);
                    }
                    else{
                        g.drawOval(hola * j +hola/10, hola*i +hola/10, hola/2+hola/10+10, hola/2+hola/10+10);
                    }
                }
            }
        }
        for(int i=0; i<tamaño; i++){
            for(int j=0;j<tamaño;j++){
                if(tablero.getElemento(i, j)!=null){
                    g.setColor(tablero.getElemento(i, j).getColor());
                    if(tablero.getElemento(i,j).getForma()==Elemento.REDONDA){
                        g.fillOval(hola * j +hola/7 , hola*i +hola/7, hola/2+hola/10, hola/2+hola/10);
                    }
                    else{
                        g.fillRoundRect(hola * j +hola/10, hola*i +hola/10, hola/2 +10, hola/2+10, j, j);
                    }
                }
            }
        }
    }
}