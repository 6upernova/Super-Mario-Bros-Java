package enemies;

import factories.Sprite;

public class Goomba extends Enemy{

	static final private int pointsOnDeath=60;
	static final private int pointsOnPlayerDamage=-30;
	
	protected Goomba(Sprite sprite, int x, int y) {
		super(sprite, x, y);
	}

	public int getPoints() {
		return pointsOnDeath;
	}
	public void killsPlayer() {
		
	}
}
