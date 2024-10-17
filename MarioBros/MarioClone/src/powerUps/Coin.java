package powerUps;

import factories.Sprite;

public class Coin extends PowerUp{

	static final private int points=5;
	
	public Coin(Sprite sprite, int x, int y) {
		super(sprite, x, y, points);
	}
	
	public int getPoints() {
		return points;
	}

}
