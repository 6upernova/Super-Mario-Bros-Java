package views;
import javax.swing.JFrame;
import character.CharacterEntity;
import character.Keyboard;
import game.Game;
import game.LogicalEntity;

public class ViewController {   
    protected JFrame window;
    protected LevelScreen levelScreen;
    //protected GameOverScreen gameOverScreen;
    //protected RankingScreen rankingScreen;
    //protected MenuScreen menuScreen;
    protected Keyboard keyboardInputs;
    protected Game game;

    public ViewController(Game game){
        this.game = game;
        levelScreen = new LevelScreen(this);
        configureWindow();
        //To do resto de screens
        
    }
    public ViewController(){
        levelScreen = new LevelScreen(this);
        configureWindow();        
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

    public void showLevelScreen(){
        window.setContentPane(levelScreen);
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

    public CharacterObserver registerEntity(CharacterEntity character){
        CharacterObserver characterObserver = levelScreen.drawEntityCharacter(character);
        levelScreen.drawHitbox(character);
        refresh();
        return characterObserver;

    }

    public GraphicObserver registerEntity(LogicalEntity entity){
        GraphicObserver entityObserver = levelScreen.drawLogicalEntity(entity);
        levelScreen.drawHitbox(entity);
        refresh();
        return entityObserver;
    }

    
    public void removeLogicalEntity(LogicalEntity e) {
        levelScreen.remove(e.getGraphicObserver());
    }
    public void updateInformation(int newCoins, int newScore, int newTime, int newLives){
        levelScreen.updateInformationPanel(newCoins,newScore, newTime, newLives);
    }
    public void clearEntities() {
        this.levelScreen = new LevelScreen(this);
    }
}
