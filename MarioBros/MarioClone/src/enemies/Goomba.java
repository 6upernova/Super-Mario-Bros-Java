package enemies;

import factories.Sprite;

public class Goomba extends Enemy{

	static final private int pointsOnDeath=60;
	static final private int pointsOnKill=-30;
	
	public Goomba(Sprite sprite, int x, int y) {
		super(sprite, x, y,pointsOnDeath,pointsOnKill);
	}

	public int getPoints() {
		return pointsOnDeath;
	}
	public int getPointsOnKill() {
		return pointsOnKill;
	}
}
