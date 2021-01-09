import java.io.IOException;

public class PlayerController {
    
    public void addPlayer(String name, String nationality, String club, int position, double price) throws IOException{
        Player player = new Player(name, nationality, club, position, price);
        Database db = new Database();
        db.addPlayer(player);
    }
}
