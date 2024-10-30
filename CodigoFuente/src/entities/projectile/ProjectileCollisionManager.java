package entities.projectile;
import java.util.Iterator;
import java.util.List;

import entities.enemies.Enemy;
import entities.platforms.Platform;
import game.Game;
import entities.BoundingBox;


public class ProjectileCollisionManager {    
	protected List<Platform> platforms;
    protected List<Enemy> enemies;
    private Game game;
	public ProjectileCollisionManager(Game game) {
		this.platforms = game.getCurrentLevel().getPlatforms();
        this.enemies = game.getCurrentLevel().getEnemies();
        this.game = game;
	}	

	public boolean projectilesCollisions(Projectile projectile){
        
        //float dampingFactor = ;    // Factor de amortiguación para reducir altura del rebote
	    boolean collision = false;
        Iterator<Platform> it = platforms.iterator();
	    BoundingBox projectileBox = projectile.getBoundingBox();
	    Platform platform;
	    while (it.hasNext() && !collision){
	        platform = it.next();
	        collision = projectileBox.collision(platform.getBoundingBox());               
	        if(collision){
                if(!projectile.downCollision(platform)){
                    checkRemove(projectile);
                }
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
                game.removeLogicalEntity(enemy);
                game.getCurrentLevel().getEnemies().remove(enemy);
                
            }
        }
        return collision;
    }
}