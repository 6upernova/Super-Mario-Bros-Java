package launcher;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import game.Game;
import platforms.*;
import projectile.Projectile;
import character.Character;
import character.CharacterCollisionManager;
import character.Keyboard;
import enemies.Enemy;
import tools.LogicTools;
import views.ViewConstants;

public class CharacterThread extends Thread {
	
	protected Game game;
    protected Character character;
    protected Keyboard keyboard;
    private CharacterCollisionManager characterCollisionManager;
    private int frameCount;
    private int spriteNumber;
    private boolean isRunning;
    private HashMap<String,Platform> platformsByCoords;
    

    public CharacterThread(Keyboard keyboard, Game game){
    	this.game = game;
        this.characterCollisionManager = new CharacterCollisionManager(game);
        this.character = game.getCurrentLevel().getCharacter();
        this.platformsByCoords = LogicTools.groupPlatformsByCoords(game.getCurrentLevel().getPlatforms());
        this.keyboard = keyboard;
        this.frameCount = 0;
        this.spriteNumber = 1;
        this.isRunning = false;
    }
    
    public void run() {
        //Iterator<Projectile> it = game.getCurrentLevel().getProjectiles().iterator();
        String horizontalDirection;
        String verticalDirection;
        String spacebar;
        int counter = 0;
        int timer = 400;
        int timeCounter = 0; // Contador de tiempo
        setIsRunning(true);
        while (isRunning) {
            horizontalDirection = keyboard.getPlayerHorizontalDirection();
            verticalDirection = keyboard.getPlayerVerticalDirection();
            spacebar = keyboard.getSpacebar();
            frameCount++;
            if (character.isInEnd()) {
                game.playNextLevel();
                timer = 400;
                isRunning = false;
            }
            else if(character.getLives() == 0){
                game.stop();
                isRunning= false;
            	}
            	else {
            		moveCharacter(horizontalDirection, verticalDirection, spacebar);
            		characterCollisionManager.platformsCollisions(character);
            		characterCollisionManager.enemiesCollisions(character);
            		characterCollisionManager.powerUpsCollisions(character);
            		checkEnemiesInRange(game.getCurrentLevel().getEnemies());

                    
                    for(Projectile projectile: game.getCurrentLevel().getProjectiles()){
                        moveProjectile(projectile);
                    } 
                    

                if (character.isInvincible()) {
                    if (counter > character.STAR_INVINCIBILITY_TIME) {
                        character.setInvencible(false);
                        counter = 0;
                    } else {
                        counter += 10;
                    }
                }
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
            }
        }
    }
    
    private void checkEnemiesInRange(List<Enemy> enemyList){
        for(Enemy enemy : enemyList)
            if(!enemy.isActive() && enemy.getX() <= Math.round(character.getX()) + 16){
                enemy.activateEnemy();
                //System.out.println("Enemigo en rango");
            }
    }
    
    private void moveCharacter(String horizontalDirection, String verticalDirection, String spacebar) {
		
        character.applyGravity();
        switch (spacebar) {
            case "Space":
                if(character.canThrowFireball()){
                    game.createFireBall(Math.round(character.getX()), Math.round(character.getY()+1), keyboard.getPreviousDirection());
                }                          
                break;
        }
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
		character.setHorizontalSpeed(ViewConstants.CHARACTER_SPEED);

        if(!character.isInAir() && !LogicTools.isOnSolid(platformsByCoords,character) ){
            character.setIsInAir(true);
        }
        
        character.moveRight("Right"+spriteNumber);
        if(frameCount%4==0) 
            spriteNumber = spriteNumber == 3 ? 1 : spriteNumber + 1;
    }
		
	private void moveLeft() {
        float characterLeftLimit = LogicTools.characterInMapEnd(game);
        if(character.getX() <= characterLeftLimit){
            character.setHorizontalSpeed(0);
        }
        else{
            character.setHorizontalSpeed(ViewConstants.CHARACTER_SPEED);
        }
        
        if(!character.isInAir() && !LogicTools.isOnSolid(platformsByCoords,character) ){
            character.setIsInAir(true);
        }
            
        character.moveLeft("Left"+spriteNumber);
            
        if(frameCount%4==0) 
            spriteNumber = spriteNumber == 3 ? 1 : spriteNumber + 1;

    }

	public void setIsRunning(boolean value) {
    	this.isRunning = value;
    }


    private void moveProjectile(Projectile projectile) {
        String direction = projectile.getDirection();
        switch (direction) {
            case "Left":
                moveProjectileLeft(projectile, projectile.getX());
                break;
            case "Right":
                moveProjectileRight(projectile, projectile.getX());
                break;
        }
    }
    
    private void moveProjectileLeft(Projectile projectile, float startPosition) {   
        if(projectile.getX()-5 <= startPosition){
            projectile.setX(projectile.getX()+1);
        }     
        else{
            game.removeLogicalEntity(projectile);
        }
    	projectile.moveLeft();
    }
    
    private void moveProjectileRight(Projectile projectile, float startPosition) {
    	if(projectile.getX()-5 <= startPosition){
            projectile.setX(projectile.getX()+1);
        }
        else{
            game.removeLogicalEntity(projectile);
        }
    	projectile.moveRight();
    }
}