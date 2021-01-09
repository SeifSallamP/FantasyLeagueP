
import java.io.File;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dell
 */
public class RegularUser extends User {
    public Squad squad;
    public SquadController squadController;
	public RegularUser() throws IOException
	{
//                squad = new Squad("Database" + File.separator + "Users" + File.separator + this.email + File.separator + "Squad List.txt","Database" + File.separator + "Users" + File.separator + this.email + File.separator + "Budget.txt");
                squadController = new SquadController(squad);
	}
    
}
