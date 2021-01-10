
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Integer.parseInt;

public class GameWeekBufferedEditor {
    GameWeekController gameweek;
    GameWeekBufferedEditor(){gameweek = new GameWeekController();}
    GameWeekBufferedEditor(GameWeekController gameweek){this.gameweek = gameweek;}
    void pointsWriter(String playerName, String userText, int score) throws FileNotFoundException, IOException{
        File playerFile = new File(gameweek.currentGameWeek + File.separator + playerName + ".txt");
        if (!playerFile.isFile()){
            playerFile.createNewFile();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(playerFile, true));
            bufferedWriter.write("Total Points: " + 0);bufferedWriter.newLine();
            bufferedWriter.write("Goals Scored: " + 0); bufferedWriter.newLine();
            bufferedWriter.write("Assists: " + 0); bufferedWriter.newLine();
            bufferedWriter.write("Yellow Cards: " + 0); bufferedWriter.newLine();
            bufferedWriter.write("Red Cards: " + 0); bufferedWriter.newLine();
            bufferedWriter.write("Clean Sheet: " + 0); bufferedWriter.newLine();
            bufferedWriter.write("MVP: " + 0); bufferedWriter.newLine();
            bufferedWriter.write("Bonus Points: " + 0);bufferedWriter.newLine();
            bufferedWriter.write("Saved Penalties: " + 0 ); bufferedWriter.newLine();
            bufferedWriter.write("Missed Penalties: " + 0);bufferedWriter.newLine();
            bufferedWriter.write("Conceded Goals: " + 0); bufferedWriter.newLine();
            bufferedWriter.write("Played Just 60 Minutes: " + 0); bufferedWriter.newLine();
            bufferedWriter.write("Played More Than 60 Minutes: " + 0); bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
        }
        File tempPlayerFile = new File(gameweek.currentGameWeek.getAbsolutePath() + File.separator + playerName + " temp.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(playerFile));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempPlayerFile, true));
        String readText;
        while ((readText = bufferedReader.readLine()) != null){
            if (readText.contains(userText)){
                int temp = parseInt(readText.replace(userText, ""));
                temp = temp + score;
                bufferedWriter.write(userText + temp);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }else {bufferedWriter.write(readText); bufferedWriter.newLine();bufferedWriter.flush();}
        }
        bufferedWriter.close();
        bufferedReader.close();
        playerFile.delete();
        tempPlayerFile.renameTo(playerFile);
}

    void pointsSquadWriter() throws IOException{
        File[] usersFolders = new File("Database" + File.separator + "Users").listFiles();
        for (File x : usersFolders){
            File squadsFolder = new File(x.getAbsolutePath() + File.separator + "Squads");
            File[] squadsArray = squadsFolder.listFiles();
            for (File y : squadsArray){
                File squadListFile = new File(y.getAbsolutePath() + File.separator + "Squad List.txt");
                BufferedReader bufferedReader = new BufferedReader(new FileReader(squadListFile));
                String tempStr;
                while((tempStr = bufferedReader.readLine()) != null){
                    if(tempStr.contains("Name: ")){
                        File squadGameWeek = new File(y.getAbsolutePath() + File.separator +
                                                                    gameweek.currentGameWeek.getName());
                      if(!squadGameWeek.isDirectory()){
                          squadGameWeek.mkdir();
                      }
                      for (File player : gameweek.currentGameWeek.getAbsoluteFile().listFiles()){
                          if (tempStr.replace("Name: ", "").contentEquals(player.getName().replace(".txt", ""))){
                              BufferedReader playerReader = new BufferedReader(new FileReader(player));
                              String tempPlayerStr;
                              File playerFileInUserFolder = new File(squadGameWeek.getAbsolutePath() + File.separator + player.getName());
                              BufferedWriter bufferedWriter;
                              if (!playerFileInUserFolder.isDirectory()){
                                  playerFileInUserFolder.createNewFile();
                                   bufferedWriter = new BufferedWriter(new FileWriter(squadGameWeek.getAbsolutePath() +
                                                                    File.separator + player.getName()));
                              while ((tempPlayerStr = playerReader.readLine()) != null){

                                  bufferedWriter.write(tempPlayerStr);bufferedWriter.newLine();bufferedWriter.flush();
                              }
                             }
                              else{
                                  File tempPlayerFileInUserFolder = new File(squadGameWeek.getAbsolutePath()
                                                                                    + File.separator + "temp " + player.getName());
                              tempPlayerFileInUserFolder.createNewFile();
                                  bufferedWriter = new BufferedWriter(new FileWriter(tempPlayerFileInUserFolder));   
                              while ((tempPlayerStr = bufferedReader.readLine()) != null){
                                  bufferedWriter.write(tempPlayerStr);
                                  bufferedWriter.newLine();
                                  bufferedWriter.flush();
                              }
                              bufferedWriter.close();
                              new File(squadGameWeek.getAbsolutePath() + File.separator + player.getName()).delete();
                              tempPlayerFileInUserFolder.renameTo(new File(squadGameWeek.getAbsolutePath() +
                                                                    File.separator + player.getName()));
                              }
                          }
                      }
                    }
                }
          bufferedReader.close();  
            }
        }
    }
    
    }