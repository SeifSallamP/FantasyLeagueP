import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FileLinesMethods {
    boolean lineNameSkipper_Comparer(String obj, File file) throws FileNotFoundException{
            Scanner scan = new Scanner(file); int line = 0; int lineTarget = 1;
            while(scan.hasNextLine()){
                line++;
                if (line == lineTarget){
                    String name = scan.skip(Pattern.compile(".+ ")).nextLine();
                    if (obj.equals(name)){
                        return true;
                    }lineTarget+=7;
                }else scan.nextLine();
    }
            return false;
    };
    double linePriceSkipper_Calculator(File file) throws FileNotFoundException{
        Scanner scan = new Scanner(file);
        int lineTarget = 5; int line = 0; double totalCost = 0;
        ArrayList<Double> price = new ArrayList<Double>();
            lineTarget = 5; int i=0;
                while(scan.hasNextLine()){
                    line++;
                    if (line == lineTarget){
                        price.add(scan.skip(Pattern.compile(".+: ")).nextDouble());scan.nextLine();
                        totalCost+= price.get(i);
                        lineTarget+=6; i++;
                    }
                    scan.nextLine();
                }
                return totalCost;
    }
    int lineClubSkipper_Counter(String club, File file) throws FileNotFoundException{
        Scanner scan = new Scanner(file);
        int clubCounter = 0;
        int line = 0; 
        int lineTarget = 3;
        while(scan.hasNextLine()){
            line++;
            if (line == lineTarget){ 
                String clubScanner = scan.skip(Pattern.compile(".+: ")).nextLine();
                if(club.equals(clubScanner)){
                    clubCounter++;
                }
                lineTarget+=7;
            }else scan.nextLine();
        }
        return clubCounter;
    }
    int filePlayers_Counter(File file) throws FileNotFoundException{
        Scanner scan = new Scanner(file);
        int lineCounter = 0;
        while(scan.hasNextLine()){lineCounter++;scan.nextLine();}
        return (lineCounter/7); 
    }
    int[] linePositionsSkipper_Counter(File file) throws FileNotFoundException{
             Scanner scan = new Scanner(file);
             ArrayList<Integer> positions = new ArrayList<Integer>(); int lineTarget = 3; int line = 0; 
             int i = 0; int gkCounter = 0; int defCounter = 0; int attCounter = 0; int midCounter = 0;
             while(scan.hasNextLine()){
                 if (line == lineTarget){
                     positions.add(i, scan.skip(Pattern.compile(".+: ")).nextInt());
                     if (positions.get(i) == 1){
                         gkCounter++;}
                     else if(positions.get(i) == 2)
                     {defCounter++;
                     }
                     else if(positions.get(i) == 3)
                     {
                         midCounter++;
                     }
                     else if(positions.get(i) == 4)
                     {
                         attCounter++;
                     }
                     i++; lineTarget+=7;
                 }
                 line++;
                 scan.nextLine();
             }
              int[] positionsCounterArray = {gkCounter, defCounter, midCounter, attCounter};
                      return positionsCounterArray;
    }
    
}
