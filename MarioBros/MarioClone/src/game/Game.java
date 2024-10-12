package game;

import java.util.List;

import javax.swing.JPanel;

import character.Player;
import factories.Level;
import factories.LevelGenerator;
import platforms.Platform;
import views.CharacterObserver;
import views.EntityObserver;
import views.Observer;
import views.ViewController;

public class Game {
    protected Player player;
    protected LevelGenerator levelGenerator;
    protected Level currentLevel;
    protected ViewController viewController;
    protected int numberLevel;
    

    public Game () {
        numberLevel= 1;
        viewController= new ViewController();
        //String modo = custom;
        //pasarle a entity facotory modo=custom si se quiere modo custom
        //si se quiere crear modo original asignar modo = "original"
        
        //crear nivel 
        levelGenerator = new LevelGenerator("Orignal",numberLevel);
        currentLevel= levelGenerator.createLevel(numberLevel);
        
        //Crear Player
        player = new Player("player");
        
        //crear obserserver para las entidades creadas
        setObserversPlayer();
        setObserversPlatforms(currentLevel.getPlatforms());
        //setObserversEntity(currentLevel.getEnemys());
        //setObserversEntity(currentLevel.getPowerUps());
        viewController.chargeLevel(currentLevel);
        //chargeEntitysSpritesLevel();    
    }
        
    public void newGame() {
    	//Crear el nuevo nivel
    	levelGenerator = new LevelGenerator("Orignal", numberLevel);
        currentLevel= levelGenerator.createLevel( numberLevel );
               
        //crear obserserver para las entidades creadas
        setObserversPlayer();
        setObserversPlatforms(currentLevel.getPlatforms());
        //setObserversEntity(currentLevel.getEnemys());
        // setObserversEntity(currentLevel.getPowerUps());
        viewController.chargeLevel(currentLevel);
    }

    public void setObserversEntity(List<Entity> entityList){
    	for (Entity entity : entityList) {
        Observer observer = new EntityObserver(entity);
        entity.registerObserver(observer);
    	}
    }
    
    public void setObserversPlayer(){
        CharacterObserver observer = new CharacterObserver(player.getCharacter(), viewController.getLevelPanel());
        player.getCharacter().registerObserver(observer);
    }  
    
    public void setObserversPlatforms(List<Platform> platformsList) {
    	for (Platform platform: platformsList) {
    		platform.getObserver().update();
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