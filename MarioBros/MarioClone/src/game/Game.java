package game;

import java.util.List;

import javax.swing.JPanel;

import character.Character;
import character.Player;
import factories.Level;
import factories.LevelGenerator;
import platforms.Platform;
import views.CharacterObserver;
import views.EntityObserver;
import views.Observer;
import views.ViewController;


public class Game {
    
    protected LevelGenerator levelGenerator;
    protected Level currentLevel;
    protected ViewController viewController;
    protected int numberLevel;
    protected String currentPlayer;//Crear label en el menu para ingresar nombre
    

    public Game (int level) {
        levelGenerator = new LevelGenerator("Orignal",level);
        currentLevel= levelGenerator.createLevel(level);
        setObservers();
           
    }

    //Launcher operation

    public void setViewController(ViewController viewController){
        this.viewController = viewController;
    }


    //Graphic operations
        

    public void setObservers(){
        //Hay que revisar la clase character y player
        setObserverCharacter(currentLevel.getCharacter());
        setObserversPlatforms(currentLevel.getPlatforms());
    }


    protected void setObserverCharacter(Character character){
        Observer characterObserver = viewController.registerEntity(character);
        character.registerObserver(characterObserver);

    }  
    
    protected void setObserversPlatforms(List<Platform> platformsList) {
    	for (Platform platform: platformsList) {
            Observer platFormObserver = viewController.registerEntity(platform);
    		platform.registerObserver(platFormObserver);
    	}
    }
    
   /* public void chargeEnemyLevel(List<Enemy> enemyList) {
    	for (Enemy enemy: enemyList) {
    		enemy.getObserver().update();
    	}
    }*/
    
   /* public void chargePowerUpsLevel(List<PowerUp> powerUpList) {
    	for (PowerUp powerUp: powerUpList) {
    		powerUp.getObserver().update();
    	}
    }
    
    public void nextLevel() {
    	numberLevel++;
    	newGame();
    }*/
    
    /* public setViewController(ViewController viewController){
         this.viewController = viewController;
     }*/

}