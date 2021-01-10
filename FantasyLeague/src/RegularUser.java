
import java.io.File;
import java.io.IOException;

public class RegularUser extends User {
    public Squad squad;
    public SquadController squadController;
    public Database db=new Database();
	public RegularUser()
	{
//                squad = new Squad("Database" + File.separator + "Users" + File.separator + this.email + File.separator + "Squad List.txt","Database" + File.separator + "Users" + File.separator + this.email + File.separator + "Budget.txt");
                squadController = new SquadController(squad);
	}

    RegularUser(String firstName, String lastName, String email, String password, String favClub, String type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.favouriteClub = favClub;
        this.type = type;
        squadController =new SquadController();
        squadController.squadsFolder=new File(db.databaseFolder.getAbsolutePath() + File.separator + "Users" + File.separator + email + File.separator + "Squads");
    }
    
}
