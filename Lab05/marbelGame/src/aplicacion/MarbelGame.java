package aplicacion;

import java.awt.Color;
import java.util.Random;
public class MarbelGame {
    private Elemento[][] tablero;
    private Elemento[][] inicial;
    private Elemento[][] posicionada;
    private Elemento[][] posicionadaInicial;
    private int tamaño;
    private int cantMarbels;
    private int cantBarriers;
    private int posicionadas;
    private int noPosicionadas;

    public MarbelGame(int tamaño, int cantMarbels, int cantBarriers){
        tablero = new Elemento[tamaño][tamaño];
        inicial = new Elemento[tamaño][tamaño];
        posicionada = new Elemento[tamaño][tamaño];
        posicionadaInicial = new Elemento[tamaño][tamaño];
        posicionadas=0;
        noPosicionadas=cantMarbels;
        this.tamaño=tamaño;
        this.cantMarbels=cantMarbels;
        this.cantBarriers=cantBarriers;
        for(int i=0;i<tamaño;i++){
            for(int j=0;j<tamaño;j++){
                tablero[i][j]=null;
            }
        }
        //prepararAlgunosElementos();
        createMarbelsAndHoles();
        createBarriers();
        prepareInicial();
    }

    public int getPosicionadas(){
        return posicionadas;
    }

    public int getNoPosicionadas(){
        return noPosicionadas;
    }

    private void createMarbelsAndHoles(){
        Random random = new Random();
        for(int i=0; i<cantMarbels;i++){
            float r = random.nextFloat(), g = random.nextFloat(), b = random.nextFloat(); 
            boolean flag = false;
            int fila, filaHole;
            int columna, columnaHole;
            while(!flag){
                fila = random.nextInt(tamaño);
                columna = random.nextInt(tamaño);
                if(tablero[fila][columna]==null && posicionada[fila][columna]==null){
                    tablero[fila][columna]= new Marbell(this, fila, columna, new Color(r,g,b) ,false);
                    flag=true;
                }
            }
            flag=false;
            while(!flag){
                filaHole = random.nextInt(tamaño);
                columnaHole = random.nextInt(tamaño);
                if(tablero[filaHole][columnaHole]==null && posicionada[filaHole][columnaHole]==null){
                    posicionada[filaHole][columnaHole]= new Hole(this, filaHole, columnaHole, new Color(r,g,b));
                    flag=true;
                }
            }
        }
    }

    public Elemento getElentoPosicionada(int i, int j){
        return posicionada[i][j];
    }
    private void createBarriers(){
        Random random = new Random();
        for(int i=0;i<cantBarriers;i++){
            boolean flag = false;
            int fila,columna;
            while(!flag){
                fila = random.nextInt(tamaño);
                columna = random.nextInt(tamaño);
                if(tablero[fila][columna]==null && posicionada[fila][columna]==null){
                    tablero[fila][columna]= new Barrier(this, fila, columna, Color.black);
                    flag=true;
                }
            }
        }
    }

    private void prepareInicial(){
        for(int i=0; i< tablero.length;i++){
            for(int j=0; j<tablero.length;j++){
                inicial[i][j]=tablero[i][j];
                posicionadaInicial[i][j]=posicionada[i][j];
            }
        }
    }

    public void reiniciar(){
        posicionadas=0;
        noPosicionadas=cantMarbels;
        for(int i=0;i<tablero.length;i++){
            for(int j=0; j<tablero.length;j++){
                tablero[i][j]=inicial[i][j];
                posicionada[i][j]=posicionadaInicial[i][j];
            }
        }
    }
    public Elemento getElemento(int i, int j){
        return tablero[i][j];    
    }

    
    public String pintarNazi(){
        String temp="[";
        for(int i=0;i<tamaño;i++){
            for(int j=0;j<tamaño;j++){
                if(tablero[i][j] instanceof Marbell){
                    temp+="1 , ";
                }
                else if(tablero[i][j]instanceof Barrier){
                    temp+="B , ";
                }
                else if(tablero[i][j]instanceof Hole){
                    temp+="H , ";
                }
                else{
                    temp+="0 , ";
                }
            }
            temp+="]";
        }
        return temp;
    }
    /*
    private void prepararAlgunosElementos(){
        tablero[0][1]= new Marbell(this, 1, 2, Color.ORANGE,false);
        tablero[1][0] = new Marbell(this,2,1,Color.BLUE,false);
        tablero[1][2]= new Marbell(this,2,3,Color.GREEN,false);
        tablero[1][1] = new Barrier(this, 2, 2, Color.BLACK);
        tablero[2][0] = new Hole(this, 3, 1, Color.BLUE);
        tablero[3][1] = new Hole(this,4,2,Color.GREEN);
        tablero[2][3] = new Hole(this,3,4,Color.ORANGE);
    }
    */  
    public void move(char direccion){
        boolean whatLetter = saidWhatLetter(direccion);
        if(whatLetter){
            readVertical(direccion);
        }
        else{
            readHorizontal(direccion);

        }
    }

    private void readVertical(char direccion){
        if(direccion=='N'){
            for(int i=0;i<tamaño;i++){
                for(int j=tamaño-1;j>=0;j--){
                    if(tablero[j][i]instanceof Marbell && tablero[j][i].getHaveHole()==false){
                        moverNorte(i,j);
                    }
                }
            }
        }
        else{
           for(int i=0;i<tamaño;i++){
               for(int j=0;j<tamaño;j++){
                if(tablero[j][i]instanceof Marbell && tablero[j][i].getHaveHole()==false){
                    moverSur(i,j);
                }
               }
           }  
        }
    }

