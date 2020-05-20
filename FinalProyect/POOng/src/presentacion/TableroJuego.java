package src.presentacion;

import javax.swing.*;
import src.aplicacion.*;
import java.awt.*;
import java.util.ArrayList;
public class TableroJuego extends JPanel{

    /**
     *Esta clase nos permite adquierir la plantilla en donde se jugara
     */
    private static final long serialVersionUID = 1L;

    /**
     * Este es el encargado de dibujar el tablero en donde se 
     */
    private ArrayList<Integer> listaPersonajes = new ArrayList<Integer>();
    private JLabel player1;
    private JLabel player2;
    private JLabel estrellita;
    private JLabel objetivoUno;
    private JLabel objetivoDos;
    private JLabel pelota;
    private String ruta1;
    private String ruta2;
    private int lateral;
    private Poong poong;
    private ImageIcon imgIcon;
    private ImageIcon imgPelota;
    private JLabel bloque;
    private ImageIcon imgBloque;
    /**
     * Este es el constructor de la clase
     * @param poong
     */
    public TableroJuego(Poong poong){
        this.poong=poong;
        modo();
        prepareRuta1();
        prepareRuta2();
        prepareElementos();
        prepareImagenes();

    }

    /**
     * Este metodo lo que hace es settear poong
     */
    public void setPoong(){
        poong=Poong.getPong();
        repaint();
    }

    /**
     * Este metodo prepara las imagenes
     */
    private void prepareImagenes(){
        ImageIcon imagePlaUno = new ImageIcon(getClass().getResource(ruta1));
        ImageIcon imagePlaDos = new ImageIcon(getClass().getResource(ruta2));
        imgIcon = new ImageIcon(getClass().getResource("images/objetivo.png"));
        imgPelota = new ImageIcon(getClass().getResource("images/pelota.png"));
        imgBloque = new ImageIcon(getClass().getResource("images/bloque.png"));
        player1 = new JLabel(imagePlaUno); player1.setBounds(8, 100, 61 , 80); add(player1);
        player2 = new JLabel(imagePlaDos); player2.setBounds(lateral, 100, 61, 80); add(player2);
        estrellita = new JLabel(poong.getPremio().getImage()); estrellita.setBounds(poong.getPremio().getX(), poong.getPremio().getY(), 20, 20); add(estrellita);
        objetivoUno = new JLabel(imgIcon); objetivoUno.setBounds(poong.getObjUno().getX(), poong.getObjUno().getY(), 20, 20); add(objetivoUno);
        objetivoDos = new JLabel(imgIcon); objetivoDos.setBounds(poong.getObjDos().getX(), poong.getObjDos().getY(), 20, 20); add(objetivoDos);
        pelota = new JLabel(imgPelota); pelota.setBounds(poong.getPelota().getX(),poong.getPelota().getY(),20,20); add(pelota);
        bloque = new JLabel(imgBloque); bloque.setBounds(poong.getBloque().getX(),poong.getBloque().getY(),20,20); add(bloque);
    }

    /**
     * Este metodo prepara las rutas para las imagenes 
     */
    private void prepareRuta1(){
        if(listaPersonajes.get(0)==1){
            ruta1="images/goku.png";
        }
        else if(listaPersonajes.get(0)==2){
            ruta1="images/deadpool.png";
        }
        else if(listaPersonajes.get(0)==3){
            ruta1="images/joker.png";
        }
        else if(listaPersonajes.get(0)==4){
            ruta1="images/jesus.png";
        }
        else if(listaPersonajes.get(0)==5){
            ruta1="images/spiderman.png";
        }
        else if(listaPersonajes.get(0)==6){
            ruta1="images/naruto.png";
        }
    }

    private void prepareRuta2(){
        if(listaPersonajes.get(1)==1){
            ruta2="images/goku.png";
        }
        else if(listaPersonajes.get(1)==2){
            ruta2="images/deadpool.png";
        }
        else if(listaPersonajes.get(1)==3){
            ruta2="images/joker.png";
        }
        else if(listaPersonajes.get(1)==4){
            ruta2="images/jesus.png";
        }
        else if(listaPersonajes.get(1)==5){
            ruta2="images/spiderman.png";
        }
        else if(listaPersonajes.get(1)==6){
            ruta2="images/naruto.png";
        }
    }

