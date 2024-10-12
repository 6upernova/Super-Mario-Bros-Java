package enemies;

import factories.Sprite;

public class Spiny extends Enemy{

	static final private int pointsOnDeath=60;
	static final private int pointsOnKill=-30;
	
	public Spiny(Sprite sprite, int x, int y) {
		super(sprite, x, y, pointsOnDeath, pointsOnKill);
	}
	
	public int getPointsOnDeath() {
		return pointsOnDeath;
	}
	
	public int getPointsOnKill() {
		return pointsOnKill;
	}
}
