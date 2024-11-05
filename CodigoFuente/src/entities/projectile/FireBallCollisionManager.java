package entities.projectile;
import java.util.Iterator;
import java.util.List;
import entities.enemies.Enemy;
import entities.platforms.Platform;
import game.Game;
import entities.BoundingBox;
import entities.CollisionManager;

public class FireBallCollisionManager implements CollisionManager<FireBall> {    
	
	protected List<Platform> platforms;
    protected List<Enemy> enemies;
    private Game game;
    private int spriteNumber;
    
	public FireBallCollisionManager(Game game) {
		this.platforms = game.getCurrentLevel().getPlatforms();
        this.enemies = game.getCurrentLevel().getEnemies();
        this.game = game;
        this.spriteNumber = 1;
	}	

	public void platformsCollisions(FireBall projectile){
	    boolean collision = false;
        Iterator<Platform> it = platforms.iterator();
	    BoundingBox projectileBox = projectile.getBoundingBox();
	    Platform platform;
	    while (it.hasNext() && !collision){
	        platform = it.next();
	        collision = projectileBox.collision(platform.getBoundingBox());
            if(collision){    
                if(projectileBox.downCollision(platform.getBoundingBox()))
                    projectile.rebound();
                if(projectile.rightCollision(platform) || projectile.leftCollision(platform))
                    burst(projectile);
            }
	    }   
	}

    public void checkRemove(FireBall projectile){        
        game.removeLogicalEntity(projectile);
        game.getCurrentLevel().getFireBalls().remove(projectile);
    }   

    public void burst(Projectile projectile){
        FireBall fireBall= (FireBall) projectile;
        fireBall.setIsExplode(true);
        spriteNumber=1;
    }

    public void enemiesCollisions(FireBall projectile){
        if(!((FireBall)projectile).getIsExplode()){
        boolean collision = false;
        Iterator<Enemy> enemiesIt = enemies.iterator();
        Enemy enemy;
        boolean endIteration = false;
        while(enemiesIt.hasNext() && !endIteration){
            enemy = enemiesIt.next();
            collision = projectile.colision(enemy);
            if (collision) {
                endIteration = true;
                game.getCurrentLevel().getCharacter().addScore(enemy.getPointsOnDeath());
                enemy.dead();
                burst(projectile);
                game.reproduceSound("kick");
            }
        }
       }
    }
   
    public void powerUpsCollisions(FireBall entity) {}
    
    public void moveProjectile(FireBall projectile, int frame) {   
        if(frame%5==0) 
            spriteNumber = spriteNumber == 4 ? 1 : spriteNumber + 1;     
        platformsCollisions(projectile);
        String direction = projectile.getDirection();
        if(!((FireBall)projectile).getIsExplode())
             switch (direction) {
                  case "Left":                
                        moveProjectileLeft(projectile);
                        break;
                  case "Right":
                        moveProjectileRight(projectile);
                        break;
             }
        else exploding(projectile);
    }

    private void exploding(FireBall projectile){
        FireBall fireBall=((FireBall) projectile);
        if(spriteNumber==4){
            remove(fireBall);
        }
        else{
            fireBall.exploding(spriteNumber);
        }
    }

    private void remove(FireBall fireBall){ 
        game.removeLogicalEntity(fireBall);
        game.getCurrentLevel().getFireBalls().remove(fireBall);
    }

    private void moveProjectileLeft(FireBall projectile) {
        if (Math.abs(projectile.getX() - projectile.getInitialX()) >= 15) {
            burst(projectile);
        } 
        else {
            projectile.moveLeft(spriteNumber);
        }
    }

    private void moveProjectileRight(FireBall projectile) {
        if (Math.abs(projectile.getX() - projectile.getInitialX()) >= 15) {
            burst(projectile);
        } 
        else {
            projectile.moveRight(spriteNumber);
        }
    }

}

