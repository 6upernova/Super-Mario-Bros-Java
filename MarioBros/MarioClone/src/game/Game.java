package game;
import java.util.Collection;
import java.util.List;
import character.Character;
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
    protected CharacterThread characterThread;
    protected EnemyThread enemyThread;
    protected Ranking ranking;
    private String mode;


    public Game () {
        //this.numberLevel = 1;
        //crear metodo changeLevel(int level) y si se quiere actualizar el nivel
        //usarlo para que dentro de ese modo se llame a levelGenerator.getLevel(int level)
        //cuando se pueda hacer eso, se puede sacar el int level que tiene Game en el constructor
        //Luego cambiar a un metodo para no tener que crear un game si se quiere cambiar de nivel
        this.ranking = new Ranking();
    } 
    public void setName(String name){
        this.currentPlayer = name;
    }   
    //Launcher operation
    public void setViewController(ViewController viewController){
        this.viewController = viewController;       
    }

    public void start(){
        setObservers();
        enemyThread = new EnemyThread(this);
        characterThread = new CharacterThread(viewController.getKeyboard(), this);
        characterThread.start();
        enemyThread.start();
        viewController.showLevelScreen();
        sound = new SoundReproducer("musicLevel"+ numberLevel);
        sound.loop();
    }

    public void stop(){
        //ranking 
        ranking.addToRank(currentPlayer, getCurrentLevel().getCharacter().getScore());
        viewController.clearLevelScreen();
        viewController.showMenuScreen();
        

    }

    protected void setLevel(int number){
        currentLevel = levelGenerator.createLevel(number);
        currentLevel.setCharacter(levelGenerator.createCharacter());
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
            GraphicObserver platformObserver = viewController.registerEntity(platform, true);
    		platform.registerObserver(platformObserver);
    	}
    }
    
   protected void setEnemiesObservers(List<Enemy> enemyList) {
    	for (Enemy enemy: enemyList) {
    		GraphicObserver enemyObserver = viewController.registerEntity(enemy, true);
    		enemy.registerObserver(enemyObserver);
    	}
    }
    
    protected void setPowerUpsObservers(List<PowerUp> powerUpList) {
    	for (PowerUp powerUp: powerUpList){
    		GraphicObserver powerUpObserver = viewController.registerEntity(powerUp, false);
    		powerUp.registerObserver(powerUpObserver);
    	}
    }
    
    public void removeLogicalEntity(LogicalEntity e) {
        viewController.removeLogicalEntity(e);
        System.out.println("borre algo");
    }    

    public void playNextLevel() {
        changeLevel();
        this.characterThread.interrupt();
        this.enemyThread.interrupt();
        this.characterThread = new CharacterThread(viewController.getKeyboard(), this);
        enemyThread = new EnemyThread(this);
        characterThread.start();
        enemyThread.start();
        viewController.showLevelScreen();
        sound = new SoundReproducer("musicLevel" + numberLevel);
        sound.loop();
    }
    

    protected void changeLevel() {  
        System.out.println("Cambiando de nivel");
        Character currentCharacter =resetCharacter();
        viewController.clearLevelScreen();
        if (sound != null) {
            sound.stop();
        }    
       
        currentLevel = levelGenerator.getNextLevel();   
        System.out.println(currentLevel == null);
        if(currentLevel != null){
            currentLevel.setCharacter(currentCharacter);
            setObservers();
        }
        else{

        }
    }

    private Character resetCharacter(){
        Character character = currentLevel.getCharacter();
        character.setInEnd(false);
        character.setInStart();
        return character;
    }


    public void updateInformation(int score, int coins, int timer, int lives) {
        viewController.updateInformation(coins, score, timer, lives);
    }
    public Collection<String> getRankingPlayers() {
        return ranking.getPlayers();
    }
    public void setMode(String mode) {
        this.mode = mode;
        this.levelGenerator = new LevelGenerator(mode);  
        setLevel(1);         
    }
}