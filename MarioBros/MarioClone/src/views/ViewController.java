package views;

import javax.swing.JFrame;
import javax.swing.JPanel;

import character.CharacterEntity;
import game.Game;

public class ViewController    {
   
    protected JFrame window;
    protected LevelScreen levelScreen;
    //protected GameOverScreen gameOverScreen;
    //protected RankingScreen rankingScreen;
    //protected MenuScreen menuScreen;

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
        
        //To do resto de screens
        
    }

    public void configureWindow (){
        window = new JFrame("p-comision23 :: MarioBros");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setSize(ViewConstants.WIN_WIDTH, ViewConstants.WIN_HEIGHT);
		window.setLocationRelativeTo(null);
		window.setVisible(true);

    }

    public void showLevelScreen(){
        window.setContentPane(levelScreen);
        refresh();
    }

    public void startGame(){
        game.start();
    }

    public void refresh(){
        window.revalidate();
        window.repaint();
    }

    // ObserverEntityMethods

    public Observer registerEntity(CharacterEntity character ){
        Observer characterObserver = levelScreen.drawEntityCharacter(character);
        refresh();
        return characterObserver;

    }
}
