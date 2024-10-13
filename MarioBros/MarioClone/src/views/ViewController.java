package views;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
		window.setResizable(false);
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

    public Observer registerEntity(CharacterEntity character ){
        Observer characterObserver = levelScreen.drawEntityCharacter(character);
        refresh();
        return characterObserver;

    }

    public Observer registerEntity(LogicalEntity entity){
        Observer entityObserver = levelScreen.drawLogicalEntity(entity);
        refresh();
        return entityObserver;
    }
}
