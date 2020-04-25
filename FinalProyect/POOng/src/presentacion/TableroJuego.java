package src.presentacion;
import javax.swing.*;
import src.aplicacion.*;
import java.awt.*;
public class TableroJuego extends JPanel{

    /**
     *Esta clase nos permite adquierir la plantilla en donde se jugara
     */
    private static final long serialVersionUID = 1L;

    /**
     * Este es el encargado de dibujar el tablero en donde se 
     */
    private Pelota pelota;
    private Raqueta raqueta1, raqueta2;
    public TableroJuego(){
        pelota = new Pelota(0,0);
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        raqueta1 = new Raqueta(8,100); raqueta2 = new Raqueta((int)d.getWidth()/2+9,100);
        prepareElementos();
    }

    /**
     * Este metodo nos permite preparar los elemntos los cuales seran las raquetas y las pelotas
     */
    private void prepareElementos(){
        setBackground(Color.black);
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        setSize(d.width/2+50,d.height/2+50);
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
        actualizar();
    }

    /**
     * Este metodo nos dibuja los elementos
     * @param g
     */
    public void dibujar(Graphics2D g){
        g.drawLine(370, 0, 370, 700);
        g.drawString(pelota.getScore1(), 250, 30);
        g.drawString(pelota.getScore2(), 480, 30);
        g.fill((Shape) pelota.getPelota());
        g.fill((Shape) raqueta1.getRaqueta());
        g.fill((Shape) raqueta2.getRaqueta());
    }
    
    /**
     * Este metodo actualiza la posicion de los elementos del tablero
     */
    public void actualizar(){
        pelota.mover(choque(raqueta1.getRaqueta()),choque(raqueta2.getRaqueta())); 
        raqueta1.moveR1();
        raqueta2.moveR2();
    }

    /**
     * Este metodo nos dice si hay coliciones entre objetos
     */
    private boolean choque(Rectangle r){
        return pelota.getPelota().intersects(r);
    }
}