import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MidCleanSheet implements CleanSheet {
    protected int score;
    protected int cleanSheetValue = 1;
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
public static void main(String[] args){
    MidCleanSheet mc = new MidCleanSheet();
    mc.cleanSheet("Cristiano Ronaldo");
}    
}
