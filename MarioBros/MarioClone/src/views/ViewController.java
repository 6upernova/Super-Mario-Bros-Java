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
    protected MenuScreen menuScreen;
    protected Keyboard keyboardInputs;
    protected Game game;

    public ViewController(){
        this.game = new Game();
        game.setViewController(this);
        levelScreen = new LevelScreen(this);
        menuScreen = new MenuScreen(this);
        configureWindow();
        //showMenuScreen();             //Para empezar el juego en la menuScreen borrar el comentario de esta linea y
        game.start();                   //comentar esta linea
        
        //To do resto de screens
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

    public void startGame(){
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

    public GraphicObserver registerEntity(LogicalEntity entity){
        GraphicObserver entityObserver = levelScreen.drawLogicalEntity(entity);
        refresh();
        return entityObserver;
    }

    
    public void removeLogicalEntity(LogicalEntity e) {
        levelScreen.remove(e);
    }
    public void updateInformation(int newCoins, int newScore, int newTime, int newLives){
        levelScreen.updateInformationPanel(newCoins,newScore, newTime, newLives);
    }
    public void clearEntities() {
        this.levelScreen = new LevelScreen(this);
    }

    public void exitGame(){
        window.setVisible(false);
        window.dispose();
    }

    public LevelScreen getLevelScreen(){
        return levelScreen;
    }
}
