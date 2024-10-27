package game;
import java.util.Collection;
import java.util.List;
import character.Character;
import character.CharacterState;
import enemies.Enemy;
import factories.Level;
import factories.LevelGenerator;
import factories.SpriteFactory;
import launcher.CharacterThread;
import launcher.EnemyThread;
import platforms.Platform;
import powerUps.PowerUp;
import ranking.Ranking;
import views.GraphicObserver;
import views.ViewController;

public class Game {
    protected LevelGenerator levelGenerator;
    protected ViewController viewController;
    protected SpriteFactory spriteFactory;
    protected Level currentLevel;
    protected String currentPlayer;//Crear label en el menu para ingresar nombre
    protected int numberLevel;
    protected SoundReproducer sound;
    private String mode;
    protected CharacterThread thread;
    protected Ranking ranking;

    public Game () {
        //this.numberLevel = 1;
        //crear metodo changeLevel(int level) y si se quiere actualizar el nivel
        //usarlo para que dentro de ese modo se llame a levelGenerator.getLevel(int level)
        //cuando se pueda hacer eso, se puede sacar el int level que tiene Game en el constructor
        //Luego cambiar a un metodo para no tener que crear un game si se quiere cambiar de nivel
        this.mode = "Original";
        this.levelGenerator = new LevelGenerator(mode);  
        this.ranking = new Ranking();         
    }    
    //Launcher operation
    public void setViewController(ViewController viewController){
        this.viewController = viewController;       
    }

    public void start(){
        numberLevel++;
        currentLevel = levelGenerator.createLevel();
        setObservers();
        EnemyThread enemyThread = new EnemyThread(this);
        CharacterThread thread = new CharacterThread(viewController.getKeyboard(), this);
        thread.start();
        //viewController.showMenuScreen();
        //viewController.showRankingScreen();
        viewController.showLevelScreen();
        sound = new SoundReproducer("musicLevel"+ numberLevel);
        sound.loop();
        enemyThread.start();
    }

    public void stop(){
        //ranking 
        ranking.addToRank(currentPlayer, getCurrentLevel().getCharacter().getScore());
        
        clearCurrentLevel();
        viewController.showMenuScreen();
    }
    
    public Level getCurrentLevel(){
        return currentLevel;
    }

    public ViewController getViewController(){
        return viewController;
    }
    public void reproduceSoundEffect(String path) {
        sound.setAuxiliarAudio(path);
        sound.start();
    }

    //Graphic operations
    public void setObservers(){
        setCharacterObserver(currentLevel.getCharacter());
        setPlatformsObservers(currentLevel.getPlatforms());
        setPowerUpsObservers(currentLevel.getPowerUps());
        setEnemiesObservers(currentLevel.getEnemies());
    }

    protected void setCharacterObserver(Character character){
        GraphicObserver characterObserver = viewController.registerEntity(character);
        character.registerObserver(characterObserver);

    }  
    
    protected void setPlatformsObservers(List<Platform> platformsList) {
    	for (Platform platform: platformsList) {
            GraphicObserver platformObserver = viewController.registerEntity(platform);
    		platform.registerObserver(platformObserver);
    	}
    }
    
   protected void setEnemiesObservers(List<Enemy> enemyList) {
    	for (Enemy enemy: enemyList) {
    		GraphicObserver enemyObserver = viewController.registerEntity(enemy);
    		enemy.registerObserver(enemyObserver);
    	}
    }
    
    protected void setPowerUpsObservers(List<PowerUp> powerUpList) {
    	for (PowerUp powerUp: powerUpList){
    		GraphicObserver powerUpObserver = viewController.registerEntity(powerUp);
    		powerUp.registerObserver(powerUpObserver);
    	}
    }
    
    public void removeLogicalEntity(LogicalEntity e) {
        viewController.removeLogicalEntity(e);
        System.out.println("borre algo");
    }    

    public void playNextLevel(int score, int coins, int lives, CharacterState state) {
        changeLevel(score,coins,lives,state);
        this.thread = new CharacterThread(viewController.getKeyboard(), this);
        thread.start();
        viewController.showLevelScreen();
        sound = new SoundReproducer("musicLevel" + numberLevel);
        sound.loop();
    }
    

    protected void changeLevel(int score, int coins, int lives, CharacterState state) {  
        System.out.println("Cambiando de nivel");
        // Eliminar elementos del nivel anterior
        currentLevel.getCharacter().setInEnd(false); 
        clearCurrentLevel();
        if (sound != null) {
            sound.stop();
        }    
        currentLevel = levelGenerator.getNextLevel();   
        if(currentLevel != null){
            //Cambiar por Un metodo que sea reset Character
            currentLevel.getCharacter().setState(state);       
            currentLevel.getCharacter().addCoins(coins);
            currentLevel.getCharacter().addLives(lives);
            currentLevel.getCharacter().addScore(score);
            setObservers();
            viewController.showLevelScreen(); 
        }
        else{
            //es porque gano, decidir que va a ir aca
        }
    }

    private void clearCurrentLevel() {
        currentLevel.delete(); 
        viewController.clearEntities();
    }

    public void updateInformation(int score, int coins, int timer, int lives) {
        viewController.updateInformation(coins, score, timer, lives);
    }
    public Collection<String> getRankingPlayers() {
        return ranking.getPlayers();
    }
}