import java.time.Duration;

public class CommandLine extends Submission{
    /**
     * Esta clase nos permite subir las soluciones por terminal
     */
    private String sourceCode;
    public CommandLine(String code){
        this.sourceCode=code;
    }

    /**
     * Este metodo nos permite saber si el programa es correcto y si cumple las condiciones 
     * para ser subido
     * 
     * @ Throws TIMEOUT, si el tiempo de ejecucion es mayor al tiempo limite 
     */
    public void evalua(){
        String status = super.getStatus();
        if(!status.equals("Pendiente")){
            boolean copilo = super.compile();
            if(copilo){
                boolean ejecuto = super.execute();
                Duration duration = new Duration();
                Duration executionLimit = super.getExecutionLimit(); Duration executionTime = super.getExecutionTime();
                int limit = duration.compareTo(executionLimit); int time = duration.compareTo(executionTime);
                if(limit>time){
                    if(ejecuto){
                        super.setStatus="Correcto";
                    }
                }
                else{
                    super.setStaus("Rechazado");
                    throw new ECIJudgeException(ECIJudgeException.TIMEOUT);
                }
            }
        }
    }
}