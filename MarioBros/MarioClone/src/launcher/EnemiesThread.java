package launcher;

import java.util.List;

import enemies.*;
import game.Game;

public class EnemiesThread extends Thread{
	
	protected List<Enemy> enemies;
	private int frameCount;
	private int spriteNumber;
	private boolean inScreen;
	
	public EnemiesThread(Game game) {
		this.enemies  = game.getCurrentLevel().getEnemies();
		frameCount = 0;
		spriteNumber = 1;
		inScreen = false;
	}
	
	public void run() {
		String HorizontalEnemiesDirection;
		String PiranhaPlantState;
		while(true) {
			while (!inScreen) {
				try {
					wait();
                } catch (InterruptedException e) {
                	Thread.currentThread().interrupt();
                }
			}
			moveEnemy();
		}
	}
	
	private void moveEnemy() {
		
	}
	private void moveRight() {
		
	}
	private void moveLeft() {
		
	}
	private void setInScreen(boolean value) {
        this.inScreen = value;
        if (inScreen) {
            notify();  
        }
    }
}
