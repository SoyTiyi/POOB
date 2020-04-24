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
    private int ANCHO;
    private int ALTO;
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

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.white);
        dibujar(g2);
        actualizar();
    }

    public void dibujar(Graphics2D g){
        g.fill((Shape) pelota.getPelota());
        g.fill((Shape) raqueta1.getRaqueta());
        g.fill((Shape) raqueta2.getRaqueta());
    }
    
    public void actualizar(){
        pelota.mover(choque(raqueta1.getRaqueta()),choque(raqueta2.getRaqueta()));
        raqueta1.moveR1();
        raqueta2.moveR2();
        repaint();
    }

    private boolean choque(Rectangle r){
        return pelota.getPelota().intersects(r);
    }
}