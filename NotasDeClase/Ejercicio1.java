
public Class Aspect{
    private int minutes;
    private int semester;
    private ArrayList<Scene> escenas = new ArrayList<Scene>();
    public int minutes(Student s) throws ECISeriesException{
        int cont=0;
        if(this.semester==s.getSemester()){
            for(Reaction r:s.getReaction()){
                if(r.getAfinnity>75){
                    if(r.getScene()!=null){
                        cont+=r.getScene().getAspect().getMinutes();
                    }
                    else{
                        throw new ECISeriesException(ECISeriesException.EMPTY_SCENES);
                    }
                }
            }
        }
        else{
            throw new ECISeriesException(ECISeriesException.NO_SEMESTER);
        }
        return cont;
    }
    public int getMinutes(){
        return minutes;
    }
}


public class Knowledge extends Aspect{

}

public Class ECISeriesException extends Exception{
    public static final String NO_SEMESTER="el estudiante no es del semestre correspondiente";
    public static final String EMPTY_SCENES="El aspecto no tiene las escenas necesarias definidas";
    public ECISeriesException(String message){
        super(message);
    }
}