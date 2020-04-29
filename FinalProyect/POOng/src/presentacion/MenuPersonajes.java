package src.presentacion;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

/**
 * Esta clase nos permite dinujar la ventana
 */
public class MenuPersonajes extends JFrame{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JLabel backGround;
    private String tipo;
    private JLabel player1;
    private JLabel player2;
    private JLabel goku1, goku2;
    private JLabel deadpool1, deadpool2;
    private JLabel joker1, joker2;
    private JLabel jesus1, jesus2;
    private JLabel spiderman1, spiderman2;
    private JLabel naruto1, naruto2;
    private JButton okButton;
    private JLabel imageOk;
    private JRadioButton radio1, radio2, radio3, radio4, radio5, radio6, radio7, radio8, radio9, radio10, radio11, radio12;
    private ArrayList<JRadioButton> radioBotones= new ArrayList<JRadioButton>();
    public static ArrayList<Integer> listaPersonajes = new ArrayList<Integer>();
    
    /**
     * Este es el contructor de la clase
     * @param tipo
     */
    public MenuPersonajes(String tipo){
        this.tipo=tipo;
        prepareBotones();
        prepareElementos();
        prepareOk();
        if(tipo.equals("")){
            dosPlayers();
        }
        else{

        }
        prepareAcciones();
    }

    /**
     * Este metodo nos prepara los botones para selecciones los personajes
     */
    private void prepareBotones(){
        radio1 = new JRadioButton();radioBotones.add(radio1);
        radio2 = new JRadioButton();radioBotones.add(radio2);
        radio3 = new JRadioButton();radioBotones.add(radio3);
        radio4 = new JRadioButton();radioBotones.add(radio4);
        radio5 = new JRadioButton();radioBotones.add(radio5);
        radio6 = new JRadioButton();radioBotones.add(radio6);
        radio7 = new JRadioButton();radioBotones.add(radio7);
        radio8 = new JRadioButton();radioBotones.add(radio8);
        radio9 = new JRadioButton();radioBotones.add(radio9);
        radio10 = new JRadioButton();radioBotones.add(radio10);
        radio11 = new JRadioButton();radioBotones.add(radio11);
        radio12 = new JRadioButton();radioBotones.add(radio12);
    }

    /**
     * Este metodo nos prepara los objetos de la ventana
     */
    private void prepareElementos(){
        setLayout(null);
        setTitle("Personajes");
        setIconImage(new ImageIcon(getClass().getResource("images/icon2.png")).getImage());
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        setBounds(0,0,d.width/2+50,d.height/2+50);
        setLocationRelativeTo(null);
        setResizable(false);
        ImageIcon back = new ImageIcon("C:/Users/santi/Desktop/POOB/FinalProyect/POOng/src/presentacion/images/background.jpg");
        backGround = new JLabel(back);
        backGround.setBounds(0,0,d.width/2+50,d.height/2+50);
        backGround.setLayout(null);
        add(backGround);
    }

    /**
     * Este metodo nos prepara el menu de eleccion para dos jugadores
     */
    private void dosPlayers(){
        ImageIcon imgPla1 = new ImageIcon("C:/Users/santi/Desktop/POOB/FinalProyect/POOng/src/presentacion/images/Player1.png");
        player1 = new JLabel(imgPla1);
        player1.setBounds(70,20,160,40);
        backGround.add(player1);
        ImageIcon imgPla2 = new ImageIcon("C:/Users/santi/Desktop/POOB/FinalProyect/POOng/src/presentacion/images/Player2.png");
        player2 = new JLabel(imgPla2);
        player2.setBounds(500, 20, 160, 40);
        preparePersonajesDos();
        backGround.add(player2);
    }


