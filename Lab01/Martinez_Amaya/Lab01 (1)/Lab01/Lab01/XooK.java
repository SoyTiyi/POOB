import java.util.*;

/**
 * This Class create the XooK 
 * 
 * @Santiago Martinez and Ricardo Amaya 
 * @1.0 version 
 */
public class XooK
{
    private int number;
    private int xPosition;
    private int yPosition;
    private int width;
    private int height;
    private int diameter;
    private int iterationFloor;
    private int cloneNumber;
    private String color;
    private boolean isVisible;
    private ArrayList<Circle> circle = new ArrayList<Circle>();
    private ArrayList<Rectangle> rectangle = new ArrayList<Rectangle>();
    private ArrayList<Integer> floor = new ArrayList<Integer>();
    private ArrayList<Triangle> triangle = new ArrayList<Triangle>();
    /**
     * This metod is the constructor of XooK
     */
    public XooK(int number){
        this.number= number; 
        xPosition = 100;
        diameter= 7;
        yPosition = 300;
        isVisible= false;
        height=5;
        width=38;
        color="negro";
    }
    
    /**
     * This metod make visible the number in the maya system
     */
    public void makeVisible(){
        floor.clear();
        circle.clear();
        rectangle.clear();
        triangle.clear();
        draw();
    }
    
    public void makeInvisible(){
        erase();
        circle.clear();
        rectangle.clear();
        triangle.clear();
        floor.clear();
    }
    
    private void erase(){
        int numberRectangle = number/5;
        int numberCircle = number%5;
        
        for(int i=0; i<rectangle.size();i++){
            rectangle.get(i).makeInvisible();
        }

        for(int j=0; j<circle.size();j++){
            circle.get(j).makeInvisible();
        }
        
        for(int i=0;i<triangle.size();i++){
            triangle.get(i).makeInvisible();
        }
    }
    
    /**
     * This metod get de value
     */
    public int getValue(){
        return number;
    }
    
    /**
     * This metod set de number that mayas wants 
     */
    public void setValue(int number){
        erase();
        xPosition = 100;
        diameter= 7;
        yPosition = 50;
        isVisible= false;
        height=5;
        width=38;
        this.number=number;
        makeVisible();
    }
    
    /**
     * This metod change the color of the XooK figure
     */
    public void changeColor(String color){
        int quantifyCir=0;
        int quantifyRec=0;
        for(int i=0;i<floor.size();i++){
            int numberRectangle=floor.get(i)/5;
            int numberCircle=floor.get(i)%5;
            for(int j=0;j<numberRectangle;j++){
                rectangle.get(quantifyRec).changeColor(color);
                quantifyRec+=1;
            }
        
            for(int j=0;j<numberCircle;j++){
                circle.get(quantifyCir).changeColor(color);
                quantifyCir+=1;
            }
        }
        for(int i=0;i<triangle.size();i++){
            triangle.get(i).changeColor(color);
        }
    }
    
    /**
     * This metod move in the Horizontal axis the XooK
     */
    public void moveHorizontal(int distance){
        int quantifyCir=0;
        int quantifyRec=0;
        for(int i=0;i<floor.size();i++){
            int numberRectangle = floor.get(i)/5;
            int numberCircle = floor.get(i)%5;
            for(int j=0;j<numberRectangle;j++){
                rectangle.get(quantifyRec).moveHorizontal(distance);
                quantifyRec+=1;
            }
            
            for(int j=0;j<numberCircle;j++){
                circle.get(quantifyCir).moveHorizontal(distance);
                quantifyCir+=1;
            }
        }
        for(int i=0;i<triangle.size();i++){
            triangle.get(i).moveHorizontal(distance);
        }
    }
    
    /**
     * This metod draw in the canvas de XooK
     */
    private void draw(){
        cloneNumber=number;
        while(cloneNumber>0){
            floor.add(cloneNumber%20);
            cloneNumber/=20;
        }
        System.out.println(floor);
        if(cloneNumber==0){
            floor.add(cloneNumber);
        }
        
        int quantifyCir=0;
        int quantifyRec=0;
        int numTriangle=0;
        System.out.println(floor.size());
        for(int i=0;i<floor.size()-1;i++){
            int numberRectangle=floor.get(i)/5;
            int numberCircle=floor.get(i)%5;
            int numberTriangle=floor.get(i)%20;
            int moveY=yPosition;
            int moveX=xPosition;
            System.out.println("numberTriangle");
            System.out.println(numberTriangle);
            if(numberTriangle==0){
                System.out.println(numberTriangle);
                System.out.println("Entre");
                triangle.add(new Triangle(moveY));
                triangle.get(numTriangle);
                triangle.get(numTriangle).makeVisible();
                triangle.get(numTriangle).changeColor(color);
                numTriangle+=1;
            }
           
            for(int j=0;j<numberRectangle;j++){
                rectangle.add(new Rectangle());
                rectangle.get(quantifyRec).changeSize(height,width);
                rectangle.get(quantifyRec).changeColor(color);
                rectangle.get(quantifyRec).moveVertical(moveY);
                rectangle.get(quantifyRec).makeVisible();
                quantifyRec+=1;
                moveY=moveY-10;
            }
            moveY+=150;
            for (int z=0;z<numberCircle;z++){
                circle.add(new Circle(moveY));
                circle.get(quantifyCir).changeSize(diameter);
                circle.get(quantifyCir).changeColor(color);
                circle.get(quantifyCir).moveHorizontal(moveX);
                circle.get(quantifyCir).makeVisible();
                quantifyCir+=1;
                moveX=moveX+10;
            }
            moveX=xPosition;
            yPosition=moveY-200;
        }
    }
    
    /**
     * This metod give a random number and show in the maya sistem
     */
    public void random(){
        int min=0;
        int max=100;
        int random_int = (int )(Math.random() * max + min);
        System.out.println(random_int);
        number=random_int;
        setValue(number);
    }
    
}