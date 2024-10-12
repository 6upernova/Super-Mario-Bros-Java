package enemies;

import factories.Sprite;

public class BuzzyBeetle extends Enemy {

	static final private int pointsOnDeath=30;
	static final private int pointsOnKill=-15;
	
	public BuzzyBeetle(Sprite sprite, int x, int y) {
		super(sprite, x, y,pointsOnDeath,pointsOnKill);
	}
	
	public int getPoints() {
		return pointsOnDeath;
	}
	
	public int getPointsOnKill() {
		return pointsOnKill;
	}
}
