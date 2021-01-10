
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DEFCleanSheet implements CleanSheet {
    protected int score;
    protected int cleanSheetValue = 4;
     DEFCleanSheet(GameWeekBufferedEditor gwbe){
        CleanSheet.gwbe.gameweek = gwbe.gameweek;
    }
    @Override
    public void cleanSheet(String playerName) {
        score = cleanSheetValue;
        try {
            gwbe.pointsWriter(playerName, "Total Points: ", score);
            gwbe.pointsWriter(playerName, "Clean Sheets: ", 1);
        } catch (IOException ex) {
            Logger.getLogger(YellowCardAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

}
