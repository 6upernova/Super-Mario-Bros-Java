package launcher;

import java.util.Iterator;
import java.util.List;
import enemies.*;
import game.Game;

public class EnemyThread extends Thread {
	
    protected List<Enemy> enemies;
    private int frameCount;
    private int spriteNumber;

    public EnemyThread(Game game) {
        this.enemies = game.getCurrentLevel().getEnemies();
        this.frameCount = 0;
        this.spriteNumber = 1;
    }

    public void run() {
    	//Iterator<Enemy> enemiesIt=enemies.iterator();
        //Enemy enemy;
        //boolean endIteration=false;
        while (true) {
        	frameCount++;
        	for(Enemy enemy: enemies) {
        		//enemy = enemiesIt.next();
        		if(enemy.isActive())
        			moveEnemy(enemy);
        		//enemy = enemiesIt.next();
        		//endIteration=true;
        		try {
        			Thread.sleep(16);
        		}
        		catch (InterruptedException e) {
        		e.printStackTrace();
        		} 
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
}