    /**
     * Este metodo nos añade las imagenes de los personajes
     */
    private void preparePersonajesDos(){
        ImageIcon imageBat = new ImageIcon("C:/Users/santi/Desktop/POOB/FinalProyect/POOng/src/presentacion/images/goku.png");
        goku1 = new JLabel(imageBat); goku2 = new JLabel(imageBat);
        goku1.setBounds(50, 70, 61, 80); goku2.setBounds(480,70,61,80); radio1.setBounds(120, 100, 16, 16); radio7.setBounds(550, 100, 16, 16);
        backGround.add(goku1); backGround.add(goku2); backGround.add(radio1); backGround.add(radio7);
        ImageIcon imageDead = new ImageIcon("C:/Users/santi/Desktop/POOB/FinalProyect/POOng/src/presentacion/images/deadpool.png");
        deadpool1 = new JLabel(imageDead); deadpool2 = new JLabel(imageDead);
        deadpool1.setBounds(50,160,61,80); deadpool2.setBounds(480, 160, 61, 80); radio2.setBounds(120, 190, 16, 16); radio8.setBounds(550, 190, 16, 16);
        backGround.add(deadpool1); backGround.add(deadpool2); backGround.add(radio2); backGround.add(radio8);
        ImageIcon imageJok = new ImageIcon("C:/Users/santi/Desktop/POOB/FinalProyect/POOng/src/presentacion/images/joker.png");
        joker1 = new JLabel(imageJok); joker2 = new JLabel(imageJok);
        joker1.setBounds(50, 250, 61, 80); joker2.setBounds(480, 250, 61, 80); radio3.setBounds(120,280,16,16); radio9.setBounds(550,280,16,16);
        backGround.add(joker1); backGround.add(joker2); backGround.add(radio3); backGround.add(radio9);
        ImageIcon imageJe = new ImageIcon("C:/Users/santi/Desktop/POOB/FinalProyect/POOng/src/presentacion/images/jesus.png");
        jesus2 = new JLabel(imageJe); jesus1 = new JLabel(imageJe);
        jesus2.setBounds(600,70,61,80); jesus1.setBounds(150, 70, 61, 80); radio4.setBounds(220,100,16,16); radio10.setBounds(670,100,16,16);
        backGround.add(jesus2); backGround.add(jesus1); backGround.add(radio4); backGround.add(radio10);
        ImageIcon imageSp = new ImageIcon("C:/Users/santi/Desktop/POOB/FinalProyect/POOng/src/presentacion/images/spiderman.png");
        spiderman2 = new JLabel(imageSp); spiderman1 = new JLabel(imageSp);
        spiderman2.setBounds(600, 160, 61, 80); spiderman1.setBounds(150,160,61,80); radio5.setBounds(220,190,16,16); radio11.setBounds(670,190,16,16);
        backGround.add(spiderman2); backGround.add(spiderman1); backGround.add(radio5); backGround.add(radio11);
        ImageIcon imageNa = new ImageIcon("C:/Users/santi/Desktop/POOB/FinalProyect/POOng/src/presentacion/images/naruto.png");
        naruto2 = new JLabel(imageNa); naruto1 = new JLabel(imageNa);
        naruto2.setBounds(600, 250, 61, 80); naruto1.setBounds(150, 250, 61, 80); radio6.setBounds(220,280,16,16); radio12.setBounds(670,280,16,16);
        backGround.add(naruto2); backGround.add(naruto1); backGround.add(radio6); backGround.add(radio12);

    }

    /**
     * Este metodo nos prepara el boton ok 
     */
    private void prepareOk(){
        okButton = new JButton();
        okButton.setOpaque(false); okButton.setContentAreaFilled(false); okButton.setBorderPainted(false);
        okButton.setBounds(300, 330, 140,60);
        backGround.add(okButton);
        ImageIcon imagenOk = new ImageIcon("C:/Users/santi/Desktop/POOB/FinalProyect/POOng/src/presentacion/images/Ok.png");
        imageOk = new JLabel(imagenOk);
        imageOk.setBounds(300, 330, 135, 60);
        backGround.add(imageOk);
    }

