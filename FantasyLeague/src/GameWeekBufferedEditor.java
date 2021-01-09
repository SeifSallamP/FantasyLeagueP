
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
//        File playerFile = new File("Database" + File.separator + "Game Weeks" + File.separator + "Game Week 1" + File.separator + playerName + ".txt");
        File playerFile = new File(gameweek.currentGameWeek + File.separator + playerName + ".txt");
        System.out.println("player file: " + playerFile.getAbsolutePath());
        System.out.println(gameweek.currentGameWeek);
        if (!playerFile.isFile()){
            playerFile.createNewFile();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(playerFile, true));
//            bufferedWriter.write(userText + score);
            bufferedWriter.write("Total Points: " + 0);bufferedWriter.newLine();
            bufferedWriter.write("Goals: " + 0); bufferedWriter.newLine();
            bufferedWriter.write("Assists: " + 0); bufferedWriter.newLine();
            bufferedWriter.write("Yellow Cards:" + 0); bufferedWriter.newLine();
            bufferedWriter.write("Red Cards:" + 0); bufferedWriter.newLine();
            bufferedWriter.write("Clean Sheet: " + 0); bufferedWriter.newLine();
            bufferedWriter.write("MVP: " + 0); bufferedWriter.newLine();
            bufferedWriter.write("Bonus Points: " + 0);bufferedWriter.newLine();
            bufferedWriter.write("Saved Penalties: " + 0 ); bufferedWriter.newLine();
            bufferedWriter.write("Missed Penalties: " + 0);bufferedWriter.newLine();
            bufferedWriter.close();
        }
//        File tempPlayerFile = new File("Database" + File.separator + "Game Weeks" + File.separator + "Game Week 1" + File.separator + playerName + " temp.txt");
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
            }else {bufferedWriter.write(readText); bufferedWriter.newLine();}
        }
        bufferedWriter.close();
        bufferedReader.close();
        playerFile.delete();
        System.out.println(tempPlayerFile.renameTo(playerFile));
}
//    void pointsSquadsWriter() throws FileNotFoundException, IOException{
//        File[] usersFolders = new File("Database" + File.separator + "Users").listFiles();
//        for (File x : usersFolders){
//            File squadsFolder = new File(x.getAbsolutePath() + File.separator + "Squads");
//            File[] squadsArray = squadsFolder.listFiles();
//            for (File y : squadsArray){
//                File squadListFile = new File(y.getAbsolutePath() + File.separator + "Squad List.txt");
//                BufferedReader bufferedReader = new BufferedReader(new FileReader(squadListFile));
//                String tempStr;
//                while((tempStr = bufferedReader.readLine()) != null){
//                    if(tempStr.contains("Name: ")){
//                        File squadGameWeek = new File(y.getAbsolutePath() + File.separator +
//                                                                    gameweek.currentGameWeek.getName() + ".txt");
//                        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(squadGameWeek, true));
//                      if(!squadGameWeek.isFile()){
//                          squadGameWeek.createNewFile();
//                          bufferedWriter.write("Squad Points: " + 0); bufferedWriter.newLine();
//                      }
//                      for (File player : gameweek.currentGameWeek.getAbsoluteFile().listFiles()){
//                          if (tempStr.replace("Name: ", "").contentEquals(player.getName())){
//                              BufferedReader playerReader = new BufferedReader(new FileReader(player));
//                              String tempPlayerStr;
//                              while ((tempPlayerStr = bufferedReader.readLine()) != null){
//                                  //Don't forget to continue coding it 
//                                  
//                              }
//                          }
//                      }
//                      
//                    }
//                }
//            }
//        }
//    }
    void pointsSquadWriter() throws IOException{
        File[] usersFolders = new File("Database" + File.separator + "Users").listFiles();
        for (File x : usersFolders){
            File squadsFolder = new File(x.getAbsolutePath() + File.separator + "Squads");
            File[] squadsArray = squadsFolder.listFiles();
            System.out.println("First for loop: " + x);
            System.out.println("squadsArray length: " + squadsArray.length);
            for (File y : squadsArray){
                File squadListFile = new File(y.getAbsolutePath() + File.separator + "Squad List.txt");
                System.out.println("Y: " + y.getAbsolutePath());
                System.out.println("SquadList File: " + squadListFile.getAbsolutePath());
                BufferedReader bufferedReader = new BufferedReader(new FileReader(squadListFile));
                String tempStr;
                while((tempStr = bufferedReader.readLine()) != null){
                    System.out.println("tempStr: " + tempStr);
                    if(tempStr.contains("Name: ")){
                        System.out.println("GW: " + gameweek.currentGameWeek.getName());
                        File squadGameWeek = new File(y.getAbsolutePath() + File.separator +
                                                                    gameweek.currentGameWeek.getName());
                        System.out.println("SquadgameWeek: " + squadGameWeek.getAbsolutePath());
                      if(!squadGameWeek.isDirectory()){
                          squadGameWeek.mkdir();
                      }
                      for (File player : gameweek.currentGameWeek.getAbsoluteFile().listFiles()){
                          System.out.println("Player: " + player.getAbsolutePath());
                          if (tempStr.replace("Name: ", "").contentEquals(player.getName().replace(".txt", ""))){
                              System.out.println("yaaaaa");
                              BufferedReader playerReader = new BufferedReader(new FileReader(player));
                              String tempPlayerStr;System.out.println("Player name: " + player.getName());
                              File playerFileInUserFolder = new File(squadGameWeek.getAbsolutePath() + File.separator + player.getName());
                              BufferedWriter bufferedWriter;
                              if (!playerFileInUserFolder.isDirectory()){
                                  playerFileInUserFolder.createNewFile();
                                   bufferedWriter = new BufferedWriter(new FileWriter(squadGameWeek.getAbsolutePath() +
                                                                    File.separator + player.getName()));
                              while ((tempPlayerStr = playerReader.readLine()) != null){
                                  //Don't forget to continue coding it
                                  System.out.println("tempPlayerStr: " + tempPlayerStr);
                                  bufferedWriter.write(tempPlayerStr);bufferedWriter.newLine();
                              }
                              }
                              else{File tempPlayerFileInUserFolder = new File(squadGameWeek.getAbsolutePath()
                                                                                    + File.separator + "temp " + player.getName());
                              tempPlayerFileInUserFolder.createNewFile();
                                  bufferedWriter = new BufferedWriter(new FileWriter(tempPlayerFileInUserFolder));   
                              while ((tempPlayerStr = bufferedReader.readLine()) != null){
                                  //Don't forget to continue coding it
                                  bufferedWriter.write(tempPlayerStr);
                              }
                              tempPlayerFileInUserFolder.renameTo(new File(squadGameWeek.getAbsolutePath() +
                                                                    File.separator + player.getName()));
                              new File(squadGameWeek.getAbsolutePath() + File.separator + player.getName()).delete();
                              }bufferedWriter.close();
                          }
                      }
                    }
                }
          bufferedReader.close();  
            }
        }
    }
    public static void main(String[] args) throws IOException{
        EventPerformer ep = new EventPerformer("Cristiano Ronaldo");
        ep.selectGameWeek("Game Week 1");
        System.out.println("Game week: " + ep.gameWeek.currentGameWeek);
        System.out.println("Buffered Week: " + ep.gameWeekBufferedEditor.gameweek.currentGameWeek);
//        ep.scoreGoal("Cristiano Ronaldo");
//        ep.scoreGoals("Cristiano Ronaldo", 5);
        AttScores n = new AttScores();
        n.scoreGoal("Cristiano Ronaldo");
    }
    }