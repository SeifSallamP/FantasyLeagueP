
import java.io.IOException;


public class PenaltySaved extends PenaltyAction {
    int penaltyValue = 5;    
    PenaltySaved(){};
    PenaltySaved(int newPenaltyValue){
            this.penaltyValue = newPenaltyValue;
        }
        void savePenalty(String playerName) throws IOException{
            score = penaltyValue;
            gwbe.scoreWriter(playerName, "Score: ", score);
        }
        void savePenalty(String playerName, int penalties) throws IOException{
            score = penaltyValue * penalties;
            gwbe.scoreWriter(playerName, "Score: ", score);
        }
  public static void main(String[] args) throws IOException{
      PenaltySaved ps = new PenaltySaved();
      ps.savePenalty("Cristiano Ronaldo");
  }

}

