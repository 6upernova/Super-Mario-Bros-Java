package powerUps;

import factories.Sprite;

public class SuperMushroom extends PowerUp{
	
	static final private int points=10;
	
	public SuperMushroom(Sprite sprite, int x, int y) {
		super(sprite, x, y, points);
	}

	
}
