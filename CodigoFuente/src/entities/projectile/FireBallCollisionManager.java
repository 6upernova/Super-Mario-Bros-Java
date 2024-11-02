package entities.projectile;
import java.util.Iterator;
import java.util.List;

import entities.enemies.Enemy;
import entities.platforms.Platform;
import game.Game;
import entities.BoundingBox;


public class FireBallCollisionManager {    
	protected List<Platform> platforms;
    protected List<Enemy> enemies;
    private Game game;
	public FireBallCollisionManager(Game game) {
		this.platforms = game.getCurrentLevel().getPlatforms();
        this.enemies = game.getCurrentLevel().getEnemies();
        this.game = game;
	}	

	public boolean platformsCollisions(Projectile projectile){
	    boolean collision = false;
        Iterator<Platform> it = platforms.iterator();
	    BoundingBox projectileBox = projectile.getBoundingBox();
	    Platform platform;
	    while (it.hasNext() && !collision){
	        platform = it.next();
	        collision = projectileBox.collision(platform.getBoundingBox());
            if(collision){
                if(projectileBox.intersects(platform.getBoundingBox().getBoundsTop()))
                    ((FireBall)projectile).rebound();
                else if(projectile.rightCollision(platform) || projectile.leftCollision(platform))
                    checkRemove(projectile);
                
            }
                           
	    }   
	    return collision;
	}

    public void checkRemove(Projectile projectile){        
        game.removeLogicalEntity(projectile);
        game.getCurrentLevel().getProjectiles().remove(projectile);   
    }

    public boolean enemiesCollisions(Projectile projectile){
        boolean collision = false;
        Iterator<Enemy> enemiesIt = enemies.iterator();
        Enemy enemy;
        boolean endIteration = false;
        while(enemiesIt.hasNext() && !endIteration){
            enemy = enemiesIt.next();
            collision = projectile.colision(enemy);
            if (collision) {
                endIteration = true;
                enemy.acceptVisit(game.getCurrentLevel().getCharacter());
                checkRemove(projectile);
            }
        }
        return collision;
    }
    
    public void moveProjectile(Projectile projectile) {        
        platformsCollisions(projectile);
        String direction = projectile.getDirection();
        switch (direction) {
            case "Left":                
                moveProjectileLeft(projectile);
                break;

            case "Right":
                moveProjectileRight(projectile);
                break;
        }

    }

    private void moveProjectileLeft(Projectile projectile) {
        if (Math.abs(projectile.getX() - projectile.getInitialX()) >= 15) {
            checkRemove(projectile);
        } 
        else {
            projectile.moveLeft();
        }
    }

    private void moveProjectileRight(Projectile projectile) {
        if (Math.abs(projectile.getX() - projectile.getInitialX()) >= 15) {
            checkRemove(projectile);
        } 
        else {
            ((FireBall)projectile).moveRight();
        }
    }

}