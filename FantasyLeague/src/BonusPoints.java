
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BonusPoints {
    GameWeekBufferedEditor gwbe = new GameWeekBufferedEditor();
    int addBonus(int bonusPoints){
        return bonusPoints;
    };
    void addBonus(String playerName, int bonusPoints){
        try {
            gwbe.scoreWriter(playerName, "Score: ", bonusPoints);
        } catch (IOException ex) {
            Logger.getLogger(BonusPoints.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public static void main(String[] args){
    BonusPoints bp = new BonusPoints();
    bp.addBonus("Cristiano Ronaldo", 1);
}
}
