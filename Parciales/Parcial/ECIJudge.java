import java.util.ArrayList;

public class ECIJudge{
    /**
     * La clase ECIJudge gestiona las maratones
     */
    private ArrayList<Team> teams;
    private ArrayList<Student> students;
    private ArrayList<Contest> contests;
    private ArrayList<Problem> problems;

    public ECIJudge(){
        teams = new ArrayList<Team>();
        students = new ArrayList<Student>();
        contest = new ArrayList<contest>();
        problems = new ArrayList<Problem>();
    }


    /**
     * Calculates the final contest scoreboard
     * @param name es un String, hace referencia al nombre de la competencia
     * @throws ECIJudgeException PENDING_SUBMMISIONS
     * @throws ECIJudgeException ALL_SUBMMISIONS_REJECTED
     * @throws ECIJudgeException CONTEST_IN_PROGRESS
     * @return lista, el nombre de los equipos ordenados
     */
    public String[] getFinalScoreBoard(String contestName) throws ECIJudgeException{
        ArrayList<String,Integer> nombreYpuntaje = new ArrayList<String,Integer>();
        int [] listScores= new int[teams.size()];
        for(int z=0;z<conests.size();z++){
            if(contest.get(z).getName()==contestName){
                for(int i=0 ; i<teams.size();i++){
                    ArrayList<Submission> submissionsTeam = new ArrayList<Submission>();
                    submissionsTeam = teams.get(i).getSubmissions();
                    int cont = 0;
                    for(int j=0 ; j<submissionsTeam.size() ; j++){
                        if(submissionsTeam.get(j).getStatus!="Pendiente"){
                            int rechazados=0;
                            if(submissionsTeam.get(j).getStatus=="Rechazado"){
                                rechazados+=1;
                                if(rechazados==submissionsTeam.size()){
                                    throw new ECIJudgeException(ECIJudgeException.ALL_SUBMISSIONS_REJECTED);
                                }
                            }
                            else{
                                int baseScore= submissionsTeam.get(j).getScore();
                                Duration duration = new Duration();
                                if(teams.get(i).getNumMembers()==1){
                                    baseScore+=5;
                             }
                                else if(submissionsTeam.get(j).getAverageTime()>duration.compareTo(submissionsTeam.get(j).getExecutionTime())){
                                    baseScore+=5;
                                }
                            }
                        }
                        else{
                            throw new ECIJudgeException(ECIJudgeException.PENDING_SUBMMISIONS);
                        }
                    }
                    listScore[i]=baseScore;
                    nombreYpuntaje.add(teams.get(i).getName(),basesScore);
                }
                nombreYpuntaje.ordenados();
                String[] finalStrings = new String[teams.size()];
                for(int i=0;i<finalString.length;i++){
                    finalStrings[i]= nombreYpuntaje.get(i).get(0);
                }
                return finalStrings;
            }
        }
    }

}