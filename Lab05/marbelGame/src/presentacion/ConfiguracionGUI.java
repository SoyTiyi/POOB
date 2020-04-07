package presentacion;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;

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
   private JTextField cantMarbels;
   private JTextField cantBarriers;
   public Color colorTablero;
   public static int tamaño;
   public static int cantidadBar;
   public static int cantidadMar;

   /**
    * Este es el contructor para la clase Configuracion
    */
   public ConfiguracionGUI() {
      lista = new JComboBox<String>();
      prepararElementos();
      prepareElementosConfiguracion();
      prepareAccciones();
   }

   private void prepararElementos() {
      setLayout(null);
      setTitle("Configuracion");
      Toolkit t = Toolkit.getDefaultToolkit();
      Dimension d = t.getScreenSize();
      setBounds(0, 0, d.width / 3, d.height / 3 + 120);
      setLocationRelativeTo(null);
      setResizable(false);
      jugar = new JButton("Jugar");
      jugar.setBounds(320, 270, 100, 50);
      add(jugar);
   }

   private void prepareElementosConfiguracion() {
      panelConfiguracion = new JPanel();
      panelConfiguracion.setBounds(20, 20, 410, 230);
      panelConfiguracion.setBorder(BorderFactory.createLineBorder(Color.black));
      panelConfiguracion.setLayout(null);
      JLabel tamaño = new JLabel("Tamaño :");
      tamaño.setBounds(50, 20, 70, 20);
      lista.addItem("1");
      lista.addItem("3");
      lista.addItem("4");
      lista.setBounds(200, 25, 70, 20);
      panelConfiguracion.add(tamaño);
      panelConfiguracion.add(lista);
      JLabel marbels = new JLabel("Marbels");
      marbels.setBounds(50, 70, 70, 20);
      cantMarbels = new JTextField();
      cantMarbels.setBounds(200, 75, 70, 20);
      panelConfiguracion.add(marbels);
      panelConfiguracion.add(cantMarbels);
      JLabel barriers = new JLabel("Barriers");
      barriers.setBounds(50, 120, 70, 20);
      cantBarriers = new JTextField();
      cantBarriers.setBounds(200, 120, 70, 20);
      panelConfiguracion.add(barriers);
      panelConfiguracion.add(cantBarriers);
      JLabel color = new JLabel("Color");
      color.setBounds(50, 170, 70, 20);
      seleccionarColor = new JButton("Cambiar");
      seleccionarColor.setBounds(200, 170, 120, 20);
      panelConfiguracion.add(color);
      panelConfiguracion.add(seleccionarColor);
      add(panelConfiguracion);
   }

   private void prepareAccciones() {
      addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent ev) {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
         }
      });

      jugar.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ev) {
            if (cantBarriers.getText().equals("") || cantMarbels.getText().equals("")) {
               JOptionPane.showMessageDialog(null, "Debe de llenar todas las casillas");
            } else {
               changeVariables();
               TableroGUI tableroGUI = new TableroGUI(tamaño, cantidadMar, cantidadBar, colorTablero);
               tableroGUI.setVisible(true);
               setVisible(false);
            }
         }
      });

      seleccionarColor.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ev) {
            colorTablero = JColorChooser.showDialog(null, "Seleccione Color", Color.black);
         }
      });
   }

   private void changeVariables(){
      String cantBar = cantBarriers.getText();
      String cantMar = cantMarbels.getText();
      String tam = (String)lista.getSelectedItem();
      cantidadBar = Integer.parseInt(cantBar);
      cantidadMar = Integer.parseInt(cantMar);
      tamaño = Integer.parseInt(tam);
      
   }   

     public static void main(String args[]){
        ConfiguracionGUI configuracionGUI = new ConfiguracionGUI();
        configuracionGUI.setVisible(true);
     }
     
}