package enemies;

import factories.Sprite;

public class Lakitu extends Enemy{

	static final private int pointsOnDeath=60;
	static final private int pointsOnKill=0;
	
	public Lakitu(Sprite sprite, int x, int y) {
		super(sprite, x, y, pointsOnDeath, pointsOnKill);
	}

	public int getPointsOnDeath() {
		return pointsOnDeath;
	}
	
	public int getPointsOnKill() {
		return pointsOnKill;
	}
	
}
