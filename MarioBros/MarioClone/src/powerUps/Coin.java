package powerUps;

import factories.Sprite;

public class Coin extends PowerUp{

	static final int points=5;
	
	protected Coin(Sprite sprite, int x, int y) {
		super(sprite, x, y);
	}

	public int getPoints() {
		return points;
	}
	
}
