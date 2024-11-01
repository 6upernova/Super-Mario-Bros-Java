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
                endIteration = true;
                game.getCurrentLevel().getCharacter().addScore(enemy.pointsOnDeath());
                game.removeLogicalEntity(enemy);
                game.addToRemovedEnenemies(enemy);      
                game.getCurrentLevel().getEnemies().remove(enemy);          
            }
        }
        return collision;
    }
    
    public void moveProjectile(Projectile projectile) {        
        game.reproduceSound("fireball");
        projectilesCollisions(projectile);
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
        projectile.setX(projectile.getX() - 1);
        moveProjectileVerticalmenteY(projectile);
        if (Math.abs(projectile.getX() - projectile.getInitialX()) >= 15) {
            checkRemove(projectile);
        } 
        else {
            projectile.moveLeft();
        }
    }

    private void moveProjectileRight(Projectile projectile) {
        projectile.setX(projectile.getX() + 1);
        moveProjectileVerticalmenteY(projectile);
        if (Math.abs(projectile.getX() - projectile.getInitialX()) >= 15) {
            checkRemove(projectile);
        } 
        else {
            projectile.moveRight();
        }
    }

    private void moveProjectileVerticalmenteY(Projectile projectile) {
        float gravity = 0.15f * 0.5f;
        projectile.setVerticalSpeed(projectile.getVerticalSpeed() - gravity);
        if (!projectilesCollisions(projectile))
            projectile.setY(projectile.getY() + projectile.getVerticalSpeed());
        else
            projectile.setY(projectile.getY() - projectile.getVerticalSpeed());
    }
}