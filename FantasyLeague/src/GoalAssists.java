
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GoalAssists {
    int score;
    int assistValue = 3;
    GameWeekBufferedEditor gwbe=new GameWeekBufferedEditor();
    GoalAssists(GameWeekBufferedEditor gwbe){
        this.gwbe.gameweek = gwbe.gameweek;
    }
    void assistedGoal(String playerName){
        score = assistValue;
        try {
            gwbe.pointsWriter(playerName, "Total Points: ", score);
            gwbe.pointsWriter(playerName, "Assists: ", 1);
        } catch (IOException ex) {
            Logger.getLogger(GoalAssists.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void assistGoal(String playerName, int goals){
        score=  assistValue * goals;
        try {
            gwbe.pointsWriter(playerName, "Assists: ", goals);
        } catch (IOException ex) {
            Logger.getLogger(GoalAssists.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
