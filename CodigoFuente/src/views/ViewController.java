package views;
import java.util.Collection;

import javax.swing.JFrame;

import entities.LogicalEntity;
import entities.character.CharacterEntity;
import entities.character.Keyboard;
import game.Game;

public class ViewController {   
    protected JFrame window;
    protected LevelScreen levelScreen;
    //protected GameOverScreen gameOverScreen;
    protected MenuScreen menuScreen;
    protected Keyboard keyboardInputs;
    protected Game game;
    protected RankingScreen rankingScreen;
    protected PreGameScreen preGameScreen;
    public ViewController(Game game){   
        this.game = game;
        this.levelScreen = new LevelScreen(this);
        this.rankingScreen = new RankingScreen(this);
        this.preGameScreen = new PreGameScreen(this);
        configureWindow();

        
    }
    public ViewController(){
        this.game = new Game();
        game.setViewController(this);
        this.levelScreen = new LevelScreen(this);
        this.menuScreen = new MenuScreen(this);
        this.rankingScreen = new RankingScreen(this);
        this.preGameScreen = new PreGameScreen(this);
        configureWindow();
        showMenuScreen();             
        
    }

    public void configureWindow (){
        keyboardInputs = new Keyboard();
        window = new JFrame("p-comision23 :: MarioBros");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		window.setSize(ViewConstants.WIN_WIDTH, ViewConstants.WIN_HEIGHT);
		window.setLocationRelativeTo(null);
        window.addKeyListener(keyboardInputs);
		window.setVisible(true);
    }


    public void newGame(String mode, String name){
        this.game = new Game();
        game.setMode(mode);
        game.setName(name);
        game.setViewController(this);
        game.start();
    }

    public void showMenuScreen(){
        window.setContentPane(menuScreen);
        refresh();
    }
    public void showLevelScreen(){
        window.setContentPane(levelScreen);
        window.requestFocusInWindow();
        refresh();
    }

    public void showRankingScreen(){ 
        window.setContentPane(rankingScreen);
        refresh();
    }
    public void showPreGameScreen(){
        window.setContentPane(preGameScreen);
        refresh();
    }

    //To do resto de screens

    public void refresh(){
        window.revalidate();
        window.repaint();
    }
    
    public Keyboard getKeyboard(){
        return keyboardInputs;
    }

    // ObserverEntityMethods

    public GraphicObserver registerEntity(CharacterEntity character){
        GraphicObserver characterObserver = levelScreen.drawEntityCharacter(character);
        refresh();
        return characterObserver;

    }

    public GraphicObserver registerEntity(LogicalEntity entity, boolean isActive){
        GraphicObserver entityObserver = levelScreen.drawLogicalEntity(entity, isActive);
        refresh();
        return entityObserver;
    }

    
    public void removeLogicalEntity(LogicalEntity e) {
        levelScreen.remove(e);
    }
    public void updateInformation(int newCoins, int newScore, int newTime, int newLives){
        levelScreen.updateInformationPanel(newCoins,newScore, newTime, newLives);
    }
    public void clearLevelScreen() {
        this.levelScreen = new LevelScreen(this);
    }

    public void exitGame(){
        window.setVisible(false);
        window.dispose();
        System.exit(0);
    }

    public LevelScreen getLevelScreen(){
        return levelScreen;
    }

    public Collection<String> getPlayers() {
        return game.getRankingPlayers();
    }
}