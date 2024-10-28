package launcher;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import enemies.*;
import game.Game;

public class EnemyThread extends Thread {
	
    protected List<Enemy> enemies;
    private EnemyCollisionManager ecm; 
    private int frameCount;
    private int spriteNumber;

    public EnemyThread(Game game) {
        this.enemies = game.getCurrentLevel().getEnemies();
        this.frameCount = 0;
        this.spriteNumber = 1;
        this.ecm = new EnemyCollisionManager(game);
    }

    public void run() {
    	List<Enemy> enemyCopy = new ArrayList<>(enemies); //Copia de la lista enemigos para poder modificarla
    	while(true) {
    		Iterator<Enemy> iterator = enemyCopy.iterator();
    		Enemy enemy;
    		frameCount++;
    		while (iterator.hasNext()) {
    			enemy=iterator.next();
    			if (enemy.isActive()) { 
    				
    				moveEnemy(enemy);
    			}
    		}
    		try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
            }
    	}
    }
    
    private void moveEnemy(Enemy enemy) {
    	ecm.platformsCollisions(enemy);
        String direction = enemy.getDirection();
        //enemy.applyGravity();
        switch (direction) {
            case "Left":
                moveLeft(enemy);
                break;
            case "Right":
                moveRight(enemy);
                break;
            case "None":
            	break;
        }
    }
    
    private void moveLeft(Enemy enemy) {
    	enemy.moveLeft();
    }
    
    private void moveRight(Enemy enemy) {
    	enemy.moveRight();
    }
}