
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EventPerformer {
    CardsActions cardsActions;
    CleanSheet cleanSheet;
    GoalAssists goalAssists;
    ScoredGoals scoredGoals;
    MVP mvp;
    BonusPoints bonusPoints;
    PlayerFactory playerFactory;
    GameWeekController gameWeek;
    GameWeekBufferedEditor gameWeekBufferedEditor;
    EventPerformer(){};
    EventPerformer(String playerName){
        playerFactory = new PlayerFactory();
        cleanSheet = playerFactory.createPlayerCleanSheet(playerName);
        scoredGoals = playerFactory.createPlayerScore(playerName);
        mvp = new MVP();
        goalAssists = new GoalAssists();
        bonusPoints = new BonusPoints();
        gameWeek = new GameWeekController();
        gameWeekBufferedEditor = new GameWeekBufferedEditor(gameWeek);
    }
    void scoreGoal(String playerName){
        scoredGoals.scoreGoal(playerName);
        try {
            gameWeekBufferedEditor.pointsSquadWriter();
        } catch (IOException ex) {
            Logger.getLogger(EventPerformer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void scoreGoals(String playerName, int goals){
        scoredGoals.scoreGoals(playerName, goals);
        try {
            gameWeekBufferedEditor.pointsSquadWriter();
        } catch (IOException ex) {
            Logger.getLogger(EventPerformer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void assistGoal(String playerName){
        goalAssists.assistedGoal(playerName);
        try {
            gameWeekBufferedEditor.pointsSquadWriter();
        } catch (IOException ex) {
            Logger.getLogger(EventPerformer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void assistGoal(String playerName, int goals){
        goalAssists.assistGoal(playerName, goals);
        try {
            gameWeekBufferedEditor.pointsSquadWriter();
        } catch (IOException ex) {
            Logger.getLogger(EventPerformer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void DoCleanSheet(String playerName){
        cleanSheet.cleanSheet(playerName);
        try {
            gameWeekBufferedEditor.pointsSquadWriter();
        } catch (IOException ex) {
            Logger.getLogger(EventPerformer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void giveRedCard(String playerName){
        cardsActions = new RedCardAction();
        cardsActions.giveCard(playerName);
        try {
            gameWeekBufferedEditor.pointsSquadWriter();
        } catch (IOException ex) {
            Logger.getLogger(EventPerformer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void giveYellowCard(String playerName){
        cardsActions = new YellowCardAction();
        cardsActions.giveCard(playerName);
        try {
            gameWeekBufferedEditor.pointsSquadWriter();
        } catch (IOException ex) {
            Logger.getLogger(EventPerformer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void addBonusPoints(String playerName, int points){
        bonusPoints.addBonus(playerName, points);
        try {
            gameWeekBufferedEditor.pointsSquadWriter();
        } catch (IOException ex) {
            Logger.getLogger(EventPerformer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void rewardMVP(String playerName, int bonus){
        mvp.rewardMVP(playerName, bonus);
        try {
            gameWeekBufferedEditor.pointsSquadWriter();
        } catch (IOException ex) {
            Logger.getLogger(EventPerformer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void addGameWeek(){
        gameWeek.addGameWeek();
    }
    void selectGameWeek(String folderName){
        gameWeek.selectGameWeek(folderName);
        gameWeekBufferedEditor.gameweek = gameWeek;
    }
    void emptyGameWeek(String folderName){
        gameWeek.emptyGameWeek(folderName);
    } 
    void countGameWeeks(){
        gameWeek.countGameWeeks();
    }
}
