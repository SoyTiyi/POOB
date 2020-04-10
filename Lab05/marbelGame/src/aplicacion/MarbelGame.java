package aplicacion;

import javafx.scene.paint.Color;

public class MarbelGame {
    private Elemento[][] tablero;
    private int tamaño;
    private int cantMarbels;
    private int cantBarriers;
    private Color color;

    public MarbelGame(int tamaño, int cantMarbels, int cantBarriers, Color color){
        tablero = new Elemento[tamaño][tamaño];
        this.tamaño=tamaño;
        this.cantMarbels=cantMarbels;
        this.cantBarriers=cantBarriers;
        for(int i=0;i<tamaño;i++){
            for(int j=0;j<tamaño;j++){
                tablero[i][j]=null;
            }
        }
        prepararAlgunosElementos();
        pintarNazi();
    }

    public void pintarNazi(){
        for(int i=0;i<tamaño;i++){
            String temp="[";
            for(int j=0;j<tamaño;j++){
                if(tablero[i][j] instanceof Marbell){
                    temp+="1 , ";
                }
                else if(tablero[i][j]instanceof Barrier){
                    temp+="B , ";
                }
                else{
                    temp+="0 , ";
                }
            }
            temp+="]";
            System.out.println(temp);
        }
    }

    private void prepararAlgunosElementos(){
        tablero[0][1]= new Marbell(this, 1, 2, Color.ORANGE);
        tablero[1][0] = new Marbell(this,2,1,Color.BLUE);
        tablero[1][2]= new Marbell(this,2,3,Color.GREEN);
        tablero[1][1] = new Barrier(this, 2, 2, Color.BLACK);
    }

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
                    if(tablero[j][i]instanceof Marbell){
                        moverNorte(i,j);
                    }
                }
            }
        }
        else{
           for(int i=0;i<tamaño;i++){
               for(int j=0;j<tamaño;j++){
                if(tablero[j][i]instanceof Marbell){
                    moverSur(i,j);
                }
               }
           }  
        }
    }

    private void readHorizontal(char direccion){
        if(direccion=='E'){
            for(int i=0;i<tamaño;i++){
                for(int j=tamaño-1;j>=0;j--){
                    if(tablero[i][j] instanceof Marbell){
                        moverEste(i,j);
                    }
                }
            }
        }
        else{
            for(int i=0;i<tamaño;i++){
                for(int j=tamaño-1;j>=0;j--){
                    if(tablero[i][j] instanceof Marbell){
                        moverOeste(i,j);
                    }
                }
            }
        }
    }

    private void moverEste(int i, int j){
        for(int z=j-1; z>=0;z--){
            if(tablero[i][z] instanceof Barrier || tablero[i][z] instanceof Marbell){
                if(z!=j-1){
                    tablero[i][z+1]=tablero[i][j];
                    tablero[i][j]=null;
                    break;
                }
                else{
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
            if(tablero[i][z] instanceof Barrier || tablero[i][z] instanceof Marbell){
                if(z!=j+1){
                    tablero[i][z-1]=tablero[i][j];
                    tablero[i][j]=null;
                    break;
                }
                else{
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
            if(tablero[z][i]instanceof Barrier || tablero[z][i] instanceof Marbell){
                if(z!=j+1){
                    tablero[z-1][i]=tablero[j][i];
                    tablero[j][i]=null;
                    break;
                }
                else{
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
            if(tablero[z][i]instanceof Barrier || tablero[z][i] instanceof Marbell){
                if(z!=j-1){
                    tablero[z+1][i]=tablero[j][i];
                    tablero[j][i]=null;
                    break;
                }
                else{
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
        MarbelGame marbelgame = new MarbelGame(4, 3, 3, Color.BLACK);
        marbelgame.move('E');
        System.out.println("Segunda Matriz");
        marbelgame.pintarNazi();
    }

}