    /**
     * Este metodo prepara el modo de juego
     */
    private void modo(){
        listaPersonajes.add(poong.getJugadorUno());
        listaPersonajes.add(poong.getJugadorDos());
    }
    /**
     * Este metodo nos permite preparar los elemntos los cuales seran las raquetas y las pelotas
     */
    private void prepareElementos(){
        Color colorBack= new Color(115,230,190);
        setBackground(colorBack);
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        setSize(d.width/2+45,d.height/2+40);
        setLayout(null);
        ImageIcon imgPizza = new ImageIcon(getClass().getResource("images/fortalez.png"));
        JLabel vidaUno = new JLabel(imgPizza); vidaUno.setBounds(115,13,20,20); add(vidaUno);
        JLabel vidaDos = new JLabel(imgPizza); vidaDos.setBounds(630, 13, 20, 20); add(vidaDos);
    }

    /**
     * Este metodo es el encargado cordinar la gestion de dibujo del tablero
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.white);
        dibujar(g2);
    }

    /**
     * Este metodo nos dibuja los elementos
     * @param g
     */
    public void dibujar(Graphics2D g){
        g.drawLine(370, 0, 370, 700);
        g.drawString(poong.getPelota().getScore1(), 250, 30);
        g.drawString(poong.getPelota().getScore2(), 480, 30);
        pelota.setLocation(poong.getPelota().getX(), poong.getPelota().getY());
        g.drawString(poong.getRaquetaUno().getVida()+"",150,30);
        g.drawString(poong.getRaquetaDos().getVida()+"",580,30);
        //g.fill((Shape) poong.getPelota().getPelota());
        controlEstrellita();
        controlObjetivoUno(); controlObjetivoDos();
        controlBloque();
        //g.fill((Shape) raqueta1.getRaqueta());
        //g.fill((Shape) raqueta2.getRaqueta());
    }

    /**
     * Este metodo evalua la situacion de la imagen del bloque
     */
    private void controlBloque(){
        if(poong.getBloque().getVisible()){
            bloque.setBounds(poong.getBloque().getX(),poong.getBloque().getY(),20,20);
        }
        else{
            bloque.setBounds(700,700,20,20);
        }
    }

    /**
     * Este metodo evalua la situacion de la imagen del objetivo uno 
     */
    private void controlObjetivoUno(){
        if(poong.getObjUno().getVisible()){
            objetivoUno.setBounds(poong.getObjUno().getX(), poong.getObjUno().getY(), 20, 20);
        }
        else{
            objetivoUno.setBounds(500, 500, 20, 20);
        }
    }
    
    /**
     * Este metodo evalua la situacion de la imagen del objetivo dos
     */
    private void controlObjetivoDos(){
        if(poong.getObjDos().getVisible()){
            objetivoDos.setBounds(poong.getObjDos().getX(), poong.getObjDos().getY(), 20, 20);
        }
        else{
            objetivoDos.setBounds(600, 600, 20, 20);
        }  
    }
    /**
     * Este metodo evalua la situacion de la imagen de la estrellita 
     */
    private void controlEstrellita(){
        if(poong.getPremio().getVisible()){
            estrellita.setVisible(true);
            estrellita.setIcon(poong.getPremio().getImage());
            estrellita.setBounds(poong.getPremio().getX(), poong.getPremio().getY(), 20, 20);
        }
        else{
            estrellita.setVisible(false);
        }   
    }

    /**
     * Este metodo actualiza la posicion de los elementos del tablero
     */
    public void actualizar(){
        poong.move(); 
        player1.setLocation(poong.getRaquetaUno().getRaqueta().x-10,poong.getRaquetaUno().getRaqueta().y);
        player2.setLocation(poong.getRaquetaDos().getRaqueta().x-20,poong.getRaquetaDos().getRaqueta().y);
    }
}