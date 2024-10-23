package character;

import java.util.List;

import enemies.Enemy;
import game.BoundingBox;
import game.Game;
import platforms.Platform;
import powerUps.PowerUp;


public class CharacterCollitionManager{

    protected List<Enemy> enemies;
    protected List<Platform> platforms;
    protected List<PowerUp> powerUps;
    private Game game;
	
	public CharacterCollitionManager(Game game) {
		this.game = game;
		this.enemies = game.getCurrentLevel().getEnemies();
        this.platforms = game.getCurrentLevel().getPlatforms();
        this.powerUps = game.getCurrentLevel().getPowerUps();
	}
	
	public boolean enemiesColitions(Character character){
        boolean colition = false;
        for(Enemy enemy: enemies){
            colition = character.colision(enemy);
            //System.out.println(colition);
            if (colition) {
            	enemy.acceptVisit(character);
                //System.out.println(character.leftCollision(enemy) || character.rightCollision(enemy));
                if(character.leftCollision(enemy) || character.rightCollision(enemy) && !character.isInvincible()){
                    game.resetLevel();
                    System.out.println("deberia resetear");
                    break;
                }
                if(character.downCollision(enemy))
                    enemies.remove(enemy);
                break;
            }
        }
        return colition;
    }
	
	public boolean powerUpsColitions(Character character){
        boolean colition = false;
        for(PowerUp e: powerUps){
            colition = character.colision(e);
            //System.out.println(colition);
            if (colition) {
                    e.acceptVisit(character);   
                    game.removeLogicalEntity(e);  
                    powerUps.remove(e);   
                break;
            }
        }
        return colition;
    }
	
	public boolean platformsColitions(Character character){
        boolean colition = false;
        BoundingBox characterBox = character.getBoundingBox();
        for(Platform e: platforms){
            colition = characterBox.collision(e.getBoundingBox());
            if (colition) {  
                if(e.isBreakeable()){
                    //System.out.println("es rompible");
                    if(characterBox.upCollision(e.getBoundingBox())){
                        e.acceptVisit(character);
                        //System.out.println("colisiona la cabeza");
                        
                    }
                    else if(characterBox.downCollision(e.getBoundingBox())){
                        e.acceptVisit(character);
                        //System.out.println("deberia estar arriba");
                                        
                    }
                    else if(characterBox.leftCollision(e.getBoundingBox())){
                        e.acceptVisit(character);
                        
                    }
                    else if(characterBox.rightCollision(e.getBoundingBox())){
                        e.acceptVisit(character);
                        
                    }
                    
                }
                break;
            }
        }
        return colition;
    }
	
	public boolean platformsDownCollisions(Character character) {
        boolean colition = false;
        BoundingBox characterBox = character.getBoundingBox();
        for(Platform e: platforms){
            colition = characterBox.collision(e.getBoundingBox());
            if (colition)
                if(e.isBreakeable())
                    //System.out.println("es rompible");
                    if(characterBox.downCollision(e.getBoundingBox())){
                        e.acceptVisit(character);
                        System.out.println("colisiona la cabeza"); 
                    }
        }
        return colition;
    } 
}
