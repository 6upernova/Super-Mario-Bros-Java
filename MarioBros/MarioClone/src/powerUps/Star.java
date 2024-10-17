package powerUps;

import factories.Sprite;

public class Star extends PowerUp{

	static final private int points=20;
			
	public Star(Sprite sprite, int x, int y) {
		super(sprite, x, y, points);
	}

	public int getPoints() {
		return points;
	}
}
