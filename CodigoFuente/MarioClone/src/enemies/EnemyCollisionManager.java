package enemies;

import java.util.Iterator;
import java.util.List;
import game.BoundingBox;
import game.Game;
import platforms.Platform;

public class EnemyCollisionManager {
	
	protected List<Platform> platforms;
	
	public EnemyCollisionManager(Game game) {
		this.platforms = game.getCurrentLevel().getPlatforms();
	}
	
	public boolean platformsCollisions(Enemy enemy){
	    boolean collision = false;
	    Iterator<Platform> it = platforms.iterator();
	    BoundingBox enemyBox = enemy.getBoundingBox();
	    Platform platform;
	    while (it.hasNext()){
	        platform = it.next();
	        collision = enemyBox.collision(platform.getBoundingBox());               
	        if(collision){
                if (enemy.getVerticalSpeed() < 0 && enemy.downCollision(platform) ) {
                    enemy.setIsInAir(false);
                    enemy.setVerticalSpeed(0);
                    enemy.setY(platform.getY() + (platform.getHeight()));
                }
                else if(enemy.leftCollision(platform) && enemy.getDirection()=="Left"){
                	enemy.setX(platform.getX() + platform.getWidth());
                    enemy.setDirection("Right");
                }
                else if(enemy.upCollision(platform)){
                    enemy.setVerticalSpeed(0);
                    enemy.setY(Math.round(enemy.getY()));
                    enemy.setIsInAir(true);
                }
                else if(enemy.rightCollision(platform) && enemy.getDirection()=="Right"){
                	enemy.setX(Math.round(enemy.getX()));
                    enemy.setDirection("Left");
                }
            }
	    }
	    return collision;
	}
}
