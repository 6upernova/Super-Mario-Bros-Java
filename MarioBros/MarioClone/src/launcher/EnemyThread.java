package launcher;

import java.util.Iterator;
import java.util.List;
import enemies.*;
import game.Game;

public class EnemyThread extends Thread {
	
    protected List<Enemy> enemies;
    private int frameCount;
    private int spriteNumber;
    private boolean isRunning;

    public EnemyThread(Game game) {
        this.enemies = game.getCurrentLevel().getEnemies();
        this.frameCount = 0;
        this.spriteNumber = 1;
        this.isRunning = false;
    }

    public void run() {
    	while(true) {
    		Iterator<Enemy> iterator = enemies.iterator();
    		Enemy enemy;
    		while (iterator.hasNext()) {
    			enemy=iterator.next();
    			if (enemy.isActive()) 
    				moveEnemy(enemy);
    		}
    		try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
            }
    	}
    }

        
   /* private boolean inScreen(Enemy enemy) {
    	float enemyPositionX= enemy.getX();
    	boolean isInScreen;
    	if(enemyPositionX>GraphicTools.getScreenPositionX(enemyPositionX))
    }*/
    
    private void moveEnemy(Enemy enemy) {
        String direction = enemy.getDirection();
        switch (direction) {
            case "Left":
                enemy.moveLeft();
                break;
            case "Right":
                enemy.moveRight();
                break;
            case "None":
            	break;
        }
    }
    
    public void setIsRunning(boolean value) {
    	this.isRunning = value;
    }
    
}