package game;
import java.util.List;
import character.Character;
import enemies.Enemy;
import factories.Level;
import factories.LevelGenerator;
import factories.SpriteFactory;
import launcher.CharacterThread;
import platforms.Platform;
import powerUps.PowerUp;
import views.Observer;
import views.ViewController;

public class Game {
    protected LevelGenerator levelGenerator;
    protected ViewController viewController;
    protected SpriteFactory spriteFactory;
    protected Level currentLevel;
    protected String currentPlayer;//Crear label en el menu para ingresar nombre
    protected int numberLevel;

    public Game (int level) {
        //this.numberLevel = 1;
        //crear metodo changeLevel(int level) y si se quiere actualizar el nivel
        //usarlo para que dentro de ese modo se llame a levelGenerator.getLevel(int level)
        //cuando se pueda hacer eso, se puede sacar el int level que tiene Game en el constructor
        //Luego cambiar a un metodo para no tener que crear un game si se quiere cambiar de nivel
        this.levelGenerator = new LevelGenerator("Orignal",level);
           
    }
    /* TO COMPLETE
    public void changeLevel(int level){
        this.currentLevel = levelGenerator.getLevel(level);
        this.numberLevel = level;
    } */     

    //Launcher operation
    public void setViewController(ViewController viewController){
        this.viewController = viewController;
    }

    public void start(){
        currentLevel= levelGenerator.createLevel();
        setObservers();
        CharacterThread thread = new CharacterThread(viewController.getKeyboard(), currentLevel.getCharacter());
        thread.start();
        viewController.showLevelScreen();
    }


    //Graphic operations
        

    public void setObservers(){
        //Hay que revisar la clase character y player
        setCharacterObserver(currentLevel.getCharacter());
        setPlatformsObservers(currentLevel.getPlatforms());
        setPowerUpsObservers(currentLevel.getPowerUps());
        setEnemiesObservers(currentLevel.getEnemies());
    }


    protected void setCharacterObserver(Character character){
        Observer characterObserver = viewController.registerEntity(character);
        character.registerObserver(characterObserver);

    }  
    
    protected void setPlatformsObservers(List<Platform> platformsList) {
    	for (Platform platform: platformsList) {
            Observer platformObserver = viewController.registerEntity(platform);
    		platform.registerObserver(platformObserver);
    	}
    }
    
   protected void setEnemiesObservers(List<Enemy> enemyList) {
    	for (Enemy enemy: enemyList) {
    		Observer enemyObserver=viewController.registerEntity(enemy);
    		enemy.registerObserver(enemyObserver);
    	}
    }
    
    protected void setPowerUpsObservers(List<PowerUp> powerUpList) {
    	for (PowerUp powerUp: powerUpList) {
    		Observer powerUpObserver= viewController.registerEntity(powerUp);
    		powerUp.registerObserver(powerUpObserver);
    	}
    }
     /*
    public void nextLevel() {
    	numberLevel++;
    	newGame();
    }*/
    
    /* public setViewController(ViewController viewController){
         this.viewController = viewController;
     }*/

}