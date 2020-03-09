import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;
/**
 *This Class make the calculator that the mayas needs to make the add, subt, mult
 *and Division.
 *
 * @Ricardo Amaya and Santiago Martínez
 * @1.8 (1/29/2020)
 */
public class CalcXook
{
    private String operacion;
    private String color;
    private ArrayList<Integer> number = new ArrayList<Integer>();
    private ArrayList<Integer> operands = new ArrayList<Integer>();
    private ArrayList<Integer> exponent = new ArrayList<Integer>();
    /**
     * This metod is the constructor of the Calculator
     */
    public CalcXook(){
        menu();
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    private void menu(){
        System.out.println("This calculator make operation with a decimal system and return the in maya sistem");
        System.out.println();
        System.out.println("What color do you want to show in the figure?");
        Scanner scan= new Scanner(System.in);
        color = scan.nextLine();
        System.out.println("Introduce the numbers that you wants to operate");
        System.out.println("When you have already finished, introduce a negative number");
        pushValue();
    }
    
    /**
     * This metod put the number in the stack
     */
    public void pushValue(){
       Scanner scan = new Scanner(System.in);
       int integerNumber;
       integerNumber=scan.nextInt();
       while(integerNumber>-1){
           number.add(integerNumber);
           integerNumber=scan.nextInt();
        }
    }
    
    /**
     * This metod create the list of operands
     */
    private void operandsValues(){
        int numberValues = Integer.parseInt(JOptionPane.showInputDialog("Write the numbers the number that you want to operate"));
        System.out.println(number);
        for(int i=0;i<numberValues;i++){
            System.out.println(number.get(number.size()-1));
            System.out.println("Entre");
            operands.add(number.remove(number.size()-1));
        }
    }
    
    /**
     * This metod make the addition of two decimal numbers
     */
    public void addition(){
        int resultado=0;
        operandsValues();
        for(int i=0;i<operands.size();i++){
            resultado+=operands.get(i);
        }
        
        if(resultado<-1){
            friendlyMessage();
        }
        operands.clear();
        number.add(resultado);
        XooK figure= new XooK(resultado);
        figure.makeVisible();
        figure.changeColor(color);
    }
    
    /**
     * This metod show a friendly message for the maya expert
     */
    public void friendlyMessage(){
        JOptionPane.showMessageDialog(null,"This numbers can´t be operate");
    }
    
    /**
     * This metod make the subtraction of two decimal numbers
     */
    public void subtraction(){
        operandsValues();
        System.out.println(operands);
        int resultado=operands.get(0);
        for(int i=1;i<operands.size();i++){
            resultado-=operands.get(i);
        }
        
        if(resultado<0){
            friendlyMessage();
        }
        operands.clear();
        XooK figure= new XooK(resultado);
        figure.makeVisible();
        figure.changeColor(color);
    }
    
    /**
     * This metod operate the operands that you want, and make her multiplication.
     */
    public void multiplication(){
        int resultado=1;
        operandsValues();
        for(int i=0;i<operands.size();i++){
            resultado=operands.get(i)*resultado;
            System.out.println(resultado);
        }
        System.out.println(resultado);
        if(resultado<0){
            friendlyMessage();
        }
        operands.clear();
        XooK figure= new XooK(resultado);
        figure.makeVisible();
        figure.changeColor(color);
    }
    
    /**
     * This metod operate the operands what you want, and make the divisions of all
     */
    public void division(){
        int resultado=0;
        operandsValues();
        for(int i=0;i<operands.size();i++){
            resultado/=operands.get(i);
        }
        
        if(resultado<0){
            friendlyMessage();
        }
        operands.clear();
        XooK figure= new XooK(resultado);
        figure.makeVisible();
        figure.changeColor(color);
    }
    
    /**
     * This metod operate the numbers and calculate the power of the exponent that you want
     */
    public void pow(){
        int resultado=1;
        int numberValues = Integer.parseInt(JOptionPane.showInputDialog("Write the number you want to raise"));
        if (numberValues > 0){
            int x =number.remove(-1);
            for(int i=0;i<numberValues;i++){
            exponent.add(x);
            }
            for(int i=0;i<operands.size();i++){
            resultado*=exponent.get(i);
            }
        }else{
            resultado=0;
        }
        operands.clear();             
        number.add(resultado);
        XooK figure= new XooK(resultado);
        figure.makeVisible();
        figure.changeColor(color);
        
    }
}
