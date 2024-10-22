package views;
import javax.swing.JFrame;
import javax.swing.JPanel;
import character.CharacterEntity;
import character.Keyboard;
import game.BoundingBox;
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

    public GraphicObserver registerEntity(CharacterEntity character){
        GraphicObserver characterObserver = levelScreen.drawEntityCharacter(character);
        character.setObserver(characterObserver);
        levelScreen.drawHitbox(character);
        refresh();
        return characterObserver;

    }

    public GraphicObserver registerEntity(LogicalEntity entity){
        GraphicObserver entityObserver = levelScreen.drawLogicalEntity(entity);
        entity.setObserver(entityObserver);
        levelScreen.drawHitbox(entity);
        refresh();
        return entityObserver;
    }

    
    public void removeLogicalEntity(LogicalEntity e) {
        levelScreen.remove(e.getGraphicObserver());
    }
}
