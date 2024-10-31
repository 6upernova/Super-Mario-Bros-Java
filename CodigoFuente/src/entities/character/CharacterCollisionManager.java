package entities.character;

import java.util.Iterator;
import java.util.List;

import entities.BoundingBox;
import entities.enemies.Enemy;
import entities.platforms.Platform;
import entities.powerUps.PowerUp;
import game.Game;

public class CharacterCollisionManager{
    protected List<Enemy> enemies;
    protected List<Platform> platforms;
    protected List<PowerUp> powerUps;
    private Game game;
	
	public CharacterCollisionManager(Game game) {
		this.game = game;
    	this.enemies = game.getCurrentLevel().getEnemies();
        this.platforms = game.getCurrentLevel().getPlatforms();
        this.powerUps = game.getCurrentLevel().getPowerUps();
	}
	
	public boolean enemiesCollisions(Character character){
        boolean collision = false;
        Iterator<Enemy> enemiesIt = enemies.iterator();
        Enemy enemy;
        boolean endIteration = false;
        while(enemiesIt.hasNext() && !endIteration){
            enemy = enemiesIt.next();
            collision = character.colision(enemy);
            if (collision) {
            	if(character.isInvincible() || character.downCollision(enemy)){
                    smallJump(character);
                    enemy.acceptVisit(character);
                    game.removeLogicalEntity(enemy);
                    enemies.remove(enemy);
                }
            	else if(character.leftCollision(enemy) || character.rightCollision(enemy) || character.upCollision(enemy) && (!character.isInvincible() && !character.isInvulnerable())){
                    character.damaged();
                    character.setInvulnerable(true);
                }     
                endIteration = true;
            }
        }
        return collision;
    }
    
    private void smallJump(Character character){
        String side = character.isMovingRight() ? "Right" : "Left";
        character.smallJump(side);
    }
	
	public boolean powerUpsCollisions(Character character){
        boolean collision = false;
        Iterator<PowerUp> it = powerUps.iterator();
        PowerUp powerUp;
        boolean endIteration = false;
        while (it.hasNext() && !endIteration) {
            powerUp = it.next();
            if(powerUp.isActive()){
                collision = character.colision(powerUp);
                //System.out.println(collision);
                if (collision) {
                    powerUp.acceptVisit(character);   
                    game.removeLogicalEntity(powerUp);  
                    powerUps.remove(powerUp);   
                    endIteration = true;
                }
            }
            
        }
        return collision;
    }
	
	public boolean platformsCollisions(Character character){
	    boolean collision = false;
	    boolean endIteration = false;
	    Iterator<Platform> it = platforms.iterator();
	    boolean removeEntity=false;
	    BoundingBox characterBox = character.getBoundingBox();
	    Platform platform;
	    while (it.hasNext() && !endIteration){
	        platform = it.next();
	        collision = characterBox.collision(platform.getBoundingBox());               
	        if(collision){
                if (character.getVerticalSpeed() < 0 && character.downCollision(platform) ) {
                    character.setIsInAir(false);
                    character.setVerticalSpeed(0);
                    character.setY(platform.getY() + (platform.getHeight()));
                }
                else  if(character.leftCollision(platform)){
                    character.setX(platform.getX() + platform.getWidth());
                }
                else if(character.upCollision(platform)){
                    character.setVerticalSpeed(0);
                    character.setY(Math.round(character.getY()));
                    removeEntity= platform.isBreakeable() && character.capacityToBreakBlocks();
                }
                else  if(character.rightCollision(platform)){
                    character.setX(Math.round(character.getX()));
                }
                platform.acceptVisit(character);
                if(removeEntity) {
                	game.removeLogicalEntity(platform);
                	platforms.remove(platform);
                	endIteration=true;
                }
            }
	    }
	    return collision;
	}
}
