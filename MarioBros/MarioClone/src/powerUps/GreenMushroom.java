package powerUps;

import factories.Sprite;

public class GreenMushroom extends PowerUp{

	static final private int points=100;
	
	protected GreenMushroom(Sprite sprite, int x, int y) {
		super(sprite, x, y);
	}
	
	public int getPoints() {
		return points;
	}
}
