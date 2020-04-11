package presentacion;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class ConfiguracionGUI extends JFrame {
   /**
    * Esta clase nos crea la ventana de configuracion, la cual nos ayudara a
    * configurar el tablero
    */
   private static final long serialVersionUID = 1L;
   /* Estos son los botones para el menu */
   private JButton seleccionarColor;
   private JButton colorBackGrounda;
   private JButton jugar;
   private JPanel panelConfiguracion;
   private JTextField lista;
   private JTextField cantMarbels;
   private JTextField cantBarriers;
   public Color colorTablero;
   public Color colorLineas;
   public static int tamaño;
   public static int cantidadBar;
   public static int cantidadMar;

   /**
    * Este es el contructor para la clase Configuracion
    */
   public ConfiguracionGUI() {
      prepararElementos();
      prepareElementosConfiguracion();
      prepareAccciones();
   }

   private void prepararElementos() {
      setLayout(null); getContentPane().setBackground(Color.black);
      setTitle("Configuracion");
      Toolkit t = Toolkit.getDefaultToolkit();
      Dimension d = t.getScreenSize();
      setBounds(0, 0, d.width / 3, d.height / 3 + 120);
      setLocationRelativeTo(null);
      setResizable(false);
      jugar = new JButton("Jugar"); jugar.setForeground(Color.black); jugar.setBackground(Color.red); jugar.setBorder(new LineBorder(Color.red));
      jugar.setBounds(320, 270, 100, 50);
      add(jugar);
   }

   private void prepareElementosConfiguracion() {
      panelConfiguracion = new JPanel(); panelConfiguracion.setBackground(Color.red);
      panelConfiguracion.setBounds(20, 20, 410, 230);
      panelConfiguracion.setBorder(BorderFactory.createLineBorder(Color.black));
      panelConfiguracion.setLayout(null);
      JLabel tamaño = new JLabel("Tamaño :");
      tamaño.setBounds(50, 10, 70, 20); tamaño.setForeground(Color.black);
      lista = new JTextField();
      lista.setBounds(200, 15, 70, 20);
      panelConfiguracion.add(tamaño);
      panelConfiguracion.add(lista);
      JLabel marbels = new JLabel("Marbels"); marbels.setForeground(Color.black);
      marbels.setBounds(50, 50, 70, 20);
      cantMarbels = new JTextField();
      cantMarbels.setBounds(200, 55, 70, 20);
      panelConfiguracion.add(marbels);
      panelConfiguracion.add(cantMarbels);
      JLabel barriers = new JLabel("Barriers"); barriers.setForeground(Color.black);
      barriers.setBounds(50, 100, 70, 20);
      cantBarriers = new JTextField();
      cantBarriers.setBounds(200, 100, 70, 20);
      panelConfiguracion.add(barriers);
      panelConfiguracion.add(cantBarriers);
      JLabel colorPrincipal = new JLabel("Color Principal"); colorPrincipal.setForeground(Color.black);
      colorPrincipal.setBounds(50, 150, 120, 20);
      seleccionarColor = new JButton("Cambiar"); seleccionarColor.setForeground(Color.red); seleccionarColor.setBackground(Color.black); seleccionarColor.setBorder(new LineBorder(Color.red));
      seleccionarColor.setBounds(200, 150, 120, 20);
      panelConfiguracion.add(colorPrincipal);
      panelConfiguracion.add(seleccionarColor);
      JLabel colorSecundario = new JLabel("Color Secundario"); colorSecundario.setForeground(Color.black);
      colorSecundario.setBounds(50, 200, 120, 20);
      colorBackGrounda = new JButton("Cambiar"); colorBackGrounda.setForeground(Color.red); colorBackGrounda.setBackground(Color.black); colorBackGrounda.setBorder(new LineBorder(Color.red));
      colorBackGrounda.setBounds(200,200,120,20);
      panelConfiguracion.add(colorSecundario);
      panelConfiguracion.add(colorBackGrounda);
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
            if (cantBarriers.getText().equals("") || cantMarbels.getText().equals("") || lista.getText().equals("")) {
               JOptionPane.showMessageDialog(null, "Debe de llenar todas las casillas");
            } else {
               changeVariables();
               TableroGUI tableroGUI = new TableroGUI(tamaño, cantidadMar, cantidadBar, colorTablero, colorLineas);
               tableroGUI.setVisible(true);
               setVisible(false);
            }
         }
      });

      seleccionarColor.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ev) {
            colorTablero = JColorChooser.showDialog(null, "Seleccione Color", Color.white);
         }
      });

      colorBackGrounda.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ev) {
            colorLineas = JColorChooser.showDialog(null, "Seleccione Color", Color.black);
         }
      });
   }

   private void changeVariables(){
      String cantBar = cantBarriers.getText();
      String cantMar = cantMarbels.getText();
      String tam = lista.getText();
      cantidadBar = Integer.parseInt(cantBar);
      cantidadMar = Integer.parseInt(cantMar);
      tamaño = Integer.parseInt(tam);
      
   }   

     public static void main(String args[]){
        ConfiguracionGUI configuracionGUI = new ConfiguracionGUI();
        configuracionGUI.setVisible(true);
     }
     
}