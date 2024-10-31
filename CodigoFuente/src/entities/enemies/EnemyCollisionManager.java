package entities.enemies;

import java.util.Iterator;
import java.util.List;

import entities.BoundingBox;
import entities.platforms.Platform;
import game.Game;

public class EnemyCollisionManager {
	
	protected List<Platform> platforms;
	protected List<Enemy> enemies;
	
	public EnemyCollisionManager(Game game) {
		this.platforms = game.getCurrentLevel().getPlatforms();
		this.enemies = game.getCurrentLevel().getEnemies();
	}
	
	public boolean platformsCollisions(Enemy enemy){
	    boolean collision = false;
	    Iterator<Platform> it = platforms.iterator();
	    BoundingBox enemyBox = enemy.getBoundingBox();
	    Platform platform;
	    while (it.hasNext()){
	        platform = it.next();
	        collision = enemyBox.collision(platform.getBoundingBox());               
	        if(collision)
				collisionWithPlatform(enemy, platform);
	    }
	    return collision;
	}
	
	private void collisionWithPlatform(Enemy enemy, Platform platform){
		if (enemy.getVerticalSpeed() < 0 && enemy.downCollision(platform) ) 
			downPlatformCollision(enemy, platform);
		else if(enemy.leftCollision(platform) && enemy.getDirection()=="Left")
			leftPlatformCollision(enemy, platform);
		else if(enemy.rightCollision(platform) && enemy.getDirection()=="Right")
			rightPlatformCollision(enemy, platform);
	}
	private void downPlatformCollision(Enemy enemy, Platform platform){
		enemy.setIsInAir(false);
		enemy.setVerticalSpeed(0);
		enemy.setY(platform.getY() + (platform.getHeight()));
	}
	private void leftPlatformCollision(Enemy enemy, Platform platform){
		enemy.setX(platform.getX() + platform.getWidth());
		enemy.setDirection("Right");
	}
	private void rightPlatformCollision(Enemy enemy, Platform platform){
		enemy.setX(Math.round(enemy.getX()));
		enemy.setDirection("Left");
	}

	public void enemiesCollision(Enemy enemySource){
        Iterator<Enemy> enemiesIt = enemies.iterator();
        Enemy enemyDestination;
        boolean endIteration = false;
        while(enemiesIt.hasNext() && !endIteration){
            enemyDestination = enemiesIt.next();
			if(enemyDestination.isActive()){
				boolean collision = enemySource.colision(enemyDestination);
				if (collision) {
					collisionWithOtherEnemy(enemySource, enemyDestination);
					endIteration = true;
				}
			}
        }
	}
	
	private void collisionWithOtherEnemy(Enemy enemySource, Enemy enemyDestination){
		if(enemySource.leftCollision(enemyDestination))
			leftEnemyCollision(enemySource, enemyDestination);
		else if(enemySource.rightCollision(enemyDestination))
			rightEnemyCollision(enemySource, enemyDestination);
	}
	private void leftEnemyCollision(Enemy enemySource, Enemy enemyDestination){
		enemySource.setDirection("Right");
		enemyDestination.setDirection("Left");
	}
	private void rightEnemyCollision(Enemy enemySource, Enemy enemyDestination){
		enemySource.setDirection("Left");
		enemyDestination.setDirection("Right");
	}
}
