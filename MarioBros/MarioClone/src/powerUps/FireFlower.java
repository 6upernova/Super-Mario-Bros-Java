package powerUps;

import factories.Sprite;

public class FireFlower extends PowerUp{
	
	static final private int points=5;

	public FireFlower(Sprite sprite, int x, int y) {
		super(sprite, x, y, points);
	}
	
}
