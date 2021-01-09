
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Integer.parseInt;

public class GameWeekBufferedEditor {
    
    void scoreWriter(String playerName, String userText, int score) throws FileNotFoundException, IOException{
        File playerFile = new File("Database" + File.separator + "Game Weeks" + File.separator + "Game Week 1" + File.separator + playerName + ".txt");
        if (!playerFile.isFile()){
            playerFile.createNewFile();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(playerFile), true);
            bufferedWriter.write(userText + score);
        }
        File tempPlayerFile = new File("Database" + File.separator + "Game Weeks" + File.separator + "Game Week 1" + File.separator + playerName + " temp.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(playerFile));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempPlayerFile, true));
        String readText;
        while ((readText = bufferedReader.readLine()) != null){
            if (readText.contains(userText)){
                int temp = parseInt(readText.replace(userText, ""));
                temp = temp + score;
                bufferedWriter.write(userText + temp);
                bufferedWriter.newLine();
            }else {bufferedWriter.write(readText); bufferedWriter.newLine();}
        }
        bufferedWriter.close();
        bufferedReader.close();
        playerFile.delete();
        System.out.println(tempPlayerFile.renameTo(playerFile));
}
}