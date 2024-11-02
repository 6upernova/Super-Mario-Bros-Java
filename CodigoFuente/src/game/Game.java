package game;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import entities.LogicalEntity;
import entities.character.Character;
import entities.character.CharacterThread;
import entities.character.ObserverSound;
import entities.enemies.Enemy;
import entities.enemies.EnemyThread;
import entities.platforms.Platform;
import entities.powerUps.PowerUp;
import entities.projectile.FireBall;
import entities.projectile.Projectile;
import factories.LevelGenerator;
import ranking.Ranking;
import views.GraphicObserver;
import views.ViewController;

public class Game {
    protected LevelGenerator levelGenerator;
    protected ViewController viewController;
    protected Level currentLevel;
    protected String currentPlayer;//Crear label en el menu para ingresar nombre
    protected int numberLevel;
    protected SoundReproducer sound;
    protected CharacterThread characterThread;
    protected SoundGenerator generatorSounds;
    protected EnemyThread enemyThread;
    protected Ranking ranking;
    protected String mode;


    public Game () {
        this.numberLevel = 1;
        this.ranking = new Ranking();
        this.generatorSounds= new SoundGenerator();
        this.sound = new SoundReproducer(generatorSounds);
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
        startMusic();
    }

    public void stop(){
        //ranking 
        sound.stopMusic();
        ranking.addToRank(currentPlayer, getCurrentLevel().getCharacter().getScore());
        viewController.clearLevelScreen();
        viewController.showMenuScreen();
    }

    protected void setLevel(int number){
        currentLevel = levelGenerator.createLevel(number);
    }
    
    public synchronized Level getCurrentLevel() {
        return currentLevel;
    }
    
    public ViewController getViewController(){
        return viewController;
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
        setCharacterObserverOfSound(character);
    }  
    
    private void setCharacterObserverOfSound(Character character) {
		ObserverSound observer= new ObserverSound(this);
		character.setObserverOfSound(observer);
	}
	protected void setPlatformsObservers(List<Platform> platformsList) {
    	for (Platform platform: platformsList) {
            GraphicObserver platformObserver = viewController.registerEntity(platform, true);
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
    		GraphicObserver powerUpObserver = viewController.registerEntity(powerUp, powerUp.isActive());
    		powerUp.registerObserver(powerUpObserver);
    	}
    }
    
    public void removeLogicalEntity(LogicalEntity e) {
        viewController.removeLogicalEntity(e);
    }

    public void playNextLevel() {
        changeLevel();
    }
    
    public void reproduceSound(String path) {
    	sound.setAuxiliarSound(path);
		sound.start();
    }

    public void reproduceSoundDeath(String path) {
    	reproduceSound(path);
    }

    public void stopSound() {
    	sound.stopMusic();
    }
    
    protected void changeLevel() {  
        viewController.clearLevelScreen();
        if(levelGenerator.haveNextLevel()){
            Character currentCharacter=resetCharacter();
            currentLevel = levelGenerator.getNextLevel(); 
            currentLevel.setCharacter(currentCharacter);
            setObservers();
            currentCharacter.setIsBusy(true);
            this.characterThread.setIsRunning(false);
            this.enemyThread.setIsRunning(false);
            this.characterThread.interrupt();
            this.enemyThread.interrupt();
            this.characterThread = new CharacterThread(viewController.getKeyboard(), this);
            this.enemyThread = new EnemyThread(this);
            viewController.showLevelScreen();
            startMusic();
            characterThread.start();
            enemyThread.start();
            currentCharacter.setIsBusy(false);
        }
        else{      
            viewController.showMenuScreen();
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

    public void createFireBall(int x, int y, String direction) {
        Projectile fireBall = levelGenerator.createFireBall(x,y,direction);
        currentLevel.addFireBall(fireBall);
        setProjectilesObservers(fireBall);
    }

    protected void setProjectilesObservers(Projectile projectile){
        GraphicObserver projectileOberver = viewController.registerEntity(projectile,true);
        projectile.registerObserver(projectileOberver);   
    }


    public void reproduceLoopSound(String path, int iteracions) {
        sound.setMusicSound(path);
        sound.loop(iteracions);
    } 

    public void startMusic(){
        sound.setMusicSound("musicLevel1");
        sound.loop(-1);
    }

    public boolean isRunningSound() {
        return sound.isRunning();
    }

    public void stopMusic() {
        sound.stopMusic();
    }
}