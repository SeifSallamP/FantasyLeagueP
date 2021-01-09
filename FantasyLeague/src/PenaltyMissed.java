
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.Scanner;


public class PenaltyMissed extends PenaltyAction {
    int penaltyValue = -2;
    PenaltyMissed(){};
    void saveScore(String playerName) throws FileNotFoundException, IOException{
        File playerFile = new File("Database" + File.separator + "Game Weeks" + File.separator + "Game Week 1" + File.separator + playerName + ".txt");
        if (!playerFile.isFile()){playerFile.createNewFile();}
        File tempPlayerFile = new File("Database" + File.separator + "Game Weeks" + File.separator + "Game Week 1" + File.separator + playerName + " temp.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(playerFile));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempPlayerFile, true));
        String text;
        while ((text = bufferedReader.readLine()) != null){
            if (text.contains("Score: ")){
                int temp = parseInt(text.replace("Score: ", ""));
                temp = temp + score;
                bufferedWriter.write("Score: " + temp);
                bufferedWriter.newLine();
            }else {bufferedWriter.write(text); bufferedWriter.newLine();}
        }
        bufferedWriter.close();
        bufferedReader.close();
//        while((text = bufferedReader.readLine()) != null){
//            if (text.contains("Score: ")){
//           StringBuilder sb = new StringBuilder(); 
//            }
//    }
        /*Use bufferedWriter to write to a temporary file then rename it and delete the original
            (Make it a method in FilesLinesMethods because you would use it a lot);
        
        */
//        scan.findInLine("Score: ").replace(String.valueOf(scan.nextInt()), String.valueOf(scan.nextInt() - score));
        
    }
    PenaltyMissed(int newPenaltyValue){
            this.penaltyValue = newPenaltyValue;
        }
        void missPenalty(String playerName) throws IOException{
            score = penaltyValue;
//            saveScore(playerName);
            gwbe.scoreWriter(playerName, "Score: ", score);
        }
        void missPenalty(String playerName, int penalties) throws IOException{
            score = penaltyValue * penalties;
            gwbe.scoreWriter(playerName, "Score: ", score);
        }
        public static void main(String[] args) throws IOException{
            PenaltyMissed pm = new PenaltyMissed();
            pm.missPenalty("Cristiano Ronaldo");
        }
}
