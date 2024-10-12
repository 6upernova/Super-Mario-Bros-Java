package powerUps;

import factories.Sprite;

public class GreenMushroom extends PowerUp{

	static final private int points=100;
			
	public GreenMushroom(Sprite sprite, int x, int y) {
		super(sprite, x, y, points);
	}
	
}
