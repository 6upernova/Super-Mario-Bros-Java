package game;

import java.util.List;

import character.Character;
import factories.Level;
import factories.LevelGenerator;
import launcher.CharacterThread;
import platforms.Platform;
import powerUps.PowerUp;
import views.Observer;
import views.ViewController;


public class Game {
    
    protected LevelGenerator levelGenerator;
    protected Level currentLevel;
    protected ViewController viewController;
    protected int numberLevel;
    protected String currentPlayer;//Crear label en el menu para ingresar nombre
    

    public Game (int level) {

        //Luego cambiar a un metodo para no tener que crear un game si se quiere cambiar de nivel
        levelGenerator = new LevelGenerator("Orignal",level);
           
    }

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
        setObserverCharacter(currentLevel.getCharacter());
        setObserversPlatforms(currentLevel.getPlatforms());
        setObserversPowerUp(currentLevel.getPowerUps());
    }


    protected void setObserverCharacter(Character character){
        Observer characterObserver = viewController.registerEntity(character);
        character.registerObserver(characterObserver);

    }  
    
    protected void setObserversPlatforms(List<Platform> platformsList) {
    	for (Platform platform: platformsList) {
            Observer platformObserver = viewController.registerEntity(platform);
    		platform.registerObserver(platformObserver);
    	}
    }
    
   /* public void chargeEnemyLevel(List<Enemy> enemyList) {
    	for (Enemy enemy: enemyList) {
    		enemy.getObserver().update();
    	}
    }*/
    
    protected void setObserversPowerUp(List<PowerUp> powerUpList) {
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