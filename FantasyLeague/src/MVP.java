
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MVP{
    int score;
    BonusPoints bp = new BonusPoints();
    GameWeekBufferedEditor gwbe = new GameWeekBufferedEditor();
    /*
    Player selectMVP(String playerName){
        Player player = new Player();
        return player;
    }
    void rewardMVP(Player player, int playerPoints, int bonus){
        score = bp.addBonus(playerPoints, bonus);
    }*/
    void rewardMVP(String playerName, int bonus){
        score = bp.addBonus(bonus);
        try {
            gwbe.pointsWriter(playerName, "Total Points: ", score);
            gwbe.pointsWriter(playerName, "MVP: ", 1);
        } catch (IOException ex) {
            Logger.getLogger(MVP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
public static void main(String[] args){
    MVP mvp = new MVP();
    mvp.rewardMVP("Cristiano Ronaldo", 5);
}
}
