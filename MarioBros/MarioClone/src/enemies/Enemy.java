package enemies;

import factories.Sprite;
import game.Entity;

public abstract class Enemy extends Entity{
	
	private int pointsOnDeath;
	private int pointsOnKill;
	
	public Enemy(Sprite sprite, int x, int y, int pointsOnDeath,int pointsOnKill) {
		super(sprite, x, y);
		this.pointsOnDeath=pointsOnDeath;//Puntos cuando enemigo muere
		this.pointsOnKill=pointsOnKill;//Puntos cuando enemigo mata
	}

}
