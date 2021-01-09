
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GoalAssists {
    int score;
    int assistValue = 3;
    GameWeekBufferedEditor gwbe = new GameWeekBufferedEditor();
    void assistedGoal(String playerName){
        score = assistValue;
        try {
            gwbe.scoreWriter(playerName, "Score: ", score);
        } catch (IOException ex) {
            Logger.getLogger(GoalAssists.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void assistGoal(String playerName, int goals){
        score=  assistValue * goals;
        try {
            gwbe.scoreWriter(playerName, "Score: ", score);
        } catch (IOException ex) {
            Logger.getLogger(GoalAssists.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public static void main(String[] args){
    GoalAssists ga = new GoalAssists();
    ga.assistGoal("Cristiano Ronaldo", 2);
}
}
