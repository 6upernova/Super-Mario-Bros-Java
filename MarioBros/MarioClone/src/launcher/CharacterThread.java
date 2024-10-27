package launcher;

import java.util.HashMap;
import java.util.List;
import game.Game;
import views.GraphicTools;
import views.ViewConstants;
import platforms.*;
import character.Character;
import character.CharacterCollisionManager;
import character.Keyboard;
import enemies.Enemy;

public class CharacterThread extends Thread {
    protected Game game;
    protected Character character;
    protected Keyboard keyboard;
    private CharacterCollisionManager characterCollisionManager;
    private int frameCount;
    private int spriteNumber;
    private HashMap<String,Platform> platformsByCoords;

    public CharacterThread(Keyboard keyboard, Game game){
        this.characterCollisionManager = new CharacterCollisionManager(game);
        this.character = game.getCurrentLevel().getCharacter();
        this.platformsByCoords = groupPlatformsByCoords(game.getCurrentLevel().getPlatforms());
        this.keyboard = keyboard;
        this.frameCount = 0;
        this.spriteNumber = 1;
        this.game = game;
    }
    
    public void run() {
        String horizontalDirection;
        String verticalDirection;
        int counter = 0;
        int timer = 400;
        int timeCounter = 0; // Contador de tiempo
        boolean inGame = true;
        while (inGame) {
            horizontalDirection = keyboard.getPlayerHorizontalDirection();
            verticalDirection = keyboard.getPlayerVerticalDirection();
            frameCount++;
    
            if (character.isInEnd()) {
                game.playNextLevel(character.getScore(), character.getCoins(), character.getLives(), character.getState());
                timer = 400;
                inGame = false;
            }
            else if(character.getLives() == 0){
                game.stop();
                inGame= false;
            } 
            else {
                moveCharacter(horizontalDirection, verticalDirection);
                characterCollisionManager.platformsCollisions(character);
                characterCollisionManager.enemiesCollisions(character);
                characterCollisionManager.powerUpsCollisions(character);
                checkEnemiesInRange(game.getCurrentLevel().getEnemies());
                
                if (character.isInvincible()) {
                    if (counter > character.STAR_INVINCIBILITY_TIME) {
                        character.setInvencible(false);
                        counter = 0;
                    } else {
                        counter += 10;
                    }
                }
                System.out.println(character.isInvulnerable());
                if(character.isInvulnerable()){
                    if (counter > character.HIT_INVINCIBILITY_TIME) {
                        character.setInvulnerable(false);
                        counter = 0;
                    } else {
                        counter += 10;
                    }
                }
    
                // Actualizar timer cada segundo
                timeCounter++;
                if (timeCounter >= 60) { // 60 iteraciones aproximadamente 1 segundo
                    timer--;
                    timeCounter = 0; // Reiniciar el contador de tiempo
                }
    
                game.updateInformation(character.getScore(), character.getCoins(), timer, character.getLives());
            }
            
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void checkEnemiesInRange(List<Enemy> enemyList){
        for(Enemy enemy : enemyList)
            if(!enemy.isActive() && enemy.getX() == Math.round(character.getX()) + 6){
                enemy.activateEnemy();
                System.out.println("Enemigo en rango");
            }
    }
    
   
    private void moveCharacter(String horizontalDirection, String verticalDirection) {
        character.applyGravity();
        switch (verticalDirection) {
        case "Up":
            if(!character.isInAir())
                if(horizontalDirection == "None")
                    character.jump("Jumping" + keyboard.getPreviousDirection());
                else
                    character.jump("Jumping" + horizontalDirection);
            break;
        }
    	switch(horizontalDirection) {
    		case "None":
    			character.stayStill("Still" + keyboard.getPreviousDirection());
    			break;
    		case "Right":
    			moveRight();
                break;
    		case "Left":
    			moveLeft();
    			break;
    	}
    }

	private void moveRight() {
		

        if(!character.isInAir() && !isOnSolid() ){
            character.setIsInAir(true);
        }
        
        character.moveRight("Right"+spriteNumber);
        if(frameCount%4==0) 
            spriteNumber = spriteNumber == 3 ? 1 : spriteNumber + 1;
    }
		
	private void moveLeft() {
        float characterLeftLimit=characterInMapEnd();
        if(character.getX()>=characterLeftLimit) {
            if(!character.isInAir() && !isOnSolid() ){
                character.setIsInAir(true);
            }
            character.moveLeft("Left"+spriteNumber);
            if(frameCount%4==0) 
                spriteNumber = spriteNumber == 3 ? 1 : spriteNumber + 1;
        }
    }

    //Metodos Para LogicTools:

    private float characterInMapEnd() {
        float scrollbarPos = (game.getViewController().getLevelScreen().getScrollbarXPosition()/ViewConstants.CELL_SIZE);
        return scrollbarPos+1;
        
    }


    //Metodo provisional hasta tener un level data
    private HashMap<String,Platform> groupPlatformsByCoords(List<Platform> platforms){
        HashMap<String,Platform> toret = new HashMap<String,Platform>();
        for(Platform platform : platforms){
            //System.out.println(platform.getX()+","+platform.getY());
            toret.put((platform.getX()+","+platform.getY()), platform);
        
        }
        return toret;
    }

    private String getKey(float x, float y){
        return (GraphicTools.roundInt(x)+","+GraphicTools.roundInt(y));
    }

    private boolean isOnSolid(){
        return platformsByCoords.get(getKey(character.getX() , character.getY()-1)) != null;
    }

}