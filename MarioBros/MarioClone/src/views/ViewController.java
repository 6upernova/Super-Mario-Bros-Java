package views;

import javax.swing.JFrame;
import javax.swing.JPanel;

import game.Game;

public class ViewController  {
   
    protected JFrame window;
    protected LevelScreen levelScreen;
    //protected GameOverScreen gameOverScreen;
    //protected RankingScreen rankingScreen;
    //protected MenuScreen menuScreen;

    protected Game game;


    public ViewController(Game game){
        this.game = game;
        levelScreen = new LevelScreen(this);
        setWindow();
        //To do resto de screens
        
    }
    public ViewController(){
        levelScreen = new LevelScreen(this);
        setWindow();
        
        //To do resto de screens
        
    }

    public void setWindow (){
        window = new JFrame("p-comision23 :: MarioBros");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setSize(ViewConstants.WINWIDTH, ViewConstants.WINHEIGHT);
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
}
