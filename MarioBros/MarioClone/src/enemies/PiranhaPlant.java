package enemies;

import factories.Sprite;

public class PiranhaPlant extends Enemy{

	static final private int pointsOnDeath=30;
	static final private int pointsOnKill=-30;
	
	public PiranhaPlant(Sprite sprite, int x, int y) {
		super(sprite, x, y, pointsOnDeath, pointsOnKill);
		// TODO Auto-generated constructor stub
	}
	
	public int getPoints() {
		return pointsOnDeath;
	}
	
	public int getPointsOnKill() {
		return pointsOnKill;
	}
	
}