    private void readHorizontal(char direccion){
        if(direccion=='E'){
            for(int i=0;i<tamaño;i++){
                for(int j=0;j<tamaño;j++){
                    if(tablero[i][j] instanceof Marbell && tablero[i][j].getHaveHole()==false){
                        moverEste(i,j);
                    }
                }
            }
        }
        else{
            for(int i=0;i<tamaño;i++){
                for(int j=tamaño-1;j>=0;j--){
                    if(tablero[i][j] instanceof Marbell && tablero[i][j].getHaveHole()==false){
                        moverOeste(i,j);
                    }
                }
            }
        }
    }

    private void moverEste(int i, int j){
        for(int z=j-1; z>=0;z--){
            if(tablero[i][z] instanceof Barrier || (tablero[i][z] instanceof Marbell && tablero[i][z].getHaveHole()==false)){
                if(z!=j-1){
                    tablero[i][z+1]=tablero[i][j];
                    tablero[i][j]=null;
                    break;
                }
                else{
                    break;
                }
            }
            else if(posicionada[i][z] instanceof Hole){
                if(tablero[i][j].getColor().equals(posicionada[i][z].getColor())){
                    posicionadas+=1;
                    noPosicionadas-=1;
                    posicionada[i][z]=null;
                    posicionada[i][z]=tablero[i][j]; 
                    tablero[i][j]=null;
                    break;
                }
                else if(z==0){
                    tablero[i][z]=tablero[i][j];
                    tablero[i][j]=null;
                    break;
                }
            }
            else if(z==0){
                tablero[i][z]=tablero[i][j];
                tablero[i][j]=null;
                break;
            }
        }
    }

    private void moverOeste(int i, int j){
        for(int z=j+1;z<tamaño;z++){
            if(tablero[i][z] instanceof Barrier || (tablero[i][z] instanceof Marbell && tablero[i][z].getHaveHole()==false)){
                if(z!=j+1){
                    tablero[i][z-1]=tablero[i][j];
                    tablero[i][j]=null;
                    break;
                }
                else{
                    break;
                }
            }
            else if(posicionada[i][z] instanceof Hole){
                if(tablero[i][j].getColor().equals(posicionada[i][z].getColor())){
                    posicionadas+=1;
                    noPosicionadas-=1;
                    posicionada[i][z]=null;
                    posicionada[i][z]=tablero[i][j]; 
                    tablero[i][j]=null; 
                    break;
                }
                else if(z==tamaño-1){
                    tablero[i][z]=tablero[i][j];
                    tablero[i][j]=null;
                    break;
                }
            }
            else if(z==tamaño-1){
                tablero[i][z]=tablero[i][j];
                tablero[i][j]=null;
                break;
            }
        }
    }

    private void moverNorte(int i, int j){
        for(int z=j+1;z<tamaño;z++){
            if(tablero[z][i]instanceof Barrier || (tablero[z][i] instanceof Marbell && tablero[z][i].getHaveHole()==false)){
                if(z!=j+1){
                    tablero[z-1][i]=tablero[j][i];
                    tablero[j][i]=null;
                    break;
                }
                else{
                    break;
                }
            }
            else if(posicionada[z][i] instanceof Hole){
                if(posicionada[z][i].getColor().equals(tablero[j][i].getColor())){
                    posicionadas+=1;
                    noPosicionadas-=1;
                    posicionada[z][i]=null;
                    posicionada[z][i]=tablero[j][i]; 
                    tablero[j][i]=null;
                    break;
                }
                else if(z==tamaño-1){
                    tablero[z][i]=tablero[j][i];
                    tablero[j][i]=null;
                    break;
                }
            }
            else if(z==tamaño-1){
                tablero[z][i]=tablero[j][i];
                tablero[j][i]=null;
                break;

            }
        }
    }

    private void moverSur(int i,int j){
        for(int z=j-1;z>=0;z--){
            if(tablero[z][i]instanceof Barrier || (tablero[z][i] instanceof Marbell && tablero[z][i].getHaveHole()==false)){
                if(z!=j-1){
                    tablero[z+1][i]=tablero[j][i];
                    tablero[j][i]=null;
                    break;
                }
                else{
                    break;
                }
            }
            else if(posicionada[z][i] instanceof Hole){
                if(posicionada[z][i].getColor().equals(tablero[j][i].getColor())){
                    posicionadas+=1;
                    noPosicionadas-=1;
                    posicionada[z][i]=null;
                    posicionada[z][i]=tablero[j][i]; 
                    tablero[j][i]=null;
                    break;
                }
                else if(z==0){
                    tablero[z][i]=tablero[j][i];
                    tablero[j][i]=null;
                    break;
                }
            }
            else if(z==0){
                tablero[z][i]=tablero[j][i];
                tablero[j][i]=null;
                break; 
            }
        }
    }
    
    private boolean saidWhatLetter(char direccion){
        if(direccion=='N' || direccion=='S'){
            return true;
        }
        else{
            return false;
        }
    }

    public int getTamaño(){
        return tamaño;
    }

    public static void main(String args[]){
        System.out.println("Primera Matriz");
        MarbelGame marbelgame = new MarbelGame(4, 3, 3);
        marbelgame.move('N');
        System.out.println(marbelgame.pintarNazi());
    }
}