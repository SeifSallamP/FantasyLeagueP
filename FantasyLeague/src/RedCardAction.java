import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RedCardAction implements CardsActions {
    int score;
    int cardValue = -3;
    @Override
    public void giveCard(String playerName) {
        score = cardValue;
        try {
            gwbe.scoreWriter(playerName, "Score: ", score);
        } catch (IOException ex) {
            Logger.getLogger(RedCardAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public static void main(String[] args){
    RedCardAction rd = new RedCardAction();
    rd.giveCard("Cristiano Ronaldo");
}   
}