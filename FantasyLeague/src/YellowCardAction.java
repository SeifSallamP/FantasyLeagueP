
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class YellowCardAction implements CardsActions {
    int score;
    int cardValue = -1;
    @Override
    public void giveCard(String playerName) {
        score = cardValue;
        try {
            gwbe.scoreWriter(playerName, "Score: ", score);
        } catch (IOException ex) {
            Logger.getLogger(YellowCardAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 public static void main(String[] args){
     YellowCardAction yd = new YellowCardAction();
     yd.giveCard("Cristiano Ronaldo");
 }  
}