    /**
     * Este metodo prepara las acciones de los objetos
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

        radio1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                if(radio1.isSelected()){
                    radio2.setEnabled(false); radio3.setEnabled(false); radio4.setEnabled(false);
                    radio5.setEnabled(false); radio6.setEnabled(false); radio7.setEnabled(false);
                }
                else{
                    radio2.setEnabled(true); radio3.setEnabled(true); radio4.setEnabled(true);
                    radio5.setEnabled(true); radio6.setEnabled(true); radio7.setEnabled(true);
                }
            }
        });

        radio2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                if(radio2.isSelected()){
                    radio1.setEnabled(false); radio3.setEnabled(false); radio4.setEnabled(false);
                    radio5.setEnabled(false); radio6.setEnabled(false); radio8.setEnabled(false);
                }
                else{
                    radio1.setEnabled(true); radio3.setEnabled(true); radio4.setEnabled(true);
                    radio5.setEnabled(true); radio6.setEnabled(true); radio8.setEnabled(true);
                }
            }
        });

        radio3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                if(radio3.isSelected()){
                    radio2.setEnabled(false); radio1.setEnabled(false); radio4.setEnabled(false);
                    radio5.setEnabled(false); radio6.setEnabled(false); radio9.setEnabled(false);
                }
                else{
                    radio2.setEnabled(true); radio1.setEnabled(true); radio4.setEnabled(true);
                    radio5.setEnabled(true); radio6.setEnabled(true); radio9.setEnabled(true);
                }
            }
        });

        radio4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                if(radio4.isSelected()){
                    radio2.setEnabled(false); radio3.setEnabled(false); radio1.setEnabled(false);
                    radio5.setEnabled(false); radio6.setEnabled(false); radio10.setEnabled(false);
                }
                else{
                    radio2.setEnabled(true); radio3.setEnabled(true); radio1.setEnabled(true);
                    radio5.setEnabled(true); radio6.setEnabled(true); radio10.setEnabled(true);
                }
            }
        });

        radio5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                if(radio5.isSelected()){
                    radio2.setEnabled(false); radio3.setEnabled(false); radio4.setEnabled(false);
                    radio1.setEnabled(false); radio6.setEnabled(false); radio11.setEnabled(false);
                }
                else{
                    radio2.setEnabled(true); radio3.setEnabled(true); radio4.setEnabled(true);
                    radio1.setEnabled(true); radio6.setEnabled(true); radio11.setEnabled(true);
                }
            }
        });

        radio6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                if(radio6.isSelected()){
                    radio2.setEnabled(false); radio3.setEnabled(false); radio4.setEnabled(false);
                    radio5.setEnabled(false); radio1.setEnabled(false); radio12.setEnabled(false);
                }
                else{
                    radio2.setEnabled(true); radio3.setEnabled(true); radio4.setEnabled(true);
                    radio5.setEnabled(true); radio1.setEnabled(true); radio12.setEnabled(true);
                }
            }
        });

        radio7.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                if(radio7.isSelected()){
                    radio8.setEnabled(false); radio9.setEnabled(false); radio10.setEnabled(false);
                    radio11.setEnabled(false); radio12.setEnabled(false); radio1.setEnabled(false);
                }
                else{
                    radio8.setEnabled(true); radio9.setEnabled(true); radio10.setEnabled(true);
                    radio11.setEnabled(true); radio12.setEnabled(true); radio1.setEnabled(true);
                }
            }
        });

        radio8.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                if(radio8.isSelected()){
                    radio7.setEnabled(false); radio9.setEnabled(false); radio10.setEnabled(false);
                    radio11.setEnabled(false); radio12.setEnabled(false); radio2.setEnabled(false);
                }
                else{
                    radio7.setEnabled(true); radio9.setEnabled(true); radio10.setEnabled(true);
                    radio11.setEnabled(true); radio12.setEnabled(true); radio2.setEnabled(true);
                }
            }
        });

        radio9.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                if(radio9.isSelected()){
                    radio8.setEnabled(false); radio7.setEnabled(false); radio10.setEnabled(false);
                    radio11.setEnabled(false); radio12.setEnabled(false); radio3.setEnabled(false);
                }
                else{
                    radio8.setEnabled(true); radio7.setEnabled(true); radio10.setEnabled(true);
                    radio11.setEnabled(true); radio12.setEnabled(true); radio3.setEnabled(true);
                }
            }
        });

        radio10.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                if(radio10.isSelected()){
                    radio8.setEnabled(false); radio9.setEnabled(false); radio7.setEnabled(false);
                    radio11.setEnabled(false); radio12.setEnabled(false); radio4.setEnabled(false);
                }
                else{
                    radio8.setEnabled(true); radio9.setEnabled(true); radio7.setEnabled(true);
                    radio11.setEnabled(true); radio12.setEnabled(true); radio4.setEnabled(true);
                }
            }
        });
        

        radio11.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                if(radio11.isSelected()){
                    radio8.setEnabled(false); radio9.setEnabled(false); radio10.setEnabled(false);
                    radio7.setEnabled(false); radio12.setEnabled(false); radio5.setEnabled(false);
                }
                else{
                    radio8.setEnabled(true); radio9.setEnabled(true); radio10.setEnabled(true);
                    radio7.setEnabled(true); radio12.setEnabled(true); radio5.setEnabled(true);
                }
            }
        });

        radio12.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                if(radio12.isSelected()){
                    radio8.setEnabled(false); radio9.setEnabled(false); radio10.setEnabled(false);
                    radio11.setEnabled(false); radio7.setEnabled(false); radio6.setEnabled(false);
                }
                else{
                    radio8.setEnabled(true); radio9.setEnabled(true); radio10.setEnabled(true);
                    radio11.setEnabled(true); radio7.setEnabled(true); radio6.setEnabled(true);
                }
            }
        });

        okButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                int cont = 0;
                for(int i =0; i < radioBotones.size();i++){
                    if(radioBotones.get(i).isSelected()){
                        cont+=1;
                    }
                }
                if(cont==2){
                    prepareNumPlayer1();
                    System.out.println(listaPersonajes.get(0));
                    System.out.println(listaPersonajes.get(1));
                    setVisible(false);
                    Controles controles = new Controles(tipo);
                    controles.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }
        });
    }

    /**
     * Este metodo añade el numero del personaje para el jugador numero 1
     */
    private void prepareNumPlayer1(){
        if(radio1.isEnabled()) listaPersonajes.add(1);
        else if(radio2.isEnabled()) listaPersonajes.add(2);
        else if(radio3.isEnabled()) listaPersonajes.add(3);
        else if(radio4.isEnabled()) listaPersonajes.add(4);
        else if(radio5.isEnabled()) listaPersonajes.add(5);
        else if(radio6.isEnabled()) listaPersonajes.add(6);
        prepareNumPlayer2();
    }

    /**
     * Este metodo añade el numero del personaje para el jugador numero 2
     */
    private void prepareNumPlayer2(){
        if(radio7.isEnabled())  listaPersonajes.add(1);
        else if(radio8.isEnabled()) listaPersonajes.add(2);
        else if(radio9.isEnabled()) listaPersonajes.add(3);
        else if(radio10.isEnabled()) listaPersonajes.add(4);
        else if(radio11.isEnabled()) listaPersonajes.add(5);
        else if(radio12.isEnabled()) listaPersonajes.add(6);
    }

    /**
     * Metodo principal
     */
    public static void main(String[] args){
        MenuPersonajes menu = new MenuPersonajes("");
        menu.setVisible(true);
    }

}