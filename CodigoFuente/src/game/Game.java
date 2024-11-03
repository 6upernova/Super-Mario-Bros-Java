package game;
import java.util.Collection;
import java.util.List;
import entities.LogicalEntity;
import entities.character.Character;
import entities.character.CharacterThread;
import entities.enemies.Enemy;
import entities.enemies.EnemyThread;
import entities.platforms.Platform;
import entities.powerUps.PowerUp;
import entities.projectile.Projectile;
import entities.state.spiny.Spinny;
import factories.LevelGenerator;
import observer.GraphicObserver;
import observer.ObserverSound;
import ranking.Ranking;
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
    
    public void setViewController(ViewController viewController){
        this.viewController = viewController;       
    }

    public void start(){
        setObservers();
        this.enemyThread = new EnemyThread(this);
        this.characterThread = new CharacterThread(viewController.getKeyboard(), this);
        characterThread.start();
        enemyThread.start();
        viewController.showLevelScreen();
        startMusicLevel();
    }

    public void stop(){
        sound.stopMusic();
        ranking.addToRank(currentPlayer, getCurrentLevel().getCharacter().getScore());
        viewController.clearLevelScreen();
        waitMusic();
        viewController.showMenuScreen();
    }

    protected void setLevel(int number){
        currentLevel = levelGenerator.createLevel(number, null);
    }
    
    public synchronized Level getCurrentLevel() {
        return currentLevel;
    }
    
    public ViewController getViewController(){
        return viewController;
    }
    
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

    public void startMusicLevel(){
        sound.setMusicSound("musicLevel1");
        sound.loop(-1);
    }
    
    protected void changeLevel() {  
        viewController.clearLevelScreen();
        if(levelGenerator.haveNextLevel()){
            Character currentCharacter=resetCharacter();
            currentLevel = levelGenerator.getNextLevel(currentCharacter); 
            currentLevel.setCharacter(currentCharacter);
            currentCharacter.setIsBusy(true);
            setObservers();
            this.characterThread.setIsRunning(false);
            this.enemyThread.setIsRunning(false);
            this.characterThread.interrupt();
            this.enemyThread.interrupt();
            this.characterThread = new CharacterThread(viewController.getKeyboard(), this);
            this.enemyThread = new EnemyThread(this);
            waitMusic();
            viewController.showLevelScreen();
            startMusicLevel();
            characterThread.start();
            enemyThread.start();
            currentCharacter.setIsBusy(false);
        }
        else{      
            viewController.showMenuScreen();
        }
    }


    private void waitMusic(){
        while(sound.isRunning()){
        }
    }

    private Character resetCharacter(){
        Character character = currentLevel.getCharacter();
        character.setInStart();
        character.setInEnd(false);
        character.setIsInAir(false);
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
        sound.loop(0);
    } 

    public void startMusic(String path){
        sound.setMusicSound("path");
        sound.loop(0);
    }

    public boolean isRunningSound() {
        return sound.isRunning();
    }

    public void createEgg(int x, int y) {
        Spinny spinny = levelGenerator.createSpinny(x,y);
        currentLevel.getEnemies().add(spinny);
    	GraphicObserver enemyObserver = viewController.registerEntity(spinny);
    	spinny.registerObserver(enemyObserver);        
    }
}