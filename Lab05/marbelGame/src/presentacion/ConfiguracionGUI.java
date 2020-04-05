package presentacion;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JComboBox;
public class ConfiguracionGUI extends JFrame {
   /**
    * Esta clase nos crea la ventana de configuracion, la cual nos ayudara a
    * configurar el tablero
    */
   private static final long serialVersionUID = 1L;
   /* Estos son los botones para el menu */
   private JButton seleccionarColor;
   private JButton jugar;
   private JPanel panelConfiguracion;
   private JComboBox<String> lista;

   /**
    * Este es el contructor para la clase Configuracion
    */
   public ConfiguracionGUI() {
      lista = new JComboBox<String>();
      prepararElementos();
      prepareElementosConfiguracion();
      prepareAccciones();
   }

   public void prepararElementos() {
      setLayout(null);
      setTitle("Configuracion");
      Toolkit t = Toolkit.getDefaultToolkit();
      Dimension d = t.getScreenSize();
      setBounds(0, 0, d.width / 3, d.height / 3 + 120);
      setLocationRelativeTo(null);
      setResizable(false);
      jugar = new JButton("Jugar");
      jugar.setBounds(320,270,100,50);
      add(jugar);
   }

   private void prepareElementosConfiguracion() {
      panelConfiguracion = new JPanel();
      panelConfiguracion.setBounds(20, 20, 410, 230);
      panelConfiguracion.setBorder(BorderFactory.createLineBorder(Color.black));
      panelConfiguracion.setLayout(null);
      JLabel tamaño = new JLabel("Tamaño :");
      tamaño.setBounds(50, 20, 70, 20);
      lista.addItem("1"); lista.addItem("3"); lista.addItem("4");
      lista.setBounds(200, 25, 70, 20);
      panelConfiguracion.add(tamaño); panelConfiguracion.add(lista);
      JLabel marbels = new JLabel("Marbels");
      marbels.setBounds(50, 70, 70, 20);
      JTextField cantMarbels = new JTextField();
      cantMarbels.setBounds(200, 75, 70, 20);
      panelConfiguracion.add(marbels); panelConfiguracion.add(cantMarbels);
      JLabel barriers = new JLabel("Barriers");
      barriers.setBounds(50,120,70,20);
      JTextField cantBarriers = new JTextField();
      cantBarriers.setBounds(200, 120, 70, 20);
      panelConfiguracion.add(barriers); panelConfiguracion.add(cantBarriers);
      JLabel color = new JLabel("Color");
      color.setBounds(50,170,70,20);
      seleccionarColor = new JButton("Cambiar");
      seleccionarColor.setBounds(200,170,120,20);
      panelConfiguracion.add(color); panelConfiguracion.add(seleccionarColor);
      add(panelConfiguracion);
   }

   public void prepareAccciones() {
      addWindowListener(new WindowAdapter() {
         public void windowClosing (WindowEvent ev){
            setDefaultCloseOperation(EXIT_ON_CLOSE);
         }
     });
     }


     public static void main(String args[]){
        ConfiguracionGUI configuracionGUI = new ConfiguracionGUI();
        configuracionGUI.setVisible(true);
     }
     
}