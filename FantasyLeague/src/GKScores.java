
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GKScores implements ScoredGoals {
    int score;
    int goalValue = 6;
    @Override
    public void scoreGoals(String playerName, int goals) {
        score = goalValue * goals;
        try {
            gwbe.pointsWriter(playerName, "Total Points: ", score);
            gwbe.pointsWriter(playerName, "Goals: ", goals);
        } catch (IOException ex) {
            Logger.getLogger(MidScores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void scoreGoal(String playerName) {        
        score = goalValue;
        try {
            gwbe.pointsWriter(playerName, "Total Points: ", score);
            gwbe.pointsWriter(playerName, "Goals: ", 1);
        } catch (IOException ex) {
            Logger.getLogger(MidScores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args){
        GKScores gs = new GKScores();
        gs.scoreGoal("Cristiano Ronaldo");
    }
    
}
