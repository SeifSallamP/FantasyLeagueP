
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AttScores implements ScoredGoals {
    int score;
    int goalValue = 4;
    @Override
    public void scoreGoals(String playerName, int goals) {
        score = goalValue * goals;
        try {
            gwbe.scoreWriter(playerName, "Score: ", score);
        } catch (IOException ex) {
            Logger.getLogger(MidScores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void scoreGoal(String playerName) {
          score = goalValue;
          try {
            gwbe.scoreWriter(playerName, "Score: ", score);
        } catch (IOException ex) {
            Logger.getLogger(MidScores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args){
        AttScores as = new AttScores();
        as.scoreGoal("Cristiano Ronaldo");
    }
}
