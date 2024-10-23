package character;

import java.util.Iterator;
import java.util.List;

import enemies.Enemy;
import game.BoundingBox;
import game.Game;
import platforms.Platform;
import powerUps.PowerUp;


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
        Enemy e;
        boolean endIteration = false;
        while(enemiesIt.hasNext() && !endIteration){
            e = enemiesIt.next();
            collision = character.colision(e);
            if (collision) {
                /*
                if(character.leftCollision(e) || character.rightCollision(e) && !character.isInvincible()){
                    character.dead();
                    game.resetLevel();
                    endIteration = true;
                }
                 */
                //if(character.downCollision(e)){
                    //e.acceptVisit(character);
            	System.out.println("colision con enemigo");
                game.removeLogicalEntity(e);
                enemies.remove(e);                    
                endIteration = true;
            }
        }
        return collision;
    }
	
	public boolean powerUpsCollisions(Character character){
        boolean collision = false;
        Iterator<PowerUp> it = powerUps.iterator();
        PowerUp e;
        boolean endIteration = false;
        while (it.hasNext() && !endIteration) {
            e = it.next();
            collision = character.colision(e);
            //System.out.println(collision);
            if (collision) {
                e.acceptVisit(character);   
                game.removeLogicalEntity(e);  
                powerUps.remove(e);   
                endIteration = true;
            }
        }
        return collision;
    }
	
	 public boolean platformsCollisions(Character character){
	        boolean collision = false;
	        boolean endIteration = false;
	        Iterator<Platform> it = platforms.iterator();

	        BoundingBox characterBox = character.getBoundingBox();
	        Platform p;
	        while (it.hasNext() && !endIteration){  
	            p = it.next();
	            collision = characterBox.collision(p.getBoundingBox());
	            if(collision){
	            	System.out.println("Colision con plataforma");
	                if(p.isBreakeable()){
	                    //System.out.println("es rompible");
	                    if(characterBox.upCollision(p.getBoundingBox())) {
	                        p.acceptVisit(character);
	                        //System.out.println("colisiona la cabeza"); 
	                    }
	                    else if(characterBox.downCollision(p.getBoundingBox())){
	                            p.acceptVisit(character);
	                            //System.out.println("deberia estar arriba");                        
	                            }
	                    else if(characterBox.leftCollision(p.getBoundingBox())){
	                            p.acceptVisit(character);
	                            }
	                    else if(characterBox.rightCollision(p.getBoundingBox())){
	                            p.acceptVisit(character);                    
	                            }      
	                    endIteration = true;          
	                }
	            }
	        }
	        return collision;
	    }
	
	public boolean platformsDownCollisions(Character character) {
        boolean collision = false;
        BoundingBox characterBox = character.getBoundingBox();
        for(Platform e: platforms){
            collision = characterBox.collision(e.getBoundingBox());
            if (collision)
                if(e.isBreakeable())
                    //System.out.println("es rompible");
                    if(characterBox.downCollision(e.getBoundingBox())){
                        e.acceptVisit(character);
                        System.out.println("colisiona la cabeza"); 
                    }
        }
        return collision;
    } 
}
